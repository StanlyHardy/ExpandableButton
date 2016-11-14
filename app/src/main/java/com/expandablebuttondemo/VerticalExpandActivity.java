package com.expandablebuttondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.expandablebutton.VerticalExpandableButton;

/**
 * Created by StanlyMoses on 31/10/16.
 */
public class VerticalExpandActivity extends AppCompatActivity {

    VerticalExpandableButton btnHike, btnYoutube, btnTwitter, btnInstagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical);

        btnHike = (VerticalExpandableButton) findViewById(R.id.btn_hike);
        btnYoutube = (VerticalExpandableButton) findViewById(R.id.btn_youtube);
        btnTwitter = (VerticalExpandableButton) findViewById(R.id.btn_twitter);
        btnInstagram = (VerticalExpandableButton) findViewById(R.id.btn_instagram);

        btnHike.setExpansionListener(view -> Toast.makeText(getApplicationContext(), R.string.clicked_hike, Toast.LENGTH_SHORT).show());

        btnYoutube.setExpansionListener(view -> Toast.makeText(getApplicationContext(), R.string.clicked_youtube, Toast.LENGTH_SHORT).show());

        btnTwitter.setExpansionListener(view -> Toast.makeText(getApplicationContext(), R.string.clicked_twitter, Toast.LENGTH_SHORT).show());

        btnInstagram.setExpansionListener(view -> Toast.makeText(getApplicationContext(), R.string.clicked_instagram, Toast.LENGTH_SHORT).show());
    }
}
