package com.example.myserials;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity
{
    int tbbtSeason =0;
    int tbbtSerial =0;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        sharedPref = getPreferences(Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        setTbbtSeason(sharedPref.getInt("TbbtSeason", 1));
        setTbbtSerial(sharedPref.getInt("TbbtSerial", 1));
    }

    public void incTbbtSeason(View view)
    {
        setTbbtSeason(tbbtSeason+1);
        setTbbtSerial(1);
    }

    void setTbbtSeason(int numberSeason)
    {
        tbbtSeason=numberSeason;
        Button _btn = (Button) findViewById(R.id.TBBTSeason);
        _btn.setText(Integer.toString( tbbtSeason)+" сезон");
        editor.putInt("TbbtSeason",tbbtSeason);
        editor.commit();
    }
    public void incTbbtSerial(View view)
    {
        setTbbtSerial(tbbtSerial+1);
    }
    void setTbbtSerial(int numberSerial)
    {
        tbbtSerial=numberSerial;
        Button _btn = (Button) findViewById(R.id.TBBTSeries);
        _btn.setText(Integer.toString( tbbtSerial)+" сезон");
        editor.putInt("TbbtSerial",tbbtSerial);
        editor.commit();
    }

    public void resetTbbt(View view)
    {
        setTbbtSeason(1);
        setTbbtSerial(1);
    }
}
