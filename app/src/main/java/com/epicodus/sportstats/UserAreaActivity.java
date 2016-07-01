package com.epicodus.sportstats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        final EditText mUserName = (EditText) findViewById(R.id.etUserName);
        final EditText mPassWord = (EditText) findViewById(R.id.etPassWord);

        final TextView mWelcomeMessage = (TextView) findViewById(R.id.tvWelcomeMsg);
    }
}
