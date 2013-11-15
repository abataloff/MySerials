package com.example.myserials.Domain;

/**
 * Created by abataloff on 10.11.13.
 */
public interface ISerial {
    SeriesNumeration getSeriesNumerationType();
    String getName();
    int[] getSeriesMap();
    int getId();
}
