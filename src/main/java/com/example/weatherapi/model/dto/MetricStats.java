package com.example.weatherapi.model.dto;

public class MetricStats {
    private double value;

    public MetricStats(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}