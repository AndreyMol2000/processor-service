package ru.rksp.molchanov.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rksp.molchanov.dto.EventDto;
import ru.rksp.molchanov.service.EventProducerService;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventController {

    private final EventProducerService producerService;

    @PostMapping
    @Operation(summary = "Отправить событие в очередь events.raw")
    public ResponseEntity<String> createEvent(@RequestBody EventDto eventDto) {
        producerService.send(eventDto);
        return ResponseEntity.ok("Событие отправлено в очередь events.raw");
    }
}