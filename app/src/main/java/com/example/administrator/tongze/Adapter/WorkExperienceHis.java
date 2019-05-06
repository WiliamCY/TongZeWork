package com.example.administrator.tongze.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.tongze.List.ExperienceList;
import com.example.administrator.tongze.List.PaseExperienceList;
import com.example.administrator.tongze.R;
import com.example.administrator.tongze.Utils.DataUtils;
import com.example.administrator.tongze.Utils.DateUtil;
import com.example.administrator.tongze.Utils.TimeUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WorkExperienceHis extends RecyclerView.Adapter<WorkExperienceHis.ViewHolder> {
    private String TAG = "ExperienceAdapter";
    private int CAN_SEE = 0;
    private int status;
    private Context mContext;
    private List<PaseExperienceList.DataBean.WorkExperienceHisBean> list;


   public  WorkExperienceHis (List<PaseExperienceList.DataBean.WorkExperienceHisBean> lists, Context context){
       this.list = lists;
       this.mContext = context;
   }

    public WorkExperienceHis.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.experience_workexperiencehis,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PaseExperienceList.DataBean.WorkExperienceHisBean bean = list.get(position);
        holder.company.setText(bean.getCompany());
        holder.duty.setText(bean.getDuty());
        holder.company_phone.setText(bean.getCompany_phone());
        holder.salary.setText(bean.getSalary());
        holder.dimission_reason.setText(bean.getDimission_reason());
        String startTime = bean.getStart_timestamp();
        String endTime = bean.getFinish_timestamp();
       String start = TimeUtils.YearMon(startTime);
        String end = TimeUtils.YearMon(endTime);
        holder.eTime.setText(start+"-"+end);

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView company,duty,company_phone,salary,dimission_reason,eTime;
        public ViewHolder(View view) {
            super(view);
            company = view.findViewById(R.id.company);
            duty = view.findViewById(R.id.duty);
            company_phone = view.findViewById(R.id.company_phone);
            salary = view.findViewById(R.id.salary);
            dimission_reason = view.findViewById(R.id.dimission_reason);
            eTime = view.findViewById(R.id.eTime);


        }
    }


}
