package com.example.fastmenu.adapter.viewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastmenu.R;
import com.example.fastmenu.adapter.menuRecyclerview.Food;
import com.example.fastmenu.adapter.menuRecyclerview.FoodItemAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FrameChicken extends Fragment {


    private View view;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Food> items;

    //Firebase
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private String companyName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_chicken, container, false);

        Context context = view.getContext();
        recyclerView = (RecyclerView) view.findViewById(R.id.menuChickenRecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        items = new ArrayList<>();

        database=FirebaseDatabase.getInstance();
        //아래 코드로 하면 food1은 가져와진다.
        //databaseReference=database.getReference().child("Food").child("KFC").child("Hamburger").child("food1");
        databaseReference=database.getReference().child("Food").child(companyName).child("Chicken");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                System.out.println("@@@@제대로 들와짐");
                items.clear();
                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                    Food food = snapshot1.getValue(Food.class);
                    System.out.println("@@@@" + food);
                    items.add(food);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("@@@@ERROR", String.valueOf(error.toException()));
            }
        });

        adapter = new FoodItemAdapter(items);
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void setCompanyName(String name){
        companyName = name;
    }
}
