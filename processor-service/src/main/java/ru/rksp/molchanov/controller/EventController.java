package ru.rksp.molchanov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rksp.molchanov.service.ClickHouseService;
import ru.rksp.molchanov.service.EventConsumerService;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventController {

    private final EventConsumerService eventService;
    private final ClickHouseService clickHouseService;

    @PostMapping("/count")
    public ResponseEntity<String> countEvents() {
        long count = eventService.countEvents();

        try {
            clickHouseService.saveCount(count);
        } catch (Exception e) {
            return ResponseEntity.ok("Количество: " + count + " (ClickHouse временно недоступен)");
        }

        return ResponseEntity.ok("Количество записано в ClickHouse: " + count);
    }
}