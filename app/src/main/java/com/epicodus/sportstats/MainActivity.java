package com.epicodus.sportstats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.etUserName) EditText mUserName;
    @Bind(R.id.etPassWord) EditText mPassWord;
    @Bind(R.id.bSignIn) Button mSignInButton;
    @Bind(R.id.tvRegisterHere) TextView mRegisterHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mSignInButton.setOnClickListener(this);
        mRegisterHere.setOnClickListener(this);
    }

    @Override
        public void onClick(View v) {
        if(v == mSignInButton) {
            String usernameInput = mUserName.getText().toString();
            Intent intent = new Intent(MainActivity.this, TeamsActivity.class);
            intent.putExtra("username", usernameInput);
            startActivity(intent);
        }

        if(v == mRegisterHere) {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        }
    }
}
