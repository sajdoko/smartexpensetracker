package com.sajdoko.smartexpensetracker.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import com.sajdoko.smartexpensetracker.R;

public class SettingsActivity extends AppCompatActivity {
    // You can either use a PreferenceFragmentCompat or handle SharedPreferences manually
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // If using PreferenceFragmentCompat:
        // getSupportFragmentManager().beginTransaction()
        //       .replace(R.id.settings_container, new MySettingsFragment())
        //       .commit();
    }
}
