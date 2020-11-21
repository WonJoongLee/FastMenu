package com.example.fastmenu.adapter.companyList;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fastmenu.Menu;
import com.example.fastmenu.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    public ArrayList<Company> companies = null;

    public MainAdapter(ArrayList<Company> companies){
        this.companies = companies;
    }

    @NonNull
    @Override // Create new views(invoked by the layout manager)
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mainrecylerview, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        holder.text.setText(companies.get(position).getText());
        Glide.with(holder.itemView)
                .load(companies.get(position).getImage())//리스트에서 사진을 가져오는 부분
                .into(holder.image);//사진을 삽입해줌
    }

    @Override
    public int getItemCount() {
        return companies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.ivLogo);
            text = itemView.findViewById(R.id.tvCompany);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    int pos = getAdapterPosition();
                    if(pos!=RecyclerView.NO_POSITION){//notifyDataSetChanged() 중 아이템뷰를 갱신하는 과정에서,
                        //뷰홀더가 참조하는 아이템이 어댑터에서 삭제되면 getAdapterPosition()
                        //메서드는 NO_POSITION을 리턴하기 때문에 이 검사를 해줘야 한다.
                        Company item = companies.get(pos);//companies ArrayList에서 click된 pos의 item을 가져와서 item 변수에 넣는다.

                        if(item.getText().equals("KFC")){
                            Intent intentKFC = new Intent(view.getContext(), Menu.class);
                            context.startActivity(intentKFC);
                        }

                    }
                }
            });
        }
    }
}
