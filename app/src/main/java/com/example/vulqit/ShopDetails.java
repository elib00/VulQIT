package com.example.vulqit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.HashMap;
import java.util.List;

public class ShopDetails extends AppCompatActivity {
    TextView shopName;
    ShapeableImageView shopImage;
    TextView contactNumber;
    TextView location;
    TextView operatingHours;
    TextView plusCode;
    Button backButton;
    Button jumpToLocationButton;

    //utils
    Button jumpToServicesButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shop_details);
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        initializeView();
    }

    private void initializeView(){
        shopName = (TextView) findViewById(R.id.detailsShopname);
        shopImage = (ShapeableImageView) findViewById(R.id.detailsShopImage);
        contactNumber = (TextView) findViewById(R.id.detailsShopContactNumber);
        operatingHours = (TextView) findViewById(R.id.detailsShopOperatingHours);
        location = (TextView) findViewById(R.id.detailsShopLocation);
        plusCode = (TextView) findViewById(R.id.detailsPlusCode);

        Bundle values = getIntent().getExtras();
        if(values != null){
            shopName.setText(values.getString("shop_name"));
            shopImage.setImageResource(values.getInt("image"));
            contactNumber.setText(values.getString("contact_number"));
            location.setText(values.getString("location"));
            operatingHours.setText(values.getString("operating_time"));
            plusCode.setText(values.getString("plus_code"));
        }

        backButton = (Button) findViewById(R.id.backButton);
        jumpToLocationButton = (Button) findViewById(R.id.jumpToLocationButton);
        jumpToServicesButton = (Button) findViewById(R.id.servicesButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            //exit the page
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        jumpToLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve latitude and longitude values
                assert values != null;
                double latitude = values.getDouble("latitude");
                double longitude = values.getDouble("longitude");

                // Create an intent to navigate back to MapFragment
                Intent intent = new Intent(ShopDetails.this, MainActivity.class);
                intent.putExtra("latitude", latitude);
                intent.putExtra("longitude", longitude);
                setResult(Activity.RESULT_OK, intent);
                Toast.makeText(ShopDetails.this, String.format("Locating %s", values.getString("shop_name")), Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        jumpToServicesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShopDetails.this, ShopServices.class);
                assert values != null;
                String mapString = values.getString("service");
                intent.putExtra("service", mapString);
                startActivity(intent);
            }
        });

        initializeColors();
    }

    private void initializeColors(){
        jumpToServicesButton = (Button) findViewById(R.id.servicesButton);
        jumpToServicesButton.setBackgroundColor(getResources().getColor(R.color.cadmium_green));
        jumpToServicesButton.setText(getResources().getString(R.string.services_button_text));
    }
}