package com.expandablebuttondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.expandablebutton.HorizontalExpandableButton;


/**
 * Created by StanlyMoses on 31/10/16.
 */

public class HorizontalExpandActivity extends AppCompatActivity {

    HorizontalExpandableButton btnHike, btnYoutube, btnTwitter, btnInstagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal);

        btnHike = (HorizontalExpandableButton) findViewById(R.id.btn_hike);
        btnYoutube = (HorizontalExpandableButton) findViewById(R.id.btn_youtube);
        btnTwitter = (HorizontalExpandableButton) findViewById(R.id.btn_twitter);
        btnInstagram = (HorizontalExpandableButton) findViewById(R.id.btn_instagram);

        btnHike.setExpansionListener(view -> Toast.makeText(getApplicationContext(), R.string.clicked_hike, Toast.LENGTH_SHORT).show());

        btnYoutube.setExpansionListener(view -> Toast.makeText(getApplicationContext(), R.string.clicked_youtube, Toast.LENGTH_SHORT).show());

        btnTwitter.setExpansionListener(view -> Toast.makeText(getApplicationContext(), R.string.clicked_twitter, Toast.LENGTH_SHORT).show());

        btnInstagram.setExpansionListener(view -> Toast.makeText(getApplicationContext(), R.string.clicked_instagram, Toast.LENGTH_SHORT).show());
    }
}
