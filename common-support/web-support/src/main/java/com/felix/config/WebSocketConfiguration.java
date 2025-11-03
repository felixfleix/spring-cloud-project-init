package com.felix.config;

import com.felix.property.WebSocketProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

@Configuration
@EnableConfigurationProperties(value = {WebSocketProperties.class})
@EnableWebSocket
public class WebSocketConfiguration {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Bean
    @ConditionalOnMissingBean
    public ServletServerContainerFactoryBean createWebSocketContainer(WebSocketProperties webSocketProperties) {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(webSocketProperties.getMaxTextMessageBufferSize());
        container.setMaxBinaryMessageBufferSize(webSocketProperties.getMaxBinaryMessageBufferSize());
        return container;
    }

}
