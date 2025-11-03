package com.felix;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AIApplication {

    public static void main(String[] args) {
        SpringApplication.run(AIApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(ChatClient.Builder builder) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                ChatClient chatClient = builder.build();
                String response = chatClient.prompt("Tell me a joke")
                        .call()
                        .content();
                System.out.println(response);
            }
        };
    }

}
