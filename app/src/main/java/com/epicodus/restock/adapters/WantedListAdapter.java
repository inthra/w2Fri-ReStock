package com.epicodus.restock.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.restock.R;
import com.epicodus.restock.models.Foodcart;
import com.epicodus.restock.ui.DeliveryDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WantedListAdapter extends RecyclerView.Adapter<WantedListAdapter.WantedViewHolder> {
    private ArrayList<Foodcart> mFoodcarts = new ArrayList<>();
    private Context mContext;

    public WantedListAdapter(Context context, ArrayList<Foodcart> foodcarts) {
        mContext = context;
        mFoodcarts = foodcarts;
    }

    @Override
    public WantedListAdapter.WantedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wanted_list_item, parent, false);
        WantedViewHolder viewHolder = new WantedViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WantedListAdapter.WantedViewHolder holder, int position) {
        holder.bindFoodcart(mFoodcarts.get(position));
    }

    @Override
    public int getItemCount() {
        return mFoodcarts.size();
    }

    public class WantedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.nameTextView) TextView mNameTextView;
        @Bind(R.id.itemImageView) ImageView mItemImageView;

        private Context mContext;

        public WantedViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindFoodcart(Foodcart foodcart) {
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
            Intent intent = new Intent(mContext, DeliveryDetailActivity.class);
            intent.putExtra("position", itemPosition + "");
            intent.putExtra("foodcarts", Parcels.wrap(mFoodcarts));
            mContext.startActivity(intent);
        }


    }
}
