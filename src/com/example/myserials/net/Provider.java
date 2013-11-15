package com.example.myserials.net;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.myserials.Domain.ISerial;
import com.example.myserials.Domain.ISeriesNumber;
import com.example.myserials.Domain.Review;
import com.example.myserials.Domain.SeasonAndSeriesNumber;
import com.example.myserials.Domain.SeasonAndSeriesSerial;
import com.example.myserials.Domain.SeriesNumeration;
import com.example.myserials.R;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;


/**
 * Created by abataloff on 19.10.13.
 */
public class Provider {

    public static Provider getCurrent() {
        return current;
    }

    private static Provider current;
    private Context context;
    public Provider (Context context)
    {
        current = this;
        this.context = context;
        load();
    }
    private ArrayList<Review> reviews;
    public Review[] getMyViews()
    {
        Review[] _arr = new Review[reviews.size()];
        return reviews.toArray(_arr);
    }
    public void save()
    {
        SharedPreferences _sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        SharedPreferences.Editor _editor = _sharedPref.edit();

        String _idSerialsString = "";
        for (int i = 0; i < reviews.size(); i++)
        {
            Review _review = reviews.get(i);
            if(i>0)
                _idSerialsString += ",";

            _idSerialsString += Integer.toString(_review.getSerial().getId());
            _editor.putString(_review.getSerial().getName(), _review.getSeriesNumber().toString());
        }

        _editor.putString("IdSerials", _idSerialsString);

        _editor.commit();
    }

    private void load()
    {
        reviews = new ArrayList<Review>();

        SharedPreferences _sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        Hashtable<Integer, ISerial> _serials = getSerials();

        String _idSerialsString = _sharedPref.getString("IdSerials","");
        if(_idSerialsString.contains(","))
        {
            String[] _arrIdSerials = _idSerialsString.split(",");
            for(int i =0; i< _arrIdSerials.length;i++)
            {
                int _id =  Integer.parseInt(_arrIdSerials[i]);
                if(_serials.containsKey(_id))
                {
                    ISerial _serial = _serials.get(_id);
                    String _seriesNumberString = _sharedPref.getString(_serial.getName(),"");
                    SeriesNumeration _numeration =  _serial.getSeriesNumerationType();
                    ISeriesNumber _number = createSeriesNumber(_numeration, _serial.getSeriesMap(),_seriesNumberString);
                    reviews.add(new Review(_serial,_number));
                }
            }
        }
        if (reviews.isEmpty())
        {
            reviews.add(new Review(_serials.get(1) ,new SeasonAndSeriesNumber(_serials.get(1).getSeriesMap(),6,8)));
            reviews.add(new Review(_serials.get(2) ,new SeasonAndSeriesNumber(_serials.get(2).getSeriesMap(),7,8)));
        }
    }

    ISeriesNumber createSeriesNumber(SeriesNumeration a_seriesNumeration, int[] a_seriesMap, String a_seriesNumberString)
    {
        ISeriesNumber _retNumber = null;

        switch (a_seriesNumeration)
        {
            case SeasonAndSeries:_retNumber = SeasonAndSeriesNumber.create(a_seriesMap,a_seriesNumberString);
                break;
        }
        return _retNumber;
    }

    public void removeReviewd(Review a_review) {
        reviews.remove(a_review);
    }

    public Hashtable<Integer, ISerial> getSerials()
    {
        ISerial _tbbt = new SeasonAndSeriesSerial("Теория большого взрыва",new int[] {0,17,23,23,24,24,24},1);
        ISerial _himym = new SeasonAndSeriesSerial("Как я встретил вашу маму",new int[] {0,22,22,20,24,24,24,24,24},2);
        ISerial[] _arr = new ISerial[]{_tbbt,_himym};
        Hashtable<Integer,ISerial> _retDic = new Hashtable<Integer, ISerial>();
        for(int i=0; i<_arr.length; i++)
        {
            ISerial _serial = _arr[i];
            _retDic.put(_serial.getId(),_serial);
        }
        return _retDic;
    }
}
