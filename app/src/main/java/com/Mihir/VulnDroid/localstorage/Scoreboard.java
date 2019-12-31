package com.Mihir.VulnDroid.localstorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Locale;

public class Scoreboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        setTitle("ScoreBoard");
        SharedPreferences prefs = this.getSharedPreferences("counter", Context.MODE_PRIVATE);
        int score = prefs.getInt("counter",0);
        TextView mtv = findViewById(R.id.score);
        mtv.setText(String.format(Locale.US,"%d",score));
    }
}
