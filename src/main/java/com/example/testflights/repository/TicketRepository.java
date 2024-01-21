package com.example.testflights.repository;

import com.example.testflights.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    @Query(value = "SELECT t.carrier, MIN(extract(epoch from t.arrival - t.departure)) / 60 " +
            "FROM Ticket t " +
            "WHERE t.origin = :origin AND t.destination = :destination " +
            "GROUP BY t.carrier", nativeQuery = true)
    List<Object[]> getTicketsWithMinTime(@Param("origin") String origin,
                                         @Param("destination") String destination);

    @Query(value = "SELECT (AVG(t.price) - PERCENTILE_CONT(0.5) WITHIN GROUP ( ORDER BY t.price )) FROM Ticket t " +
            "WHERE t.origin = :origin AND t.destination = :destination", nativeQuery = true)
    Integer getDiffAvgAndMedian(@Param("origin") String origin,
                                @Param("destination") String destination);
}
