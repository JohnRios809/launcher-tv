package com.custom.retro.launcher.ui.theme;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import com.custom.retro.launcher.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSettings = findViewById(R.id.btnSettings);
        if (btnSettings != null) {
            btnSettings.setOnClickListener(v -> {
                Intent intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                startActivity(intent);
            });
        }

        // Enlaces correctos a tus apps
        setupDockApp(R.id.dockSpotify, "com.spotify.tv.android");
        setupDockApp(R.id.dockYoutube, "com.google.android.youtube.tv");
        setupDockApp(R.id.dockXuper, "com.xuper.netxxus");
        setupDockApp(R.id.dockPlayStore, "com.android.vending");
    }

    private void setupDockApp(int viewId, String packageName) {
        FrameLayout tile = findViewById(viewId);
        if (tile != null) {
            tile.setOnClickListener(v -> {
                PackageManager pm = getPackageManager();
                Intent intent = pm.getLaunchIntentForPackage(packageName);
                if (intent != null) {
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        // Evitar salir del launcher con el botón atrás
    }
}