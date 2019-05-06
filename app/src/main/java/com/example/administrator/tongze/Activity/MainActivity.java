package com.example.administrator.tongze.Activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;
import com.azoft.carousellayoutmanager.DefaultChildSelectionListener;
import com.example.administrator.tongze.Adapter.MainAdapter;
import com.example.administrator.tongze.Entiy.Result;
import com.example.administrator.tongze.GeTui.GeTuiService;
import com.example.administrator.tongze.GeTui.IntentService;
import com.example.administrator.tongze.GeTui.PushService;
import com.example.administrator.tongze.List.CEO;
import com.example.administrator.tongze.List.LoginList;
import com.example.administrator.tongze.List.MainList;
import com.example.administrator.tongze.List.UserMessageList;
import com.example.administrator.tongze.R;
import com.example.administrator.tongze.Retrofit.RetrofitUtil;
import com.example.administrator.tongze.Utils.AlertDialog;
import com.example.administrator.tongze.Utils.SignGenerate;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.igexin.sdk.PushManager;
import com.jaeger.library.StatusBarUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends BaseTemplateActivity {
    private String TAG = "MainActivity";
    private GeTuiService getuiBroadcast;
    private IntentFilter intentFilter;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.main_back)
    ImageView mainBack;
    private List<UserMessageList.DataBean> lists = new ArrayList<>();
    private MainAdapter adapter;
    private String user_id,token;
    private List<CEO> ceos = new ArrayList<>();
    private List<CEO.DataBean> mains = new ArrayList<>();
    private  List<String> c = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        StatusBarUtil.setTransparent(this);
        getuiBroadcast = new GeTuiService();
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.tongze.GETUI");
        PushManager.getInstance().initialize(this,PushService.class);
        PushManager.getInstance().registerPushIntentService(this, IntentService.class);
        Intent intent = getIntent();
        user_id = intent.getStringExtra("user_id");
        token = intent.getStringExtra("token");
        initDatas(user_id,token);

    }

    private  void initViews(List<UserMessageList.DataBean> lists) {
        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapter = new MainAdapter(lists, this);
        initRecyclerView(recyclerview, new CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL, false), adapter);
        recyclerview.setAdapter(adapter);
    }

    //private  void initDatas(String user_id,String token) {
