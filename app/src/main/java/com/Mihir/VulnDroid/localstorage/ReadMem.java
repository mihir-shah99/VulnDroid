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


public class ReadMem extends AppCompatActivity {
    Button b1;
    public int totalCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_mem);
        setTitle("Info in Functions");
        b1= findViewById(R.id.click_btn1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              callme();
                Toast.makeText(ReadMem.this, "Function call is successful", Toast.LENGTH_SHORT).show();
            }
        });
        Button b1 = findViewById(R.id.button3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText mEditText = findViewById(R.id.editText3);
                String str = mEditText.getText().toString();
                String hey = md5(str);
                if (hey.equals("4ce868d6a47d58b023fd9b8da75f5d40"))
                {
                    SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    Intent intenti = new Intent(ReadMem.this, congo.class);
                    startActivity(intenti);
                    editor.putInt("counter1", totalCount);
                    totalCount = prefs.getInt("counter", 0);
                    totalCount+=100;
                    editor.putInt("counter1", totalCount);
                    editor.apply();
                }
                else
                {
                    Toast.makeText(ReadMem.this, "C'mon, TRY HARDER!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public String callme(){
        String a = "48EEE90286A2250DE7FAE143E4E029524C3021F679EED5D1A3557BD754796389";
        String decrypted = "";
        try {
            decrypted = AESUtils.decrypt(a);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return decrypted;
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
