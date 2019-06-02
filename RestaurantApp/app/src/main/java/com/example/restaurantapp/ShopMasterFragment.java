package com.example.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ShopMasterFragment extends AppCompatActivity {


    EditText mShopName,mMobileNumber,mAddress;
    Button mBtn_Add;
    private DatabaseHelper databaseHelper;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_shop_master);

        databaseHelper=new DatabaseHelper(this);

        mShopName= (EditText) findViewById(R.id.edit_shopname);
        mMobileNumber= (EditText) findViewById(R.id.edit_mobile_number);
        mAddress= (EditText) findViewById(R.id.edit_address);
        mBtn_Add= (Button) findViewById(R.id.btn_add);


        mBtn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   ShopMaster shopMaster = new ShopMaster();
                    shopMaster.setmName(mShopName.getText().toString());
                    shopMaster.setmMobileNumber(mMobileNumber.getText().toString());
                    shopMaster.setmAddress(mAddress.getText().toString());
                    databaseHelper.createShopMaster(shopMaster);

                    Intent intent=new Intent(ShopMasterFragment.this,HomeActivity.class);
                    startActivity(intent);
                    finish();

//                    SharedPref sharedPref=new SharedPref(getApplicationContext());
//                    //to change the boolean value as true
//                    sharedPref.secondTime();
                }

        });









    }





    }









