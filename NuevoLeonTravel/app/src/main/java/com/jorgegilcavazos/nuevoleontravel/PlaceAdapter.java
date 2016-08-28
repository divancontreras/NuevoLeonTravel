package com.jorgegilcavazos.nuevoleontravel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {
    Context mContext;
    List<String> mPlaces;

    public PlaceAdapter(Context context, List<String> places) {
        mContext = context;
        mPlaces = places;
    }

    @Override
    public PlaceAdapter.PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_card, parent, false);

        PlaceViewHolder placeViewHolder = new PlaceViewHolder(view);
        return placeViewHolder;
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, int position) {
        holder.mPlaceName.setText(mPlaces.get(position));
    }

    @Override
    public int getItemCount() {
        return null != mPlaces ? mPlaces.size() : 0;
    }

    public static class PlaceViewHolder extends RecyclerView.ViewHolder {
        public ImageView mPlaceImage;
        public TextView mPlaceName, mPlaceRating, mPlacePhone, mPlaceAddress, mPlaceOpen;

        public PlaceViewHolder(View view) {
            super(view);
            mPlaceImage = (ImageView) view.findViewById(R.id.place_image);
            mPlaceName = (TextView) view.findViewById(R.id.place_name);
            mPlacePhone = (TextView) view.findViewById(R.id.place_phone);
            mPlaceAddress = (TextView) view.findViewById(R.id.place_address);
            mPlaceRating = (TextView) view.findViewById(R.id.place_rating);
            mPlaceOpen = (TextView) view.findViewById(R.id.place_open);
        }
    }
}