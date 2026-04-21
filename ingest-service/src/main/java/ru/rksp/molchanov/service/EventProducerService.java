package ru.rksp.molchanov.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.rksp.molchanov.config.RabbitConfig;
import ru.rksp.molchanov.dto.EventDto;

@Service
@RequiredArgsConstructor
public class EventProducerService {

    private final RabbitTemplate rabbitTemplate;

    public void send(EventDto eventDto) {
        rabbitTemplate.convertAndSend(
                RabbitConfig.EVENTS_RAW_QUEUE,
                eventDto
        );
    }
}