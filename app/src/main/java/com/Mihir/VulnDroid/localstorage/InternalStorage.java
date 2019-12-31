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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class InternalStorage extends AppCompatActivity {
    public int totalCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);
        setTitle("Internal Storage");

        try {
            writeFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Button b1 = findViewById(R.id.button3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText mEditText= findViewById(R.id.editText3);
                String str = mEditText.getText().toString();
                String hey = md5(str);
                if (hey.equals("d65a06371ead59453950464ff071311d"))
                {
                    SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    totalCount = prefs.getInt("counter", 0);
                    totalCount+=100;
                    editor.putInt("counter", totalCount);
                    editor.apply();
                    Intent intenti = new Intent(InternalStorage.this, congo.class);
                    startActivity(intenti);
                }
                else
                {
                    Toast.makeText(InternalStorage.this, "C'mon, TRY HARDER!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

            private void writeFile() throws Exception {
                String FILENAME = "flag.txt";
                String flag = "";

                try {
                    flag = AESUtils.decrypt("E002FB444709E8CE166917B37106655574E412283656C6584ED95EF25110B5D6");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                FileOutputStream fos = null;
                try {
                    fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                fos.write(flag.getBytes());
                fos.close();
            }

            public static String md5(String s) {
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