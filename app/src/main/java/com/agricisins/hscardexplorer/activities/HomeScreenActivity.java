package com.agricisins.hscardexplorer.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.agricisins.hscardexplorer.R;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_home_screen_browse_cards: {
                startActivity(new Intent(this, CardBrowserActivity.class));
                break;
            }
            default: {
                break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
