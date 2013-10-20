package com.example.myserials.Domain;

/**
 * Created by abataloff on 19.10.13.
 */
public class Review {

    public Serial Serial;
    ISerialNumber SerialNumber;

    public Review(Serial a_serial,ISerialNumber a_serialNumber){
        Serial = a_serial;
        SerialNumber = a_serialNumber;
    }
}
