package com.example.myserials.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myserials.R;

import com.example.myserials.Domain.Review;

/**
 * Created by abataloff on 03.11.13.
 */
public class ReviewArrayAdapter extends ArrayAdapter<Review> {

    private final Context context;
    private final Review[] values;

    public ReviewArrayAdapter(Context context, Review[] values) {
        super(context, R.layout.list_review, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_review, parent, false);
        TextView _nameView = (TextView) rowView.findViewById(R.id.reviewSeriesName);
        TextView _numberView = (TextView) rowView.findViewById(R.id.reviewSeriesNumber);
        _nameView.setText(values[position].getSerial().toString());
        _numberView.setText(values[position].getSeriesNumber().toString());
        return rowView;
    }

}
