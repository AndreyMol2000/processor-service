package ru.rksp.molchanov.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "raw_student_events")
@Getter
@Setter
public class RawStudentEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "group_name", nullable = false)
    private String groupName;

    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;

    @Column(name = "received_at", nullable = false)
    private LocalDateTime receivedAt;
}