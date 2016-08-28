package com.jorgegilcavazos.nuevoleontravel;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class QueHacerFragment extends Fragment {
    private static final String PLACES_API_KEY = "AIzaSyDJtWLJGMkD4bgPTSLtLh4zNd_pse7pInY";

    private View rootView;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        MainActivity mainActivity = (MainActivity) getActivity();

        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_que_hacer, container, false);

        GridView gridView = (GridView) rootView.findViewById(R.id.gridview);
        gridView.setAdapter(new CategoryAdapter(mainActivity));

        /*
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.quehacer_rv);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setNestedScrollingEnabled(false);


        PlaceAdapter adapter = new PlaceAdapter(mainActivity, mainActivity.getPlaces());
        mRecyclerView.setAdapter(adapter);
        */
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
