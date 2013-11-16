package com.example.myserials;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myserials.Adapters.ReviewArrayAdapter;
import com.example.myserials.Domain.ISerial;
import com.example.myserials.Domain.Review;
import com.example.myserials.net.Provider;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity
{
    Provider provider;
    private ListAdapter adapter;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        provider = new Provider(this);
        refresh();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public void onDestroy()
    {
        super.onDestroy();
        provider.save();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        showReviewDetails(position);
    }

    void refresh()
    {
        adapter = new ReviewArrayAdapter(this, provider.getMyViews());
        setListAdapter(adapter);
    }

    public static int curPosition;
    void showReviewDetails(int a_position)
    {
        Intent _intent = new Intent(MainActivity.this, ReviewDetails.class);
        Bundle _bundle = new Bundle();
        _bundle.putInt("Position", a_position);
        curPosition = a_position;
        startActivity(_intent,_bundle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_addView:
                addView();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public static ISerial[] Serials;
    void addView()
    {
        ISerial[] _freeSerials = provider.getFreeSerials();

        if(_freeSerials.length>0)
        {
            ArrayList<Integer> _ids = new ArrayList<Integer>();

            for (int i = 0; i < _freeSerials.length;i++)
            {
                _ids.add(_freeSerials[i].getId());
            }

            Intent _intent = new Intent(MainActivity.this, SerialsActivity.class);
            Bundle _bundle = new Bundle();
            //_bundle.putIntegerArrayList("serials", _ids);
            Serials = _freeSerials;
            startActivity(_intent,_bundle);
        }
        else
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Нет новых сериалов", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
