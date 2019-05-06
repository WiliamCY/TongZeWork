package com.example.administrator.tongze.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.tongze.List.BasicInformationList;
import com.example.administrator.tongze.R;

import java.util.List;

public class AwardAdapter extends RecyclerView.Adapter<AwardAdapter.ViewHolder> {
    private Context mContext;
    private List<BasicInformationList.DataBean.AwardPunishmentBean> list;





    public AwardAdapter(List<BasicInformationList.DataBean.AwardPunishmentBean> stringList, Context context){
        this.list = stringList;
        this.mContext = context;
    }
    @NonNull
    @Override
    public AwardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.award_array,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final AwardAdapter.ViewHolder holder, int position) {
        BasicInformationList.DataBean.AwardPunishmentBean bean = list.get(position);
        holder.itemName.setText(bean.getDesp());



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
