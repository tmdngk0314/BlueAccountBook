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

    private DatePickerDialog.OnDateSetListener callbackMethod;
    private Button button_Date1,button_Date2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InitializeView();
        this.InitializeListener();

        Intent inIntent = getIntent();
        final int Vaule = inIntent.getIntExtra("Num2",0);

        ImageButton calcbutton = (ImageButton)findViewById(R.id.calcbutton);
        ImageButton listbutton = (ImageButton)findViewById(R.id.listbutton);
        ImageButton memobutton = (ImageButton)findViewById(R.id.memobutton);
        ImageButton successbutton = (ImageButton)findViewById(R.id.successbutton);
        ImageButton informationbutton = (ImageButton)findViewById(R.id.informationbutton);
        ImageButton calculatorbutton = (ImageButton)findViewById(R.id.calculatorbutton);
        ImageButton listaddbtn = (ImageButton)findViewById(R.id.listaddbtn);

        TextView TodayJichul = (TextView)findViewById(R.id.TodayJichul);
        TextView MonthJichul = (TextView)findViewById(R.id.MonthJichul);



        calcbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), CalendarActivity.class);
                startActivity(intent1);
            }
        });

        listaddbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent11 = new Intent(getApplicationContext(), List_add_Activity.class);
                startActivity(intent11);
            }
        });

        listbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent2);
            }
        });

        memobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), MemoActivity.class);
                startActivity(intent3);
            }
        });

        successbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getApplicationContext(), Success.class);
                startActivity(intent4);
            }
        });

        informationbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(getApplicationContext(), Information.class);
                startActivity(intent5);
            }
        });
        calculatorbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(getApplicationContext(), CalculatorActivity.class);
                startActivity(intent6);
            }
        });


    }
    public void InitializeView()
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