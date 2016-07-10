package com.epicodus.restock.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.restock.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RolesActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.tvUsername) TextView mUsername;
    @Bind(R.id.bRestock) Button mRestockButton;
    @Bind(R.id.tvHeader) TextView mAppNameHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roles);
        ButterKnife.bind(this);

        Typeface pacificoFont = Typeface.createFromAsset(getAssets(), "fonts/pacifico.ttf");
        mAppNameHeader.setTypeface(pacificoFont);

        mUsername = (TextView) findViewById(R.id.tvUsername);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        mUsername.setText(username);

        mRestockButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mRestockButton) {
            Intent intent = new Intent(RolesActivity.this, DeliveryListActivity.class);
            startActivity(intent);
        }
    }
}
