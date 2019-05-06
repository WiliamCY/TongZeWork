package com.example.administrator.tongze.Fragment;

import android.annotation.SuppressLint;
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
import android.widget.TextView;

import com.example.administrator.tongze.Adapter.AwardAdapter;
import com.example.administrator.tongze.Adapter.FamilyAdapter;
import com.example.administrator.tongze.Adapter.SchoolAdapter;
import com.example.administrator.tongze.Entiy.Result;
import com.example.administrator.tongze.List.BasicInformationList;
import com.example.administrator.tongze.List.UserMessageList;
import com.example.administrator.tongze.R;
import com.example.administrator.tongze.Retrofit.RetrofitUtil;
import com.example.administrator.tongze.Utils.SignGenerate;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.nostra13.universalimageloader.utils.L;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

@SuppressLint("ValidFragment")
public class FragmentBasicInformation extends Fragment {
    @BindView(R.id.name)
    TextView tname;
    @BindView(R.id.mangers_years)
    TextView tmangerYears;
    @BindView(R.id.work_years)
    TextView tworkYears;
    @BindView(R.id.ComeTime)
    TextView tComeTime;
    @BindView(R.id.college)
    TextView college;
    @BindView(R.id.education)
    TextView teducation;
    @BindView(R.id.major)
    TextView tmajor;
    @BindView(R.id.sendout)
    TextView tsendout;
    @BindView(R.id.adjust)
    TextView tadjust;
    @BindView(R.id.employ_department)
    TextView temployDepartment;
//    @BindView(R.id.main_adapter_h10)
//    TextView tmainAdapterH10;
//    @BindView(R.id.main_adapter_h11)
//    TextView tmainAdapterH11;
    @BindView(R.id.skill)
    TextView tskill;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.current_address)
    TextView tcurrentAddress;
    @BindView(R.id.native_address)
    TextView tnativeAddress;
    Unbinder unbinder;
    @BindView(R.id.phone)
    TextView tphone;
    @BindView(R.id.email)
    TextView temail;
    @BindView(R.id.eduRecyclerview)
    RecyclerView eduRecyclerview;
    @BindView(R.id.familyRecyclerview)
    RecyclerView familyRecyclerview;
    @BindView(R.id.awardRecyclerview)
    RecyclerView awardRecyclerview;
    private SchoolAdapter adapter;
    private FamilyAdapter familyAdapter;
    private AwardAdapter awardAdapter;
    private BasicInformationList.DataBean list;
    private List<BasicInformationList.DataBean.EducationHisBean> educaList = new ArrayList<>();
    private List<BasicInformationList.DataBean.FamilyMemberBean> familyList = new ArrayList<>();
    private List<BasicInformationList.DataBean.AwardPunishmentBean> awardPunishmentBeans = new ArrayList<>();
    private String name, identity_card, native_place, nationality_id, nationality, politics, stature, weight, married, birth, sex, birthday, animal, constellation, school, major, entrance_timestamp, graduate_timestamp;
    private String education_id, education, full_time, work_years, manage_years, come_time, sendout, adjust, driving_license, driving_years, english_level_id, english_level, foreign_languages, skills, referrals, referrals_name;
    private String native_location_name, native_address, current_location_id, current_location_name, current_address, emergency_contact, emergency_relation, emergency_phone, emergency_address, family_member, relation, work;
    private String work_place, start_timestamp, phone, email, finish_timestamp, type, desp, names, ComeTime, WorkYears, ManageYears, Skill, schools, Education_names, Majors, Adjusts, Sendouts, id, token, emp_type,temployDepartments;
    private TextView native_location_id;
    private List<?> native_location_detail;
    private List<?> current_location_detail;


    @SuppressLint("ValidFragment")
    public FragmentBasicInformation(Bundle bundle) {
        names = bundle.getString("UserName");
        ComeTime = bundle.getString("ComeTime");
        WorkYears = bundle.getString("WorkYears");
        ManageYears = bundle.getString("ManageYears");
        Skill = bundle.getString("skill");
        Education_names = bundle.getString("education_name");
        Majors = bundle.getString("major");
        Adjusts = bundle.getString("adjust");
        Sendouts = bundle.getString("sendout");
        schools = bundle.getString("school");
        id = bundle.getString("id");
        token = bundle.getString("token");


    }

    /**
     * c基础信息界面
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.basicinformation, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;

    }


    private void initData() {
//        HashMap<String, String> body = new HashMap<>();
//        body.put("uid", id);
//        body.put("token", token);
//        body.put("sign", SignGenerate.generate(body));
//        RetrofitUtil.getService().getUserMessageAll(body).enqueue(new Callback<Result<BasicInformationList.DataBean>>() {
//            @Override
//            public void onResponse(Response<Result<BasicInformationList.DataBean>> response, Retrofit retrofit) {
//                Result result = response.body();
//                if (result.getRet() == 200) {
                    String c =  "{\"id\":\"6\",\"user_id\":\"28\",\"name\":\"夏童豪\",\"identity_card\":\"330283199603132758\",\"email\":\"caojianli1989@126.com\",\"native_place\":\"浙江宁波\",\"nationality_id\":\"1\",\"nationality\":\"汉族\",\"politics\":\"2\",\"stature\":\"180\",\"weight\":\"60\",\"married\":\"0\",\"birth\":\"0\",\"phone\":\"18268697597\",\"sex\":\"0\",\"school\":\"宁波理工\",\"major\":\"信息与计算科学\",\"entrance_timestamp\":\"1409500800\",\"graduate_timestamp\":\"1527782400\",\"education_id\":\"1\",\"education\":\"高中\",\"full_time\":\"1\",\"employ_post_id\":\"1\",\"employ_post\":\"总经理\",\"work_years\":\"3.0\",\"manage_years\":\"2.0\",\"come_time\":\"随时到岗\",\"sendout\":\"1\",\"adjust\":\"1\",\"driving_license\":\"1\",\"driving_years\":\"5.0\",\"english_level_id\":\"1\",\"english_level\":\"雅思7\",\"foreign_languages\":\"\",\"skills\":\"技能特长\",\"emp_type\":\"0\",\"referrals\":\"0\",\"referrals_name\":\"\",\"native_location_id\":\"330212\",\"native_address\":\"世纪大道\",\"current_location_id\":\"310300\",\"current_address\":\"中山路\",\"emergency_contact\":\"张三\",\"emergency_relation\":\"兄弟\",\"emergency_phone\":\"17682453143\",\"emergency_address\":\"宁波奉化\",\"native_location_detail\":[{\"id\":\"330000\",\"name\":\"浙江省\",\"arealevel\":\"1\",\"parent_id\":\"0\"},{\"id\":\"330200\",\"name\":\"宁波市\",\"arealevel\":\"2\",\"parent_id\":\"330000\"},{\"id\":\"330212\",\"name\":\"鄞州区\",\"arealevel\":\"3\",\"parent_id\":\"330200\"}],\"native_location_name\":\"浙江省_宁波市_鄞州区\",\"current_location_detail\":[{\"id\":\"310000\",\"name\":\"上海市\",\"arealevel\":\"1\",\"parent_id\":\"0\"},{\"id\":\"310300\",\"name\":\"长宁区\",\"arealevel\":\"2\",\"parent_id\":\"310000\"}],\"current_location_name\":\"上海市_长宁区\",\"birthday\":\"19960313\",\"animal\":\"鼠\",\"constellation\":\"双鱼座\",\"education_his\":[{\"id\":\"5\",\"user_id\":\"28\",\"school\":\"浙江大学\",\"education_id\":\"1\",\"major\":\"计算机\",\"full_time\":\"1\",\"start_timestamp\":\"1409500800\",\"finish_timestamp\":\"1527782400\",\"highest\":\"0\",\"delete_flag\":\"0\",\"education\":\"高中\"},{\"id\":\"10\",\"user_id\":\"28\",\"school\":\"宁波理工\",\"education_id\":\"1\",\"major\":\"信息与计算科学\",\"full_time\":\"1\",\"start_timestamp\":\"1409500800\",\"finish_timestamp\":\"1527782400\",\"highest\":\"0\",\"delete_flag\":\"0\",\"education\":\"高中\"},{\"id\":\"33\",\"user_id\":\"28\",\"school\":\"宁波理工\",\"education_id\":\"1\",\"major\":\"信息与计算科学\",\"full_time\":\"1\",\"start_timestamp\":\"1409500800\",\"finish_timestamp\":\"1527782400\",\"highest\":\"1\",\"delete_flag\":\"0\",\"education\":\"高中\"}],\"family_member\":[{\"id\":\"5\",\"user_id\":\"28\",\"relation\":\"1\",\"name\":\"王五\",\"work\":\"员工\",\"work_place\":\"宁波鄞州区\",\"phone\":\"17682453143\",\"delete_flag\":\"0\"},{\"id\":\"6\",\"user_id\":\"28\",\"relation\":\"3\",\"name\":\"李四\",\"work\":\"老板老板\",\"work_place\":\"宁波江北区江北区\",\"phone\":\"15258209684\",\"delete_flag\":\"0\"}],\"award_punishment\":[{\"id\":\"1\",\"user_id\":\"28\",\"type\":\"1\",\"desp\":\"2010年获得国家奖学金\",\"delete_flag\":\"0\"},{\"id\":\"2\",\"user_id\":\"28\",\"type\":\"1\",\"desp\":\"2010年获得省奖学金\",\"delete_flag\":\"0\"}]}";
                    String cs = c.trim();
                    list = new Gson().fromJson(cs,BasicInformationList.DataBean.class);
//                    try {
//                        Gson gson = new Gson();
//                        JsonArray array = new JsonParser().parse(cs).getAsJsonArray();
//                        for(JsonElement jsonElement : array){
//                            list.add(gson.fromJson(jsonElement,BasicInformationList.DataBean.class));
//                        }
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }

//                    list = (BasicInformationList.DataBean) result.getData();
                    temployDepartments = list.getEmploy_post();
                    phone = list.getPhone();
                    email = list.getEmail();
                    work_years = list.getWork_years();
                    manage_years = list.getManage_years();
                    come_time = list.getCome_time();
                    school = list.getSchool();
                    major = list.getMajor();
                    sendout = list.getSendout();
                    adjust = list.getAdjust();
                    skills = list.getSkills();
                    emp_type = list.getEmp_type();
                    native_location_name = list.getNative_location_name();
                    native_address = list.getNative_address();
                    current_location_name = list.getCurrent_location_name();
                    current_address = list.getCurrent_address();
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("Emp", Context.MODE_PRIVATE).edit();
                    editor.putString("emp_type", emp_type);
                    editor.apply();
                    educaList = list.getEducation_his();
                    initEduList(educaList);
                    familyList = list.getFamily_member();
                    initFamilt(familyList);
                    awardPunishmentBeans = list.getAward_punishment();
                    initAward(awardPunishmentBeans);
                    initShare();
                }
//            }

            private void initEduList(List<BasicInformationList.DataBean.EducationHisBean> educaList) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                eduRecyclerview.setLayoutManager(layoutManager);
                adapter = new SchoolAdapter(educaList, getActivity());
                eduRecyclerview.setAdapter(adapter);
            }

            private void initFamilt(List<BasicInformationList.DataBean.FamilyMemberBean> familyMemberBeanList) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                familyRecyclerview.setLayoutManager(layoutManager);
                familyAdapter = new FamilyAdapter(familyMemberBeanList, getActivity());
                familyRecyclerview.setAdapter(familyAdapter);
            }
            private void  initAward(List<BasicInformationList.DataBean.AwardPunishmentBean> awardPunishmentBeans){
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                awardRecyclerview.setLayoutManager(layoutManager);
                awardAdapter  = new AwardAdapter(awardPunishmentBeans,getActivity());
                awardRecyclerview.setAdapter(awardAdapter);

            }

            private void initShare() {
                temployDepartment.setText(temployDepartments);
                tcurrentAddress.setText(native_location_name + native_address);
                tnativeAddress.setText(current_location_name + current_address);
                if (WorkYears.indexOf(".") > 0) {
                    WorkYears = WorkYears.replaceAll("0+?$", "");//去掉多余的0
                    WorkYears = WorkYears.replaceAll("[.]$", "");//如最后一位是.则去掉
                }
                if (ManageYears.indexOf(".") > 0) {
                    ManageYears = WorkYears.replaceAll("0+?$", "");//去掉多余的0
                    ManageYears = WorkYears.replaceAll("[.]$", "");//如最后一位是.则去掉
                }
                tphone.setText(phone);
                temail.setText(email);
                tworkYears.setText(WorkYears + "年");
                tname.setText(names);
                tmangerYears.setText(ManageYears + "年");
                tComeTime.setText(ComeTime);
                college.setText(schools);
                teducation.setText(Education_names);
                tmajor.setText(Majors);
                if (Sendouts.equals("1")) {
                    tsendout.setText("接受外出");
                } else {
                    tsendout.setText("不接受外出");
                }
                if (Adjusts.equals("1")) {
                    tadjust.setText("接受调剂");
                } else {
                    tadjust.setText("不接受调剂");
                }

                tskill.setText(Skill);


            }

//            @Override
//            public void onFailure(Throwable t) {
//
//            }
//        });


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
