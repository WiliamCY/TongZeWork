package com.example.administrator.tongze.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.tongze.Entiy.Result;
import com.example.administrator.tongze.List.OtherQuerty;
import com.example.administrator.tongze.R;
import com.example.administrator.tongze.Retrofit.RetrofitUtil;
import com.example.administrator.tongze.Utils.FlowLayoutManager;
import com.example.administrator.tongze.Utils.SignGenerate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class OtherQuertyAdapter extends RecyclerView.Adapter<OtherQuertyAdapter.ViewHolder> {
    private List<OtherQuerty.DataBean.ItemsBean> list;
    private String TAG = "OtherQuertyAdapter";
    private Context mContext;
    private ItemAdapter adapter;
    private ItemsAdapter adapters;
    private List<String> ss = new ArrayList<>();
    private List<String> Allid = new ArrayList<>();
    private  String finalId;
    private String ids,token;
    private  HashMap<String,List<String>> map = new HashMap<>();
    private String userOther;

    private OnItemClickLitener onItemClickLitener;


    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.onItemClickLitener = mOnItemClickLitener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView factor,reference;
        RecyclerView words,wordss;
        public ViewHolder(View view) {
            super(view);
            factor = view.findViewById(R.id.factor);
            reference = view.findViewById(R.id.reference);
            words = view.findViewById(R.id.words);
            wordss = view.findViewById(R.id.wordss);

        }
    }
    public OtherQuertyAdapter(List<OtherQuerty.DataBean.ItemsBean> dataBeans,Context context){
        this.list = dataBeans;
        this.mContext = context;
    }
    @NonNull
    @Override
    public OtherQuertyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.otherquestions,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final OtherQuertyAdapter.ViewHolder holder, int position) {
        OtherQuerty.DataBean.ItemsBean otherList = list.get(position);
        holder.factor.setText(otherList.getFactor());
        String words = otherList.getWords();
        String [] fenge=words.split(",");
        final String ids = list.get(position).getId();
        final List<String> lists = Arrays.asList(fenge);
        final FlowLayoutManager layoutManager = new FlowLayoutManager(mContext,true);
        holder.words.setLayoutManager(layoutManager);
        adapter = new ItemAdapter(lists,mContext,ids);
        holder.words.setAdapter(adapter);
        holder.reference.setText(otherList.getReference());
        adapter.setOnItemClickLitener(new OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }

            @Override
            public void onItemSlectClick(View view, int position, String selectId) {

            }

            @Override
            public void onItemSlectNameClick(View view, int position, String selectName) {

            }

            @Override
            public void onItemSlectNameIdsClick(View view, int position, final String selectName, final String id) {
                Log.i(TAG,"DSJDFLS"+id);
                if(Allid.size()==0 ) {
//                    if(selectName.equals("其他")) {
//                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
//                        builder.setTitle("请输入");
//                        //    通过LayoutInflater来加载一个xml的布局文件作为一个View对象
//                        View viewx = LayoutInflater.from(mContext).inflate(R.layout.dialog_userset, null);
//                        //    设置我们自己定义的布局文件作为弹出框的Content
//                        builder.setView(viewx);
//
//                        final EditText username = (EditText) viewx.findViewById(R.id.userOther);
//
//                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                 userOther = username.getText().toString().trim();
//                                ss.add(userOther);
//                                final FlowLayoutManager layoutManager = new FlowLayoutManager(mContext, true);
//                                holder.wordss.setLayoutManager(layoutManager);
//                                adapters = new ItemsAdapter(ss, mContext);
//                                holder.wordss.setAdapter(adapters);
//                                Allid.add(id);
//                                initData(id, selectName);
//                            }
//                        });
//                        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//                            }
//                        });
//                        builder.show();
//                    }else {
                        ss.add(selectName);
                        final FlowLayoutManager layoutManager = new FlowLayoutManager(mContext, true);
                        holder.wordss.setLayoutManager(layoutManager);
                        adapters = new ItemsAdapter(ss, mContext);
                        holder.wordss.setAdapter(adapters);
                        Allid.add(id);
                        initData(id, selectName);
//                    }
                }else {
                    finalId = Allid.get(Allid.size() - 1);
                    if (finalId.equals(id)) {
                        if(!ss.contains(selectName)) {
                            ss.add(selectName);
                            List<String> c = ss;
                            map.put(id,c);
                            final FlowLayoutManager layoutManager = new FlowLayoutManager(mContext, true);
                            holder.wordss.setLayoutManager(layoutManager);
                            adapters = new ItemsAdapter(ss, mContext);
                            holder.wordss.setAdapter(adapters);
                            Allid.add(id);
                            initData(id, selectName);
                        }else {
                            Toast.makeText(mContext,"已经存在",Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        ss = map.get(id);
                        if (ss == null) {
                            ss = new ArrayList<>();
                            map.put(id,ss);
                        }
                            ss.add(selectName);
                            final FlowLayoutManager layoutManager = new FlowLayoutManager(mContext, true);
                            holder.wordss.setLayoutManager(layoutManager);
                            adapters = new ItemsAdapter(ss, mContext);
                            holder.wordss.setAdapter(adapters);
                            Allid.add(id);
                            initData(id, selectName);

                    }
                }
                }
        });
    }
  private  void initData(String id,String selectName){
      SharedPreferences sharedPreferences = mContext.getSharedPreferences("data", Context.MODE_PRIVATE);
      ids = sharedPreferences.getString("id","");
      token = sharedPreferences.getString("token","");
        HashMap<String,String> body = new HashMap<>();
        body.put("interview_flow_id",ids);
        body.put("other_result",selectName);
        body.put("user_id",ids);
        body.put("token",token);
         body.put("sign", SignGenerate.generate(body));
        RetrofitUtil.getService().putOtherQuerty(body).enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Response<Result> response, Retrofit retrofit) {
                Result result = response.body();
                if(result.getRet() == 200){
                    Toast.makeText(mContext,"发送成功",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(mContext,"发送失败",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

  }
    @Override
    public int getItemCount() {
        return list.size();
    }


}
