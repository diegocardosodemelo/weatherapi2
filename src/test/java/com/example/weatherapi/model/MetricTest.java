package com.example.weatherapi.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class MetricTest {
    @Test
    public void testGetValueByMetric() {
        Sensor sensor = new Sensor(1L, "Sensor1");
        Metric metric = new Metric(1L, sensor, 25.5, 70.0, 15.5, LocalDateTime.now());

        assertEquals(25.5, metric.getValueByMetric("temperature"), "Temperature should match");
        assertEquals(70.0, metric.getValueByMetric("humidity"), "Humidity should match");
        assertEquals(15.5, metric.getValueByMetric("windspeed"), "Wind speed should match");
        assertThrows(IllegalArgumentException.class, () -> metric.getValueByMetric("unknown"), "Should throw an exception for unknown metrics");
    }
}