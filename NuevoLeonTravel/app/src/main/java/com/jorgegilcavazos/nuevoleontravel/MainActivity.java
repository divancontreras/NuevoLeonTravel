package com.jorgegilcavazos.nuevoleontravel;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.Places;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, GoogleApiClient.OnConnectionFailedListener {
    private static final String TAG = "MainActivity";
    private static final int MY_LOCATION_PERMISSION = 0;
    private GoogleApiClient mGoogleApiClient;
    private int selectedFragment;
    private NavigationView mNavigationView;
    private NestedScrollView mNestedScrollView;

    private List<Place> mPlaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        setFragment(0);

        mPlaces = new ArrayList<>();

        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.PLACE_DETECTION_API)
                .addApi(Places.GEO_DATA_API)
                .enableAutoManage(this, this)
                .build();
        new FetchCurrentPlacesTask().execute();


        //Picasso.with(this).load(imageUrl).fit().centerCrop().into(toolbarImageView);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_inicio) {
            setFragment(0);
        } else if (id == R.id.nav_quehacer) {
            setFragment(1);
        } else if (id == R.id.nav_transporte) {
            setFragment(2);
        } else if (id == R.id.nav_hoteles) {

        } else if (id == R.id.nav_eventos) {
            setFragment(4);
        } else if (id == R.id.nav_cuenta) {

        }else if (id == R.id.nav_ajustes) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setFragment(int fragmentId) {
        selectedFragment = fragmentId;
        android.support.v4.app.FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (fragmentId) {
            case 0:
                setTitle("Nuevo León");
                InicioFragment inicioFragment = new InicioFragment();
                fragmentTransaction.replace(R.id.fragment, inicioFragment);
                fragmentTransaction.commit();
                break;
            case 1:
                setTitle("Explora");
                QueHacerFragment fragment = new QueHacerFragment();
                fragmentTransaction.replace(R.id.fragment, fragment);
                fragmentTransaction.commit();
                break;
            case 2:
                setTitle("Paseos Extraordinarios");
                PaseosFragment paseosFragment = new PaseosFragment();
                fragmentTransaction.replace(R.id.fragment, paseosFragment);
                fragmentTransaction.commit();
                break;
            case 4:
                setTitle("Eventos");
                EventosFragment eventosFragment = new EventosFragment();
                fragmentTransaction.replace(R.id.fragment, eventosFragment);
                fragmentTransaction.commit();
                break;
        }
        mNavigationView.getMenu().getItem(fragmentId).setChecked(true);
        scrollToTop();
    }

    private void getPermission() {
        new RequestLocationPermissionTask(this).execute();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private class FetchCurrentPlacesTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            if (ContextCompat.checkSelfPermission(MainActivity.this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                getPermission();
            } else {
                mGoogleApiClient.connect();
                PendingResult<PlaceLikelihoodBuffer> result = Places.PlaceDetectionApi
                        .getCurrentPlace(mGoogleApiClient, null);
                result.setResultCallback(new ResultCallback<PlaceLikelihoodBuffer>() {
                    @Override
                    public void onResult(PlaceLikelihoodBuffer likelyPlaces) {
                        for (PlaceLikelihood placeLikelihood : likelyPlaces) {
                            Place place = placeLikelihood.getPlace();
                            mPlaces.add(place.freeze());
                            Log.i(TAG, String.format("Plaaaaaace '%s' has likelihood: %g",

                                    placeLikelihood.getPlace().getName(),
                                    placeLikelihood.getLikelihood()));
                        }

                        likelyPlaces.release();
                    }
                });
            }

            return null;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_LOCATION_PERMISSION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    new FetchCurrentPlacesTask().execute();
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    private class RequestLocationPermissionTask extends AsyncTask<Void, Void, Void> {
        private Activity mActivity;

        public RequestLocationPermissionTask(Activity activity) {
            mActivity = activity;
        }

        @Override
        protected Void doInBackground(Void... params) {
            ActivityCompat.requestPermissions(mActivity,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_LOCATION_PERMISSION);
            return null;
        }
    }

    @Override
    public void onBackPressed() {
        switch (selectedFragment) {
            case 0:
                // Exit application.
                super.onBackPressed();
                break;
            default:
                // Return to main fragment.
                setFragment(0);
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    public void scrollToTop() {
        mNestedScrollView.fullScroll(View.FOCUS_UP);
    }
}
