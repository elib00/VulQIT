package com.example.vulqit;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class ShopServices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shop_services);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        initializeView();
    }

    private void initializeView(){
        Bundle values = getIntent().getExtras();
        HashMap<String, String> receivedMap = new HashMap<>();

        try {
            assert values != null;
            JSONObject jsonObject = new JSONObject(Objects.requireNonNull(values.getString("service")));
            Iterator<String> keys = jsonObject.keys();

            while (keys.hasNext()) {
                String key = keys.next();
                String value = jsonObject.getString(key);
                System.out.println("Service: " + key + " | Price: " + value);
                receivedMap.put(key, value);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}