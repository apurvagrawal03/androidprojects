package com.example.apurva.trailapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

/**
 * Created by apurva on 12/5/19.
 */

public class PopUpWindow extends AppCompatActivity implements View.OnClickListener{

    Toolbar mActionBarToolbar;
    AlertDialog.Builder builder;
    Button mbtn1,mbtn2,mbtn3,mbtn4,mbtn5,mbtn6,mbtn7,mbtn8,mbtn9,mbtn10,mbtn11,mbtn12,mbtn13,mbtn14,mbtn15,mbtn16,mbtn17,mbtn18,mbtn19,mbtn20;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_window);

        builder=new AlertDialog.Builder(this);

        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        mActionBarToolbar.setTitle("All Posts");
        setSupportActionBar(mActionBarToolbar);

        mbtn1= (Button) findViewById(R.id.btn1);
        mbtn2= (Button) findViewById(R.id.btn2);
        mbtn3= (Button) findViewById(R.id.btn3);
        mbtn4= (Button) findViewById(R.id.btn4);
        mbtn5= (Button) findViewById(R.id.btn5);
        mbtn6= (Button) findViewById(R.id.btn6);
        mbtn7= (Button) findViewById(R.id.btn7);
        mbtn8= (Button) findViewById(R.id.btn8);
        mbtn9= (Button) findViewById(R.id.btn9);
        mbtn10= (Button) findViewById(R.id.btn10);
        mbtn11= (Button) findViewById(R.id.btn11);
        mbtn12= (Button) findViewById(R.id.btn12);
        mbtn13= (Button) findViewById(R.id.btn13);
        mbtn14= (Button) findViewById(R.id.btn14);
        mbtn15= (Button) findViewById(R.id.btn15);
        mbtn16= (Button) findViewById(R.id.btn16);
        mbtn17= (Button) findViewById(R.id.btn17);
        mbtn18= (Button) findViewById(R.id.btn18);
        mbtn19= (Button) findViewById(R.id.btn19);
        mbtn20= (Button) findViewById(R.id.btn20);

        mbtn1.setOnClickListener(this);
        mbtn2.setOnClickListener(this);
        mbtn3.setOnClickListener(this);
        mbtn4.setOnClickListener(this);
        mbtn5.setOnClickListener(this);
        mbtn6.setOnClickListener(this);
        mbtn7.setOnClickListener(this);
        mbtn8.setOnClickListener(this);
        mbtn9.setOnClickListener(this);
        mbtn10.setOnClickListener(this);
        mbtn11.setOnClickListener(this);
        mbtn12.setOnClickListener(this);
        mbtn13.setOnClickListener(this);
        mbtn14.setOnClickListener(this);
        mbtn15.setOnClickListener(this);
        mbtn16.setOnClickListener(this);
        mbtn17.setOnClickListener(this);
        mbtn18.setOnClickListener(this);
        mbtn19.setOnClickListener(this);
        mbtn20.setOnClickListener(this);


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

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn1:
                String one="/storage/emulated/0/1";
                Intent intent1=new Intent(this,Post_Page.class);
                intent1.putExtra("post",one);
                intent1.putExtra("postNumber","1");
                startActivity(intent1);
                break;
            case R.id.btn2:
                String two="/storage/emulated/0/2";
                Intent intent2=new Intent(this,Post_Page.class);
                intent2.putExtra("post",two);
                intent2.putExtra("postNumber","2");
                startActivity(intent2);
                break;
            case R.id.btn3:
                String three="/storage/emulated/0/3";
                Intent intent3=new Intent(this,Post_Page.class);
                intent3.putExtra("post",three);
                intent3.putExtra("postNumber","3");
                startActivity(intent3);
                break;
            case R.id.btn4:
                String four="/storage/emulated/0/4";
                Intent intent4=new Intent(this,Post_Page.class);
                intent4.putExtra("post",four);
                intent4.putExtra("postNumber","4");
                startActivity(intent4);
                break;
            case R.id.btn5:
                String five="/storage/emulated/0/5";
                Intent intent5=new Intent(this,Post_Page.class);
                intent5.putExtra("post",five);
                intent5.putExtra("postNumber","5");
                startActivity(intent5);
                break;
            case R.id.btn6:
                String six="/storage/emulated/0/6";
                Intent intent6=new Intent(this,Post_Page.class);
                intent6.putExtra("post",six);
                intent6.putExtra("postNumber","6");
                startActivity(intent6);
                break;
            case R.id.btn7:
                String seven="/storage/emulated/0/7";
                Intent intent7=new Intent(this,Post_Page.class);
                intent7.putExtra("post",seven);
                intent7.putExtra("postNumber","7");
                startActivity(intent7);
                break;
            case R.id.btn8:
                String eight="/storage/emulated/0/8";
                Intent intent8=new Intent(this,Post_Page.class);
                intent8.putExtra("post",eight);
                intent8.putExtra("postNumber","8");
                startActivity(intent8);
                break;
            case R.id.btn9:
                String nine="/storage/emulated/0/9";
                Intent intent9=new Intent(this,Post_Page.class);
                intent9.putExtra("post",nine);
                intent9.putExtra("postNumber","9");
                startActivity(intent9);
                break;
            case R.id.btn10:
                String ten="/storage/emulated/0/10";
                Intent intent10=new Intent(this,Post_Page.class);
                intent10.putExtra("post",ten);
                intent10.putExtra("postNumber","10");
                startActivity(intent10);
                break;
            case R.id.btn11:
                String eleven="/storage/emulated/0/11";
                Intent intent11=new Intent(this,Post_Page.class);
                intent11.putExtra("post",eleven);
                intent11.putExtra("postNumber","11");
                startActivity(intent11);
                break;
            case R.id.btn12:
                String twelve="/storage/emulated/0/12";
                Intent intent12=new Intent(this,Post_Page.class);
                intent12.putExtra("post",twelve);
                intent12.putExtra("postNumber","12");
                startActivity(intent12);
                break;
            case R.id.btn13:
                String thirteen="/storage/emulated/0/13";
                Intent intent13=new Intent(this,Post_Page.class);
                intent13.putExtra("post",thirteen);
                intent13.putExtra("postNumber","13");
                startActivity(intent13);
                break;
            case R.id.btn14:
                String fourteen="/storage/emulated/0/14";
                Intent intent14=new Intent(this,Post_Page.class);
                intent14.putExtra("post",fourteen);
                intent14.putExtra("postNumber","14");
                startActivity(intent14);
                break;
            case R.id.btn15:
                String fifteen="/storage/emulated/0/15";
                Intent intent15=new Intent(this,Post_Page.class);
                intent15.putExtra("post",fifteen);
                intent15.putExtra("postNumber","15");
                startActivity(intent15);
                break;
            case R.id.btn16:
                String sixtenn="/storage/emulated/0/16";
                Intent intent16=new Intent(this,Post_Page.class);
                intent16.putExtra("post",sixtenn);
                intent16.putExtra("postNumber","16");
                startActivity(intent16);
                break;
            case R.id.btn17:
                String seventeen="/storage/emulated/0/17";
                Intent intent17=new Intent(this,Post_Page.class);
                intent17.putExtra("post",seventeen);
                intent17.putExtra("postNumber","17");
                startActivity(intent17);
                break;
            case R.id.btn18:
                String eighteen="/storage/emulated/0/18";
                Intent intent18=new Intent(this,Post_Page.class);
                intent18.putExtra("post",eighteen);
                intent18.putExtra("postNumber","18");
                startActivity(intent18);
                break;
            case R.id.btn19:
                String nineteen="/storage/emulated/0/19";
                Intent intent19=new Intent(this,Post_Page.class);
                intent19.putExtra("post",nineteen);
                intent19.putExtra("postNumber","19");
                startActivity(intent19);
                break;
            case R.id.btn20:
                String tewnty="/storage/emulated/0/20";
                Intent intent20=new Intent(this,Post_Page.class);
                intent20.putExtra("post",tewnty);
                intent20.putExtra("postNumber","20");
                startActivity(intent20);
                break;

        }
    }
}
