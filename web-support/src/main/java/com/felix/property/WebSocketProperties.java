package com.felix.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "spring.websocket.config")
public class WebSocketProperties {

    private Integer maxTextMessageBufferSize = 8192;

    private Integer maxBinaryMessageBufferSize = 8192;

}
