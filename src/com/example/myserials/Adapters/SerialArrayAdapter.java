package com.example.myserials.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myserials.Domain.ISerial;
import com.example.myserials.Domain.Review;
import com.example.myserials.R;

/**
 * Created by abataloff on 03.11.13.
 */
public class SerialArrayAdapter extends ArrayAdapter<ISerial> {

    private final Context context;
    private final ISerial[] values;

    public SerialArrayAdapter(Context context, ISerial[] values) {
        super(context, R.layout.list_serial, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_serial, parent, false);
        TextView _nameView = (TextView) rowView.findViewById(R.id.serialName);
        _nameView.setText(values[position].getName());
        return rowView;
    }

}
