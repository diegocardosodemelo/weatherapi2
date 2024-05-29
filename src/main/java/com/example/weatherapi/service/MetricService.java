package com.example.weatherapi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.OptionalDouble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.weatherapi.model.Metric;
import com.example.weatherapi.model.dto.MetricStats;
import com.example.weatherapi.repository.MetricRepository;

@Service
public class MetricService {

    @Autowired
    private MetricRepository metricRepository;

    public Metric saveMetric(Metric metric) {
        return metricRepository.save(metric);
    }

    public List<Metric> getMetrics(Long sensorId, String fromDate, String toDate, String statistic, String metricType) {
        return metricRepository.findAll(); // Placeholder
    }
    
    public MetricStats getMetricStats(Long sensorId, String metric, LocalDateTime start, LocalDateTime end, String stat) {
        List<Metric> metrics = metricRepository.findBySensorIdAndTimestampBetween(sensorId, start, end);

        if (start == null || end == null) {
            metrics = metricRepository.findTopBySensorIdOrderByTimestampDesc(sensorId);
        }

        return calculateStat(metrics, metric, stat);
    }

    private MetricStats calculateStat(List<Metric> metrics, String metric, String stat) {
        OptionalDouble result;
        switch (stat.toLowerCase()) {
            case "min":
                result = metrics.stream().mapToDouble(m -> m.getValueByMetric(metric)).min();
                break;
            case "max":
                result = metrics.stream().mapToDouble(m -> m.getValueByMetric(metric)).max();
                break;
            case "sum":
                return new MetricStats(metrics.stream().mapToDouble(m -> m.getValueByMetric(metric)).sum());
            case "average":
                result = metrics.stream().mapToDouble(m -> m.getValueByMetric(metric)).average();
                break;
            default:
                throw new IllegalArgumentException("Invalid statistic type: " + stat);
        }
        return new MetricStats(result.isPresent() ? result.getAsDouble() : 0);
    }
}