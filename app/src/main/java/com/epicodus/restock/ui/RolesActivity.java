package com.epicodus.restock.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.epicodus.restock.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RolesActivity extends AppCompatActivity {
    @Bind(R.id.tvUsername) TextView mUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roles);
        ButterKnife.bind(this);

        mUsername = (TextView) findViewById(R.id.tvUsername);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        mUsername.setText(username);
    }
}
