package com.example.apurva.trailapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by apurva on 9/5/19.
 */

public class Post_Number extends AppCompatActivity {

     EditText mEditPostNmuber;
    Button   mBtnSubmit;
    String image="/storage/emulated/0/";
    Toolbar mActionBarToolbar;
    AlertDialog.Builder builder;
    ImageButton mImgHome,mImgInfo;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_post_number);


        builder = new AlertDialog.Builder(this);

        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        mActionBarToolbar.setTitle("Post number");
        setSupportActionBar(mActionBarToolbar);

        mEditPostNmuber= (EditText) findViewById(R.id.edit_post);
        mBtnSubmit= (Button) findViewById(R.id.btnSubmit);
        mImgHome= (ImageButton) findViewById(R.id.imageHome);
        mImgInfo= (ImageButton) findViewById(R.id.imageInfo);

        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message=image+"/"+mEditPostNmuber.getText().toString();
                String post=mEditPostNmuber.getText().toString();
                Intent intent=new Intent(Post_Number.this,Post_Page.class);

                intent.putExtra("postNumber",post);
                intent.putExtra("post",message);

                startActivity(intent);

                mEditPostNmuber.setText("");
            }
        });

        mImgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Post_Number.this,IntroActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mImgInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu=new PopupMenu(Post_Number.this,mImgInfo);
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
        alert.setTitle("AlertDialogExample");
        alert.show();


    }
}
