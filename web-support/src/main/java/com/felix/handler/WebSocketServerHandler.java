package com.felix.handler;

import org.springframework.web.socket.*;

import java.nio.charset.StandardCharsets;

public class WebSocketServerHandler implements WebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("连接成功");
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        System.out.println("收到消息：" + message.getPayload());
        Object payload = message.getPayload();
        String response = "你好：" + payload;
        TextMessage textMessage = new TextMessage(response.getBytes(StandardCharsets.UTF_8));
        session.sendMessage(textMessage);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("连接异常");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        System.out.println("连接关闭");
    }

    @Override
    public boolean supportsPartialMessages() {
        System.out.println("是否支持部分消息");
        return false;
    }
}
