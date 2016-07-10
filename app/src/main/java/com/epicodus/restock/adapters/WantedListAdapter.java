package com.epicodus.restock.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.restock.R;
import com.epicodus.restock.models.Foodcart;

import java.util.ArrayList;

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

    public class WantedViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.nameTextView) TextView mNameTextView;

        private Context mContext;

        public WantedViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindFoodcart(Foodcart foodcart) {
            mNameTextView.setText(foodcart.getName());
        }
    }
}
