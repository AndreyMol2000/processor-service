package ru.rksp.molchanov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rksp.molchanov.entity.RawStudentEvent;

public interface RawStudentEventRepository extends JpaRepository<RawStudentEvent, Long> {
}