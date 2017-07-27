package com.mcmurtry.testoftests;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);

        findViewById(R.id.helloButton).setOnClickListener((x) -> {
            ((TextView)findViewById(R.id.helloText)).setTextColor(Color.YELLOW);
        });
    }
}
