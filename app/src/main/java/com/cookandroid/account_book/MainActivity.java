package com.cookandroid.account_book;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog.OnDateSetListener callbackMethod;  //데이트 피커 객체
    private Button button_Date1,button_Date2;  // 데이트피커를 사용할 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InitializeView();
        this.InitializeListener();

        Intent inIntent = getIntent();
        String TJi,TS,TJur,MJi,MS,MJur,TB,MB,TotalJ;

        final int Vaule = inIntent.getIntExtra("Num2",0);

        ImageButton calcbutton = (ImageButton)findViewById(R.id.calcbutton);      //사용할 이미지버튼, 텍스트 뷰들의 객체생성
        ImageButton listbutton = (ImageButton)findViewById(R.id.listbutton);
        ImageButton memobutton = (ImageButton)findViewById(R.id.memobutton);
        ImageButton successbutton = (ImageButton)findViewById(R.id.successbutton);
        ImageButton informationbutton = (ImageButton)findViewById(R.id.informationbutton);
        ImageButton calculatorbutton = (ImageButton)findViewById(R.id.calculatorbutton);
        ImageButton listaddbtn = (ImageButton)findViewById(R.id.listaddbtn);

        TextView TodayJichul = (TextView)findViewById(R.id.TodayJichul);
        TextView TodaySuip = (TextView)findViewById(R.id.TodaySuip);
        TextView TodayJurchuk = (TextView)findViewById(R.id.TodayJurchuk);
        TextView TodayBalance = (TextView)findViewById(R.id.TodayBalance);
        TextView MonthJichul = (TextView)findViewById(R.id.MonthJichul);
        TextView MonthSuip = (TextView)findViewById(R.id.MonthSuip);
        TextView MonthJurchuk = (TextView)findViewById(R.id.MonthJurchuk);
        TextView MonthBalance = (TextView)findViewById(R.id.MonthBalance);
        TextView AllJasan = (TextView)findViewById(R.id.AllJasan);
        TextView AllJur = (TextView)findViewById(R.id.Alljur);

        TJi = inIntent.getStringExtra("ToJichul");      // 내역추가 부분의 인텐트들을 받아온다
        TS = inIntent.getStringExtra("ToSuip");
        TJur = inIntent.getStringExtra("ToJurchuk");
        MJi = inIntent.getStringExtra("MonJichul");
        MS = inIntent.getStringExtra("MonSuip");
        MJur = inIntent.getStringExtra("MonJurchuk");

         TB = inIntent.getStringExtra("BalToday");
         MB = inIntent.getStringExtra("BalMonth");
         TotalJ = inIntent.getStringExtra("TotalJasan");

         TodayJichul.setText(TJi+"원");                    // 받아온 인텐트들을 객체에 넣고 값을 출력
        TodaySuip.setText(TS+"원");
        TodayJurchuk.setText(TJur+"원");
        TodayBalance.setText(TB+"원");
        MonthJichul.setText(MJi+"원");
        MonthSuip.setText(MS+"원");
        MonthJurchuk.setText(MJur+"원");
        MonthBalance.setText(MB+"원");
        AllJasan.setText(TotalJ+"원");
        AllJur.setText(MJur+"원");


        calcbutton.setOnClickListener(new View.OnClickListener() {            //캘린더 버튼 누를시 CalendarActivity 실행
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), CalendarActivity.class);
                startActivity(intent1);
            }
        });

        listaddbtn.setOnClickListener(new View.OnClickListener() {            //내역추가 버튼 누를시 List_add_Activity 실행
            @Override
            public void onClick(View view) {
                Intent intent11 = new Intent(getApplicationContext(), List_add_Activity.class);
                startActivity(intent11);
            }
        });

        listbutton.setOnClickListener(new View.OnClickListener() {          // 내역 버튼 누를시 ListActivity 실행
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent2);
            }
        });

        memobutton.setOnClickListener(new View.OnClickListener() {          //메모 버튼 누를시 MemoActivity 실행
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), MemoActivity.class);
                startActivity(intent3);
            }
        });

        successbutton.setOnClickListener(new View.OnClickListener() {       //목표지출 버튼 누를 시  SuccessActivity 실행
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getApplicationContext(), Success.class);
                startActivity(intent4);
            }
        });

        informationbutton.setOnClickListener(new View.OnClickListener() {  //도움말 버튼 누를시 MemoActivity 실행
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(getApplicationContext(), Information.class);
                startActivity(intent5);
            }
        });
        calculatorbutton.setOnClickListener(new View.OnClickListener() {    //계산기 버튼 누를시 calculaterActivity 실행
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(getApplicationContext(), CalculatorActivity.class);
                startActivity(intent6);
            }
        });


    }
    public void InitializeView()   //데이트피커 InitializeView
    {
        button_Date1 = (Button) findViewById(R.id.btnDate1);
        button_Date2 = (Button) findViewById(R.id.btnDate2);
    }

    public void InitializeListener()
    {
        callbackMethod = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                button_Date1.setText(year + "년" + (monthOfYear+1) + "월" + dayOfMonth + "일");
                button_Date2.setText(year + "년" + (monthOfYear+1) + "월" + dayOfMonth + "일");
            }
        };
    }

    public void OnClickHandler(View view)
    {
        DatePickerDialog dialog = new DatePickerDialog(this, callbackMethod, 2021, 6, 16);

        dialog.show();
    }
}