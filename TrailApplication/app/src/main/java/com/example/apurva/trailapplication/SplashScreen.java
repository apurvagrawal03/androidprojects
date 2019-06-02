package com.example.apurva.trailapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


/**
 * Created by apurva on 24/2/19.
 */

public class SplashScreen extends AppCompatActivity {

    private ImageView mImageSanyuktLogo,mImageTithbiLogo,mImageLogo,mImageSuswagatamLogo,mImageVanyabibhagLogo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_splash);
        init();

        //Animation of the splash screen
        Animation myAnim= AnimationUtils.loadAnimation(this,R.anim.mytransition);
        mImageSanyuktLogo.startAnimation(myAnim);
        mImageTithbiLogo.startAnimation(myAnim);
        mImageLogo.startAnimation(myAnim);
        mImageSuswagatamLogo.startAnimation(myAnim);
        mImageVanyabibhagLogo.startAnimation(myAnim);

        //Splash screen duration for jump after a particular time to another activity
        Thread myyThread=new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(5000);
                    Intent intent=new Intent(getApplicationContext(),IntroActivity.class);
                    startActivity(intent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {

                }
            }
        };
        myyThread.start();
    }
    //Initiase the views
    public void init()
    {
        mImageSanyuktLogo= (ImageView) findViewById(R.id.ImageSanyuktLogo);
        mImageTithbiLogo= (ImageView) findViewById(R.id.ImageThitbhiLogo);
        mImageLogo= (ImageView) findViewById(R.id.ImageLogo);
        mImageSuswagatamLogo= (ImageView) findViewById(R.id.ImageSuswagatamLogo);
        mImageVanyabibhagLogo= (ImageView) findViewById(R.id.ImageVanvibhagLogo);
    }
}
