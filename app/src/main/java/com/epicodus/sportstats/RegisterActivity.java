package com.epicodus.sportstats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText mFirstName = (EditText) findViewById(R.id.etFirstName);
        final EditText mLastName = (EditText) findViewById(R.id.etLastName);
        final EditText mEmail = (EditText) findViewById(R.id.etEmail);
        final EditText mUserName = (EditText) findViewById(R.id.etUserName);
        final EditText mPassWord = (EditText) findViewById(R.id.etPassWord);

        final Button mRegisterButton = (Button) findViewById(R.id.bRegister);

    }
}
