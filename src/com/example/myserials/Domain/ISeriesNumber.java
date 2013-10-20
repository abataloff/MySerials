package com.example.myserials.Domain;

/**
 * Created by abataloff on 19.10.13.
 */
public interface ISeriesNumber {
    SeriesNumeration getSeriesNumeration();
    void setSeriesNumeration(SeriesNumeration a_seriesNumeration);
    void  Inc();
}
