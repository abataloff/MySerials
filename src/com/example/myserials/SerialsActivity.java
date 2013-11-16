package com.example.myserials;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.myserials.Adapters.ReviewArrayAdapter;
import com.example.myserials.Adapters.SerialArrayAdapter;
import com.example.myserials.Domain.ISerial;
import com.example.myserials.net.Provider;

import java.util.List;

/**
 * Created by abataloff on 16.11.13.
 */
public class SerialsActivity  extends ListActivity
{
    Provider provider;
    ISerial[] serials;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //serials = savedInstanceState.getIntegerArrayList("serials");
        provider= Provider.getCurrent();

        serials = MainActivity.Serials;
        SerialArrayAdapter adapter = new SerialArrayAdapter(this, serials);
        setListAdapter(adapter);
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
   {
       //ISerial _serial = provider.getSerialById(_idSerial);
       Provider.getCurrent().addNewViewOnSerial(serials[position]);
    }
}
