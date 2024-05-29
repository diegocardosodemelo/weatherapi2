package com.example.weatherapi.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.weatherapi.model.Metric;

public interface MetricRepository extends JpaRepository<Metric, Long> {
	List<Metric> findBySensorIdAndTimestampBetween(Long sensorId, LocalDateTime start, LocalDateTime end);
    List<Metric> findTopBySensorIdOrderByTimestampDesc(Long sensorId);
}