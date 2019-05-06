package com.example.administrator.tongze.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.tongze.List.PaseExperienceList;
import com.example.administrator.tongze.R;
import com.example.administrator.tongze.Utils.DateUtil;
import com.example.administrator.tongze.Utils.TimeUtils;

import java.util.List;

public class impoWorkHis extends RecyclerView.Adapter<impoWorkHis.ViewHolder> {
    private String TAG = "ExperienceAdapter";
    private int CAN_SEE = 0;
    private int status;
    private Context mContext;
    private List<PaseExperienceList.DataBean.ImpoWorkHisBean> list;


   public impoWorkHis(List<PaseExperienceList.DataBean.ImpoWorkHisBean> lists, Context context){
       this.list = lists;
       this.mContext = context;
   }

    public impoWorkHis.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.experience_impoprojecthis,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull impoWorkHis.ViewHolder holder, int position) {
        PaseExperienceList.DataBean.ImpoWorkHisBean bean = list.get(position);
        holder.company.setText(bean.getCompany());
        holder.name.setText(bean.getName());
        holder.certifier.setText(bean.getCertifier());
        holder.cer_phone.setText(bean.getCer_phone());
        holder.desp.setText(bean.getDesp());
        holder.result.setText(bean.getResult());
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
        TextView name,company,certifier,cer_phone,desp,result,eTime;
        public ViewHolder(View view) {
            super(view);
            company = view.findViewById(R.id.company);
            name = view.findViewById(R.id.name);
            certifier = view.findViewById(R.id.certifier);
            cer_phone = view.findViewById(R.id.cer_phone);
            desp = view.findViewById(R.id.desp);
            result = view.findViewById(R.id.result);
            eTime = view.findViewById(R.id.eTime);


        }
    }
}
