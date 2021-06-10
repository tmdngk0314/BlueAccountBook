package com.cookandroid.account_book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.Date;

public class ListAddActivity extends AppCompatActivity {

    EditText editText1,editText2,editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_add);

        editText1 = findViewById(R.id.editji);
        editText2 = findViewById(R.id.editsu);
        editText3 = findViewById(R.id.editjur);

        findViewById(R.id.btnsave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText1.getText().toString();

                if (str.length() > 0) {
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    String substr = sdf.format(date);

                    Intent intent = new Intent();
                    intent.putExtra("main", str);
                    intent.putExtra("sub", substr);
                    setResult(RESULT_OK, intent);

                    finish();
                }  // 아무것도 입력을 하지 않았을 때를 대비해서 글자가 0개 초과일 때 실행

            }
        });

        findViewById(R.id.btndel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);

                finish();
            }
        });
    }
}