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
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_que_hacer, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.quehacer_rv);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setNestedScrollingEnabled(false);

        List<String> places = new ArrayList<>();
        places.add("Hola");
        places.add("Como");
        places.add("Esta");
        places.add("Bien");
        places.add("Gracias");
        places.add("Ok");

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);
        mRecyclerView.setAdapter(adapter);

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
