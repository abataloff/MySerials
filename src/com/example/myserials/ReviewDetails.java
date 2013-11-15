package com.example.myserials;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myserials.Domain.Review;
import com.example.myserials.net.Provider;

/**
 * Created by abataloff on 04.11.13.
 */
public class ReviewDetails extends Activity {

    private Review review;

    private Provider provider;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_details);

        provider = Provider.getCurrent();
        //int position = savedInstanceState.getInt("Position");
        int position =MainActivity.curPosition;
        review = provider.getMyViews()[position];
        TextView serialName = (TextView) findViewById(R.id.reviewDetails_serialName);
        serialName.setText(review.getSerial().getName());
    }

    public void onDelete(View a_aview)
    {
        provider.removeReviewd(review);
    }

    public void onReviewed(View a_view)
    {
        review.Reviewed();
    }
}