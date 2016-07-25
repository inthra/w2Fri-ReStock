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

import com.epicodus.restock.Constants;
import com.epicodus.restock.R;
import com.epicodus.restock.models.Foodtruck;
import com.epicodus.restock.ui.FoodtruckDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FoodtruckListAdapter extends RecyclerView.Adapter<FoodtruckListAdapter.FoodtruckViewHolder> {
    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 400;

    private ArrayList<Foodtruck> mFoodtrucks = new ArrayList<>();
    private Context mContext;

    public FoodtruckListAdapter(Context context, ArrayList<Foodtruck> foodcarts) {
        mContext = context;
        mFoodtrucks = foodcarts;
    }

    @Override
    public FoodtruckListAdapter.FoodtruckViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foodtruck_list_item, parent, false);
        FoodtruckViewHolder viewHolder = new FoodtruckViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FoodtruckListAdapter.FoodtruckViewHolder holder, int position) {
        holder.bindFoodtruck(mFoodtrucks.get(position));
    }

    @Override
    public int getItemCount() {
        return mFoodtrucks.size();
    }

    public class FoodtruckViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.foodtruckImageView) ImageView mFoodtruckImageView;
        @Bind(R.id.nameTextView) TextView mNameTextView;

        public FoodtruckViewHolder(View itemView) {
            super(itemView);
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
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, FoodtruckDetailActivity.class);
            intent.putExtra("position", itemPosition + "");
            intent.putExtra(Constants.PARCEL_FOODTRUCKS, Parcels.wrap(mFoodtrucks));
            mContext.startActivity(intent);
        }
    }
}
