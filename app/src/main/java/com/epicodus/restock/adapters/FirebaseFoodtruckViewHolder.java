package com.epicodus.restock.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.restock.Constants;
import com.epicodus.restock.R;
import com.epicodus.restock.models.Foodtruck;
import com.epicodus.restock.ui.FoodtruckDetailActivity;
import com.epicodus.restock.ui.OwnerActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FirebaseFoodtruckViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final int MAX_WIDTH = 1000;
    private static final int MAX_HEIGHT = 1000;

    View mView;
    Context mContext;

    @Bind(R.id.foodtruckImageView) ImageView mFoodtruckImageView;
    @Bind(R.id.nameTextView) TextView mNameTextView;
    @Bind(R.id.phoneTextView)TextView mPhoneTextView;
    @Bind(R.id.addressTextView) TextView mAddressTextView;

    public FirebaseFoodtruckViewHolder (View itemView) {
        super(itemView);
        mView = itemView;

        ButterKnife.bind(this, itemView);

        mContext = itemView.getContext();

        itemView.setOnClickListener(this);
    }

    public void bindFoodtruck(Foodtruck foodtruck) {
        Picasso.with(mContext)
                .load(foodtruck.getImageUrl())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(mFoodtruckImageView);

        mNameTextView.setText(foodtruck.getName());
        mPhoneTextView.setText(foodtruck.getPhone());
        mAddressTextView.setText(android.text.TextUtils.join(", ", foodtruck.getAddress()));
    }

    @Override
    public void onClick(View view) {
        final ArrayList<Foodtruck> foodtrucks = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_FOODTRUCKS);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    foodtrucks.add(snapshot.getValue(Foodtruck.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, OwnerActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra(Constants.PARCEL_FOODTRUCKS, Parcels.wrap(foodtrucks));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
