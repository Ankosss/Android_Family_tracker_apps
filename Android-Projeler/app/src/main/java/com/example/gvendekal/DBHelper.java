package com.example.gvendekal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.android.gms.dynamic.DeferredLifecycleHelper;

public class DBHelper extends SQLiteOpenHelper
{

    public static final String DBNAME="login.db";
    public DBHelper(Context context)
    {
        super(context, "Login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase Mydb)
    {
        Mydb.execSQL("create Table users(id INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL,username Text NOT NULL,password Text NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Mydb, int oldVersion, int newVersion)
    {
        Mydb.execSQL("drop Table if exists users");
    }

    public Boolean insertData (String username,String password)
    {
        SQLiteDatabase Mydb=this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result = Mydb.insert("users",null,contentValues);
        if (result==-1)return false;
        else return  true;
    }
        /**oluşturmak istenilen kullanıcı adı veritabanında daha önceden kullanıldı mı kontrol**/
    public boolean checkusername (String username)
    {
        SQLiteDatabase Mydb = this.getWritableDatabase();
        Cursor cursor = Mydb.rawQuery("Select * from users where username =?", new String[]{username});
        if (cursor.getCount() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
        /**Kullanıcı adı ve şifre sorgulama**/
        public Boolean checkusernamepassword(String username, String password)
        {
            SQLiteDatabase Mydb =this.getWritableDatabase();
            Cursor cursor=Mydb.rawQuery("Select * From users where username=? and password=?",new String[]{username,password});
            if (cursor.getCount()>0) return true;
            else return false;
        }
}

