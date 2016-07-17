package com.epicodus.restock.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.restock.R;
import com.epicodus.restock.models.Foodtruck;
import com.epicodus.restock.ui.FoodtruckDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FoodtruckListAdapter extends RecyclerView.Adapter<FoodtruckListAdapter.WantedViewHolder> {
    private ArrayList<Foodtruck> mFoodcarts = new ArrayList<>();
    private Context mContext;

    public FoodtruckListAdapter(Context context, ArrayList<Foodtruck> foodcarts) {
        mContext = context;
        mFoodcarts = foodcarts;
    }

    @Override
    public FoodtruckListAdapter.WantedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foodtruck_list_item, parent, false);
        WantedViewHolder viewHolder = new WantedViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FoodtruckListAdapter.WantedViewHolder holder, int position) {
        holder.bindFoodcart(mFoodcarts.get(position));
    }

    @Override
    public int getItemCount() {
        return mFoodcarts.size();
    }

    public class WantedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.nameTextView) TextView mNameTextView;
        @Bind(R.id.itemImageView) ImageView mItemImageView;

        public WantedViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindFoodcart(Foodtruck foodcart) {
            mNameTextView.setText(foodcart.getName());
            TypedArray imgs = mContext.getResources().obtainTypedArray(R.array.random_images_array);
            Random rand = new Random();
            int rndInt = rand.nextInt(imgs.length());
            int resID = imgs.getResourceId(rndInt, 0);
            mItemImageView.setImageResource(resID);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, FoodtruckDetailActivity.class);
            intent.putExtra("position", itemPosition + "");
            intent.putExtra("foodcarts", Parcels.wrap(mFoodcarts));
            mContext.startActivity(intent);
        }


    }
}
