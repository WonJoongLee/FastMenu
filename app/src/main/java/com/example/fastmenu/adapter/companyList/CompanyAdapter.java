//TEMPORARY 쓰이지 않는 클래스
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

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.ViewHolder> {
    private ArrayList<Company> companies = null;
    public Context con;

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView1;
        ImageView imageView;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.tvCompany);
            imageView = itemView.findViewById(R.id.ivLogo);
            System.out.println(textView1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if(pos!=RecyclerView.NO_POSITION){//notifyDataSetChanged() 중 아이템뷰를 갱신하는 과정에서,
                                                      //뷰홀더가 참조하는 아이템이 어댑터에서 삭제되면 getAdapterPosition()
                                                      //메서드는 NO_POSITION을 리턴하기 때문에 이 검사를 해줘야 한다.
                        Company item = companies.get(pos);//companies ArrayList에서 click된 pos의 item을 가져와서 item 변수에 넣는다.

                        if(item.getText().equals("Menu")){
                            Intent intentKFC = new Intent(con, Menu.class);
                            con.startActivity(intentKFC);
                        }

                    }
                }
            });
        }
    }

    public CompanyAdapter(ArrayList<Company> list){
        companies = list;
    }

    @NonNull
    @Override
    public CompanyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_mainrecylerview, parent, false);
        CompanyAdapter.ViewHolder vh = new CompanyAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyAdapter.ViewHolder holder, int position) {
        final Company company = companies.get(position);
        Glide.with(holder.itemView)
                .load(companies.get(position).getImage())//리스트에서 사진을 가져오는 부분
                .into(holder.imageView);//사진을 삽입해줌
        holder.textView1.setText(company.getText());//position에 있는 것(company)에서 가져와서 text로 설정해줌

        System.out.println("@@@"+company.getText());

    }

    @Override
    public int getItemCount() {
        return companies.size();
    }

}
