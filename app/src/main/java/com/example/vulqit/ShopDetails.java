package com.example.vulqit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.imageview.ShapeableImageView;

public class ShopDetails extends AppCompatActivity {
    TextView shopName;
    ShapeableImageView shopImage;
    TextView contactNumber;
    TextView location;
    TextView operatingHours;
    Button backButton;

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

        Bundle values = getIntent().getExtras();
        if(values != null){
            shopName.setText(values.getString("shop_name"));
            shopImage.setImageResource(values.getInt("image"));
            contactNumber.setText(values.getString("contact_number"));
            location.setText(values.getString("location"));
            operatingHours.setText(values.getString("operating_time"));
        }

        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            //exit the page
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}