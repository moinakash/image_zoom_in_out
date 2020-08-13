package com.example.imagezoom_in_out;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.wajahatkarim3.easyflipview.EasyFlipView;

public class MainActivity extends AppCompatActivity {

    private ImageView shadow ;

    Button delete;
    private ViewFlipper viewFlipper, viewFlipper2,viewFlipper3;
    int x =0,y=0,z=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EasyFlipView imageView = (EasyFlipView) findViewById(R.id.idClick);
        shadow = (ImageView) findViewById(R.id.idShadow);
        delete = (Button) findViewById(R.id.idDetails);
        viewFlipper = findViewById(R.id.view_flipper);
        viewFlipper2 = findViewById(R.id.view_flipper_head);
        viewFlipper3 = findViewById(R.id.view_flipper_body);

        final Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim);
        final Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim2);

        final Animation animation3 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim3);
        final Animation animation4 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim4);
        final Animation Translate = AnimationUtils.loadAnimation(MainActivity.this,R.anim.translate);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(z==0){

                    imageView.setClickable(false);
                   // imageView.setFlipEnabled(false);
                    imageView.animate().translationX(-500).setDuration(1000);
                    shadow.animate().translationX(-500).setDuration(1000);
                    z=1;
                }else if(z==1){
                    imageView.setClickable(true);
                    imageView.animate().translationX(0).setDuration(1000);
                    shadow.animate().translationX(0).setDuration(1000);
                    z=0;
                }



            }
        });


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BG_slide();

                imageView.startAnimation(animation);

                shadow.startAnimation(animation4);

                if(y==0){
                    imageView.setFlipTypeFromRight();
                    y=1;

                }else if(y==1){

                    imageView.setFlipTypeFromLeft();
                    y=0;
                }

                imageView.flipTheView();

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {


                        imageView.startAnimation(animation2);
                        shadow.startAnimation(animation3);
                    }
                }, 999);


            }
        });




    }

    private void BG_slide(){

        if (x==0){
            viewFlipper.setInAnimation(this, R.anim.slide_in_right);
            viewFlipper.setOutAnimation(this, R.anim.slide_out_left);
            viewFlipper.showPrevious();


            viewFlipper2.setInAnimation(this, R.anim.slide_in_left_fast);
            viewFlipper2.setOutAnimation(this, R.anim.slide_out_right_fast);
            viewFlipper2.showNext();

            viewFlipper3.setInAnimation(this, R.anim.slide_in_right_fast);
            viewFlipper3.setOutAnimation(this, R.anim.slide_out_left_fast);
            viewFlipper3.showPrevious();

            x=1;
        }else if (x==1){
            viewFlipper.setInAnimation(this, R.anim.slide_in_left);
            viewFlipper.setOutAnimation(this, R.anim.slide_out_right);
            viewFlipper.showNext();

            viewFlipper2.setInAnimation(this, R.anim.slide_in_right_fast);
            viewFlipper2.setOutAnimation(this, R.anim.slide_out_left_fast);
            viewFlipper2.showPrevious();

            viewFlipper3.setInAnimation(this, R.anim.slide_in_left_fast);
            viewFlipper3.setOutAnimation(this, R.anim.slide_out_right_fast);
            viewFlipper3.showNext();

            x=0;
        }
    }


}