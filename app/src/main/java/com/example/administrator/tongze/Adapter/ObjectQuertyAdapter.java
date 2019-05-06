package com.example.administrator.tongze.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.tongze.List.HonorList;
import com.example.administrator.tongze.List.ObjectiveQuestionList;
import com.example.administrator.tongze.R;

import java.util.List;

public class ObjectQuertyAdapter extends RecyclerView.Adapter<ObjectQuertyAdapter.ViewHolder> {
    private String TAG = "ObjectQuertyAdapter";
    private  String status = "0";
    private List<ObjectiveQuestionList.DataBean.ItemsBean> mmainLists;
    private Context mContext;
    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView factor,reference,grade_a_desp,grade_b_desp,grade_c_desp,grade_d_desp;

        public ViewHolder(View view) {
            super(view);
            factor = view.findViewById(R.id.factor);
            reference = view.findViewById(R.id.reference);
            grade_a_desp  = view.findViewById(R.id.grade_a_desp);
            grade_b_desp = view.findViewById(R.id.grade_b_desp);
            grade_c_desp  =view.findViewById(R.id.grade_c_desp);
            grade_d_desp = view.findViewById(R.id.grade_d_desp);


        }
    }
    public ObjectQuertyAdapter(List<ObjectiveQuestionList.DataBean.ItemsBean> mainLists, Context context){
        this.mmainLists = mainLists;
        this.mContext = context;
    }
    @NonNull
    @Override
    public ObjectQuertyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.object_querty,parent,false);
        final ViewHolder holder = new ViewHolder(view);
//        if (mOnItemClickLitener != null) {
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mOnItemClickLitener.onItemClick(holder.itemView, holder.getAdapterPosition(),1);
//                }
//            });
//        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ObjectQuertyAdapter.ViewHolder holder, int position) {
        ObjectiveQuestionList.DataBean.ItemsBean list = mmainLists.get(position);
        holder.factor.setText(list.getFactor());
        holder.factor.setTextColor(Color.rgb(110,110,110));
        holder.reference.setText(list.getReference());
        holder.reference.setTextColor(Color.rgb(110,110,110));
        holder.grade_a_desp.setText(list.getGrade_a_desp());
        holder.grade_b_desp.setText(list.getGrade_b_desp());
        holder.grade_c_desp.setText(list.getGrade_c_desp());
        holder.grade_d_desp.setText(list.getGrade_d_desp());

       holder.grade_a_desp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               mOnItemClickLitener.onItemSlectClick(holder.itemView, holder.getAdapterPosition(),"a");
               holder.grade_a_desp.setBackgroundResource(R.color.select);
               holder.grade_a_desp.setTextColor(Color.rgb(255,255,255));
               holder.grade_b_desp.setBackgroundResource(R.color.notsee);
               holder.grade_b_desp.setTextColor(Color.rgb(110,110,110));
               holder.grade_c_desp.setBackgroundResource(R.color.notsee);
               holder.grade_c_desp.setTextColor(Color.rgb(110,110,110));
               holder.grade_d_desp.setBackgroundResource(R.color.notsee);
               holder.grade_d_desp.setTextColor(Color.rgb(110,110,110));

           }
       });
        holder.grade_b_desp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickLitener.onItemSlectClick(holder.itemView, holder.getAdapterPosition(),"b");
                holder.grade_b_desp.setBackgroundResource(R.color.selecteight);
                holder.grade_b_desp.setTextColor(Color.rgb(255,255,255));
                holder.grade_a_desp.setBackgroundResource(R.color.notsee);
                holder.grade_a_desp.setTextColor(Color.rgb(110,110,110));
                holder.grade_c_desp.setBackgroundResource(R.color.notsee);
                holder.grade_c_desp.setTextColor(Color.rgb(110,110,110));
                holder.grade_d_desp.setBackgroundResource(R.color.notsee);
                holder.grade_d_desp.setTextColor(Color.rgb(110,110,110));

            }
        });
        holder.grade_c_desp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.grade_c_desp.setBackgroundResource(R.color.selectsix);
                mOnItemClickLitener.onItemSlectClick(holder.itemView, holder.getAdapterPosition(),"c");
                holder.grade_c_desp.setTextColor(Color.rgb(255,255,255));
                holder.grade_a_desp.setBackgroundResource(R.color.notsee);
                holder.grade_a_desp.setTextColor(Color.rgb(110,110,110));
                holder.grade_b_desp.setBackgroundResource(R.color.notsee);
                holder.grade_b_desp.setTextColor(Color.rgb(110,110,110));
                holder.grade_d_desp.setBackgroundResource(R.color.notsee);
                holder.grade_d_desp.setTextColor(Color.rgb(110,110,110));
            }
        });
        holder.grade_d_desp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickLitener.onItemSlectClick(holder.itemView, holder.getAdapterPosition(),"d");
                holder.grade_d_desp.setBackgroundResource(R.color.selectfour);
                holder.grade_d_desp.setTextColor(Color.rgb(255,255,255));
                holder.grade_a_desp.setBackgroundResource(R.color.notsee);
                holder.grade_a_desp.setTextColor(Color.rgb(110,110,110));
                holder.grade_b_desp.setBackgroundResource(R.color.notsee);
                holder.grade_b_desp.setTextColor(Color.rgb(110,110,110));
                holder.grade_c_desp.setBackgroundResource(R.color.notsee);
                holder.grade_c_desp.setTextColor(Color.rgb(110,110,110));
            }
        });

    }

    @Override
    public int getItemCount() {

        return mmainLists.size();
    }


}
