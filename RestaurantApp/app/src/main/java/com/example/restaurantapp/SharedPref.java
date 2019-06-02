//package com.example.restaurantapp;
//
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//
//public class SharedPref {
//
//    //to create shared preference file;
//    SharedPreferences sharedPreferences;
//    //to edit the shared preference file
//    SharedPreferences.Editor editor;
//
//    //context pass the reference to another class
//    Context context;
//
//    //mode should be private for sharedprefernce file
//    int i=0;
//
//    String filename="sdfile";
//
//    String data="b";
//
//    public SharedPref(Context context) {
//        this.context = context;
//        sharedPreferences=context.getSharedPreferences(filename,i);
//        editor=sharedPreferences.edit();
//    }
//
//    //for second time
//    public  void secondTime()
//    {
//        editor.putBoolean(data, true);
//        editor.commit();
//    }
//
//   // for first time
//
//    public void firstTime()
//    {
//        if(!this.login()){
//       //if b is false then jump to shopfragment
//            Intent intent=new Intent(context, ShopMasterFragment.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            context.startActivity(intent);
//
//        }
//    }
//     //to get the default value as false
//    private boolean login(){
//        return sharedPreferences.getBoolean(data,false);
//    }
//}
