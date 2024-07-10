package com.uas.dpm;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    private static final int SPLASH_TIMEOUT = 3000;
    private View statusBarBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
        }

        setContentView(R.layout.activity_splash);

        statusBarBackground = findViewById(R.id.statusBarBackground);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            adjustStatusBarHeight();
        }

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(Splash.this, Login.class);
            startActivity(intent);
            finish();
        }, SPLASH_TIMEOUT);
    }

    private void adjustStatusBarHeight() {
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            int statusBarHeight = getResources().getDimensionPixelSize(resourceId);
            ViewGroup.LayoutParams params = statusBarBackground.getLayoutParams();
            params.height = statusBarHeight;
            statusBarBackground.setLayoutParams(params);
        }
    }
}