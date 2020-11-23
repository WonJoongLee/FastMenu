package com.example.fastmenu.adapter.menuRecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fastmenu.R;

import java.util.ArrayList;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.ViewHolder> {

    public ArrayList<Food> items;

    public FoodItemAdapter(ArrayList<Food> items){//Context 빼버림
        this.items = items;
    }

    @NonNull
    @Override
    public FoodItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menurecyclerview, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodItemAdapter.ViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(items.get(position).getFoodPic())
                .into(holder.foodPic);
        holder.foodName.setText(items.get(position).getFoodName());
        holder.foodPrice.setText(items.get(position).getFoodPrice());
        if(items.get(position).getSalePeriod().equals("0")){ // When the price of the food is fixed, the "salePeriod" variable is "0" on firebase.
                                                             // So when it's "0", set the visibility of the variable as "GONE".
            holder.salePeriod.setVisibility(View.GONE);
        }else{
            holder.salePeriod.setText(items.get(position).getSalePeriod());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView foodPic;
        TextView foodName;
        TextView foodPrice;
        TextView salePeriod;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            foodPic = itemView.findViewById(R.id.menuImageView);
            foodName = itemView.findViewById(R.id.foodName);
            foodPrice = itemView.findViewById(R.id.foodPrice);
            salePeriod = itemView.findViewById(R.id.salePeriod);
        }
    }
}
