package com.example.administrator.tongze.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.tongze.List.BasicInformationList;
import com.example.administrator.tongze.R;
import com.example.administrator.tongze.Utils.TimeUtils;

import java.util.List;

public class FamilyAdapter extends RecyclerView.Adapter<FamilyAdapter.ViewHolder> {
    private Context mContext;
    private List<BasicInformationList.DataBean.FamilyMemberBean> list;
    private OnItemClickLitener onItemClickLitener;

  public FamilyAdapter(List<BasicInformationList.DataBean.FamilyMemberBean> mlist, Context context){
      this.list = mlist;
      this.mContext = context;
  }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.family_adapter, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        BasicInformationList.DataBean.FamilyMemberBean bean = list.get(position);
        String type = list.get(position).getRelation();
        switch (type){
            case "1":
                holder.relation.setText("父亲");
                break;
            case "2":
                holder.relation.setText("母亲");
                break;
            case "3":
                holder.relation.setText("兄弟");
                break;
            case "4":
                holder.relation.setText("姐妹");
                break;
            case "5":
                holder.relation.setText("夫");
                break;
            case "6":
                holder.relation.setText("妻");
                break;
            case "7":
                holder.relation.setText("子");
                break;
            case "8":
                holder.relation.setText("女");
                break;
        }

        holder.name.setText(bean.getName());
        holder.work.setText(bean.getWork());
        holder.work_place.setText(bean.getWork_place());
        holder.phone.setText(bean.getPhone());





    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView relation,name,work,work_place,phone;

        public ViewHolder(View view) {
            super(view);
            relation = view.findViewById(R.id.relation);
            name = view.findViewById(R.id.name);
            work = view.findViewById(R.id.work);
            work_place = view.findViewById(R.id.work_place);
            phone = view.findViewById(R.id.phone);
        }
    }
}