package com.example.fastmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.example.fastmenu.adapter.companyList.Company;
import com.example.fastmenu.adapter.companyList.MainAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hanks.htextview.base.HTextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Company> companies;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private HTextView animatedLogo;
    private ArrayList<String> arrMessages = new ArrayList<>();
    private int delay = 3500;
    private Handler handler;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animatedLogo = findViewById(R.id.fallTextviewLogo);
        arrMessages.add("Fastfood Menu");
        arrMessages.add("FM");
        arrMessages.add("Fastest Menu");
        arrMessages.add("FM");
        animatedLogo.animateText(arrMessages.get(position));
        position++;

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, delay);
                if(position>=arrMessages.size())
                    position = 0;
                animatedLogo.animateText(arrMessages.get(position));
                position++;
            }
        }, delay);


        recyclerView = findViewById(R.id.main_recyclerView);
        recyclerView.setHasFixedSize(true); // when size is fixed.
                                            // It should be modified when firebase is connected.

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        companies = new ArrayList<>();



        //database
        database = FirebaseDatabase.getInstance();

        databaseReference = database.getReference("Company");
        //databaseReference = database.getReference().child("Company");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                System.out.println("@@@got in");
                //firebase의 database를 받아오는 곳
                companies.clear(); // 기존 arraylist 존재하지 않게 초기화(방지차원)
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    System.out.println("@@@"+snapshot.getValue());
                    Company company = snapshot.getValue(Company.class); // 받아온 데이터 company에 담음
                    companies.add(company); // data 추가 후 recyclerview에 보낼 준비
                }

                adapter.notifyDataSetChanged(); // arraylist 저장 및 새로고침
                System.out.println("@@@@"+companies.size());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("MainActivity", String.valueOf(error.toException()));
            }
        });

        adapter = new MainAdapter(companies);
        recyclerView.setAdapter(adapter);
    }
}