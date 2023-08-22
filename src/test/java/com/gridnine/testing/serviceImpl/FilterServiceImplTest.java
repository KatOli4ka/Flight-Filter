package com.gridnine.testing.serviceImpl;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.service.FilterService;
import com.gridnine.testing.service.impl.FilterServiceImpl;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Тестируем класс бизнес-логики по работе с фильтрацией набора перелётов согласно различным правилам
 */
public class FilterServiceImplTest {
    private static final LocalDateTime DEPARTURE_DATE_ACTUAL = LocalDateTime.now().plusDays(1);
    private static final LocalDateTime DEPARTURE_DATE_NOT_ACTUAL = LocalDateTime.now().minusDays(1);
    private static final LocalDateTime ARRIVAL_DATE = DEPARTURE_DATE_ACTUAL.plusHours(4);
    private static final LocalDateTime ARRIVAL_DATE_NOT_CORRECT = LocalDateTime.now().minusHours(4);
    private Segment segmentCorrect;
    private Segment segmentNotCorrect1;
    private Segment segmentNotCorrect2;
    private final List<Flight> flightList = new ArrayList<>();
    private final List<Segment> segmentList1 = new ArrayList<>();
    private final List<Segment> segmentList2 = new ArrayList<>();
    private FilterService filterService;

    @BeforeEach
    public void setup() {

        filterService = new FilterServiceImpl();

        segmentCorrect = new Segment(DEPARTURE_DATE_ACTUAL, ARRIVAL_DATE);
        segmentNotCorrect1 = new Segment(DEPARTURE_DATE_NOT_ACTUAL, ARRIVAL_DATE);
        segmentNotCorrect2 = new Segment(DEPARTURE_DATE_ACTUAL, ARRIVAL_DATE_NOT_CORRECT);
    }

    @Test
    public void testRemoveFlightUpToTheCurrentPointInTime() {

        segmentList1.add(segmentCorrect);
        segmentList2.add(segmentNotCorrect1);

        flightList.add(new Flight(segmentList1));
        flightList.add(new Flight(segmentList2));

        assertEquals(2, flightList.size());

        List<Flight> result = filterService.removeFlightUpToTheCurrentPointInTime(flightList);

        assertEquals(1, result.size());
        assertEquals(DEPARTURE_DATE_ACTUAL, result.get(0).getSegments().get(0).getDepartureDate());
    }

    @Test
    public void testRemoveSegmentsWithAnArrivalDateEarlierThanTheDepartureDate() {

        segmentList1.add(segmentCorrect);
        segmentList2.add(segmentNotCorrect2);

        flightList.add(new Flight(segmentList1));
        flightList.add(new Flight(segmentList2));

        assertEquals(2, flightList.size());

        List<Flight> result = filterService.removeSegmentsWithAnArrivalDateEarlierThanTheDepartureDate(flightList);

        assertEquals(1, result.size());
        assertEquals(ARRIVAL_DATE, result.get(0).getSegments().get(0).getArrivalDate());
    }

    @Test
    public void testRemoveTimeSpentOnEarthExceedsTwoHours() {

        segmentList1.add(segmentCorrect);
        segmentList2.add(segmentNotCorrect2);
        segmentList2.add(segmentNotCorrect1);

        flightList.add(new Flight(segmentList1));
        flightList.add(new Flight(segmentList2));

        assertEquals(2, flightList.size());

        List<Flight> result = filterService.removeTimeSpentOnEarthExceedsTwoHours(flightList);

        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getSegments().size());
        assertEquals(ARRIVAL_DATE, result.get(0).getSegments().get(0).getArrivalDate());
    }
}
