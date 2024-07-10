package com.uas.dpm;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationBarView;
import com.uas.dpm.databinding.ActivityMainBinding;
import com.uas.dpm.fragment.DetailFragment;
import com.uas.dpm.fragment.FavoriteFragment;
import com.uas.dpm.fragment.HomeFragment;
import com.uas.dpm.fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    private Button navHome, fav, detail, profile;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // Initialize the binding object
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        navHome = binding.navHome;
        fav = binding.fav;
        detail = binding.detail;
        profile = binding.navProfile;

        loadFragment(new HomeFragment());

        navHome.setOnClickListener(v -> loadFragment(new HomeFragment()));
//        fav.setOnClickListener(v -> loadFragment(new FavoriteFragment()));
//        detail.setOnClickListener(v -> loadFragment(new DetailFragment()));
        profile.setOnClickListener(v -> loadFragment(new ProfileFragment()));
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
