package com.epicodus.restock.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.epicodus.restock.models.Foodcart;
import com.epicodus.restock.ui.DeliveryDetailFragment;

import java.util.ArrayList;

public class FoodcartPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Foodcart> mFoodcarts;

    public FoodcartPagerAdapter(FragmentManager fm, ArrayList<Foodcart> foodcarts) {
        super(fm);
        mFoodcarts = foodcarts;
    }

    @Override
    public Fragment getItem(int position) {
        return DeliveryDetailFragment.newInstance(mFoodcarts.get(position));
    }

    @Override
    public int getCount() {
        return mFoodcarts.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFoodcarts.get(position).getName();
    }
}
