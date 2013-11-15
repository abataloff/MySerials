package com.example.myserials.Domain;

/**
 * Created by abataloff on 19.10.13.
 */
public class Review {
    public ISerial getSerial() {
        return serial;
    }

    ISerial serial;

    public ISeriesNumber getSeriesNumber() {
        return seriesNumber;
    }

    ISeriesNumber seriesNumber;

    public Review(ISerial a_serial,ISeriesNumber a_lastReviewedSeriesNumber){
        serial = a_serial;
        seriesNumber = a_lastReviewedSeriesNumber;
    }

    public void Reviewed()
    {
        seriesNumber.Inc();
    }
}
