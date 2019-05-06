package com.example.administrator.tongze.Fragment;

import android.content.Context;
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

import com.example.administrator.tongze.Adapter.ItemAdapter;
import com.example.administrator.tongze.Adapter.ObjectQuertyAdapter;
import com.example.administrator.tongze.Adapter.OnItemClickLitener;
import com.example.administrator.tongze.Adapter.OtherQuertyAdapter;
import com.example.administrator.tongze.Entiy.Result;
import com.example.administrator.tongze.List.OtherQuerty;
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

public class FragmentOtherQuestions extends Fragment {
    private String TAG = "FragmentOtherQuestions";
    @BindView(R.id.otherQuertyRecyclerview)
    RecyclerView otherQuertyRecyclerview;
    Unbinder unbinder;
    private List<OtherQuerty.DataBean.ItemsBean> list = new ArrayList<>();
    private List<String> lists;
    private OtherQuertyAdapter adapter;
    private String ids,token;
    private String emp_type;

    /**
     * 其他问题
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.otherquestion, container, false);
        unbinder = ButterKnife.bind(this, view);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        ids = sharedPreferences.getString("id","");
        token = sharedPreferences.getString("token","");
        SharedPreferences preferences = getActivity().getSharedPreferences("Emp",Context.MODE_PRIVATE);
        emp_type = preferences.getString("emp_type","");
        initDatas();

        return view;
    }

    private void initDatas() {
//        HashMap<String, String> body = new HashMap<>();
//        body.put("exam_type", emp_type);
//        body.put("user_id", ids);
//        body.put("token", token);
//        body.put("sign", SignGenerate.generate(body));
//        RetrofitUtil.getService().getOtherQuerty(body).enqueue(new Callback<Result<OtherQuerty.DataBean>>() {
//            @Override
//            public void onResponse(Response<Result<OtherQuerty.DataBean>> response, Retrofit retrofit) {
//                Result result = response.body();
//                if (result.getRet() == 200) {
//                    OtherQuerty.DataBean bean = (OtherQuerty.DataBean) result.getData();
//                   list = bean.getItems();
//                    initView(list);
//                }
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });
        String c = " [{\"id\":\"24\",\"exam_type\":\"1\",\"factor\":\"离职原因\\t\\t\",\"reference\":\"上一份工作的离职原因是什么？\\t\",\"words\":\"住址变动,原公司倒闭,不满意薪资福利,晋升空间,家庭原因,健康问题,压力过大,人际关系问题,其他\",\"sort_weight\":\"0\",\"delete_flag\":\"0\"},{\"id\":\"26\",\"exam_type\":\"1\",\"factor\":\"期望薪资\\t\\t\",\"reference\":\"期望薪资\\t\\t\",\"words\":\"3k以下,3-4k,4-5k,5-6k,6-7k,7-8k,8k以上,不关注薪资,其他\",\"sort_weight\":\"0\",\"delete_flag\":\"0\"},{\"id\":\"27\",\"exam_type\":\"1\",\"factor\":\"应聘者关注的问题\\t\\t\",\"reference\":\"你对公司或工作有什么问题？\\t\",\"words\":\"职业发展,薪资,年终奖,社保,公司福利,工作时间,工作环境,培训机会,公司前景,晋升空间,绩效考评,直属领导,试用期,其他\",\"sort_weight\":\"0\",\"delete_flag\":\"0\"}]";
        String cs = c.trim();
        try {
            Gson gson = new Gson();
            JsonArray array = new JsonParser().parse(cs).getAsJsonArray();
            for(JsonElement jsonElement : array){
                list.add(gson.fromJson(jsonElement,OtherQuerty.DataBean.ItemsBean.class));
            }
            initView(list);
        }catch (Exception e){
            e.printStackTrace();
        }


    }


    private void  initView(List<OtherQuerty.DataBean.ItemsBean> list){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        otherQuertyRecyclerview.setLayoutManager(layoutManager);
        adapter = new OtherQuertyAdapter(list,getActivity());
        otherQuertyRecyclerview.setAdapter(adapter);

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
