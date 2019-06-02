package com.example.restaurantapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyDatabase";

    //Login table name
    private static final String TABLE_LOGIN = "Login";
    private static final String TABLE_SHOPMASTER = "ShopMaster";




    // Login Table Columns names
    private static final String USERNAME = "User";
    private static final String PASSWORD = "Password";

    // User Table Columns names
    private static final String COLUMN_SHOP_ID = "Shop_id";
    private static final String COLUMN_SHOP_NAME = "Shop_name";
    private static final String COLUMN_MOBILE_NUMBER = "mobile_number";
    private static final String COLUMN_SHOP_ADDRESS = "address";

    private static final String CREATE_TABLE_LOGIN = "CREATE TABLE "
            + TABLE_LOGIN + "(" + USERNAME + " TEXT," + PASSWORD
            + " TEXT" + ")";

    private static final String CREATE_TABLE_SHOPMASTER = "CREATE TABLE "
            + TABLE_SHOPMASTER + "(" + COLUMN_SHOP_NAME + " TEXT PRIMARY KEY AUTOINCREMENT," +
            COLUMN_MOBILE_NUMBER + " TEXT,"  + COLUMN_SHOP_ADDRESS + " TEXT" + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_LOGIN);
        db.execSQL(CREATE_TABLE_SHOPMASTER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOGIN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOPMASTER);

        onCreate(db);
    }

    /**
     * This method is to create user record
     *
     * @param login
     */
    public boolean LogIn(Login login) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USERNAME,login.getUsername());
        values.put(PASSWORD, login.getPassword());

        // Inserting Row
       long result =  db.insert(TABLE_LOGIN, null, values);
        db.close();
       if(result == -1)
       {
           return false;
       }
       else {
           return true;
       }
    }

    public boolean isUserAlreadyRegistered() {
        SQLiteDatabase db = this.getReadableDatabase();
        return DatabaseUtils.queryNumEntries(db, TABLE_LOGIN) >= 1;
    }

    public long getProfileCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        return DatabaseUtils.queryNumEntries(db, TABLE_SHOPMASTER);
    }

    public Cursor getShopMasterProfile() {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] shopMaster = {COLUMN_SHOP_NAME,COLUMN_MOBILE_NUMBER,COLUMN_SHOP_ADDRESS};
        return  db.query(TABLE_SHOPMASTER,shopMaster,null,null,null,null,null);
    }


    public boolean createShopMaster(ShopMaster shopMaster) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_SHOP_NAME,shopMaster.getmName());
        values.put(COLUMN_MOBILE_NUMBER, shopMaster.getmMobileNumber());
        values.put(COLUMN_SHOP_ADDRESS, shopMaster.getmAddress());

        // Inserting Row
        long result =  db.insert(TABLE_SHOPMASTER, null, values);
        db.close();
        if(result == -1)
        {
            return false;
        }
        else {
            return true;
        }
    }
}

