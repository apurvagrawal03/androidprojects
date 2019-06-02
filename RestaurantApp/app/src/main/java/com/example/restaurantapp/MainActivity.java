package com.example.restaurantapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

   private RelativeLayout relay1,relay2;
   private EditText editUserName,editPassword;
   private Button btn_login;
   private DatabaseHelper databaseHelper;
   private Login login;



    Handler handler=new Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
             relay1.setVisibility(View.VISIBLE);
             relay2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper=new DatabaseHelper(this);

        relay1= (RelativeLayout) findViewById(R.id.relay1);
        relay2= (RelativeLayout) findViewById(R.id.relay2);
        handler.postDelayed(runnable,2000); //2000 is the time out for the splash

        editUserName= (EditText) findViewById(R.id.edit_username);
        editPassword= (EditText) findViewById(R.id.edit_password);
        btn_login= (Button) findViewById(R.id.btn_Login);

        AddData();

    }

     public void AddData()
     {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login=new Login();
                login.setUsername("Admin");
                login.setPassword("123");
                databaseHelper.LogIn(login);

               if(databaseHelper.isUserAlreadyRegistered()) {
                   long count = databaseHelper.getProfileCount();
                   if(count >= 1){
                       startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                   }else{
                       Intent intent=new Intent(MainActivity.this, ShopMasterFragment.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                       intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                   }
                   Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();

               }
               else {
                   Toast.makeText(getApplicationContext(),"Data not Inserted",Toast.LENGTH_SHORT).show();
               }
            }
        });


     }




    }





