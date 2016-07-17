package com.epicodus.restock.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.epicodus.restock.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OwnerActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.addFoodtrucksButton) Button mAddFoodtrucksButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);
        ButterKnife.bind(this);

        mAddFoodtrucksButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mAddFoodtrucksButton) {
            Intent intent = new Intent(OwnerActivity.this, DeliveryListActivity.class);
            startActivity(intent);
        }
    }
}
