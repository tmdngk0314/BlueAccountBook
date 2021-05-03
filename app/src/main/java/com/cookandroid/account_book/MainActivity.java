package com.cookandroid.account_book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton calcbutton = (ImageButton)findViewById(R.id.calcbutton);
        ImageButton listbutton = (ImageButton)findViewById(R.id.listbutton);
        ImageButton memobutton = (ImageButton)findViewById(R.id.memobutton);
        ImageButton successbutton = (ImageButton)findViewById(R.id.successbutton);
        ImageButton informationbutton = (ImageButton)findViewById(R.id.informationbutton);

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



    }
}