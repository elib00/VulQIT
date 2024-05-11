package com.example.vulqit;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private final HomeFragment homeFragment = new HomeFragment();
    private final ShopsFragment shopsFragment = new ShopsFragment();
    private MapFragment mapFragment = new MapFragment();
    public BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initializeView();
    }

//    @Override
//    public void onBackPressed() {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        if (fragmentManager.getBackStackEntryCount() >= 0) {
//            super.onBackPressed();
//        } else {
//            showExitConfirmationDialog();
//        }
//    }
//
//    private void showExitConfirmationDialog() {
//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
//        alertDialog.setTitle("Exit VulQIT");
//        alertDialog.setMessage("Have you located your shop?");
//        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                finishAffinity();
//            }
//        });
//        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.dismiss();
//            }
//        });
//        alertDialog.show();
//    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            System.out.println("okayy");
            double latitude = data.getDoubleExtra("latitude", 0.0);
            double longitude = data.getDoubleExtra("longitude", 0.0); // Get longitude value

            mapFragment = MapFragment.newInstance(latitude, longitude);
            bottomNavigationView.setSelectedItemId(R.id.map);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentsContainer, mapFragment).commit();
        }

        System.out.println("debugging");
    }


    private void initializeView(){
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavContainer);

        bottomNavigationView.setSelectedItemId(R.id.home);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentsContainer, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.home){
                    System.out.println("home ni");
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentsContainer, homeFragment).addToBackStack(null).commit();
                }else if(item.getItemId() == R.id.map){
                    System.out.println("maps ni");
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentsContainer, mapFragment).addToBackStack(null).commit();
                }else if(item.getItemId() == R.id.shops){
                    System.out.println("shops ni");
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentsContainer, shopsFragment).addToBackStack(null).commit();
                }


                return true;
            }
        });
    }
}