//    HashMap<String,String> body = new HashMap<>();
//    body.put("uid",user_id);
//    body.put("user_id",user_id);
//    body.put("token",token);
//    body.put("sign", SignGenerate.generate(body));
//    RetrofitUtil.getService().getUserMessage(body).enqueue(new Callback<Result<List<UserMessageList.DataBean>>>() {
//        @Override
//        public void onResponse(Response<Result<List<UserMessageList.DataBean>>> response, Retrofit retrofit) {
//            Result result = response.body();
//            if(result.getRet() == 200){
//               lists = (List<UserMessageList.DataBean>) result.getData();
//               initViews(lists);
//            }else if(result.getRet()==410) {
//                showToast(result.getMsg());
//            }else {
//                showToast("获取失败");
//            }
//        }
//
//        @Override
//        public void onFailure(Throwable t) {
//
//        }
//    });
//
//    }
    private  void initDatas(String user_id,String token) {
//        HashMap<String,String> body = new HashMap<>();
//        body.put("uid",user_id);
//        body.put("user_id",user_id);
//        body.put("token",token);
//        body.put("sign", SignGenerate.generate(body));
//        RetrofitUtil.getService().getUserMessage(body).enqueue(new Callback<Result<List<UserMessageList.DataBean>>>() {
//            @Override
//            public void onResponse(Response<Result<List<UserMessageList.DataBean>>> response, Retrofit retrofit) {
                String c = "[{\"user_id\":\"37\",\"name\":\"曹坚立\",\"come_time\":\"随时到岗\",\"work_years\":\"3.0\",\"manage_years\":\"3.0\",\"school\":\"浙江大学\",\"major\":\"软件工程\",\"education_name\":\"硕士\",\"sendout\":\"1\",\"adjust\":\"1\",\"skills\":\"擅长呢,哈哈哈\",\"post_name\":\"总经理\",\"adjustPos\":[\"应收\",\"主管\"],\"interview_flow_id\":\"27\",\"interview_level\":\"1\"},{\"user_id\":\"29\",\"name\":\"张三\",\"come_time\":\"一周内到岗\",\"work_years\":\"3.0\",\"manage_years\":\"1.0\",\"school\":\"浙江大学1111\",\"major\":\"计算机\",\"education_name\":\"高中\",\"sendout\":\"1\",\"adjust\":\"1\",\"skills\":\"会玩1111\",\"post_name\":\"策划\",\"adjustPos\":[\"策划\"],\"interview_flow_id\":\"13\",\"interview_level\":\"1\"},{\"user_id\":\"28\",\"name\":\"夏童豪\",\"come_time\":\"随时到岗\",\"work_years\":\"3.0\",\"manage_years\":\"2.0\",\"school\":\"宁波理工\",\"major\":\"信息与计算科学\",\"education_name\":\"高中\",\"sendout\":\"1\",\"adjust\":\"1\",\"skills\":\"技能特长\",\"post_name\":\"总经理\",\"adjustPos\":[\"策划\",\"行政\"],\"interview_flow_id\":\"26\",\"interview_level\":\"1\"}]";
                String cs = c.trim();
                try {
                    Gson gson = new Gson();
                    JsonArray array = new JsonParser().parse(cs).getAsJsonArray();
                    for(JsonElement jsonElement : array){
                        lists.add(gson.fromJson(jsonElement,UserMessageList.DataBean.class));
                    }
                    initViews(lists);
                }catch (Exception e){
                    e.printStackTrace();
                }


//            }

//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });

    }

    private void initRecyclerView(final RecyclerView recyclerview, final CarouselLayoutManager layoutManager, final MainAdapter adapter) {
        layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
        layoutManager.setMaxVisibleItems(1);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setHasFixedSize(true);
        recyclerview.setAdapter(adapter);
        recyclerview.addOnScrollListener(new CenterScrollListener());
        DefaultChildSelectionListener.initCenterItemListener(new DefaultChildSelectionListener.OnCenterItemClickListener() {
            @Override
            public void onCenterItemClicked(@NonNull RecyclerView recyclerView, @NonNull CarouselLayoutManager carouselLayoutManager, @NonNull View v) {
                final int position = recyclerView.getChildLayoutPosition(v);
                if(CarouselLayoutManager.INVALID_POSITION != position){
                    SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                    editor.putString("id",lists.get(position).getUser_id());
                    editor.putString("token",token);
                    editor.apply();
                    Bundle bundle = new Bundle();
                    Intent intent = new Intent(getApplicationContext(),UserMessageActivity.class);
                    String UserName = lists.get(position).getName();
                    String ComeTime = lists.get(position).getCome_time();
                    String WorkYears = lists.get(position).getWork_years();
                    String ManageYears = lists.get(position).getManage_years();
                    String skill =  lists.get(position).getSkills();
                    String school = lists.get(position).getSchool();
                    String education_name = lists.get(position).getEducation_name();
                    String major = lists.get(position).getMajor();
                    String sendout = lists.get(position).getSendout();
                    String adjust = lists.get(position).getAdjust();
                    List<String> adj = lists.get(position).getAdjustPos();
                    bundle.putString("UserName",UserName);
                    bundle.putString("ComeTime",ComeTime);
                    bundle.putString("WorkYears",WorkYears);
                    bundle.putString("ManageYears",ManageYears);
                    bundle.putString("skill",skill);
                    bundle.putString("school",school);
                    bundle.putString("education_name",education_name);
                    bundle.putString("major",major);
                    bundle.putString("sendout",sendout);
                    bundle.putString("adjust",adjust);
                    bundle.putString("id",lists.get(position).getUser_id());
                    bundle.putString("token",token);
                    intent.putExtra("Message",bundle);
                    startActivity(intent);
                }
            }
        }, recyclerview, layoutManager);

    }

    @OnClick({R.id.main_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_back:
                new AlertDialog(this).builder().setMsg("确定退出吗?").
                        setPositiveButton("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }).setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }).show();
                break;

        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(getuiBroadcast, intentFilter);
    }

}
