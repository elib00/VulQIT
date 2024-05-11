package com.example.vulqit;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class ShopServices extends AppCompatActivity {
    TableLayout servicesTable;

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
        servicesTable = (TableLayout) findViewById(R.id.servicesTable);

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

            initializeServicesTable(receivedMap);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void initializeServicesTable(HashMap<String, String> services){
        LayoutInflater inflater = LayoutInflater.from(this);
        for (String key : services.keySet()) {
            String value = services.get(key);

            TableRow row = (TableRow) inflater.inflate(R.layout.service_row_template, null);
            TextView serviceName = row.findViewById(R.id.serviceName);
            TextView servicePrice = row.findViewById(R.id.servicePrice);

            serviceName.setText(key);
            if(value.equals("N/A")){
                servicePrice.setText(value);
            }else{
                servicePrice.setText(String.format("PHP %s", value));
            }

            servicesTable.addView(row);
        }

        servicesTable.requestLayout();
    }
}