package com.gridnine.testing.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Перелёт — это перевозка пассажира из одной точки
 * в другую с возможными промежуточными посадками.
 */
public class Flight {
    private final List<Segment> segments;

    public Flight(final List<Segment> segs) {
        segments = segs;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
