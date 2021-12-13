package com.example.aes.presetup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aes.R;
import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {
    private FirebaseAuth auth;
    private final int REQUEST_CHECK_CODE = 8989;
    private static final int REQUEST_LOCATION = 1;
    TextView textView;
    Runnable endAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

       /* textView = findViewById(R.id.textView);
        textView.animate().alpha(1f).setDuration(500).setStartDelay(0).withEndAction(
                endAction = new Runnable() {
                    public void run() {
                        textView.animate().alpha(0f).setDuration(500).setStartDelay(500);
                    }
                }
        );*/
        startTrack();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        }, 5000);

    }

    private void startTrack() {
        if (ActivityCompat.checkSelfPermission(SplashScreen.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(SplashScreen.this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        }
        else {
            //Location locationGps = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            /*if(locationGps !=null)
            {
                double lat = locationGps.getLatitude();
                double lng = locationGps.getLongitude();
                x= String.valueOf(lat);
                y= String.valueOf(lng);
            }
            else {
                Toast.makeText(MainActivity2.this, "Unable to get Location", Toast.LENGTH_SHORT).show();
            }*/
        }

    }
}