package com.epicodus.restock.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.epicodus.restock.R;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context context) {
        mContext = context;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(350, 350));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5, 5, 5, 5);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    private Integer[] mThumbIds = {
            R.drawable.photo1, R.drawable.photo2, R.drawable.photo3, R.drawable.photo4, R.drawable.photo5, R.drawable.photo6,
            R.drawable.photo7, R.drawable.photo8, R.drawable.photo9, R.drawable.photo10, R.drawable.photo11, R.drawable.photo12,
            R.drawable.photo13, R.drawable.photo14, R.drawable.photo15, R.drawable.photo16, R.drawable.photo17, R.drawable.photo18,
            R.drawable.photo19, R.drawable.photo20, R.drawable.photo21, R.drawable.photo22, R.drawable.photo23, R.drawable.photo24
    };
}