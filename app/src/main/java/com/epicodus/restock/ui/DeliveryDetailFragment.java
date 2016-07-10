package com.epicodus.restock.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.restock.R;
import com.epicodus.restock.models.Foodcart;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DeliveryDetailFragment extends Fragment {
    @Bind(R.id.itemImageView) ImageView mImageLabel;
    @Bind(R.id.foodcartNameTextView) TextView mNameLabel;
    @Bind(R.id.phoneTextView) TextView mPhoneLabel;
    @Bind(R.id.addressTextView) TextView mAddressLabel;

    private Foodcart mFoodcart;

    public static DeliveryDetailFragment newInstance(Foodcart foodcart) {
        DeliveryDetailFragment deliveryDetailFragment = new DeliveryDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("foodcart", Parcels.wrap(foodcart));
        deliveryDetailFragment.setArguments(args);
        return deliveryDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFoodcart = Parcels.unwrap(getArguments().getParcelable("foodcart"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delivery_detail, container, false);
        ButterKnife.bind(this, view);

        mNameLabel.setText(mFoodcart.getName());
        mPhoneLabel.setText(mFoodcart.getPhone());
        mAddressLabel.setText(android.text.TextUtils.join(", ", mFoodcart.getAddress()));

        return view;
    }

}
