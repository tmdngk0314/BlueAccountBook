package com.cookandroid.account_book;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
        for (int i = 0; i < 16; i++) {
            String buttonID = "button" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            findViewById(resID).setOnClickListener(mClickListener);
        }
    }
        Button.OnClickListener mClickListener = new View.OnClickListener() {
            public void onClick(View view) {
                Button button = (Button) view;
                TextView textresult = (TextView) findViewById(R.id.textResult);
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
                                        textresult.setText("계산 결과 : " + cal.toString());
                                        break;
                                    case "-":
                                        cal = Integer.parseInt(firstValue) - Integer.parseInt(secondValue);
                                        textresult.setText("계산 결과 : " + cal.toString());
                                        break;
                                    case "*":
                                        cal = Integer.parseInt(firstValue) * Integer.parseInt(secondValue);
                                        textresult.setText("계산 결과 : " + cal.toString());
                                        break;
                                    case "/":
                                        if (Integer.parseInt(secondValue) != 0) {
                                            cal = Integer.parseInt(firstValue) / Integer.parseInt(secondValue);
                                            textresult.setText("계산 결과 : " + cal.toString());
                                        } else {
                                            cal = 0;
                                            textresult.setText("계산 결과 : " + cal.toString());
                                        }
                                        break;
                                }

                                editText.setText(cal.toString());
                                firstValue = "";
                                isInit = true;

                                if ("=".equals(clickValue)) {
                                    operator = "";
                                    return;
                                }
                                else if ("+".equals(clickValue)) {
                                    operator = "";
                                    return;
                                }
                                else if ("-".equals(clickValue)) {
                                    operator = "";
                                    return;
                                }
                                else if ("/".equals(clickValue)) {
                                    operator = "";
                                    return;
                                }
                                else if ("*".equals(clickValue)) {
                                    operator = "";
                                    return;
                                }
                                else if ("C".equals(clickValue)) {
                                    operator = "";
                                    return;
                                }
                                else{
                                    operator = "";
                                }
                                firstValue = cal.toString();
                            }
                            operator = clickValue;

                            break;
                        case "C":
                            firstValue = "0";
                            String secondValue = editText.getText().toString();
                            secondValue = "0";
                            editText.setText("");
                            textresult.setText("계산 결과 : " + 0);

                            if ("=".equals(clickValue)) {
                                operator = "";
                                return;
                            }
                            else if ("+".equals(clickValue)) {
                                operator = "";
                                return;
                            }
                            else if ("-".equals(clickValue)) {
                                operator = "";
                                return;
                            }
                            else if ("/".equals(clickValue)) {
                                operator = "";
                                return;
                            }
                            else if ("*".equals(clickValue)) {
                                operator = "";
                                return;
                            }
                            else if ("C".equals(clickValue)) {
                                operator = "";
                                return;
                            }
                            else{operator = "";}

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
