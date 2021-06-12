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
    /*
     1. 숫자 입력
     2. 연산자 입력
        2.1 첫번째수(firstValue)가 없으면 입력한 숫자를 첫번째수로 지정
        2.1 연산자 보관
     3. 숫자입력
     4. 연산자, = 입력
        4.1 입력한 숫자를 두번째수(secondValue)로 지정
        4.2 연산
        4.3 = 이면 모두 초기화
        4.4 = 이 아니면 계산값은 첫번째수, 연산자 보관
     */
        Button.OnClickListener mClickListener = new View.OnClickListener() {
            public void onClick(View view) {
                Button button = (Button) view;
                TextView textresult = (TextView) findViewById(R.id.textResult);
                String clickValue = button.getText().toString();

                    switch (clickValue) { // 사용자가 숫자를 입력
                        case "+":
                        case "-":
                        case "*":
                        case "/":
                        case "=":
                            if ("".equals(firstValue)) {
                                firstValue = editText.getText().toString();//첫번째 입력값으로 저장하여 보관
                                editText.setText(""); // 두번째 입력값은 위해 기존 숫자를 지운다.
                            } else if (!"".equals(operator)) { // 입력값이 null값이 아닐 때 실행 연산자 선택
                                String secondValue = editText.getText().toString();
                                Integer cal = 0;
                                switch (operator) {
                                    case "+": //더하기
                                        cal = Integer.parseInt(firstValue) + Integer.parseInt(secondValue);
                                        textresult.setText("계산 결과 : " + cal.toString());
                                        break;
                                    case "-": // 빼기
                                        cal = Integer.parseInt(firstValue) - Integer.parseInt(secondValue);
                                        textresult.setText("계산 결과 : " + cal.toString());
                                        break;
                                    case "*": //곱하기
                                        cal = Integer.parseInt(firstValue) * Integer.parseInt(secondValue);
                                        textresult.setText("계산 결과 : " + cal.toString());
                                        break;
                                    case "/": // 나누기
                                        if (Integer.parseInt(secondValue) != 0) { //입력값이 0이 아닐때 계산
                                            cal = Integer.parseInt(firstValue) / Integer.parseInt(secondValue);
                                            textresult.setText("계산 결과 : " + cal.toString());
                                        } else { // 입력값이 0이면 결과는 0 출력
                                            cal = 0;
                                            textresult.setText("계산 결과 : " + cal.toString());
                                        }
                                        break;
                                }

                                editText.setText(cal.toString()); //계산결과
                                firstValue = ""; //연산자를 누르면 처음값을 지우고 두번째 입력가능
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
                        case "C": // clear버튼튼                            firstValue = "0";
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
