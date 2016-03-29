package com.agricisins.hscardexplorer.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.agricisins.hscardexplorer.R;
import com.agricisins.hscardexplorer.custom_views.CarouselView;

public class CardBrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_browser);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            toolbar.setTitle("Card Browser");
            setSupportActionBar(toolbar);
        }

        CarouselView carouselView = (CarouselView) findViewById(R.id.carousel_view);
        if (carouselView != null) {
            carouselView.setData(new Integer[]{
                    R.drawable.dru_shit, R.drawable.op_shit, R.drawable.mind_control,
                    R.drawable.pyroblast, R.drawable.warlock_op_op
            });
        }

    }
}
