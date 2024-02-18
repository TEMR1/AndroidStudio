package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonPlus;
    private Button buttonEquals;
    private Button buttonClear;

    //--------------------------------------------------------------
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private TextView textView;
    private TextView example;

    ArrayList<Integer> numbers = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeElements();
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        if (view instanceof Button) {
            Button button = (Button) view;
            String justEnteredText = button.getText().toString();
            String exampleText = example.getText().toString();

            switch (justEnteredText) {
                case "+":
                    if (numbers.isEmpty() && exampleText.equals("")) {
                        error();
                    } else {
                        if (!exampleText.equals("")){
                            numbers.add(Integer.parseInt(exampleText));
                            example.setText("");
                        }
                        else{
                            error();
                        }
                    }

                    break;

                case "=":
                    if (numbers.isEmpty() || exampleText.equals("")) {
                        error();
                    } else {
                        numbers.add(Integer.parseInt(exampleText));
                        example.setText("");

                        int sum = sumOfNumbers(numbers);
                        example.setText(String.valueOf(sum));

                        numbers.clear();
                    }

                    break;

                case "Clear":
                    example.setText("");
                    textView.setText("");
                    numbers.clear();
                    break;

                default:
                    textView.setText("");
                    int number = Integer.parseInt(justEnteredText);
                    example.setText(exampleText + number);
                    break;
            }
        }
    }

    private int sumOfNumbers(ArrayList<Integer> numbers){
        int sum = 0;

        for (Integer num : numbers)
            sum+=num;

        return sum;
    }

    private void error(){
        example.setText("");
        textView.setText("Виникли деякі помилки!");
    }

    private void initializeElements() {
        example = findViewById(R.id.example);
        textView = findViewById(R.id.textView);

        buttonPlus = findViewById(R.id.buttonPlus);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonClear = findViewById(R.id.buttonClear);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

        buttonPlus.setOnClickListener(this);
        buttonEquals.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
    }
}