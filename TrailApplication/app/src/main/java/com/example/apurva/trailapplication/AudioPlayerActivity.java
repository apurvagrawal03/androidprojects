package com.example.apurva.trailapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;

import java.io.IOException;

/**
 * Created by apurva on 22/2/19.
 */

public class AudioPlayerActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnPlay,btnFor,btnBack;
    private SeekBar seekbar;
    private MediaPlayer mediaPlayer;
    private Runnable runnable;
    private Handler handler;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_audio_player);

        //Initialise the views
        btnPlay= (ImageButton) findViewById(R.id.btnPlay);
        btnFor= (ImageButton) findViewById(R.id.btnFor);
        btnBack= (ImageButton) findViewById(R.id.btnBack);
        seekbar= (SeekBar) findViewById(R.id.seekbar);
        handler=new Handler();




        //Initialise the media player
        mediaPlayer=new MediaPlayer();
        Intent intent=getIntent();
        Uri audioUri=intent.getData();
        try {
            mediaPlayer.setDataSource(getApplicationContext(),audioUri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Here calling of buttons on click listener
        btnBack.setOnClickListener(this);
        btnFor.setOnClickListener(this);
        btnPlay.setOnClickListener(this);

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekbar.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
                changeSeekbar();
            }
        });




       seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               if(b){
                   mediaPlayer.seekTo(i);
               }
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }
       });


    }

    //Seekbar can be handled by this method
    private void changeSeekbar() {

        seekbar.setProgress(mediaPlayer.getCurrentPosition());

        if(mediaPlayer.isPlaying())
        {
            runnable=new Runnable() {
                @Override
                public void run() {
                    changeSeekbar();
                }
            };
            handler.postDelayed(runnable,1000);
        }

    }

  //Overriden  method for on click listener
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnPlay:

                if(mediaPlayer.isPlaying())
                {
                    mediaPlayer.pause();
                    btnPlay.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                }
                else{
                    mediaPlayer.start();
                    btnPlay.setImageResource(R.drawable.ic_pause_black_24dp);
                    changeSeekbar();
                }
                break;
            case R.id.btnFor:
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()+5000);
                break;
            case R.id.btnBack:
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()-5000);
                break;

        }



    }
    //When back button pressed the audio service will stop;this method is called
    @Override
    protected void onPause() {
        super.onPause();
        if(mediaPlayer!=null)
        {
            mediaPlayer.pause();

        }
    }
}
