package com.example.vulqit;

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

import java.util.ArrayList;

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
    private ArrayList<Shop> shopArrayList;
    private String[] shopNames;
    private int[] imageResourceIDs;

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
        View view = inflater.inflate(R.layout.fragment_shops, container, false);
        initializeFragment(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();

        shopsListContainer = (RecyclerView) view.findViewById(R.id.shopsListContainer);
        shopsListContainer.setLayoutManager(new LinearLayoutManager(getContext()));
        shopsListContainer.hasFixedSize();

        CustomAdapter adapter = new CustomAdapter(getContext(), shopArrayList);
        shopsListContainer.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void dataInitialize(){
        shopArrayList = new ArrayList<>();

        shopNames = new String[]{
                getString(R.string.balud),
                getString(R.string.guiwanon),
                getString(R.string.solongon),
                getString(R.string.cawayan),
                getString(R.string.casay)
        };

        imageResourceIDs = new int[]{
                R.drawable.shop_balud,
                R.drawable.shop_guiwanon,
                R.drawable.shop_solongon,
                R.drawable.shop_cawayan,
                R.drawable.shop_casay
        };

        for(int i = 0; i < shopNames.length; i++){
            Shop shop = new Shop(imageResourceIDs[i], shopNames[i]);
            shopArrayList.add(shop);
        }
    }

    private void initializeFragment(View view){
        searchView = (SearchView) view.findViewById(R.id.shopsSearchbar);
        searchView.clearFocus();
    }

}