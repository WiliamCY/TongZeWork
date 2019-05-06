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
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.tongze.Adapter.CeoAdapter;
import com.example.administrator.tongze.Adapter.ObjectQuertyAdapter;
import com.example.administrator.tongze.Adapter.OnItemClickLitener;
import com.example.administrator.tongze.Entiy.Result;
import com.example.administrator.tongze.List.CEO;
import com.example.administrator.tongze.List.ObjectiveListGson;
import com.example.administrator.tongze.List.ObjectiveQuestionList;
import com.example.administrator.tongze.List.UserMessageList;
import com.example.administrator.tongze.R;
import com.example.administrator.tongze.Retrofit.RetrofitUtil;
import com.example.administrator.tongze.Utils.SignGenerate;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class FragmentObjectiveQuestion extends Fragment {
    @BindView(R.id.ceo_recycierview)
    RecyclerView ceoRecycierview;
    @BindView(R.id.face_time)
    TextView faceTime;
    private String TAG = "FragmentObjectiveQuestion";
    @BindView(R.id.objectRecyclerview)
    RecyclerView objectRecyclerview;
    Unbinder unbinder;
    private ObjectQuertyAdapter adapter;
    private List<ObjectiveQuestionList.DataBean.ItemsBean> list = new ArrayList<>();
    private String ids, token, emp_type;
    private List<CEO.DataBean> ceo = new ArrayList<>();
    private CeoAdapter ceoAdapter;


    /***
     * 客观题
     * */

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.objectivequestion, container, false);
        unbinder = ButterKnife.bind(this, view);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        ids = sharedPreferences.getString("id", "");
        token = sharedPreferences.getString("token", "");
        SharedPreferences preferences = getActivity().getSharedPreferences("Emp", Context.MODE_PRIVATE);
        emp_type = preferences.getString("emp_type", "");
        initData();
        initIsMain();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 ");// HH:mm:ss
