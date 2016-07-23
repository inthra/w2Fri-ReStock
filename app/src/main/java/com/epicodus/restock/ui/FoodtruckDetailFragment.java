package com.epicodus.restock.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.restock.Constants;
import com.epicodus.restock.R;
import com.epicodus.restock.models.Foodtruck;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.parceler.Parcels;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FoodtruckDetailFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.itemImageView) ImageView mImageLabel;
    @Bind(R.id.foodtruckNameTextView) TextView mNameLabel;
    @Bind(R.id.phoneTextView) TextView mPhoneLabel;
    @Bind(R.id.addressTextView) TextView mAddressLabel;
    @Bind(R.id.saveFoodtruckButton) Button mSaveFoodtruckButton;

    private Foodtruck mFoodtruck;

    public static FoodtruckDetailFragment newInstance(Foodtruck foodtruck) {
        FoodtruckDetailFragment foodtruckDetailFragment = new FoodtruckDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(Constants.PARCEL_FOODTRUCKS, Parcels.wrap(foodtruck));
        foodtruckDetailFragment.setArguments(args);

        return foodtruckDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFoodtruck = Parcels.unwrap(getArguments().getParcelable(Constants.PARCEL_FOODTRUCKS));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_foodtruck_detail, container, false);
        ButterKnife.bind(this, view);

        mNameLabel.setText(mFoodtruck.getName());
        mPhoneLabel.setText(mFoodtruck.getPhone());
        mAddressLabel.setText(android.text.TextUtils.join(", ", mFoodtruck.getAddress()));

        mPhoneLabel.setOnClickListener(this);
        mAddressLabel.setOnClickListener(this);
        mSaveFoodtruckButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mPhoneLabel) {
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + mFoodtruck.getPhone()));
            startActivity(phoneIntent);
        }
        if (v == mAddressLabel) {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + mFoodtruck.getLatitude() + "," + mFoodtruck.getLongitude() + "?q=(" + mFoodtruck.getName() + ")"));
            startActivity(mapIntent);
        }

        if (v == mSaveFoodtruckButton) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();
            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_USERS).child(uid);

            DatabaseReference foodtruckTarget = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_FOODTRUCKS);
            DatabaseReference pushRef = foodtruckTarget.push();

            String foodtruckId = pushRef.getKey();

            mFoodtruck.setPushId(foodtruckId);
            pushRef.setValue(mFoodtruck);

            Map<String, Object> thisFoodtruckId = new HashMap<String, Object>();
            thisFoodtruckId.put("foodtruckId", foodtruckId);
            userRef.updateChildren(thisFoodtruckId);

            Toast.makeText(getContext(), "Foodtruck saved to your account", Toast.LENGTH_SHORT).show();
        }
    }
}
