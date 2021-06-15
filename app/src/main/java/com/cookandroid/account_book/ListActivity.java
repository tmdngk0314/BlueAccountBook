package com.cookandroid.account_book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ListActivity extends AppCompatActivity {

    ListDBHelper dbHelper;
    EditText edtSuip,edtJichull,edtJurchuk,edtJurchukResult,edtJichullResult,edtSuipResult;
    Button btnClear,btnInsert,btnSelect;
    SQLiteDatabase sqlDB;
    TextView textdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();

        edtSuip = (EditText)findViewById(R.id.edtSuip);
        edtJichull = (EditText)findViewById(R.id.edtJichull);
        edtJurchuk = (EditText)findViewById(R.id.edtJurchuk);
        edtJurchukResult = (EditText)findViewById(R.id.edtJurchukResult);
        edtJichullResult = (EditText)findViewById(R.id.edtJichullResult);
        edtSuipResult = (EditText)findViewById(R.id.edtSuipResult);

        btnClear = (Button)findViewById(R.id.btnClear);
        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnSelect = (Button)findViewById(R.id.btnSelect);

        textdate = (TextView)findViewById(R.id.textdate);

        dbHelper = new ListDBHelper(this);

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String substr = sdf.format(date);
        textdate.setText(substr); // 오늘 날짜 삽입

        btnClear.setOnClickListener(new View.OnClickListener() {  //초기화 버튼
            @Override
            public void onClick(View view) {
                sqlDB = dbHelper.getWritableDatabase();
                dbHelper.onUpgrade(sqlDB,1,2);
                sqlDB.close();
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {  // 정보 입력 버튼
            @Override
            public void onClick(View view) {
                sqlDB = dbHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO groupTBL VALUES('"+edtSuip.getText().toString() + "',"
                        +edtJichull.getText().toString()+ ","+edtJurchuk.getText().toString()+");"); //수입, 지출, 저축 입력

                edtSuip.setText("");              //입력후 정보 clear
                edtJichull.setText("");
                edtJurchuk.setText("");
                sqlDB.close();
                Toast.makeText(getApplicationContext(),"저장되었습니다",Toast.LENGTH_SHORT).show(); //저장되었다는 토스트 메세지
            }
        });
        btnSelect.setOnClickListener(new View.OnClickListener() {  //조회 버튼
            @Override
            public void onClick(View view) {
                sqlDB = dbHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT*FROM groupTBL;",null);

                String strSuip = "수입" + "\r\n"+"--------"+"\r\n";
                String strJichull = "지출" + "\r\n"+"--------"+"\r\n";
                String strJurchuk = "저축" + "\r\n"+"--------"+"\r\n";

                while (cursor.moveToNext()){                             // 커서를 사용해서 위치 조정
                    strSuip += cursor.getString(0)+"\r\n";
                    strJichull += cursor.getString(1)+"\r\n";
                    strJurchuk += cursor.getString(2)+"\r\n";
                }

                edtSuipResult.setText(strSuip);                          //저장값들 표기
                edtJichullResult.setText(strJichull);
                edtJurchukResult.setText(strJurchuk);

                cursor.close();
                sqlDB.close();

            }
        });

    }
}