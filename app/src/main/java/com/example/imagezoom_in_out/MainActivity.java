package com.example.imagezoom_in_out;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.wajahatkarim3.easyflipview.EasyFlipView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EasyFlipView imageView = (EasyFlipView) findViewById(R.id.idClick);

        final Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim);
        final Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim2);

    /*    imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





            }
        });*/


        imageView.setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView flipView, EasyFlipView.FlipState newCurrentSide)
            {
                imageView.startAnimation(animation);

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        imageView.startAnimation(animation2);

                    }
                }, 1999);

            }
        });

    }


}