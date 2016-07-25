package com.epicodus.restock.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.epicodus.restock.Constants;
import com.epicodus.restock.R;
import com.epicodus.restock.adapters.FirebaseFoodtruckViewHolder;
import com.epicodus.restock.models.Foodtruck;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OwnerActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference mFoodtruckReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    @Bind(R.id.addFoodtrucksButton) Button mAddFoodtruckButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("back to main menu");

        mFoodtruckReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_FOODTRUCKS);
        setUpFirebaseAdapter();

        mAddFoodtruckButton.setOnClickListener(this);
    }

    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Foodtruck, FirebaseFoodtruckViewHolder>(Foodtruck.class, R.layout.saved_foodtruck_list_item, FirebaseFoodtruckViewHolder.class, mFoodtruckReference) {
            @Override
            protected void populateViewHolder(FirebaseFoodtruckViewHolder viewHolder, Foodtruck model, int position) {
                viewHolder.bindFoodtruck(model);
            }
        };

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }

    @Override
    public void onClick(View view) {
        if (view == mAddFoodtruckButton) {
            Intent intent = new Intent(OwnerActivity.this, FoodtruckListActivity.class);
            startActivity(intent);
        }
    }
}
