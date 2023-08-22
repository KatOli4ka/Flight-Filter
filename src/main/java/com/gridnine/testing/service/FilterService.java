package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

import java.util.List;

/**
 * Сервис фильтрации набора перелётов согласно различным правилам
 */
public interface FilterService {
    /**
     * Исключение вылетов до текущего момента времени из общего списка
     *
     * @param flightBuilder - общий список перелетов
     * @return отфильтрованный список без вылетов до текущего момента времени
     */
    List<Flight> removeFlightUpToTheCurrentPointInTime(List<Flight> flightBuilder);

    /**
     * Исключение перелетов, где сегменты с датой прилёта раньше даты вылета из общего списка
     *
     * @param flightBuilder - общий список перелетов
     * @return отфильтрованный список без перелетов,
     * где сегменты с датой прилёта раньше даты вылета из общего списка
     */
    List<Flight> removeSegmentsWithAnArrivalDateEarlierThanTheDepartureDate(List<Flight> flightBuilder);

    /**
     * Исключение перелетов, где общее время, проведённое на земле, превышает два часа
     *
     * @param flightBuilder - общий список перелетов
     * @return отфильтрованный список без перелетов,
     * где общее время, проведённое на земле, превышает два часа
     */
    List<Flight> removeTimeSpentOnEarthExceedsTwoHours(List<Flight> flightBuilder);
}
