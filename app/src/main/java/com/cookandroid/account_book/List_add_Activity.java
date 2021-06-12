package com.cookandroid.account_book;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class List_add_Activity extends AppCompatActivity {
    private String Tjichul,Tsuip,Tjurchuk,Mjichul,Msuip,Mjurchuk;
    private Integer Balance1 = 0,Balance2=0,TotalJasan=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_add_);
        EditText todayjichul = (EditText)findViewById(R.id.todayjichul);
        EditText todaysuip = (EditText)findViewById(R.id.todaysuip);
        EditText todayjurchuk = (EditText)findViewById(R.id.todayjurchuk);
        EditText monthjichul = (EditText)findViewById(R.id.monthjichul);
        EditText monthsuip = (EditText)findViewById(R.id.monthsuip);
        EditText monthjurchuk = (EditText)findViewById(R.id.monthjurchuk);

        TextView todaybalance = (TextView)findViewById(R.id.todaybalance);
        TextView monthbalance = (TextView)findViewById(R.id.monthbalance);


        Button balance = (Button)findViewById(R.id.balance);
        Button listaddsave = (Button)findViewById(R.id.listaddsave);

        balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tjichul = todayjichul.getText().toString();
                Tsuip = todaysuip.getText().toString();
                Tjurchuk = todayjurchuk.getText().toString();
                Mjichul = monthjichul.getText().toString();
                Msuip = monthsuip.getText().toString();
                Mjurchuk = monthjurchuk.getText().toString();

                Balance1 = Integer.parseInt(Tsuip)-(Integer.parseInt(Tjichul)+Integer.parseInt(Tjurchuk));
                Balance2 = Integer.parseInt(Msuip)-(Integer.parseInt(Mjichul)+Integer.parseInt(Mjurchuk));

                todaybalance.setText(Balance1.toString());
                monthbalance.setText(Balance2.toString());

            }
        });

        listaddsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tjichul = todayjichul.getText().toString();
                Tsuip = todaysuip.getText().toString();
                Tjurchuk = todayjurchuk.getText().toString();
                Mjichul = monthjichul.getText().toString();
                Msuip = monthsuip.getText().toString();
                Mjurchuk = monthjurchuk.getText().toString();

                Balance1 = Integer.parseInt(Tsuip)-(Integer.parseInt(Tjichul)+Integer.parseInt(Tjurchuk));
                Balance2 = Integer.parseInt(Msuip)-(Integer.parseInt(Mjichul)+Integer.parseInt(Mjurchuk));
                TotalJasan = Balance2 + Integer.parseInt(Mjurchuk);

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("ToJichul",Tjichul);
                intent.putExtra("ToSuip",Tsuip);
                intent.putExtra("ToJurchuk",Tjurchuk);
                intent.putExtra("MonJichul",Mjichul);
                intent.putExtra("MonSuip",Msuip);
                intent.putExtra("MonJurchuk",Mjurchuk);
                intent.putExtra("BalToday",Balance1.toString());
                intent.putExtra("BalMonth",Balance2.toString());
                intent.putExtra("TotalJasan",TotalJasan.toString());
                startActivity(intent);

            }
        });



    }
}
