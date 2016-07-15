package com.epicodus.restock.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.restock.R;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RolesActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.tvUsername) TextView mUsername;
    @Bind(R.id.tvHeader) TextView mAppNameHeader;
    @Bind(R.id.bRestock) Button mRestockButton;
    @Bind(R.id.bFoodtruck) Button mFoodtruckButton;


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
        mFoodtruckButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return  super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(RolesActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if(v == mRestockButton) {
            Intent intent = new Intent(RolesActivity.this, DeliveryListActivity.class);
            startActivity(intent);
        }
        if(v == mFoodtruckButton) {
            Intent intent = new Intent(RolesActivity.this, BusinessOwnerActivity.class);
            startActivity(intent);
        }
    }
}
