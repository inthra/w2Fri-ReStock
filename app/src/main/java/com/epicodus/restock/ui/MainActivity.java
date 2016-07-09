package com.epicodus.restock.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.restock.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.etUsername) EditText mUsername;
    @Bind(R.id.etPassword) EditText mPassword;
    @Bind(R.id.bSignIn) Button mSignInButton;
    @Bind(R.id.tvRegisterHere) TextView mRegisterHere;
    @Bind(R.id.tvHeader) TextView mAppNameHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Typeface pacificoFont = Typeface.createFromAsset(getAssets(), "fonts/pacifico.ttf");
        mAppNameHeader.setTypeface(pacificoFont);

        mSignInButton.setOnClickListener(this);
        mRegisterHere.setOnClickListener(this);
    }

    @Override
        public void onClick(View v) {
        if(v == mSignInButton) {
            String usernameInput = mUsername.getText().toString();
            Intent intent = new Intent(MainActivity.this, RolesActivity.class);
            intent.putExtra("username", usernameInput);
            startActivity(intent);
            mUsername.setText("");
            mPassword.setText("");
        }

        if(v == mRegisterHere) {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        }
    }
}
