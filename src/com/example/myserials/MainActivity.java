package com.example.myserials;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myserials.Adapters.ReviewArrayAdapter;
import com.example.myserials.Domain.Review;
import com.example.myserials.net.Provider;

public class MainActivity extends ListActivity
{
    Provider provider;
    private ListAdapter adapter;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        provider = new Provider(this);
        adapter = new ReviewArrayAdapter(this,provider.getMyViews());
        refresh();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onResume(Bundle savedInstanceState)
    {
        refresh();
    }

    public void onDestroy()
    {
        provider.save();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Review selectedValue = (Review) getListAdapter().getItem(position);
        selectedValue.Reviewed();
        refresh();
    }

    void refresh()
    {
        setListAdapter(adapter);
    }
}
