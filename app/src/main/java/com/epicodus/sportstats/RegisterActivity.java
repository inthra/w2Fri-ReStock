package com.epicodus.sportstats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.app.ProgressDialog.show;

public class RegisterActivity extends AppCompatActivity {
    private Button mRegisterButton;
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mEmail;
    private EditText mUserName;
    private EditText mPassWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirstName = (EditText) findViewById(R.id.etFirstName);
        mLastName = (EditText) findViewById(R.id.etLastName);
        mEmail = (EditText) findViewById(R.id.etEmail);
        mUserName = (EditText) findViewById(R.id.etUserName);
        mPassWord = (EditText) findViewById(R.id.etPassWord);

        mRegisterButton = (Button) findViewById(R.id.bRegister);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RegisterActivity.this, "Register Success", Toast.LENGTH_LONG).show();
            }
        });
    }
}
