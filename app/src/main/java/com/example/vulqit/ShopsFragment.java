package com.example.vulqit;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShopsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShopsFragment extends Fragment {

    // TODO: Rename parameter arguments,     choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    //for the app's functionalities
    private SearchView searchView;
    private RecyclerView shopsListContainer;
    private List<Shop> shops;
    private List<Shop> shopsListQuery;
    private CustomAdapter adapter;

    //values
    private String[] shopNames;
    private int[] imageResourceIDs;
    private String[] contactNumbers;
    private String[] operatingTimes;
    private String[] locations;
    private String[] plusCodes;
    private double[] latitudes;
    private double[] longitudes;

    ArrayList<HashMap<String, String>> services;


    public ShopsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShopsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShopsFragment newInstance(String param1, String param2) {
        ShopsFragment fragment = new ShopsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shops, container, false);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeFragment();

        shopsListContainer = (RecyclerView) view.findViewById(R.id.shopsListContainer);
        shopsListContainer.setLayoutManager(new LinearLayoutManager(getContext()));
        shopsListContainer.hasFixedSize();

        adapter = new CustomAdapter(getContext(), shopsListQuery);
        shopsListContainer.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //for the search bar
        searchView = (SearchView) view.findViewById(R.id.shopsSearchbar);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
//                shops = originalShopsList;
                filterList(s);
                return true;
            }
        });
    }

    private void initializeFragment(){
        shops = new ArrayList<>();
        shopsListQuery = new ArrayList<>();

        shopNames = new String[]{
                getString(R.string.balud),
                getString(R.string.guiwanon),
                getString(R.string.solongon),
                getString(R.string.cawayan),
                getString(R.string.casay),
                getString(R.string.junrod)
        };

        imageResourceIDs = new int[]{
                R.drawable.shop_balud,
                R.drawable.shop_guiwanon,
                R.drawable.shop_solongon,
                R.drawable.shop_cawayan,
                R.drawable.shop_casay,
                R.drawable.shop_junrod
        };

        contactNumbers = new String[]{
                "N/A",
                "N/A",
                "09270864397",
                "09172049905",
                "096870644999",
                "09291225946"
        };

        operatingTimes = new String[]{
                "5:00 AM - 9:00 PM",
                "7:00 AM - 9:00 PM",
                "Open 24 hours",
                "6:00 AM - 9:00 PM",
                "6:00 AM - 8:00 PM",
                "6:00 AM - 6:00 PM"
        };

        locations = new String[] {
                "Balud, Dalaguete, Cebu",
                "Guiwanon, Dalaguete, Cebu",
                "Solong-on, Dalaguete, Cebu",
                "Cawayan, Dalaguete, Cebu",
                "Casay, Dalaguete, Cebu",
                "Poblacion, Dalaguete, Cebu"
        };

        plusCodes = new String[] {
                "QG3H+MQ6",
                "QG4J+4XJ",
                "QG7J+QFG",
                "RG5P+VQ8",
                "RHG2+47M",
                "QG5M+67"
        };

        latitudes = new double[] {
                9.754160840527263,
                9.755334186062527,
                9.76443484698375,
                9.809660508048744,
                9.825334186693874,
                9.758147130092338
        };

        longitudes = new double[] {
                123.52939328652349,
                123.53239126699184,
                123.53120376700463,
                123.53695175534837,
                123.55067122590069,
                123.53313620176544
        };

        services = new ArrayList<HashMap<String, String>>(){
            {
                add(new HashMap<String, String>() {{
                    put("Vulcanize", "50.00");
                    put("Inflate", "5.00");
                }});
                add(new HashMap<String, String>() {{
                    put("Vulcanize", "60.00");
                    put("Inflate", "10.00");
                }});

                add(new HashMap<String, String>() {{
                    put("Vulcanize", "60.00");
                    put("Inflate", "N/A");
                }});
                add(new HashMap<String, String>() {{
                    put("Vulcanize", "50.00");
                    put("Inflate", "5.00");
                }});
                add(new HashMap<String, String>() {{
                    put("Vulcanize", "50.00");
                    put("Inflate", "5.00");
                }});
                add(new HashMap<String, String>(){{
                    put("Vulcanize", "40.00");
                    put("Nitrogen Air", "5.00");
                    put("Cold/Hot Patch", "80.00");
                    put("Car Wash", "100.00");
                }});
            }
        };

        for(int i = 0; i < shopNames.length; i++){
            Shop shop = new Shop(imageResourceIDs[i], shopNames[i], contactNumbers[i], operatingTimes[i], locations[i], plusCodes[i], latitudes[i], longitudes[i], services.get(i));
            shops.add(shop);
        }

        shopsListQuery.addAll(shops);
    }

    private void filterList(String text){
        List<Shop> filteredList = new ArrayList<>();
        for(Shop shop : shops){
            //if the text on the search bar matches the name of the shop
            if(shop.getShopName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(shop);
            }
        }

        if(filteredList.isEmpty()){
            Toast.makeText(getContext(), "Vulcanizing shop not found.", Toast.LENGTH_SHORT).show();
        }else{
            setFilteredList(filteredList);
        }
    }

    public void setFilteredList(List<Shop> newList){
        shopsListQuery.clear();
        shopsListQuery.addAll(newList);
        adapter.notifyDataSetChanged();
    }
}