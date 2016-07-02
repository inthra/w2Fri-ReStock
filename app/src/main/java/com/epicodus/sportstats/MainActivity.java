package com.epicodus.sportstats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private EditText mUserName;
    private EditText mPassWord;
    private Button mSignInButton;
    private TextView mRegisterLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserName = (EditText) findViewById(R.id.etUserName);
        mPassWord = (EditText) findViewById(R.id.etPassWord);

        mSignInButton = (Button) findViewById(R.id.bSignIn);
        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String usernameInput = mUserName.getText().toString();
//                Log.d(TAG, usernameInput);
                Intent intent = new Intent(MainActivity.this, TeamsActivity.class);
//                intent.putExtra("username", usernameInput);
                startActivity(intent);
            }
        });

        mRegisterLink = (TextView) findViewById(R.id.tvRegisterHere);
        mRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
               startActivity(intent);
            }
        });
    }
}
