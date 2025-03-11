package com.example.week8homework;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText textInput1;
    private EditText textInput2;
    private TextView textOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textInput1 = findViewById(R.id.inputFirstNumber);
        textInput2 = findViewById(R.id.inputSecondNumber);
        textOutput = findViewById(R.id.textView2);
    }

    private int getInput(EditText inputField) {
        String inputText = inputField.getText().toString();
        if (inputText.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(inputText);
    }

    public void plus(View view) {
        int num1 = getInput(textInput1);
        int num2 = getInput(textInput2);
        int result = num1 + num2;
        textOutput.setText(String.valueOf(result));
    }

    public void minus(View view) {
        int num1 = getInput(textInput1);
        int num2 = getInput(textInput2);
        int result = num1 - num2;
        textOutput.setText(String.valueOf(result));
    }

    public void multiply(View view) {
        int num1 = getInput(textInput1);
        int num2 = getInput(textInput2);
        int result = num1 * num2;
        textOutput.setText(String.valueOf(result));
    }

    public void divide(View view) {
        int num1 = getInput(textInput1);
        int num2 = getInput(textInput2);
        if (num2 == 0) {
            Toast.makeText(this, "The divisor cannot be 0", Toast.LENGTH_SHORT).show()
            ;
            textOutput.setText("Error");
            return;
        }
        int result = num1 / num2;
        textOutput.setText(String.valueOf(result));
    }
}