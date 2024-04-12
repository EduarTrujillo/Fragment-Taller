package com.example.fragmentaplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    IndexFragment indexFragment = new IndexFragment();

    PerfilFragment perfilFragment = new PerfilFragment();

    FrameLayout frm_index;

    BottomNavigationView btm_menu;

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frm_index = findViewById(R.id.frm_index);
        btm_menu = findViewById(R.id.btm_menu);
        btm_menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.nav_index){
                    load_fragment(indexFragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.nav_perfil){
                    load_fragment(perfilFragment);
                    return true;
                }
                return false;
            }
        });
        
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.CR7_equipo, android.R.layout.simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    private void load_fragment(Fragment fr) {
        FragmentTransaction ftr = getSupportFragmentManager().beginTransaction();
        ftr.replace(R.id.frm_index, fr);
        ftr.commit();
    }
}