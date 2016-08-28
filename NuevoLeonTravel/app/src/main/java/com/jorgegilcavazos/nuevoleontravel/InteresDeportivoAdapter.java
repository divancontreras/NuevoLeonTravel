package com.jorgegilcavazos.nuevoleontravel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class InteresDeportivoAdapter extends RecyclerView.Adapter<InteresDeportivoAdapter.InteresDeportivoViewHolder> {
    Context mContext;
    List<InteresDeportivo> mIntereses;

    public InteresDeportivoAdapter(Context context, List<InteresDeportivo> intereses) {
        mContext = context;
        mIntereses = intereses;
    }

    @Override
    public InteresDeportivoAdapter.InteresDeportivoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_card, parent, false);

        InteresDeportivoViewHolder interesVH = new InteresDeportivoViewHolder(view);
        return interesVH;
    }

    @Override
    public void onBindViewHolder(InteresDeportivoViewHolder holder, int position) {
        InteresDeportivo interesDeportivo = mIntereses.get(position);
        holder.mImage.setImageResource(interesDeportivo.getImageRes());
        holder.mName.setText(interesDeportivo.getNombre());
        holder.mRating.setText(interesDeportivo.getRating() + "/5");
        holder.mAddress.setText(interesDeportivo.getDireccion());
        holder.mWebsite.setText(interesDeportivo.getPaginaWeb());
        holder.mDescription.setText(interesDeportivo.getInformacion());
        holder.mImage.setImageResource(interesDeportivo.getImageRes());
    }

    @Override
    public int getItemCount() {
        return null != mIntereses ? mIntereses.size() : 0;
    }

    public static class InteresDeportivoViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImage;
        public TextView mName, mRating, mPhone, mAddress, mWebsite, mDescription;

        public InteresDeportivoViewHolder(View view) {
            super(view);
            mImage = (ImageView) view.findViewById(R.id.place_image);
            mName = (TextView) view.findViewById(R.id.place_name);
            mPhone = (TextView) view.findViewById(R.id.place_phone);
            mAddress = (TextView) view.findViewById(R.id.place_address);
            mRating = (TextView) view.findViewById(R.id.place_rating);
            mWebsite = (TextView) view.findViewById(R.id.place_website);
            mDescription = (TextView) view.findViewById(R.id.place_open);
        }
    }
}
