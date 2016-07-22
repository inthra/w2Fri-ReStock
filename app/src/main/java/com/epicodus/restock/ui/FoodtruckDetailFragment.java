package com.epicodus.restock.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.restock.R;
import com.epicodus.restock.models.Foodtruck;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FoodtruckDetailFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.itemImageView) ImageView mImageLabel;
    @Bind(R.id.foodtruckNameTextView) TextView mNameLabel;
    @Bind(R.id.phoneTextView) TextView mPhoneLabel;
    @Bind(R.id.addressTextView) TextView mAddressLabel;

    private Foodtruck mFoodtruck;

    public static FoodtruckDetailFragment newInstance(Foodtruck foodtruck) {
        FoodtruckDetailFragment deliveryDetailFragment = new FoodtruckDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("foodtrucks", Parcels.wrap(foodtruck));
        deliveryDetailFragment.setArguments(args);
        return deliveryDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFoodtruck = Parcels.unwrap(getArguments().getParcelable("foodtrucks"));
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
    }
}
