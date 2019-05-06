package com.example.administrator.tongze.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.tongze.List.MainList;
import com.example.administrator.tongze.List.UserMessageList;
import com.example.administrator.tongze.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private String TAG = "ESKUFHHSEKU";
          private List<UserMessageList.DataBean> mmainLists;
          private Context mContext;
          private AdJuustAdapter adapter;

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView come_time,work_years,manage_years,school,education_name,major,sendout,adjust,post_name,adjustPos,skills,mainName;
        RecyclerView adjust_add;
        public ViewHolder(View view) {
            super(view);
            mainName = view.findViewById(R.id.main_adapter_name);
            come_time = view.findViewById(R.id.come_time);
            work_years = view.findViewById(R.id.work_years);
            manage_years = view.findViewById(R.id.manage_years);
            school = view.findViewById(R.id.school);
            education_name = view.findViewById(R.id.education_name);
            major = view.findViewById(R.id.major);
            sendout = view.findViewById(R.id.sendout);
            adjust = view.findViewById(R.id.adjusts);
            post_name = view.findViewById(R.id.post_name);
            skills = view.findViewById(R.id.skills);
            adjust_add = view.findViewById(R.id.adjust_add);
        }
    }
    public  MainAdapter(List<UserMessageList.DataBean> mainLists,Context context){
        this.mmainLists = mainLists;
        this.mContext = context;
    }
    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_adapter,parent,false);
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
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        UserMessageList.DataBean list = mmainLists.get(position);
           holder.come_time.setText("离职："+list.getCome_time());
           String work = list.getWork_years();
        if(work.indexOf(".") > 0){
            work = work.replaceAll("0+?$", "");//去掉多余的0
            work = work.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        String manger = list.getManage_years();
        if(manger.indexOf(".") > 0){
            manger = work.replaceAll("0+?$", "");//去掉多余的0
            manger = work.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
           holder.work_years.setText(work+"年经验");
           holder.manage_years.setText(manger+"年管理经验");
           holder.school.setText(list.getSchool());
           holder.education_name.setText(list.getEducation_name()+"学历");
           holder.major.setText(list.getMajor());
           if(list.getAdjust().equals("1") || !list.getAdjust().isEmpty()){
               holder.adjust.setText("接受调剂");
           }else {
               holder.adjust.setText("不接受调剂");
           }
          if(list.getSendout().equals("1")  || !list.getSendout().isEmpty()){
              holder.sendout.setText("接受外派");
          }else {
              holder.sendout.setText("不接受外派");
          }
        holder.post_name.setText(list.getPost_name());
//           holder.adjustPos.setText(list.getAdjustPos());
           holder.skills.setText(list.getSkills());
           holder.mainName.setText(list.getName());
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        holder.adjust_add.setLayoutManager(layoutManager);
        List<String> adj = list.getAdjustPos();
        adapter  = new AdJuustAdapter(adj,mContext);
        holder.adjust_add.setAdapter(adapter);

    }

    @Override
    public int getItemCount() {
        return mmainLists.size();
    }


}
