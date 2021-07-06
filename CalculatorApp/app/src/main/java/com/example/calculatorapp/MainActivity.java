package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
                   buttonAC, buttonDel, buttonPlus, buttonMinus, buttonDivide, buttonMulti, buttonEquals, buttonDot;

    private TextView textViewResult, textViewHistory;

    private String number = null;

    double firstNumber = 0;
    double lastNumber = 0;

    String status = null;
    boolean operator = false;

    DecimalFormat m_formatter = new DecimalFormat("######.######");

    String history = null;
    String currentResult = null;

    boolean dot = true;
    boolean isAControl = true;
    boolean isEqualsControl = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);

        buttonPlus = findViewById(R.id.btnPlus);
        buttonMinus = findViewById(R.id.btnMinus);
        buttonMulti = findViewById(R.id.btnMulti);
        buttonDivide = findViewById(R.id.btnDivide);

        buttonAC = findViewById(R.id.btnAC);
        buttonDel = findViewById(R.id.btnDel);
        buttonDot = findViewById(R.id.btnDot);
        buttonEquals = findViewById(R.id.btnEquals);

        textViewResult = findViewById(R.id.textViewResult);
        textViewHistory = findViewById(R.id.textViewHistory);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("9");
            }
        });

        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = null;
                status = null;
                textViewResult.setText("0");
                textViewHistory.setText("");
                firstNumber = 0;
                lastNumber = 0;
                dot = true;
                isAControl = true;
            }
        });

        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isAControl)
                {
                    textViewResult.setText("0");
                }
                else
                {
                    number = number.substring(0,number.length()-1);

                    if (number.length() == 0)
                    {
                        buttonDel.setClickable(false);
                    }
                    else if (number.contains("."))
                    {
                        dot = false;
                    }
                    else
                    {
                        dot = true;
                    }

                    textViewResult.setText(number);
                }

            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + "+");

                if(operator)
                {
                    if (status == "multiplacition")
                    {
                       multiply();
                    }
                    else if (status == "division")
                    {
                       divide();
                    }
                    else if (status == "subtraction")
                    {
                        minus();
                    }
                    else
                    {
                        plus();
                    }
                }

                status = "addition";
                operator = false;
                number = null;
            }
        });

        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + "-");

                if(operator)
                {
                    if (status == "multiplacition")
                    {
                        multiply();
                    }
                    else if (status == "division")
                    {
                        divide();
                    }
                    else if (status == "addition")
                    {
                        minus();
                    }
                    else
                    {
                        plus();
                    }
                }

                status = "subtraction";
                operator = false;
                number = null;

            }
        });

        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + "*");

                if (operator)
                {
                    if (status == "addition")
                    {
                        plus();
                    }
                    else if (status == "division")
                    {
                        divide();
                    }
                    else if (status == "subtraction")
                    {
                        minus();
                    }
                    else
                    {
                        multiply();
                    }

                }

                status = "multiplacition";
                operator = false;
                number = null;

            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"/");

                if (operator)
                {
                    if (status == "multiplacition")
                    {
                        multiply();
                    }
                    else if (status == "addition")
                    {
                        plus();
                    }
                    else if (status == "subtraction")
                    {
                        minus();
                    }
                    else
                    {
                        divide();
                    }
                }

                status = "division";
                operator = false;
                number = null;
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (operator)
                {
                    if (status == "addition")
                    {
                        plus();
                    }
                    else if (status == "subtraction")
                    {
                        minus();
                    }
                    else if (status == "multiplacition")
                    {
                        multiply();
                    }
                    else if (status == "division")
                    {
                        divide();
                    }
                    else
                    {
                        firstNumber = Double.parseDouble(textViewResult.getText().toString());
                    }
                }

                operator = false;
                isEqualsControl = true;
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (dot)
                {
                    if (number == null)
                    {
                        number = "0.";
                    }
                    else
                    {
                        number = number + ".";
                    }
                }

                textViewResult.setText(number);
                dot = false;
            }
        });
    }

    public void numberClick(String view)
    {
        String regex = "[1-9]\\d*|0\\d+" ;
        if (number == null)
        {
            number = view;
        }
        else if (isEqualsControl)
        {
            firstNumber = 0;
            lastNumber = 0;
            number = view;
        }
        else
        {
            number = number + view;
        }

        if (number.matches(regex))
        {
            textViewResult.setText(number);
        }
        else
        {
            textViewResult.setText("0");
            number = null;
        }

        operator = true;
        isAControl = false;
        buttonDel.setClickable(true);
        isEqualsControl = false;
    }

    public void plus()
    {
        lastNumber = Double.parseDouble(textViewResult.getText().toString());
        firstNumber = firstNumber + lastNumber;

        textViewResult.setText((m_formatter.format(firstNumber)));
        dot = true;
    }

    public void minus()
    {
        if (firstNumber == 0)
        {
            firstNumber = Double.parseDouble(textViewResult.getText().toString());
        }
        else
        {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber - lastNumber;
        }

        textViewResult.setText(m_formatter.format(firstNumber));
        dot = true;
    }

    public void multiply()
    {
        if (firstNumber == 0)
        {
            firstNumber = 1;
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }
        else
        {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }

        textViewResult.setText(m_formatter.format(firstNumber));
    }

    public void divide()
    {
        if (firstNumber == 0)
        {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = lastNumber / 1;
        }
        else
        {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber / lastNumber;
        }

        textViewResult.setText(m_formatter.format(firstNumber));
        dot = true;
    }
}