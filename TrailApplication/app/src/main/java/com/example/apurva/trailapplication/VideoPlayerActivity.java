package com.example.apurva.trailapplication;

import android.content.res.Configuration;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.VideoView;


/**
 * Created by apurva on 12/5/19.
 */

public class VideoPlayerActivity extends AppCompatActivity {

      VideoView videoView;
      private String path="/storage/emulated/0/video.mp4";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_videoplayer);

        videoView= (VideoView) findViewById(R.id.videoView);
        videoView.setVideoPath(path);
        videoView.requestFocus();

        android.widget.MediaController mediaController=new android.widget.MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();


    }


}

