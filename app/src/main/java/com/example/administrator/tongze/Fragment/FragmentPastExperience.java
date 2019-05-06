package com.example.administrator.tongze.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.tongze.Adapter.ImpoProjectHis;
import com.example.administrator.tongze.Adapter.ObjectQuertyAdapter;
import com.example.administrator.tongze.Adapter.WorkExperienceHis;
import com.example.administrator.tongze.Adapter.impoWorkHis;
import com.example.administrator.tongze.Entiy.Result;
import com.example.administrator.tongze.List.ExperienceList;
import com.example.administrator.tongze.List.PaseExperienceList;
import com.example.administrator.tongze.List.UserMessageList;
import com.example.administrator.tongze.R;
import com.example.administrator.tongze.Retrofit.RetrofitUtil;
import com.example.administrator.tongze.Utils.SignGenerate;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class FragmentPastExperience extends Fragment {
    /***
     * 过往经历
     * */
    @BindView(R.id.ex1)
    RecyclerView ex1;
    @BindView(R.id.ex2)
    RecyclerView ex2;
    @BindView(R.id.ex3)
    RecyclerView ex3;
    Unbinder unbinder;
    private List<PaseExperienceList.DataBean.WorkExperienceHisBean> worklist = new ArrayList<>();
    private List<PaseExperienceList.DataBean.ImpoProjectHisBean> impoProjectHisBeanList = new ArrayList<>();
    private List<PaseExperienceList.DataBean.ImpoWorkHisBean> impoWorkHisBeans = new ArrayList<>();
    private     LinearLayoutManager layoutManager;
    private WorkExperienceHis workExperienceHisAdatper;
    private ImpoProjectHis impoProjectHisadapter;
    private impoWorkHis  impoWorkHisAdapter;
    private PaseExperienceList.DataBean All;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pastexperience, container, false);
        unbinder = ButterKnife.bind(this, view);
        layoutManager = new LinearLayoutManager(getActivity());
        initData();
        return view;
    }

    private void initData(){
//        HashMap<String,String> body = new HashMap<>();
//        SharedPreferences preferences = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
//        String id = preferences.getString("id","");
//        String token = preferences.getString("token","");
//        body.put("uid",id);
//        body.put("user_id",id);
//        body.put("token",token);
//        body.put("sign", SignGenerate.generate(body));
//        RetrofitUtil.getService().getPaseExper(body).enqueue(new Callback<Result<PaseExperienceList.DataBean>>() {
//            @Override
//            public void onResponse(Response<Result<PaseExperienceList.DataBean>> response, Retrofit retrofit) {
//                   Result result = response.body();
//                   if(result.getRet() == 200){
                       String c = "{\"workExperienceHis\":[{\"id\":\"4\",\"user_id\":\"28\",\"company\":\"林枫科技\",\"duty\":\"web前端\",\"company_phone\":\"18268697597\",\"salary\":\"6000\",\"start_timestamp\":\"1454256000\",\"finish_timestamp\":\"1535731200\",\"dimission_reason\":\"离职原因离职原因\",\"delete_flag\":\"0\"}],\"impoProjectHis\":[{\"id\":\"14\",\"user_id\":\"28\",\"name\":\"母婴App\",\"company\":\"林枫科技\",\"certifier\":\"王五\",\"cer_phone\":\"13429313170\",\"desp\":\"项目描述项目描述项目描述\",\"result\":\"项目心得项目心得项目心得项目心得项目心得项目心得项目心得\",\"start_timestamp\":\"1533052800\",\"finish_timestamp\":\"1543593600\",\"delete_flag\":\"0\"},{\"id\":\"13\",\"user_id\":\"28\",\"name\":\"商城App\",\"company\":\"林枫科技\",\"certifier\":\"李四\",\"cer_phone\":\"17606568212\",\"desp\":\"项目描述项目描述项目描述\",\"result\":\"项目心得项目心得项目心得项目心得项目心得项目心得项目心得\",\"start_timestamp\":\"1469980800\",\"finish_timestamp\":\"1535731200\",\"delete_flag\":\"0\"}],\"impoWorkHis\":[{\"id\":\"5\",\"user_id\":\"28\",\"name\":\"web前端\",\"company\":\"林枫科技\",\"certifier\":\"王五\",\"cer_phone\":\"15258209684\",\"desp\":\"工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述\",\"result\":\"工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得\",\"start_timestamp\":\"1493568000\",\"finish_timestamp\":\"1533052800\",\"delete_flag\":\"0\"},{\"id\":\"4\",\"user_id\":\"28\",\"name\":\"web前端\",\"company\":\"野果网络科技\",\"certifier\":\"张三\",\"cer_phone\":\"18906625981\",\"desp\":\"工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述工作描述\",\"result\":\"工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得工作心得\",\"start_timestamp\":\"1462032000\",\"finish_timestamp\":\"1490976000\",\"delete_flag\":\"0\"}]}";
                       String cs = c.trim();
                      All = new Gson().fromJson(cs,PaseExperienceList.DataBean.class);
//                       PaseExperienceList.DataBean bean    = (PaseExperienceList.DataBean) result.getData();
                       worklist = All.getWorkExperienceHis();
                        initWorkExperienceHisBean(worklist);
                       impoProjectHisBeanList = All.getImpoProjectHis();
                       impoProjectHisBeanListBean(impoProjectHisBeanList);
                       impoWorkHisBeans = All.getImpoWorkHis();
                       impoWorkHisBeansBean(impoWorkHisBeans);
//                   }
            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });
//    }
    private void initWorkExperienceHisBean(List<PaseExperienceList.DataBean.WorkExperienceHisBean> worklist){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        ex1.setLayoutManager(layoutManager);
        workExperienceHisAdatper = new WorkExperienceHis(worklist,getActivity());
        ex1.setAdapter(workExperienceHisAdatper);
    }
    private void impoProjectHisBeanListBean(List<PaseExperienceList.DataBean.ImpoProjectHisBean> impoProjectHisBeanList){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        ex2.setLayoutManager(layoutManager);
        impoProjectHisadapter = new ImpoProjectHis(impoProjectHisBeanList,getActivity());
        ex2.setAdapter(impoProjectHisadapter);
    }
    private void impoWorkHisBeansBean(List<PaseExperienceList.DataBean.ImpoWorkHisBean> impoWorkHisBeans){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        ex3.setLayoutManager(layoutManager);
        impoWorkHisAdapter = new impoWorkHis(impoWorkHisBeans,getActivity());
        ex3.setAdapter(impoWorkHisAdapter);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
