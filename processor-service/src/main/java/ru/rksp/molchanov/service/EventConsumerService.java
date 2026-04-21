package ru.rksp.molchanov.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.rksp.molchanov.config.RabbitConfig;
import ru.rksp.molchanov.dto.EventDto;
import ru.rksp.molchanov.entity.RawStudentEvent;
import ru.rksp.molchanov.repository.RawStudentEventRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EventConsumerService {

    private final RawStudentEventRepository repository;

    @RabbitListener(queues = RabbitConfig.EVENTS_RAW_QUEUE)
    public void consume(EventDto dto) {
        RawStudentEvent event = new RawStudentEvent();
        event.setLastName(dto.getLastName());
        event.setFirstName(dto.getFirstName());
        event.setGroupName(dto.getGroupName());
        event.setEventDate(LocalDate.parse(dto.getEventDate()));
        event.setReceivedAt(LocalDateTime.now());

        repository.save(event);
    }

    public long countEvents() {
        return repository.count();
    }
}