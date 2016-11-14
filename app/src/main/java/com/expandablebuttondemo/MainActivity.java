package com.expandablebuttondemo;


/**
 * Created by StanlyMoses on 31/10/16.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button verticalBtn, horizontalBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        verticalBtn = (Button) findViewById(R.id.showVertical);
        horizontalBtn = (Button) findViewById(R.id.showHorizontal);

        verticalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), VerticalExpandActivity.class));
            }
        });


        horizontalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HorizontalExpandActivity.class));
            }
        });

    }
}
