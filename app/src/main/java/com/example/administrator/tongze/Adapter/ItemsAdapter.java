package com.example.administrator.tongze.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.tongze.R;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {
    private Context mContext;
    private List<String> list;





    public ItemsAdapter(List<String> stringList, Context context){
        this.list = stringList;
        this.mContext = context;
    }
    @NonNull
    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_array,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final ItemsAdapter.ViewHolder holder, int position) {
        final String lists = list.get(position);
        holder.itemName.setText(lists);
        holder.itemName.setBackgroundResource(R.drawable.ellipses);
        holder.itemName.setTextColor(Color.rgb(255,255,255));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        public ViewHolder(View view) {
            super(view);
            itemName = view.findViewById(R.id.item_name);
        }
    }
}
