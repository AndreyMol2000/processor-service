package ru.rksp.molchanov.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Событие студента")
public class EventDto {

    @Schema(description = "Фамилия", example = "Иванов")
    private String lastName;

    @Schema(description = "Имя", example = "Иван")
    private String firstName;

    @Schema(description = "Группа", example = "ИС-31")
    private String groupName;

    @Schema(description = "Дата события", example = "2026-04-21")
    private String eventDate;
}