package com.epicodus.sportstats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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

        final EditText mUserName = (EditText) findViewById(R.id.etUserName);
        final EditText mPassWord = (EditText) findViewById(R.id.etPassWord);

        final Button mSignIn = (Button) findViewById(R.id.bSignIn);

        final TextView mRegisterLink = (TextView) findViewById(R.id.tvRegisterHere);
        mRegisterLink.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
               startActivity(intent);
           }
        });
    }
}
