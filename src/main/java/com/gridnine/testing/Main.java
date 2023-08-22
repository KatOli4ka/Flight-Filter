package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.impl.FilterServiceImpl;

import java.util.List;

public class Main {
    private static final FilterServiceImpl filterService = new FilterServiceImpl();
    private static final List<Flight> flightList = FlightBuilder.createFlights();
    public static void main(String[] args) {
        // изначальный список перелетов, сгенерированный FlightBuilder
        allFlightList();

        // вывод перелетов с актуальными датами вылетов
        removeFlightUpToTheCurrentPointInTime();

        // вывод перелетов без сегментов с датой прилёта раньше даты вылета
        removeSegmentsWithAnArrivalDateEarlierThanTheDepartureDate();

        // вывод перелетов без пересадок и/или с пересадками не более 2-х часов
        removeTimeSpentOnEarthExceedsTwoHours();
    }


    private static void allFlightList() {

        separator();
        System.out.println(flightList);
    }

    private static void removeFlightUpToTheCurrentPointInTime() {

        separator();
        System.out.println(filterService.removeFlightUpToTheCurrentPointInTime(flightList));
    }

    private static void removeSegmentsWithAnArrivalDateEarlierThanTheDepartureDate() {

        separator();
        System.out.println(filterService.removeSegmentsWithAnArrivalDateEarlierThanTheDepartureDate(flightList));
    }

    private static void removeTimeSpentOnEarthExceedsTwoHours() {

        separator();
        System.out.println(filterService.removeTimeSpentOnEarthExceedsTwoHours(flightList));
    }

    private static void separator() {

        System.out.println("=======================================================================");
    }

}