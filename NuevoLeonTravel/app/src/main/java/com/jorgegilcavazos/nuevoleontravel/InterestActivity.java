package com.jorgegilcavazos.nuevoleontravel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class InterestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        setTitle("Deportes");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.interest_rv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        List<InteresDeportivo> interesDeportivos = new ArrayList<>();

        recyclerView.setAdapter(new InteresDeportivoAdapter(this, interesDeportivos));
    }
}
