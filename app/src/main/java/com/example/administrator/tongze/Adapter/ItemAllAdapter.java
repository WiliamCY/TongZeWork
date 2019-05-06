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

public class ItemAllAdapter extends RecyclerView.Adapter<ItemAllAdapter.ViewHolder> {
    private Context mContext;
    private List<String> list;
    private OnItemClickLitener onItemClickLitener;
    private String ids;


    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.onItemClickLitener = mOnItemClickLitener;
    }


    public ItemAllAdapter(List<String> stringList, Context context, String ids){
        this.list = stringList;
        this.mContext = context;
        this.ids = ids;
    }
    @NonNull
    @Override
    public ItemAllAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_array,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final ItemAllAdapter.ViewHolder holder, int position) {
        final String lists = list.get(position);
        holder.itemName.setText(lists);
        holder.itemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.itemName.setBackgroundResource(R.drawable.ellipsered);
                holder.itemName.setTextColor(Color.rgb(255,106,106));
                onItemClickLitener.onItemSlectNameClick(holder.itemView, holder.getAdapterPosition(),lists);
            }
        });

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
