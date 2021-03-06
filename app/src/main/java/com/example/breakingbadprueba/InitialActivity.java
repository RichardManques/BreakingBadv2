package com.example.breakingbadprueba;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(checkConnection()) {
                    Intent intent = new Intent(
                            InitialActivity.this , LoginActivity.class
                    );

                    startActivity(intent);
                }

                finish();
            }
        }, 2000);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private boolean checkConnection() {
        boolean state = false;

        ConnectivityManager manager;
        manager = (ConnectivityManager) this.getSystemService(CONNECTIVITY_SERVICE);
        Network[] networks = manager.getAllNetworks();

        for(Network network : networks) {
            NetworkInfo info = manager.getNetworkInfo(network);

            if(info != null) {
                state = true;
            }
        }

        return state;
    }

}