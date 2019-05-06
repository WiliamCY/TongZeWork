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

public class AdJuustAdapter extends RecyclerView.Adapter<AdJuustAdapter.ViewHolder> {
    private Context mContext;
    private List<String> list;
    private OnItemClickLitener onItemClickLitener;
    private String ids;




    public AdJuustAdapter(List<String> stringList, Context context){
        this.list = stringList;
        this.mContext = context;
    }
    @NonNull
    @Override
    public AdJuustAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adjust_list,parent,false);
        final AdJuustAdapter.ViewHolder holder = new AdJuustAdapter.ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final AdJuustAdapter.ViewHolder holder, int position) {
           String adjust = list.get(position);
           holder.adjustPos_text.setText(adjust);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
             TextView adjustPos_text;
        public ViewHolder(View view) {
            super(view);
            adjustPos_text = view.findViewById(R.id.adjustPos_text);

        }
    }
}
