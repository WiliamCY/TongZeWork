package com.example.administrator.tongze.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.tongze.Activity.ImageViewActivity;
import com.example.administrator.tongze.Activity.WebViewActivity;
import com.example.administrator.tongze.Adapter.HonorAdapter;
import com.example.administrator.tongze.Adapter.OnItemClickLitener;
import com.example.administrator.tongze.Entiy.Result;
import com.example.administrator.tongze.List.HonorList;
import com.example.administrator.tongze.R;
import com.example.administrator.tongze.Retrofit.RetrofitUtil;
import com.example.administrator.tongze.Utils.SignGenerate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class FragmentResumeAattachments extends Fragment {
    private String TAG ="FragmentResumeAattachments";
    private List<HonorList.DataBean> list = new ArrayList<>();
    /***
     * 简历附件
     * */
    @BindView(R.id.honor_Recyclerview)
    RecyclerView honorRecyclerview;
    Unbinder unbinder;
    private List<HonorList> lists = new ArrayList<>();
    private HonorAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resumeaattachments, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();

        return view;
    }
 private void initData(){
     HashMap<String,String> body = new HashMap<>();
     SharedPreferences preferences = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
     String id = preferences.getString("id","");
     String token = preferences.getString("token","");
     body.put("uid",id);
     body.put("user_id",id);
     body.put("token",token);
     body.put("sign", SignGenerate.generate(body));
     RetrofitUtil.getService().getHonor(body).enqueue(new Callback<Result<List<HonorList.DataBean>>>() {
         @Override
         public void onResponse(Response<Result<List<HonorList.DataBean>>> response, Retrofit retrofit) {
               Result result = response.body();
               if(result.getRet() == 200){
                   list = (List<HonorList.DataBean>) result.getData();
                     innitView(list);
               }
         }

         @Override
         public void onFailure(Throwable t) {

         }
     });
 }
 private void innitView(final List<HonorList.DataBean> list){
     LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
     layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
     honorRecyclerview.setLayoutManager(layoutManager);
     adapter = new HonorAdapter(list,getActivity());
     honorRecyclerview.setAdapter(adapter);
     adapter.setOnItemClickLitener(new OnItemClickLitener() {
         @Override
         public void onItemClick(View view, int position) {
             String name = list.get(position).getDesp();
             String image = name.substring(name.lastIndexOf(".") + 1);
             if (image.equals("png") || image.equals("jpg") || image.equals("bmp") || image.equals("gif")) {
                 Intent intent = new Intent(getActivity(), ImageViewActivity.class);
                 String uri = list.get(position).getAcc_url();
                 intent.putExtra("uri", uri);
                 intent.putExtra("name", name);
                 startActivity(intent);

             } else {
                 Intent intent = new Intent(getActivity(), WebViewActivity.class);
                 String uri = list.get(position).getAcc_url();
                 intent.putExtra("uri", uri);
                 intent.putExtra("name", name);
                 startActivity(intent);
             }
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
         public void onItemSlectNameIdsClick(View view, int position, String selectName, String ids) {

         }
     });
 }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
