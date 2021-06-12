package com.cookandroid.account_book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.Date;

public class MemoAddActivity extends AppCompatActivity {  //메모 입력 액티비티

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_add);

        editText = findViewById(R.id.editMemo);

        findViewById(R.id.btnDone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();

                if(str.length() > 0){
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    //오늘 날짜를 String형으로 가져옴

                    String substr = sdf.format(date);

                    Intent intent = new Intent();
                    intent.putExtra("main",str);
                    intent.putExtra("sub", substr);
                    setResult(RESULT_OK, intent);
                    //데이터를 보냄

                    finish();
                }  // 아무것도 입력을 하지 않았을 때를 대비해서 글자가 0개 초과일 때 실행

            }
        });

        findViewById(R.id.btnNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);

                finish();
            } // 취소버튼
        });
    }
}