package com.gridnine.testing.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тестируем класс перелетов
 */
public class FlightTest {
    private static final LocalDateTime DEPARTURE_DATE_ACTUAL = LocalDateTime.now().plusDays(1);
    private static final LocalDateTime ARRIVAL_DATE = DEPARTURE_DATE_ACTUAL.plusHours(4);

    @Test
    void testGetSegments() {
        List<Segment> segments = Arrays.asList(
                new Segment(DEPARTURE_DATE_ACTUAL, ARRIVAL_DATE),
                new Segment(DEPARTURE_DATE_ACTUAL, ARRIVAL_DATE),
                new Segment(DEPARTURE_DATE_ACTUAL, ARRIVAL_DATE)
        );

        Flight flight = new Flight(segments);

        assertEquals(segments, flight.getSegments());
    }

    @Test
    void testToString() {
        List<Segment> segments = Arrays.asList(
                new Segment(DEPARTURE_DATE_ACTUAL, ARRIVAL_DATE),
                new Segment(DEPARTURE_DATE_ACTUAL, ARRIVAL_DATE)
        );

        Flight flight = new Flight(segments);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String expected = "[" + DEPARTURE_DATE_ACTUAL.format(fmt) +
                "|" + ARRIVAL_DATE.format(fmt) + "]";
        assertEquals(expected + " " + expected, flight.toString());
    }
}
