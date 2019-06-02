package com.example.apurva.trailapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by apurva on 30/1/19.
 */

public class Post_Page extends AppCompatActivity {

    ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<Images> imageModelArrayList;
    ImageButton mbtnEnglish,mbtnHindi,mbtnMarathi;
    String msg;
    TextView mTextInfo;
    ImageButton mImageButtonHome,mImageButtonInfo,mImageButtonGps;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_collapse_post);

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Get the data from the storage through string
        Bundle bundle = getIntent().getExtras();
        msg = bundle.getString("post");


        imageModelArrayList = new ArrayList<>();
        imageModelArrayList = getData();

        init();

        //This data get for the title get from the user
        Intent intent = getIntent();
        String postNumber = intent.getStringExtra("postNumber");
        getSupportActionBar().setTitle("Post no:-"+postNumber);


        mTextInfo = (TextView) findViewById(R.id.textViewInfo);

        File file1 = new File(msg, "text.txt");

        StringBuilder text = new StringBuilder();
        try {
        BufferedReader br = new BufferedReader(new FileReader(file1));
        String line;

        while ((line = br.readLine()) != null) {
            text.append(line);
            text.append('\n');
        }
        br.close();
    }catch(IOException e)
        {
    }
    mTextInfo.setText(text);





    }

    //Images taken from the TARGET FOLDER
    private ArrayList<Images> getData()
    {
        ArrayList<Images> spacecrafts=new ArrayList<>();


        File downloadsFolder=new File(msg+"/Images");
        Images s;

        if(downloadsFolder.exists())
        {
            //GET ALL FILES IN DOWNLOAD FOLDER
            File[] files=downloadsFolder.listFiles();

            //LOOP THRU THOSE FILES GETTING NAME AND URI
            for (int i=0;i<files.length;i++)
            {
                File file=files[i];

                s=new Images();

                s.setUri(Uri.fromFile(file));

                spacecrafts.add(s);
            }
        }


        return spacecrafts;
    }

    //Initialise the views
        private void init() {


        mbtnMarathi= (ImageButton) findViewById(R.id.marathi);
        mbtnEnglish= (ImageButton) findViewById(R.id.english);
            mImageButtonGps= (ImageButton) findViewById(R.id.imgBtnGps);
            mImageButtonHome= (ImageButton) findViewById(R.id.imgBtnhome);
            mImageButtonInfo= (ImageButton) findViewById(R.id.imgBtnInfo);
            mImageButtonGps.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri gpsImage=Uri.fromFile(new File(msg,"Gps.jpg"));
                    Intent intent=new Intent(Post_Page.this,GPSImageActivity.class);
                    intent.setData(gpsImage);
                    startActivity(intent);
                }
            });
            mImageButtonInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PopupMenu popupMenu=new PopupMenu(Post_Page.this,mImageButtonInfo);
                    //Inflating the Popup using xml file
                    popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());

                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            return true;
                        }

                    });

                    popupMenu.show();//showing popup menu

                }
            });
            mImageButtonHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Post_Page.this,Post_Number.class);
                    startActivity(intent);
                    finish();
                }
            });
            mbtnEnglish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri myUri = Uri.parse(msg+"/English.wav");
                    Intent intent1=new Intent(Post_Page.this,AudioPlayerActivity.class);
                    intent1.setData(myUri);
                    startActivity(intent1);
                }
            });
            mbtnMarathi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri myUri = Uri.parse(msg+"/Marathi.wav");
                    Intent intent1=new Intent(Post_Page.this,AudioPlayerActivity.class);
                    intent1.setData(myUri);
                    startActivity(intent1);
                }
            });


        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyCustomPagerAdapter(Post_Page.this,imageModelArrayList));

        //Set the circle indicator with view pager
        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

        //Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES =imageModelArrayList.size();

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };

        // Pager listener over indicator*/
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });



    }

    }



