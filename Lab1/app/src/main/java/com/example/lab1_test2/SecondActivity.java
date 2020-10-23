package com.example.lab1_test2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        TextView textView = (TextView) findViewById(R.id.text2);
        Integer messInt = Integer.parseInt(intent.getStringExtra("text"));
        Integer numInt = Integer.parseInt(intent.getStringExtra("number"));
        Integer fin = messInt + numInt;
        textView.setText(fin.toString());

        EditText answerText = (EditText) findViewById(R.id.answer_text2);
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("resultText", textView.getText().toString());
                returnIntent.putExtra("resultNumber", answerText.getText().toString());
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
    }
    
}