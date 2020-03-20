package com.example.authapp.view;

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

public class UserDaoAdapter extends RecyclerView.Adapter<UserDaoAdapter.MyViewHolder> {

    private Context context;
    private List<String> userData;
    private LayoutInflater layoutInflater;

    UserDaoAdapter(Context mContext, List<String> userData){
        this.context = mContext;
        this.userData = userData;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public UserDaoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.user_dao_view,parent,false);
        return new UserDaoAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvUser.setText(userData.get(position));
    }

    @Override
    public int getItemCount() {
        return userData.size();
    }

    void addAllUsers(List<String> users){
        userData.addAll(users);
        notifyDataSetChanged();
    }

    void addOneUser(){
        userData.add("Karan");
        notifyDataSetChanged();
    }

    void removeUser(int position){
        userData.remove(position);
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvUser;
        TextView tvUserId;
        ImageView ivDelete;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUser = itemView.findViewById(R.id.tvUsername);
            tvUserId = itemView.findViewById(R.id.tvUserId);
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
