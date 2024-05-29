package com.example.weatherapi.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.weatherapi.model.Metric;
import com.example.weatherapi.model.dto.MetricStats;
import com.example.weatherapi.service.MetricService;

@RestController
@RequestMapping("api/metrics")
public class MetricController {

    @Autowired
    private MetricService metricService;

    @PostMapping
    public Metric addMetric(@RequestBody Metric metric) {
        return metricService.saveMetric(metric);
    }

    @GetMapping
    public List<Metric> getMetricsBySensorAndDateRange(
            @RequestParam(required = false) Long sensorId,
            @RequestParam(required = false) String fromDate,
            @RequestParam(required = false) String toDate,
            @RequestParam(required = false) String statistic,
            @RequestParam(required = false) String metricType) {
        return metricService.getMetrics(sensorId, fromDate, toDate, statistic, metricType);
    }
    
    @GetMapping("/stats")
    public MetricStats getStats(@RequestParam Long sensorId, @RequestParam String metric, @RequestParam(required = false) LocalDateTime start, @RequestParam(required = false) LocalDateTime end, @RequestParam String stat) {
        return metricService.getMetricStats(sensorId, metric, start, end, stat);
    }
}