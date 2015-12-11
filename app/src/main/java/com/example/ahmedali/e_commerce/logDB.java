package com.example.ahmedali.e_commerce;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ahmed Ali on 12/4/2015.
 */
public class logDB extends SQLiteOpenHelper {


    SQLiteDatabase database;

    public logDB(Context context) {
        super(context, "user_log", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table user(email text not null,password integer not null,phone text,date text) ");


        database=getWritableDatabase();
        db.execSQL("insert into user(email,password) values ('ahmed@yahoo.com','456','01141186854')");
        db.execSQL("insert into user(email,password) values ('mohammed@yahoo.com','456')");
        db.execSQL("insert into user(email,password) values ('ahmedali@yahoo.com','456')");
        db.execSQL("insert into user(email,password) values ('ahmednady@yahoo.com','456')");
        db.execSQL("insert into user(email,password) values ('ahmedeldeeb@yahoo.com','456')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("drop table if exists user ");
        onCreate(db);
    }


    public boolean get_user(String email,String pass) {

    database=getReadableDatabase();
        String [] retcol={"email"};
        Cursor cursor=database.query("user",retcol,"email" + "=" + "\"" + email + "\"" + " AND " +
                        "password" + "=" + "\"" +pass+ "\"",null,null,null,null);


        if(cursor.getCount()!= 0){
            cursor.moveToFirst();
            database.close();
            return true;

        }
        else
        {
            return false;
        }


    }

    public void insert_sign (String email ,String pass,String ph,String dt)
    {

        database=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("email",email);
        database.insert("user",null,cv);
        cv.put("password",pass);
        database.insert("user",null,cv);
        cv.put("phone",ph);
        database.insert("user",null,cv);
        cv.put("date",dt);
        database.insert("user",null,cv);
//        database.execSQL("insert into user(email,password,phone,date) values("+email+","+pass+","+ph+","+dt+")");
        database.close();

    }
    public String getpass (String ph)
    {
        database=getReadableDatabase();
        //Cursor pass=database.rawQuery("select password from user where phone="+ph,null);

        Cursor pass=database.query("user", new String[]{"password"}, "phone="+ph, null, null, null, null);

        pass.moveToFirst();
        database.close();

        if(pass.getCount() !=0)
        {
            return pass.getString(0);

        }
        else
        return null;

    }





}
