package com.example.lifecycledemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_clicker;
    TextView tv_counter;

    int clicks = 0;


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("clickervalue",clicks);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        clicks = savedInstanceState.getInt("clickervalue");
        tv_counter = findViewById(R.id.tv_counter);
        tv_counter.setText(Integer.toString(clicks));
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("myTag","The app is Paused");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("myTag","The app is Resumed");

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("myTag","The app is Restarted");

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("myTag","The app is Started");

    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("myTag","The app is Stopped");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("myTag","The app is Destroyed");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("myTag","The app is Created");

        btn_clicker = findViewById(R.id.btn_button);
        tv_counter = findViewById(R.id.tv_counter);

        btn_clicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks++;
                tv_counter.setText(Integer.toString(clicks));
            }
        });

    }


}
