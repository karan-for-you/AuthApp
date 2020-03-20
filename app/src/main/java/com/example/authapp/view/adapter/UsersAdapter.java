package com.example.authapp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.authapp.R;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    private List<String> userData;
    private LayoutInflater layoutInflater;

    public UsersAdapter(Context mContext, List<String> userData){
        this.userData = userData;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public UsersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.user_view,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.MyViewHolder holder, int position) {
        holder.tvUser.setText(userData.get(position));
    }

    @Override
    public int getItemCount() {
        return userData.size();
    }

    public void addAllUsers(List<String> users){
        userData.addAll(users);
        notifyDataSetChanged();
    }

    public void addOneUser(){
        userData.add("Karan");
        notifyDataSetChanged();
    }

    private void removeUser(int position){
        userData.remove(position);
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvUser;
        ImageView ivDelete;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUser = itemView.findViewById(R.id.tvUsername);
            ivDelete = itemView.findViewById(R.id.ivDelete);
            ivDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeUser(getAdapterPosition());
                }
            });
        }
    }

}
