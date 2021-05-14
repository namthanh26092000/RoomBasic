package com.example.room1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends  RecyclerView.Adapter<Adapter.UserViewHolder> {
   private List<User> list;
   private Context context;

    public Adapter(Context context){
        this.context=context;
    }
    public void setData(List<User> list){
       this.list=list;
       notifyDataSetChanged();
   }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_activity,parent,false);

       return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = list.get(position);
        if(user==null){
            return;
        }
        holder.tvName.setText(user.getName());
    }

    @Override
    public int getItemCount() {
       if(list!=null){
           return list.size();
       }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
private TextView tvName;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }







}