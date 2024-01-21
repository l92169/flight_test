package com.example.testflights.controller;

import com.example.testflights.model.enums.Location;
import com.example.testflights.service.StatisticsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistics")
@AllArgsConstructor
@Tag(name = "Statistics", description = "Get some information about tickets")
public class StatisticsController {
    private StatisticsService statisticsService;

    @GetMapping("/min-time")
    @Operation(summary = "Minimum flight time between cities\n" +
            "Vladivostok and Tel Aviv in minutes")
    public List<Object[]> getMinTimeBetweenVVOandTLV() {
        return statisticsService.getMinTimeForEachCarrier(Location.VVO.toString(), Location.TLV.toString());
    }

    @GetMapping("/diff-avg-medium")
    @Operation(summary = "Get difference between the average price and the median")
    public Integer getDiffAvgMediumBetweenVVOandTLV() {
        return statisticsService.getDiffAvgMedian(Location.VVO.toString(), Location.TLV.toString());
    }

    @DeleteMapping()
    @Operation(summary = "Delete all tickets")
    public void deleteTickets() {
        statisticsService.deleteTickets();
    }
}
