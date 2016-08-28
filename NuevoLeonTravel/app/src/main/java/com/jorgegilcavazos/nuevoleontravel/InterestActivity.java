package com.jorgegilcavazos.nuevoleontravel;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class InterestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        setTitle("Deportes");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.interest_rv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        List<InteresDeportivo> interesDeportivos = new ArrayList<>();
        interesDeportivos.add(new InteresDeportivo(
                getResources().getString(R.string.estadioTec_name),
                getResources().getString(R.string.estadioTec_address),
                getResources().getString(R.string.estadioTec_phone),
                getResources().getString(R.string.estadioTec_website),
                getResources().getString(R.string.estadioTec_description),
                R.drawable.estadio,
                4));
        interesDeportivos.add(new InteresDeportivo(
                getResources().getString(R.string.golfHerradura_name),
                getResources().getString(R.string.golfHerradura_address),
                getResources().getString(R.string.golfHerradura_phone),
                getResources().getString(R.string.golfHerradura_website),
                getResources().getString(R.string.golfHerradura_description),
                R.drawable.image_golf_herradura,
                5));

        recyclerView.setAdapter(new InteresDeportivoAdapter(this, interesDeportivos));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
