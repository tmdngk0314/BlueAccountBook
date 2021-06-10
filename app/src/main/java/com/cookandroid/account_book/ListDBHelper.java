package com.cookandroid.account_book;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ListDBHelper extends SQLiteOpenHelper {
    public ListDBHelper(Context context){
        super(context,"groupDB",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE groupTBL (gSuip INTEGER PRIMARY KEY,gJichull INTEGER, gJurchuck INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS groupTBL");
        onCreate(db);
    }
}

