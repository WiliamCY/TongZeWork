package com.example.administrator.tongze.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.tongze.Adapter.ItemAllAdapter;
import com.example.administrator.tongze.Adapter.ItemsAdapter;
import com.example.administrator.tongze.Adapter.OnItemClickLitener;
import com.example.administrator.tongze.Entiy.Result;
import com.example.administrator.tongze.List.CEO;
import com.example.administrator.tongze.List.SubjectiveList;
import com.example.administrator.tongze.R;
import com.example.administrator.tongze.Retrofit.RetrofitUtil;
import com.example.administrator.tongze.Utils.FlowLayoutManager;
import com.example.administrator.tongze.Utils.SignGenerate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


public class FragmentsubjectiveItem extends Fragment {
    @BindView(R.id.reference)
    TextView reference;
    @BindView(R.id.add_suggest)
    LinearLayout addSuggest;
    @BindView(R.id.tab_all)
    LinearLayout tabAll;
    private String TAG = "FragmentsubjectiveItem";
    Unbinder unbinder;
    @BindView(R.id.iq_recyclerview)
    RecyclerView iqRecyclerview;
    @BindView(R.id.eq_recyclerview)
    RecyclerView eqRecyclerview;
    @BindView(R.id.work_recyclerview)
    RecyclerView workRecyclerview;
    @BindView(R.id.comment_recyclerview)
    RecyclerView commentRecyclerview;
    @BindView(R.id.All_querty)
    RecyclerView AllQuerty;
    @BindView(R.id.subScoreButton)
    LinearLayout subScoreButton;
    @BindView(R.id.sendScore)
    TextView sendScore;
    private List<SubjectiveList.DataBean.ItemsBean> list = new ArrayList<>();
    private ItemAllAdapter adapter;
    private List<String> ss = new ArrayList<>();
    private ItemsAdapter adapters;
    private String ids, token;
    private List<CEO.DataBean> ceo = new ArrayList<>();
    private List<String> isMainIds = new ArrayList<>();
    private String CeoIds = "0";
    private String emp_type;
    List<String> initIsMain = new ArrayList<String>();

