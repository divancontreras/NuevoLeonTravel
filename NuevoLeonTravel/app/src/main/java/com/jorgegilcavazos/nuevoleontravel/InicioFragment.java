package com.jorgegilcavazos.nuevoleontravel;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class InicioFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);
        final CardView surveyCard = (CardView) view.findViewById(R.id.survey_cardview);
        Button yesButton = (Button) view.findViewById(R.id.question_no_button);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                surveyCard.setVisibility(View.GONE);
                showToast(getActivity());
            }
        });
        Button noButton = (Button) view.findViewById(R.id.question_yes_button);
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                surveyCard.setVisibility(View.GONE);
                showToast(getActivity());
            }
        });

        Button exploreButton = (Button) view.findViewById(R.id.card1_button);
        exploreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.setFragment(1);
            }
        });

        Button consultarButton = (Button) view.findViewById(R.id.card4_button);
        consultarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.setFragment(4);
            }
        });

        Button discoverButton = (Button) view.findViewById(R.id.card2_button);
        discoverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.setFragment(2);
            }
        });

        return view;
    }

    private void showToast(Context context) {
        Toast.makeText(context, getResources().getString(R.string.response_saved), Toast.LENGTH_SHORT).show();
    }

}
