package com.Mihir.VulnDroid.localstorage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class SharedPref extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;
    public int totalCount=0;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);
        setTitle("Info in editor");

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_WORLD_READABLE);
        String n = "BCB07BFB7B57E7C786250F6B58515F8BB645C93B112C657FD2E36A640C3F982A";
        SharedPreferences.Editor editor = sharedpreferences.edit();
        String decrypted = "";
        try {
            decrypted = AESUtils.decrypt(n);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        editor.putString("flag", decrypted);
        editor.apply();
        Button b1 = findViewById(R.id.button4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText mEditText= findViewById(R.id.editText4);
                String str = mEditText.getText().toString();
                String hey = md5(str);
                if (hey.equals("0c28cfbd460bd977f9c688479ba10ba3"))
                {
                    SharedPreferences prefs = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    Intent intenti = new Intent(SharedPref.this, congo.class);
                    startActivity(intenti);
                    totalCount = prefs.getInt("counter", 0);
                    totalCount+=100;
                    editor.putInt("counter", totalCount);
                    editor.commit();
                }
                else
                {
                    Toast.makeText(SharedPref.this, "C'mon, TRY HARDER!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public static String md5(String s)
    {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(s.getBytes(Charset.forName("US-ASCII")), 0, s.length());
            byte[] magnitude = digest.digest();
            BigInteger bi = new BigInteger(1, magnitude);
            String hash = String.format("%0" + (magnitude.length << 1) + "x", bi);
            return hash;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}