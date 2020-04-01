package com.example.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Button btn_spin;
    ImageView iv_bottle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_spin = findViewById(R.id.btn_spin);
        iv_bottle = findViewById(R.id.iv_bottle);

        btn_spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int theSpinDegrees;

                Random random = new Random();

                theSpinDegrees = random.nextInt(3600);

                RotateAnimation rotateAnimation = new RotateAnimation(0,theSpinDegrees,
                        Animation.RELATIVE_TO_SELF,0.5f,
                        Animation.RELATIVE_TO_SELF,0.5f);

                rotateAnimation.setDuration(2000);
                rotateAnimation.setFillAfter(true);

                rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());


                iv_bottle.startAnimation(rotateAnimation);


                rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        int Direction = theSpinDegrees % 360;
                        if ((Direction > 340)&&(Direction <= 360)){
                            Toast.makeText(MainActivity.this, "The person to the north has been chosen", Toast.LENGTH_SHORT).show();
                        }
                        else if((Direction <= 20)&& (Direction >=0)) {
                            Toast.makeText(MainActivity.this, "The person to the north has been chosen", Toast.LENGTH_SHORT).show();
                        }
                        else if ((Direction > 20)&&(Direction <= 65))
                        {
                            Toast.makeText(MainActivity.this, "the person to the north east has been chosen", Toast.LENGTH_SHORT).show();
                        }
                        else if ((Direction > 65)&&(Direction <= 110))
                        {
                            Toast.makeText(MainActivity.this, "the person to the east has been chosen", Toast.LENGTH_SHORT).show();
                        }
                        else if ((Direction > 110)&&(Direction <= 155))
                        {
                            Toast.makeText(MainActivity.this, "the person to the south east has been chosen", Toast.LENGTH_SHORT).show();
                        }
                        else if ((Direction > 155)&&(Direction <= 200))
                        {
                            Toast.makeText(MainActivity.this, "the person to the south has been chosen", Toast.LENGTH_SHORT).show();
                        }
                        else if ((Direction > 200)&&(Direction <= 245))
                        {
                            Toast.makeText(MainActivity.this, "the person to the south west has been chosen", Toast.LENGTH_SHORT).show();
                        }
                        else if ((Direction > 245)&&(Direction <= 290))
                        {
                            Toast.makeText(MainActivity.this, "the person to the west has been chosen", Toast.LENGTH_SHORT).show();
                        }
                        else if ((Direction > 290)&&(Direction <= 340))
                        {
                            Toast.makeText(MainActivity.this, "the person to the north west has been chosen", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });


            }
        });
    }
}
