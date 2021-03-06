package com.example.apurva.trailapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import uk.co.senab.photoview.PhotoViewAttacher;


/**
 * Created by apurva on 18/2/19.
 */

public class FullScreenImage extends AppCompatActivity {


     private ImageView imageView;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_fullscreen);



        //initialise the view
        imageView= (ImageView) findViewById(R.id.imageFull);

        //get the data for image through intent
        Intent callingActivityIntent=getIntent();
        if(callingActivityIntent !=null)
        {
            Uri imageUri=callingActivityIntent.getData();
            if(imageUri != null && imageView !=null)
            {
               Picasso.with(this).load(imageUri).into(imageView);//set the image uri in imageView with the help of picasso

            }


        }
       //For the zoom view of the image
        PhotoViewAttacher photoViewAttacher=new PhotoViewAttacher(imageView);
        photoViewAttacher.update();


    }



}

