package com.felix.handler;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

@Component
@ServerEndpoint(value = "/serverwithanno",configurator = CustomWebSocketServerConfig.class)
public class WebSocketServerUseAnno {


    /**
     * Event that is triggered when a new session starts.
     *
     * @param session The new session.
     * @param config  The configuration with which the Endpoint was configured.
     */
    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        System.out.println("会话开始：" + session.getId());
    }

    /**
     * Event that is triggered when a session has closed.
     *
     * @param session     The session
     * @param closeReason Why the session was closed
     */
    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        // NO-OP by default
        System.out.println("会话关闭：" + session.getId());
    }

    /**
     * Event that is triggered when a protocol error occurs.
     *
     * @param session   The session.
     * @param throwable The exception.
     */
    @OnError
    public void onError(Session session, Throwable throwable) {
        // NO-OP by default
        System.out.println("会话出现异常：" + session.getId());
    }

    @OnMessage
    public void onMessage(Session session, String msg) {
        System.out.println("会话：" + session.getId() + "，消息：" + msg);
        try {
            session.getBasicRemote().sendText("server: " + msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        new Timer()
                .schedule(new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            session.getBasicRemote().sendText("server: timer: ");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, 3000L);
    }

}
