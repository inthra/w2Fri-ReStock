package com.epicodus.restock.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.restock.R;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.app.ProgressDialog.show;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.etFirstname) EditText mFirstname;
    @Bind(R.id.etLastname) EditText mLastname;
    @Bind(R.id.etEmail) EditText mEmail;
    @Bind(R.id.etUsername) EditText mUsername;
    @Bind(R.id.etPassword) EditText mPassword;
    @Bind(R.id.etConfirmPassword) EditText mConfirmPassword;
    @Bind(R.id.bRegister) Button mRegisterButton;
    @Bind(R.id.loginTextView) TextView mLoginTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);

        mLoginTextView.setOnClickListener(this);
        mRegisterButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mLoginTextView) {
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
        if (view == mRegisterButton) {
            Toast.makeText(RegisterActivity.this, "Register Success", Toast.LENGTH_SHORT).show();
        }
    }
}
