package com.example.hw_1_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText email;
private EditText theme;
private EditText message;
private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();

    }

    private void initListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent=new Intent(Intent.ACTION_SEND);
               intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
intent.putExtra(Intent.EXTRA_SUBJECT,theme.getText().toString());
intent.putExtra(Intent.EXTRA_TEXT,message.getText().toString());
startActivity(intent);

            }
        });
    }

    private void initView() {
        email=findViewById(R.id.et_email);
        theme=findViewById(R.id.et_theme);
        message=findViewById(R.id.et_message);
        button=findViewById(R.id.btn_send);
    }
}