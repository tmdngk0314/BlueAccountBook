package com.cookandroid.account_book;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    private TextView editText;
    private String operator = null;
    private String firstValue = "";
    private boolean isInit = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        editText = findViewById(R.id.editText);
        for (int i = 0; i < 15; i++) {
            String buttonID = "button" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            findViewById(resID).setOnClickListener(mClickListener);
        }
    }
        Button.OnClickListener mClickListener = new View.OnClickListener() {
            public void onClick(View view) {
                Button button = (Button) view;
                String clickValue = button.getText().toString();

                switch (clickValue) {
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                    case "=":
                        if ("".equals(firstValue)) {
                            firstValue = editText.getText().toString();
                            editText.setText("");
                        } else if (!"".equals(operator)) {
                            String secondValue = editText.getText().toString();
                            Integer cal = 0;
                            switch (operator) {
                                case "+":
                                    cal = Integer.parseInt(firstValue) + Integer.parseInt(secondValue);
                                    break;
                                case "-":
                                    cal = Integer.parseInt(firstValue) - Integer.parseInt(secondValue);
                                    break;
                                case "*":
                                    cal = Integer.parseInt(firstValue) * Integer.parseInt(secondValue);
                                    break;
                                case "/":
                                    cal = Integer.parseInt(firstValue) / Integer.parseInt(secondValue);
                                    break;
                            }

                            editText.setText(cal.toString());
                            firstValue = "";
                            isInit = true;

                            if ("=".equals(clickValue)) {
                                operator = "";
                                return;
                            }
                            firstValue = cal.toString();
                        }
                        operator = clickValue;

                        break;
                    default:
                        if (isInit) {
                            isInit = false;
                            editText.setText(clickValue);
                        } else {
                            editText.setText(editText.getText().toString() + clickValue);
                        }
                }

            }
        };
    }
