package com.cookandroid.account_book;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MemoSqlite {

    private static final String dbName = "myMemotest";
    private static final String table1 = "MemoTable";
    private static final int dbVersion = 1;

    private  OpenHelper opener;
    private  SQLiteDatabase db; //db관련 객체 생성

    private Context context;

    public MemoSqlite(Context context){
        this.context = context;
        this.opener = new OpenHelper(context,dbName,null,dbVersion);
        db = opener.getWritableDatabase();
    }


    private class OpenHelper extends SQLiteOpenHelper{

        public OpenHelper(@Nullable Context context, @Nullable String name,
                          @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String create = "CREATE TABLE " + table1 + "(" + "seq integer PRIMARY KEY AUTOINCREMENT,"+
                    "maintext text,"+ "subtext text,"+ "Isdone Integer)";
            //테이블 생성
            sqLiteDatabase.execSQL(create);
            //db생성, 생성된 db가 없을 경우에 한번만 호출됨
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+table1);
            onCreate(sqLiteDatabase);

        }
    }

    public void insertMemo(Memo memo){ //메모입력(NULL,maintext,subtext,0)
        String sql = "INSERT INTO "+ table1 + " VALUES(NULL, '"+memo.maintext+"', '"+memo.subtext+
                "',"+memo.getIsdone()+ ");";
        db.execSQL(sql);
    }

    public void deleteMemo(int position){ //메모의 0번째 데이터 삭제
        String sql = "DELETE FROM "+table1+" WHERE seq = "+position + ";";
        db.execSQL(sql);
    }

    public ArrayList<Memo> selectAll(){
        //데이터 조회
        String sql = "SELECT *FROM "+table1;

        ArrayList<Memo> list = new ArrayList<>();

        Cursor results = db.rawQuery(sql,null);
        //커서로 db에서 데이터를 찾아와 list에 넣어준다
        results.moveToFirst();

        while (!results.isAfterLast()){
            //db의 마지막부분까지 반복
            Memo memo = new Memo(results.getInt(0), results.getString(1),results.getString(2),results.getInt(3));
            list.add(memo);
            results.moveToNext();
        }
        results.close();
        return list;
    }




}