//获取当前时间
        Date date = new Date(System.currentTimeMillis());
        faceTime.setText("面试时间：" + simpleDateFormat.format(date));
        return view;
    }

    private void initIsMain() {
        HashMap<String, String> body = new HashMap<>();
        body.put("interview_flow_id", ids);
        body.put("user_id", ids);
        body.put("token", token);
        body.put("sign", SignGenerate.generate(body));
        RetrofitUtil.getService().getCEO(body).enqueue(new Callback<Result<List<CEO.DataBean>>>() {
            @Override
            public void onResponse(Response<Result<List<CEO.DataBean>>> response, Retrofit retrofit) {
                Result result = response.body();
                if (result.getRet() == 200) {
                    ceo = (List<CEO.DataBean>) result.getData();
                    initCeo(ceo);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void initCeo(List<CEO.DataBean> ceo) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        ceoRecycierview.setLayoutManager(layoutManager);
        ceoAdapter = new CeoAdapter(ceo, getActivity());
        ceoRecycierview.setAdapter(ceoAdapter);
    }

    private void initData() {
//        HashMap<String, String> body = new HashMap<>();
//        body.put("exam_type", emp_type);
//        body.put("user_id", ids);
//        body.put("token", token);
//        body.put("sign", SignGenerate.generate(body));
//        RetrofitUtil.getService().getObjectQuerty(body).enqueue(new Callback<Result<ObjectiveQuestionList.DataBean>>() {
//            @Override
//            public void onResponse(Response<Result<ObjectiveQuestionList.DataBean>> response, Retrofit retrofit) {
//                Result result = response.body();
//                if (result.getRet() == 200) {
//                    ObjectiveQuestionList.DataBean bean = (ObjectiveQuestionList.DataBean) result.getData();
//                    list = bean.getItems();
//                    initView(list);
//                }
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });
        String c = "[{\"id\":\"25\",\"exam_type\":\"0\",\"factor\":\"举止仪表\",\"type\":\"0\",\"reference\":\"观察法。\",\"grade_a_desp\":\"仪表端正,气质让人过目难忘\",\"grade_a\":\"10\",\"grade_b_desp\":\"穿着得体,举止礼貌有度\",\"grade_b\":\"8\",\"grade_c_desp\":\"穿着简单随意\",\"grade_c\":\"6\",\"grade_d_desp\":\"穿着不合适,不礼貌\",\"grade_d\":\"4\",\"weight\":\"0.00\",\"sort_weight\":\"0\",\"delete_flag\":\"0\"},{\"id\":\"26\",\"exam_type\":\"0\",\"factor\":\"沟通表达能力\",\"type\":\"0\",\"reference\":\"请做下自我介绍,结合自我介绍与以下问题的回答综合评价面试者的表达能力\",\"grade_a_desp\":\"有准备,有记忆点,能突出自身优势\",\"grade_a\":\"10\",\"grade_b_desp\":\"条理清晰 有亮点\",\"grade_b\":\"8\",\"grade_c_desp\":\"流畅,但比较普通\",\"grade_c\":\"6\",\"grade_d_desp\":\"磕磕绊绊,逻辑混乱,毫无准备\",\"grade_d\":\"4\",\"weight\":\"0.00\",\"sort_weight\":\"0\",\"delete_flag\":\"0\"},{\"id\":\"27\",\"exam_type\":\"0\",\"factor\":\"职位的欲望\",\"type\":\"0\",\"reference\":\"对我们公司/行业是否了解？\",\"grade_a_desp\":\"对本单位了解全面,面试经过精心准备\",\"grade_a\":\"10\",\"grade_b_desp\":\"对公司及行业有了解,面试态度认真\",\"grade_b\":\"8\",\"grade_c_desp\":\"对公司的了解有偏差,面试准备不足\",\"grade_c\":\"6\",\"grade_d_desp\":\"没做过任何了解,简历海投\",\"grade_d\":\"4\",\"weight\":\"0.00\",\"sort_weight\":\"0\",\"delete_flag\":\"0\"},{\"id\":\"28\",\"exam_type\":\"0\",\"factor\":\"性格\",\"type\":\"0\",\"reference\":\"认为自己的性格是怎么样的？\",\"grade_a_desp\":\"有领导力,成就导向；性格与岗位要求完全匹配\",\"grade_a\":\"10\",\"grade_b_desp\":\"有上进心,成就导向\",\"grade_b\":\"8\",\"grade_c_desp\":\"性格与岗位要求基本匹配\",\"grade_c\":\"6\",\"grade_d_desp\":\"性格特质不好\",\"grade_d\":\"4\",\"weight\":\"0.00\",\"sort_weight\":\"0\",\"delete_flag\":\"0\"},{\"id\":\"29\",\"exam_type\":\"0\",\"factor\":\"工作的看法\",\"type\":\"0\",\"reference\":\"你对加班有什么看法？\",\"grade_a_desp\":\"加班是继续学习、完善工作的机会（有进取心、肯为公司付出）\",\"grade_a\":\"10\",\"grade_b_desp\":\"乐观看待加班\",\"grade_b\":\"8\",\"grade_c_desp\":\"有加班费可以加班\",\"grade_c\":\"6\",\"grade_d_desp\":\"用五花八门的理由,阐述加班的弊端、不必要性等\",\"grade_d\":\"4\",\"weight\":\"0.00\",\"sort_weight\":\"0\",\"delete_flag\":\"0\"},{\"id\":\"30\",\"exam_type\":\"0\",\"factor\":\"校园经历\",\"type\":\"0\",\"reference\":\"在校参加过什么活动？例如社团/学生会/学科竞赛/创业活动/支教/公益/马拉松等          描述一下参与的过程,你扮演的角色,是否担任组织或领导工作；最后的结果如何；取得哪些成果；同学/队友如何评价你的工作和潜力? 有什么收获？\",\"grade_a_desp\":\"参加过,是核心成员,造成正面而广泛的社会影响\",\"grade_a\":\"10\",\"grade_b_desp\":\"参加过,是重要成员,成果有一定的社会影响力\",\"grade_b\":\"8\",\"grade_c_desp\":\"参与过,没有取得什么成绩或社会影响力\",\"grade_c\":\"6\",\"grade_d_desp\":\"从未参与过,或 经历造假,夸大,过分修饰\",\"grade_d\":\"4\",\"weight\":\"0.00\",\"sort_weight\":\"0\",\"delete_flag\":\"0\"},{\"id\":\"31\",\"exam_type\":\"0\",\"factor\":\"实习经历\",\"type\":\"0\",\"reference\":\"之前有做过实习吗？岗位职责？工作表现如何？上司/同事如何评价你的工作和潜力？通过这份实习,你有什么收获\",\"grade_a_desp\":\"过往实习有出色表现,受领导、同事的认可\",\"grade_a\":\"10\",\"grade_b_desp\":\"岗位职责记忆清晰,实习中有一定的团队合作能力\",\"grade_b\":\"8\",\"grade_c_desp\":\"有实习经历,工作内容重复简单\",\"grade_c\":\"6\",\"grade_d_desp\":\"无实习经历,或 造假,夸大实习经历\",\"grade_d\":\"4\",\"weight\":\"0.00\",\"sort_weight\":\"0\",\"delete_flag\":\"0\"},{\"id\":\"32\",\"exam_type\":\"0\",\"factor\":\"可塑性\",\"type\":\"0\",\"reference\":\"职业发展方向的定位？你有什么样的职业规划？\",\"grade_a_desp\":\"职业规划清晰科学\",\"grade_a\":\"10\",\"grade_b_desp\":\"有清晰的规划 但不科学\",\"grade_b\":\"8\",\"grade_c_desp\":\"职业规划不清晰\",\"grade_c\":\"6\",\"grade_d_desp\":\"无职业规划,或为了规划而规划\",\"grade_d\":\"4\",\"weight\":\"0.00\",\"sort_weight\":\"0\",\"delete_flag\":\"0\"}]";
        String cs = c.trim();
        try {
            Gson gson = new Gson();
            JsonArray array = new JsonParser().parse(cs).getAsJsonArray();
            for(JsonElement jsonElement : array){
                list.add(gson.fromJson(jsonElement,ObjectiveQuestionList.DataBean.ItemsBean.class));
            }
            initView(list);
        }catch (Exception e){
            e.printStackTrace();
        }


    }


    private void initView(final List<ObjectiveQuestionList.DataBean.ItemsBean> list) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        objectRecyclerview.setLayoutManager(layoutManager);
        adapter = new ObjectQuertyAdapter(list, getActivity());
        objectRecyclerview.setAdapter(adapter);
        adapter.setOnItemClickLitener(new OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }

            @Override
            public void onItemSlectClick(View view, int position, String selectId) {
                String id = list.get(position).getId();
                String selectid = selectId;
                String select = String.valueOf(selectid);
                sendObjectiveObject(id, select);
            }

            @Override
            public void onItemSlectNameClick(View view, int position, String selectName) {

            }

            @Override
            public void onItemSlectNameIdsClick(View view, int position, String selectName, String ids) {

            }
        });

    }

    private void sendObjectiveObject(String id, String select) {

        Gson gs = new Gson();
        Map<String,String> map = new HashMap<>();
        map.put(id,select);
        String json = gs.toJson(map);


        HashMap<String, String> body = new HashMap<>();
        body.put("interview_flow_id", ids);
        body.put("obj_result",json);
        Log.i(TAG,"SADSD"+json);
        body.put("user_id", ids);
        body.put("token", token);
        body.put("sign", SignGenerate.generate(body));
        RetrofitUtil.getService().putCommitBaseObjInfo(body).enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Response<Result> response, Retrofit retrofit) {
                Result result = response.body();
                Log.i("TAG", "sendObjectiveObject" + result.getRet());
                if (result.getRet() == 200) {
                    Toast.makeText(getActivity(), "发生成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "发生异常", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
