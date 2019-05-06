package com.example.administrator.tongze.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.tongze.List.HonorList;
import com.example.administrator.tongze.List.MainList;
import com.example.administrator.tongze.R;

import java.util.List;

public class HonorAdapter extends RecyclerView.Adapter<HonorAdapter.ViewHolder> {
          private List<HonorList.DataBean> mmainLists;
          private Context mContext;
    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView honorName;
        ImageView honorImageUri;
        public ViewHolder(View view) {
            super(view);
            honorImageUri = view.findViewById(R.id.honor_image);
            honorName = view.findViewById(R.id.honor_name);

        }
    }
    public HonorAdapter(List<HonorList.DataBean> mainLists, Context context){
        this.mmainLists = mainLists;
        this.mContext = context;
    }
    @NonNull
    @Override
    public HonorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.honor_adapter,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        if (mOnItemClickLitener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickLitener.onItemClick(holder.itemView, holder.getAdapterPosition());
                }
            });
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HonorAdapter.ViewHolder holder, int position) {
        HonorList.DataBean list = mmainLists.get(position);
        holder.honorName.setText(list.getDesp());
        Glide.with(mContext).load(list.getAcc_url()).into(holder.honorImageUri);



    }

    @Override
    public int getItemCount() {
        return mmainLists.size();
    }


}
