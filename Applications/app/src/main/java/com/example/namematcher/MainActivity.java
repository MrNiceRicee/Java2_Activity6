package com.example.namematcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_compute;
    ImageView iv_needle;
    EditText et_yourname, et_otherperson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_compute = findViewById(R.id.btn_compute);
        iv_needle = findViewById(R.id.iv_needle);

        et_yourname = findViewById(R.id.et_yourname);
        et_otherperson = findViewById(R.id.et_otherpersonname);

        btn_compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yourName = et_yourname.getText().toString().toLowerCase();
                String otherPerson = et_otherperson.getText().toString().toLowerCase();


                float totalLetters = yourName.length() + otherPerson.length();
                float totalMatches = 0;

                for (int i =0; i < yourName.length(); i++)
                {
                    for (int j =0; j< otherPerson.length(); j++) {
                        if (yourName.charAt(i)==otherPerson.charAt(j)){
                            totalMatches++;
                        }
                    }
                }

                for (int i =0; i < otherPerson.length(); i++)
                {
                    for (int j =0; j< yourName.length(); j++) {
                        if (otherPerson.charAt(i)==yourName.charAt(j)){
                            totalMatches++;
                        }
                    }
                }

                float compatScore = totalMatches/totalLetters;
                int compScore = (((int) (compatScore*100))-50);
                Toast.makeText(MainActivity.this,"Compat Score = "+compatScore, Toast.LENGTH_SHORT).show();


                RotateAnimation ra = new RotateAnimation(0,360 +compScore, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);

                ra.setFillAfter(true);
                ra.setDuration(2000);
                ra.setInterpolator(new AccelerateDecelerateInterpolator());
                iv_needle.startAnimation(ra);
            }
        });
    }
}
