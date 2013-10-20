package com.example.myserials.Domain;

/**
 * Created by abataloff on 20.10.13.
 */
public class SeasonAndSeriesNumber implements ISeriesNumber {

    SeriesNumeration seriesNumeration;

    public SeriesNumeration getSeriesNumeration()
    {
       return seriesNumeration;
    }

    public void setSeriesNumeration(SeriesNumeration a_seriesNumeration)
    {
        seriesNumeration = a_seriesNumeration;
    }

    public void  Inc()
    {

    }
}
