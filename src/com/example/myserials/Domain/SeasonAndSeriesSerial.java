package com.example.myserials.Domain;

/**
 * Created by abataloff on 19.10.13.
 */
public class SeasonAndSeriesSerial implements ISerial  {

    private int[] seriesMap;
    private int id;

    String name;

    public SeasonAndSeriesSerial(String a_name, int[] a_seriesMap, int a_id )
    {
        name = a_name;
        seriesMap = a_seriesMap;
        id = a_id;
    }

    @Override
    public String toString()
    {
        return getName();
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public SeriesNumeration getSeriesNumerationType() {
        return SeriesNumeration.SeasonAndSeries;
    }

    @Override
    public int[] getSeriesMap()
    {
        return seriesMap;
    }

    @Override
    public int getId()
    {
        return id;
    }
}
