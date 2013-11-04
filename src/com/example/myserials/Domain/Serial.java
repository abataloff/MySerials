package com.example.myserials.Domain;

/**
 * Created by abataloff on 19.10.13.
 */
public class Serial {

    public String getName() {
        return name;
    }

    String name;

    public Serial(String a_name)
    {
        name = a_name;
    }

    @Override public String toString()
    {
        return getName();
    }
}
