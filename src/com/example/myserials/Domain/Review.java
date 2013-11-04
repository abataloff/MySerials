package com.example.myserials.Domain;

/**
 * Created by abataloff on 19.10.13.
 */
public class Review {
    public Serial getSerial() {
        return serial;
    }

    Serial serial;

    public ISeriesNumber getSeriesNumber() {
        return seriesNumber;
    }

    ISeriesNumber seriesNumber;

    public Review(Serial a_serial,ISeriesNumber a_seriesNumber){
        serial = a_serial;
        seriesNumber = a_seriesNumber;
    }

    public void Reviewed()
    {
        seriesNumber.Inc();
    }
}
