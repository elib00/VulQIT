package com.example.vulqit;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{
    Context context;
    List<Shop> shops;

    public CustomAdapter(Context context, List<Shop> shops){
        this.context = context;
        this.shops = shops;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.shop_item, parent, false);
        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Shop shop = shops.get(position);
        holder.tvHeading.setText(shop.getShopName());
        holder.titleImage.setImageResource(shop.getShopImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShopDetails.class);
                intent.putExtra("image", shop.getShopImage());
                intent.putExtra("shop_name", shop.getShopName());

                context.startActivity(intent);
            }
        });
    }

    @Override   
    public int getItemCount() {
        return shops.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView titleImage;
        TextView tvHeading;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            titleImage = itemView.findViewById(R.id.shopImage);
            tvHeading = itemView.findViewById(R.id.shopName);
        }
    }
}
