package com.jorgegilcavazos.nuevoleontravel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryAdapter extends BaseAdapter {
    private Context mContext;

    public CategoryAdapter(Context c) {
        mContext = c;
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.category_card, parent, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.category_image);
        TextView textView = (TextView) view.findViewById(R.id.category_name);

        imageView.setImageResource(mThumbIds[position]);
        textView.setText(mCategoryNames[position].toUpperCase());
        return view;
    }

    private Integer[] mThumbIds = {
            R.drawable.aventura, R.drawable.rurales,
            R.drawable.urbanos, R.drawable.paseos,
            R.drawable.cultura, R.drawable.deportes,
            R.drawable.comida, R.drawable.compras,
    };

    private String[] mCategoryNames = {
            "Tours de Aventura", "Tours Rurales",
            "Tours Urbanos", "Parques y Paseos",
            "Cultura", "Deporte",
            "Comida", "Compras"
    };
}
