package com.example.administrator.tongze.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.tongze.List.BasicInformationList;
import com.example.administrator.tongze.List.CEO;
import com.example.administrator.tongze.R;

import java.util.List;

public class CeoAdapter extends RecyclerView.Adapter<CeoAdapter.ViewHolder> {
    private Context mContext;
    private List<CEO.DataBean> list;
    private OnItemClickLitener onItemClickLitener;
    private List<String>  ids;

  public CeoAdapter(List<CEO.DataBean> mlist, Context context){
      this.list = mlist;
      this.mContext = context;
  }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ceo_adapter, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
      CEO.DataBean bean = list.get(position);
      holder.name.setText(bean.getName());
      String dutys = (String) list.get(position).getDuty();
      if(dutys == null){

      }else {
          holder.duty.setText(dutys);
      }
      String positionsc = (String) list.get(position).getPosition();
    if(positionsc == null){

    }else {
     holder.positionss.setText(positionsc);
    }





    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,duty,positionss;

        public ViewHolder(View view) {
            super(view);
            duty = view.findViewById(R.id.duty);
            name = view.findViewById(R.id.name);
            positionss = view.findViewById(R.id.position);

        }
    }
}