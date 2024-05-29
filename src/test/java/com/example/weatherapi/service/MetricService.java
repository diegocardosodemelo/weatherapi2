package com.example.weatherapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.weatherapi.model.Metric;
import com.example.weatherapi.model.Sensor;
import com.example.weatherapi.model.dto.MetricStats;
import com.example.weatherapi.repository.MetricRepository;



@SpringBootTest
class MetricServiceTests {
    @Mock
    private MetricRepository metricRepository;

    @InjectMocks
    private MetricService metricService;

    @Test
    void testSaveMetric() {
        Metric metric = new Metric(1L, new Sensor(), 25.0, 60.0, 5.0, LocalDateTime.now());
        when(metricRepository.save(any(Metric.class))).thenReturn(metric);

        Metric savedMetric = metricService.saveMetric(metric);
        assertNotNull(savedMetric);
        assertEquals(25.0, savedMetric.getTemperature());
    }
    
    @Test
    void testGetMetrics() {
        List<Metric> expectedMetrics = List.of(new Metric(1L, new Sensor(), 25.0, 60.0, 5.0, LocalDateTime.now()));
        when(metricRepository.findAll()).thenReturn(expectedMetrics);

        List<Metric> metrics = metricService.getMetrics(1L, "2021-01-01", "2021-01-02", "average", "temperature");

        assertFalse(metrics.isEmpty());
        assertEquals(25.0, metrics.get(0).getTemperature());
    }
    
    @Test
    void testGetMetricStats() {
        List<Metric> metrics = List.of(new Metric(1L, new Sensor(), 25.0, 60.0, 5.0, LocalDateTime.now()));
        when(metricRepository.findBySensorIdAndTimestampBetween(anyLong(), any(), any())).thenReturn(metrics);

        MetricStats stats = metricService.getMetricStats(1L, "temperature", LocalDateTime.now().minusDays(1), LocalDateTime.now(), "min");

        assertNotNull(stats);
        assertEquals(25.0, stats.getValue());
    }
}
