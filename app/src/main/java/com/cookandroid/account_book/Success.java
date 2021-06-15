package com.cookandroid.account_book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Success extends AppCompatActivity {
    EditText suc_edit1,suc_edit2;
    TextView suc_tv1;
    ImageView img_green,img_yellow,img_red,img_orange;
    Button success_save_btn;
    String num1,num2;
    Float result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        suc_edit1 = (EditText)findViewById(R.id.suc_edit1);
        suc_edit2 = (EditText)findViewById(R.id.suc_edit2);
        suc_tv1 = (TextView)findViewById(R.id.suc_tv1);
        img_green = (ImageView)findViewById(R.id.img_green);             //목표지출에 비해 얼마나 지출한지 보여주는 이미지들의 객체
        img_yellow = (ImageView)findViewById(R.id.img_yellow);
        img_red = (ImageView)findViewById(R.id.img_red);
        img_orange = (ImageView)findViewById(R.id.img_orange);
        success_save_btn = (Button)findViewById(R.id.success_save_btn);

        Intent inIntent5 = getIntent();


        success_save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = suc_edit1.getText().toString();
                num2 = suc_edit2.getText().toString();
                if(Float.parseFloat(num2)>0 &&  Float.parseFloat(num1)>0){   // 입력값이 0이상일때 실행
                   result = (Float.parseFloat(num2) / Float.parseFloat(num1)) * 100;  // 결과 = (쓴 지출 / 목표지출) * 100 %
                   suc_tv1.setText(result.toString());
                        if(result>=0 && result<=40){                               // 결과값이(0~40) 양호
                            img_green.setVisibility(View.VISIBLE);
                            img_yellow.setVisibility(View.INVISIBLE);
                            img_orange.setVisibility(View.INVISIBLE);
                            img_red.setVisibility(View.INVISIBLE);
                         }
                        else if(result>40 && result<=70){                     //결과값이(41~70) 보통일 때
                            img_green.setVisibility(View.INVISIBLE);
                            img_yellow.setVisibility(View.VISIBLE);
                            img_orange.setVisibility(View.INVISIBLE);
                            img_red.setVisibility(View.INVISIBLE);
                        }
                        else if(result>70 && result<=100){                  //결과값이(70~100) 위험일 때
                            img_green.setVisibility(View.INVISIBLE);
                            img_yellow.setVisibility(View.INVISIBLE);
                            img_orange.setVisibility(View.VISIBLE);
                            img_red.setVisibility(View.INVISIBLE);
                        }
                        else if(result>100){                                 //결과값이(100~) 초과일 때
                            img_green.setVisibility(View.INVISIBLE);
                            img_yellow.setVisibility(View.INVISIBLE);
                            img_orange.setVisibility(View.INVISIBLE);
                            img_red.setVisibility(View.VISIBLE);
                        }

                }

                else{  // 음수는 쓸 수 없다
                    Toast.makeText(getApplicationContext(),"음수나 0은 쓸 수 없습니다.",Toast.LENGTH_SHORT).show();
                }

            }

        });



    }
}