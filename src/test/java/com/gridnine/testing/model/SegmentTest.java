package com.gridnine.testing.model;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Тестируем класс сегментов
 */
public class SegmentTest {
    @Test
    public void testGetDepartureDate() {

        LocalDateTime departureDate = LocalDateTime.of(2023, 1, 1, 12, 0);
        LocalDateTime arrivalDate = LocalDateTime.of(2023, 1, 1, 14, 0);
        Segment segment = new Segment(departureDate, arrivalDate);

        LocalDateTime result = segment.getDepartureDate();

        assertEquals(departureDate, result);
    }

    @Test
    public void testGetArrivalDate() {

        LocalDateTime departureDate = LocalDateTime.of(2023, 1, 1, 12, 0);
        LocalDateTime arrivalDate = LocalDateTime.of(2023, 1, 1, 14, 0);
        Segment segment = new Segment(departureDate, arrivalDate);

        LocalDateTime result = segment.getArrivalDate();

        assertEquals(arrivalDate, result);
    }

    @Test
    public void testToString() {

        LocalDateTime departureDate = LocalDateTime.of(2023, 1, 1, 12, 0);
        LocalDateTime arrivalDate = LocalDateTime.of(2023, 1, 1, 14, 0);
        Segment segment = new Segment(departureDate, arrivalDate);

        String result = segment.toString();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String expected = "[" + departureDate.format(formatter) + "|" + arrivalDate.format(formatter) + "]";

        assertEquals(expected, result);
    }
}
