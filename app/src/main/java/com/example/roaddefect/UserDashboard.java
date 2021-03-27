package com.example.roaddefect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class UserDashboard extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        chipNavigationBar=findViewById(R.id.bottom_nav_menu);
        chipNavigationBar.setItemSelected(R.id.bottom_nav_menu,true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new UserDashboardFragment()).commit();
        bottomMenu();

    }

    private void bottomMenu() {

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment=null;
                switch (i) {

                    case R.id.bottom_nav_home:
                        fragment=new UserDashboardFragment();
                        break;
                    case R.id.bottom_nav_add:
                        startActivity(new Intent(getApplicationContext(),DefectAddActivity.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.bottom_nav_maps:
                        fragment=new UserMapFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            }
        });
    }
}