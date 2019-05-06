package com.example.administrator.tongze.Retrofit;




import com.example.administrator.tongze.Entiy.Result;
import com.example.administrator.tongze.List.BasicInformationList;
import com.example.administrator.tongze.List.CEO;
import com.example.administrator.tongze.List.HonorList;
import com.example.administrator.tongze.List.LoginList;
import com.example.administrator.tongze.List.ObjectiveQuestionList;
import com.example.administrator.tongze.List.OtherQuerty;
import com.example.administrator.tongze.List.PaseExperienceList;
import com.example.administrator.tongze.List.SubjectiveList;
import com.example.administrator.tongze.List.UserMessageList;

import java.util.HashMap;
import java.util.List;

import okhttp3.RequestBody;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;;

/**
 * Created by admin on 2017/11/22.
 */

public interface StandingCommitteeService {
    /**
     * 获取验证码
     */
    @POST("?service=User.User.GetAuthCode")
    @FormUrlEncoded
    Call<Result> getCode(@FieldMap  HashMap<String, String> body);

    /**
     * 登录
     */
    @POST("?service=User.User.Login")
    @FormUrlEncoded
    Call<Result<LoginList.DataBean>> login(@FieldMap  HashMap<String, String> body);

    /**
     * 获取面试者的信息
     */
    @POST("?service=App.ApplyJob_InterviewProgress.GetTodayInerviewerlist")
    @FormUrlEncoded
    Call<Result<List<UserMessageList.DataBean>>> getUserMessage(@FieldMap  HashMap<String, String> body);

    /**
     * 获取面试者的全部信息
     */
    @POST("?service=App.Employee_Employee.GetPersonResumeInfo")
    @FormUrlEncoded
    Call<Result<BasicInformationList.DataBean>>  getUserMessageAll(@FieldMap  HashMap<String, String> body);


    /**
     * 获取客观题
     */
        @POST("?service=App.ApplyJob_InterviewBaseObj.GetList")
    @FormUrlEncoded
    Call<Result<ObjectiveQuestionList.DataBean>> getObjectQuerty(@FieldMap  HashMap<String, String> body);




    /**
     * 获取其他问题
     */
    @POST("?service=App.ApplyJob_InterviewBaseOther.GetList")
    @FormUrlEncoded
    Call<Result<OtherQuerty.DataBean>> getOtherQuerty(@FieldMap  HashMap<String, String> body);

    /**
     * 获取主观题
     */
    @POST("?service=App.ApplyJob_InterviewBaseSub.GetList")
    @FormUrlEncoded
    Call<Result<SubjectiveList.DataBean>> getsubjective(@FieldMap  HashMap<String, String> body);

    /**
     * 获取证书
     */
    @POST("?service=App.Employee_Employee.GetFileAccList")
    @FormUrlEncoded
    Call<Result<List<HonorList.DataBean>>> getHonor(@FieldMap  HashMap<String, String> body);



    /**
     * 获取过往经历
     */
    @POST("?service=App.Employee_Employee.PastExperience")
    @FormUrlEncoded
    Call<Result<PaseExperienceList.DataBean>> getPaseExper(@FieldMap  HashMap<String, String> body);


    /**
     * 提交客观题
     */
    @POST("?service=App.ApplyJob_InterviewProgress.CommitBaseObjInfo")
    @FormUrlEncoded
    Call<Result> putCommitBaseObjInfo(@FieldMap  HashMap<String, String> body);

    /**
     * 提交其他问题
     */
    @POST("?service=App.ApplyJob_InterviewProgress.CommitBaseOtherInfo")
    @FormUrlEncoded
    Call<Result> putOtherQuerty(@FieldMap  HashMap<String, String> body);



    /**
     * 提交主观题
     */
    @POST("?service=App.ApplyJob_InterviewProgress.CommitBaseSubInfo")
    @FormUrlEncoded
    Call<Result> putBaseSubInfo(@FieldMap  HashMap<String, String> body);
    /**
     * 提交主观题分数
     */
    @POST("?service=App.ApplyJob_InterviewProgress.CommitBaseSubScoreInfo")
    @FormUrlEncoded
    Call<Result> putBaseSubInfoSocre(@FieldMap  HashMap<String, String> body);
    /**
     * 提交面试官
     */
    @POST("?service=App.ApplyJob_InterviewProgress.GetInterviewerByFlowid")
    @FormUrlEncoded
    Call<Result<List<CEO.DataBean>>> getCEO(@FieldMap  HashMap<String, String> body);



}
