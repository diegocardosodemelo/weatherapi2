package com.example.weatherapi.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.weatherapi.service.MetricService;

@WebMvcTest(MetricController.class)
public class MetricControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MetricService metricService;

    @Test
    public void testGetMetricsBySensorAndDateRange() throws Exception {
        // Assuming you have an endpoint that takes these parameters
        mockMvc.perform(get("/metrics/statistics")
                .param("sensorId", "1")
                .param("metric", "temperature")
                .param("stat", "average")
                .param("start", "2024-05-01T00:00:00")
                .param("end", "2024-05-07T23:59:59"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value(25.5));
        
        // Verify interaction and setup correct return values in mock setup
    }
}