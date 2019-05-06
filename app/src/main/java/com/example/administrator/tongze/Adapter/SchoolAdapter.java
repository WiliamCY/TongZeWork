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
import com.example.administrator.tongze.Utils.TimeUtils;

import java.util.List;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.ViewHolder> {
    private Context mContext;
    private List<BasicInformationList.DataBean.EducationHisBean> list;
    private OnItemClickLitener onItemClickLitener;

  public  SchoolAdapter(List<BasicInformationList.DataBean.EducationHisBean> mlist,Context context){
      this.list = mlist;
      this.mContext = context;
  }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.school_adapter, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        BasicInformationList.DataBean.EducationHisBean bean = list.get(position);
        holder.schools.setText(bean.getSchool());
        holder.married.setText(bean.getMajor());
        holder.education_name.setText(bean.getEducation());
        String full = bean.getFull_time();
        if(full == "1"){
            holder.full_time.setText("全日制");
        }else {
            holder.full_time.setText("非全日制");
        }
        String startTime = bean.getStart_timestamp();
        String endTime = bean.getFinish_timestamp();
        String start = TimeUtils.YearMon(startTime);
        String end = TimeUtils.YearMon(endTime);
        holder.times.setText(start+"-"+end);





    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView schools,times,married,education_name,full_time;

        public ViewHolder(View view) {
            super(view);
            schools = view.findViewById(R.id.schools);
            times = view.findViewById(R.id.times);
            married = view.findViewById(R.id.married);
            education_name = view.findViewById(R.id.education_name);
            full_time = view.findViewById(R.id.full_time);
        }
    }
}