package com.mercubuana.fauzimaulana.cipherxor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread welcome = new Thread(){
            @Override
            public void run(){
                try{
                    super.run();
                    sleep(2000);
                } catch (Exception e){

                } finally {
                    Intent i = new Intent(MainActivity.this, Dashboard.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        welcome.start();



    }
}
