package ru.rksp.molchanov.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ClickHouseService {

    @Value("${clickhouse.url}")
    private String url;

    @Value("${clickhouse.username}")
    private String username;

    @Value("${clickhouse.password}")
    private String password;

    public void saveCount(long count) {
        String sql = "INSERT INTO student_event_aggregates (id, total_count, created_at) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, System.currentTimeMillis());
            statement.setLong(2, count);
            statement.setObject(3, LocalDateTime.now());

            statement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Ошибка записи в ClickHouse", e);
        }
    }
}