package ru.rksp.molchanov.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String EVENTS_RAW_QUEUE = "events.raw";

    @Bean
    public Queue eventsRawQueue() {
        return new Queue(EVENTS_RAW_QUEUE, true);
    }
}