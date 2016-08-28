package com.jorgegilcavazos.nuevoleontravel;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class EventosFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eventos, container, false);
        TextView question = (TextView) view.findViewById(R.id.question_text_view);
        question.setText("¿Te interesa asistir a eventos en Nuevo León?");

        Button festivalButton = (Button) view.findViewById(R.id.evento_button);
        festivalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.festivalsantalucia.gob.mx/";
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(getActivity(), Uri.parse(url));
            }
        });

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

        return view;
    }

    private void showToast(Context context) {
        Toast.makeText(context, "Respuesta guardada", Toast.LENGTH_SHORT).show();
    }
}
