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

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private Context mContext;
    private List<String> list;
    private OnItemClickLitener onItemClickLitener;
    private String ids;
    private boolean isShowOrNot = false;


    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.onItemClickLitener = mOnItemClickLitener;
    }


    public ItemAdapter(List<String> stringList,Context context,String ids){
        this.list = stringList;
        this.mContext = context;
        this.ids = ids;
    }
    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_array,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final ItemAdapter.ViewHolder holder, int position) {
        final String lists = list.get(position);
        holder.itemName.setText(lists);
        holder.itemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    holder.itemName.setBackgroundResource(R.drawable.ellipsered);
                    holder.itemName.setTextColor(Color.rgb(255, 106, 106));
                    onItemClickLitener.onItemSlectNameIdsClick(holder.itemView, holder.getAdapterPosition(), lists, ids);



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
