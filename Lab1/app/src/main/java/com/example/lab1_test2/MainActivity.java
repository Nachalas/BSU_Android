package com.example.lab1_test2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = (EditText) findViewById(R.id.answer_text1);
        TextView textView = (TextView) findViewById(R.id.text1);
        Button button = (Button) findViewById(R.id.button1);
        
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("number", editText.getText().toString());
                intent.putExtra("text", textView.getText().toString());
                startActivityForResult(intent, 10);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
            if (resultCode == Activity.RESULT_OK) {
                Integer resultText = Integer.parseInt(data.getStringExtra("resultText"));
                Integer resultNum = Integer.parseInt(data.getStringExtra("resultNumber"));
                TextView textView = (TextView) findViewById(R.id.text1);
                Integer fin = resultText + resultNum;
                textView.setText(fin.toString());
            }
        }
    }
}