    /**
     * 主观题
     **/
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.subjectiveitem, container, false);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        ids = sharedPreferences.getString("id", "");
        token = sharedPreferences.getString("token", "");
        initDatas();
        unbinder = ButterKnife.bind(this, view);
        SharedPreferences preferDataList = getActivity().getSharedPreferences("mainId", Context.MODE_PRIVATE);
        int environNums = preferDataList.getInt("id", 0);
        for (int i = 0; i < environNums; i++) {
            String environItem = preferDataList.getString("item_" + i, null);
            initIsMain.add(environItem);
            if (isMainIds.contains(ids)) {
                CeoIds = "1";
            } else {
                CeoIds = "0";
            }
        }
        subScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("请打分");
                //    通过LayoutInflater来加载一个xml的布局文件作为一个View对象
                View viewx = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_edit, null);
                //    设置我们自己定义的布局文件作为弹出框的Content
                builder.setView(viewx);

                final EditText username = (EditText) viewx.findViewById(R.id.usernamex);

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String a = username.getText().toString().trim();
                        int b = Integer.parseInt(a);
                        if (b < 0 || b > 10) {
                            Toast.makeText(getActivity(), "打分在0-10之间", Toast.LENGTH_SHORT).show();
                        } else {
                            sendScore(b);
                        }
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();

            }
        });
        return view;
    }


    private void initDatas() {
        SharedPreferences preferences = getActivity().getSharedPreferences("Emp", Context.MODE_PRIVATE);
        emp_type = preferences.getString("emp_type", "");
        HashMap<String, String> body = new HashMap<>();
        body.put("exam_type", emp_type);
        body.put("user_id", ids);
        body.put("token", token);
        body.put("sign", SignGenerate.generate(body));
        RetrofitUtil.getService().getsubjective(body).enqueue(new Callback<Result<SubjectiveList.DataBean>>() {
            @Override
            public void onResponse(Response<Result<SubjectiveList.DataBean>> response, Retrofit retrofit) {
                Result result = response.body();
                if (result.getRet() == 200) {
                    SubjectiveList.DataBean bean = (SubjectiveList.DataBean) result.getData();
                    list = bean.getItems();
                    String iq = list.get(0).getIq_words();
                    String eq = list.get(0).getEq_words();
                    String work = list.get(0).getWork_words();
                    String common = list.get(0).getCommon_words();
                    if (!iq.isEmpty() && !eq.isEmpty() && !work.isEmpty() && !common.isEmpty()) {
                        String[] iqs = iq.split(",");
                        String[] eqs = eq.split(",");
                        String[] works = work.split(",");
                        String[] commons = common.split(",");
                        List<String> iqlist = Arrays.asList(iqs);
                        List<String> eqlist = Arrays.asList(eqs);
                        List<String> worklist = Arrays.asList(works);
                        List<String> commonlist = Arrays.asList(commons);
                        initData1(iqlist);
                        initData2(eqlist);
                        initData3(worklist);
                        initData4(commonlist);
                    } else {
                        Toast.makeText(getActivity(), "发生异常,没有数据", Toast.LENGTH_SHORT).show();
                    }


                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void initData1(List<String> iqlist) {
        FlowLayoutManager layoutManager = new FlowLayoutManager(getActivity(), true);
        iqRecyclerview.setLayoutManager(layoutManager);
        adapter = new ItemAllAdapter(iqlist, getActivity(), "0");
        iqRecyclerview.setAdapter(adapter);
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
                if (!ss.contains(selectName)) {
                    ss.add(selectName);
                    final FlowLayoutManager layoutManager = new FlowLayoutManager(getActivity(), true);
                    AllQuerty.setLayoutManager(layoutManager);
                    adapters = new ItemsAdapter(ss, getActivity());
                    AllQuerty.setAdapter(adapters);
                    initData("iq_words", selectName);
                } else {
                    Toast.makeText(getActivity(), "已经存在", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onItemSlectNameIdsClick(View view, int position, String selectName, String ids) {

            }
        });
    }

    private void initData2(List<String> eqlist) {
        FlowLayoutManager layoutManager = new FlowLayoutManager(getActivity(), true);
        eqRecyclerview.setLayoutManager(layoutManager);
        adapter = new ItemAllAdapter(eqlist, getActivity(), "0");
        eqRecyclerview.setAdapter(adapter);
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
                if (!ss.contains(selectName)) {
                    ss.add(selectName);
                    final FlowLayoutManager layoutManager = new FlowLayoutManager(getActivity(), true);
                    AllQuerty.setLayoutManager(layoutManager);
                    adapters = new ItemsAdapter(ss, getActivity());
                    AllQuerty.setAdapter(adapters);
                    initData("eq_words", selectName);
                } else {
                    Toast.makeText(getActivity(), "已经存在", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onItemSlectNameIdsClick(View view, int position, String selectName, String ids) {

            }
        });


    }

    private void initData3(List<String> wroklist) {
        FlowLayoutManager layoutManager = new FlowLayoutManager(getActivity(), true);
        workRecyclerview.setLayoutManager(layoutManager);
        adapter = new ItemAllAdapter(wroklist, getActivity(), "0");
        workRecyclerview.setAdapter(adapter);
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
                if (!ss.contains(selectName)) {
                    ss.add(selectName);
                    final FlowLayoutManager layoutManager = new FlowLayoutManager(getActivity(), true);
                    AllQuerty.setLayoutManager(layoutManager);
                    adapters = new ItemsAdapter(ss, getActivity());
                    AllQuerty.setAdapter(adapters);
                    initData("work_words", selectName);
                } else {
                    Toast.makeText(getActivity(), "已经存在", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onItemSlectNameIdsClick(View view, int position, String selectName, String ids) {

            }
        });
    }

    private void initData4(List<String> commonlist) {
        FlowLayoutManager layoutManager = new FlowLayoutManager(getActivity(), true);
        commentRecyclerview.setLayoutManager(layoutManager);
        adapter = new ItemAllAdapter(commonlist, getActivity(), "0");
        commentRecyclerview.setAdapter(adapter);
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
                if (!ss.contains(selectName)) {
                    ss.add(selectName);
                    final FlowLayoutManager layoutManager = new FlowLayoutManager(getActivity(), true);
                    AllQuerty.setLayoutManager(layoutManager);
                    adapters = new ItemsAdapter(ss, getActivity());
                    AllQuerty.setAdapter(adapters);
                    initData("common_words", selectName);
                } else {
                    Toast.makeText(getActivity(), "已经存在", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onItemSlectNameIdsClick(View view, int position, String selectName, String ids) {

            }
        });
    }

    private void initData(String qq, String selectName) {

        HashMap<String, String> body = new HashMap<>();
        body.put("interview_flow_id", ids);
        body.put("sub_result", qq + ":" + selectName);
        body.put("isMain", CeoIds);
        body.put("user_id", ids);
        body.put("token", token);
        body.put("sign", SignGenerate.generate(body));
        RetrofitUtil.getService().putCommitBaseObjInfo(body).enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Response<Result> response, Retrofit retrofit) {
                Result result = response.body();
                if (result.getRet() == 200) {
                    Toast.makeText(getActivity(), "发送成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "发送失败", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void sendScore(final int score) {
        final String c = String.valueOf(score);
        HashMap<String, String> body = new HashMap<>();
        body.put("interview_flow_id", ids);
        body.put("sub_score", c);
        body.put("isMain", CeoIds);
        body.put("user_id", ids);
        body.put("token", token);
        body.put("sign", SignGenerate.generate(body));
        RetrofitUtil.getService().putBaseSubInfoSocre(body).enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Response<Result> response, Retrofit retrofit) {
                Result result = response.body();
                if (result.getRet() == 200) {
                    Toast.makeText(getActivity(), "提交成功", Toast.LENGTH_SHORT).show();
                    sendScore.setText(c);
                } else {
                    Toast.makeText(getActivity(), "提交失败", Toast.LENGTH_SHORT).show();
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

    @OnClick({ R.id.add_suggest})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add_suggest:
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("请输入");
                //    通过LayoutInflater来加载一个xml的布局文件作为一个View对象
                View viewx = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_userset, null);
                //    设置我们自己定义的布局文件作为弹出框的Content
                builder.setView(viewx);

                final EditText username = (EditText) viewx.findViewById(R.id.userOther);

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       Toast.makeText(getActivity(),"提交失败",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                break;
        }
    }
}
