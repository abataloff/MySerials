package com.example.myserials.net;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.myserials.Domain.Review;
import com.example.myserials.Domain.SeasonAndSeriesNumber;
import com.example.myserials.Domain.Serial;
import com.example.myserials.R;


/**
 * Created by abataloff on 19.10.13.
 */
public class Provider {
    private Context context;
    public Provider (Context context)
    {
        this.context = context;
        load();
    }
    private Review[] reviews;
    public Review[] getMyViews()
    {
        return reviews;
    }
    public void save()
    {
        SharedPreferences _sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor _editor = _sharedPref.edit();

        SeasonAndSeriesNumber _tbbtNum = (SeasonAndSeriesNumber) reviews[0].getSeriesNumber();
        SeasonAndSeriesNumber _himymNum = (SeasonAndSeriesNumber) reviews[1].getSeriesNumber();
        _editor.putInt("tbbtSeason", _tbbtNum.getSeasonNumber());
        _editor.putInt("tbbtSeries", _tbbtNum.getSeriesNumber());
        _editor.putInt("himymSeason", _himymNum.getSeasonNumber());
        _editor.putInt("himymSeries", _himymNum.getSeriesNumber());

        _editor.commit();
    }

    private void load()
    {
        Serial _tbbt = new Serial("Теория большого взрыва");
        Serial _himym = new Serial("Как я встретил вашу маму");
        int[] _seriesMapTbbt =new int[] {0,17,23,23,24,24,24};
        int[] _seriesMapHimym =new int[] {0,22,22,20,24,24,24,24,24};

        SharedPreferences _sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        int _tbbtSeason = _sharedPref.getInt("tbbtSeason",7);
        int _tbbtSeries = _sharedPref.getInt("tbbtSeries",7);
        int _himymSeason = _sharedPref.getInt("himymSeason",9);
        int _himymSeries = _sharedPref.getInt("himymSeries",8);

        Review _tbbtReview = new Review(_tbbt, new SeasonAndSeriesNumber(_seriesMapTbbt, _tbbtSeason, _tbbtSeries));
        Review _himymReview = new Review(_himym ,new SeasonAndSeriesNumber(_seriesMapHimym, _himymSeason, _himymSeries));

        reviews = new Review[]{_tbbtReview,_himymReview};
    }
}
