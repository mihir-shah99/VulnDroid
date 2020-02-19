package com.Mihir.VulnDroid.localstorage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public int totalCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("counter", totalCount);
        editor.apply();
    }

    public void launchsecond(View view)
    {
        Log.d(LOG_TAG, "Entering Level 1");
        Intent intent = new Intent(this, LogMe.class);
        startActivity(intent);
    }
    public void launchthird(View view) {
        Log.d(LOG_TAG, "Entering Level 2");
        Intent intent = new Intent(this, Unhash_me.class);
        startActivity(intent);
    }
    public void launchfourth(View view) {
        Log.d(LOG_TAG, "Entering Level 3");
        Intent intent = new Intent(this, ReadString.class);
        startActivity(intent);
    }
    public void launchfifth(View view) {
        Log.d(LOG_TAG, "Entering Level 4");
        Intent intent = new Intent(this, SharedPref.class);
        startActivity(intent);
    }
    public void launchseventh(View view) {
        Log.d(LOG_TAG, "Entering Level 5");
        Intent intent = new Intent(this, ReadMem.class);
        startActivity(intent);
    }
    public void launchscore(View view)
    {
        Log.d(LOG_TAG, "Checking the score");
        Intent intent = new Intent(this, Scoreboard.class);
        startActivity(intent);
    }
    public void launcheigth(View view)
    {
        Log.d(LOG_TAG, "Entering Level 6");
        Intent intent = new Intent(this, ReadDatabase.class);
        startActivity(intent);
    }
    public void launchninth(View view) {
        Log.d(LOG_TAG, "Entering Level 7");
        Intent intent = new Intent(this, insecureCert.class);
        startActivity(intent);
    }
    public void launchtenth(View view) {
        Log.d(LOG_TAG, "Entering Level 8");
        Intent intent = new Intent(this, InternalStorage.class);
        startActivity(intent);
    }
    public void launcheleventh(View view) {
        Log.d(LOG_TAG, "Entering Level 9");
        Intent intent = new Intent(this, ExternalStorage.class);
        startActivity(intent);
    }
}