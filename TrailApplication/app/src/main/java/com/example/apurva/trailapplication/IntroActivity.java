package com.example.apurva.trailapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by apurva on 5/5/19.
 */

public class IntroActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton mVideo,mInfo;
    Button mBtnSelectPost,mBtnAllPost;
    MediaPlayer player;
    Toolbar mActionBarToolbar;
    AlertDialog.Builder builder;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_main);

        builder = new AlertDialog.Builder(this);

        mBtnSelectPost= (Button) findViewById(R.id.btnSelectPost);
        mBtnAllPost= (Button) findViewById(R.id.btnAllPost);
        mVideo= (ImageButton) findViewById(R.id.imageVideo);
        mInfo= (ImageButton) findViewById(R.id.imageInfo);

        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        mActionBarToolbar.setTitle("My title");
        setSupportActionBar(mActionBarToolbar);

        player=new MediaPlayer();

        try {
           player.setDataSource("/storage/emulated/0/marathi_intro.wav");
            player.setLooping(false);
            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mBtnSelectPost.setOnClickListener(this);
        mBtnAllPost.setOnClickListener(this);
        mInfo.setOnClickListener(this);
        mVideo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnSelectPost:
                Intent intent=new Intent(IntroActivity.this,Post_Number.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btnAllPost:
                Intent intent1=new Intent(IntroActivity.this,PopUpWindow.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.imageVideo:
                Intent intent2=new Intent(IntroActivity.this,VideoPlayerActivity.class);
                startActivity(intent2);
                break;
            case R.id.imageInfo:
                PopupMenu popupMenu=new PopupMenu(IntroActivity.this,mInfo);
                //Inflating the Popup using xml file
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                       return true;
                    }

                });

                popupMenu.show();//showing popup menu
                break;
        }



        }

    @Override
    protected void onPause() {
        super.onPause();
        player.pause();
    }

    @Override
    public void onBackPressed() {



        //Setting message manually and performing action on button click
        builder.setMessage("Do you want to close this application ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();

                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("Alert");
        alert.show();
    }




}
