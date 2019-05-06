package com.example.administrator.tongze.Activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.tongze.Entiy.Result;
import com.example.administrator.tongze.GeTui.GeTuiService;
import com.example.administrator.tongze.GeTui.IntentService;
import com.example.administrator.tongze.GeTui.PushService;
import com.example.administrator.tongze.List.LoginList;
import com.example.administrator.tongze.R;
import com.example.administrator.tongze.Retrofit.RetrofitUtil;
import com.example.administrator.tongze.Utils.SignGenerate;
import com.example.administrator.tongze.Utils.util;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.igexin.sdk.PushManager;
import com.jaeger.library.StatusBarUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class LoginActivity extends BaseTemplateActivity {
    private GeTuiService getuiBroadcast;
    private IntentFilter intentFilter;
    private String TAG = "LoginActivity";
    @BindView(R.id.login_user_phone)
    EditText loginUserPhone;
    @BindView(R.id.login_user_code)
    EditText loginUserCode;
    @BindView(R.id.login_getCode)
    Button loginGetCode;
    @BindView(R.id.login_button)
    Button loginButton;
    @BindView(R.id.text)
    Button text;
    private String phone, code;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        StatusBarUtil.setTransparent(this);
        getuiBroadcast = new GeTuiService();
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.tongze.GETUI");
        PushManager.getInstance().initialize(this,PushService.class);
        PushManager.getInstance().registerPushIntentService(this, IntentService.class);
        XXPermissions.with(this)
                .permission(Permission.Group.STORAGE, Permission.Group.CAMERA)
                .request(new OnPermission() {

                    @Override
                    public void hasPermission(List<String> granted, boolean isAll) {
                        if (isAll) {

                        }else {
                            Toast.makeText(getApplicationContext(), "获取权限成功，部分权限未正常授予", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void noPermission(List<String> denied, boolean quick) {
                        if(quick) {
                            Toast.makeText(getApplicationContext(), "被永久拒绝授权，请手动授予权限", Toast.LENGTH_SHORT).show();
                            XXPermissions.gotoPermissionSettings(getApplicationContext());
                        }else {
                            Toast.makeText(getApplicationContext(), "获取权限失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }



    @OnClick({R.id.login_getCode, R.id.login_button,R.id.text})
    public void onViewClicked(View view) {
        initDatas();
        switch (view.getId()) {
            case R.id.login_getCode:
                if (phone.isEmpty()) {
                    Toast toast = Toast.makeText(this, "请输入完整手机号！", Toast.LENGTH_LONG);
                    util.showMyToast(toast, 500);
                } else if (!util.isMobileNO(phone)) {
                    Toast toast = Toast.makeText(this, "输入手机号不正确！", Toast.LENGTH_LONG);
                    util.showMyToast(toast, 500);
                } else {

                    getCode(phone);
                }
                break;
            case R.id.login_button:
                if (phone.isEmpty() || code.isEmpty()) {
                    Toast toast = Toast.makeText(this, "请输入完整", Toast.LENGTH_LONG);
                    util.showMyToast(toast, 500);
                } else if (!util.isMobileNO(phone)) {
                    Toast toast = Toast.makeText(this, "请检查手机格式", Toast.LENGTH_LONG);
                    util.showMyToast(toast, 500);
                } else if (code.isEmpty()) {
                    Toast toast = Toast.makeText(this, "验证码不能为空", Toast.LENGTH_LONG);
                    util.showMyToast(toast, 500);
                } else {
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.text:

        }
    }

    private void initDatas() {
        phone = loginUserPhone.getText().toString();
        code = loginUserCode.getText().toString();
    }

    private void getCode(String phone)  {
        HashMap<String, String> body = new HashMap<>();
        body.put("sign", "1111");
        body.put("username",phone);
        RetrofitUtil.getService().getCode(body).enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Response<Result> response, Retrofit retrofit) {
                Result result = response.body();
                if(result.getRet() == 200){
                    showToast("发送成功");
                }else if(result.getRet()==410) {
                    showToast(result.getMsg());
                }else {
                    showToast("发送失败");
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }




        });


    }
    private void Login(String phone,String code) {
   final HashMap<String,String> body = new HashMap<>();
       body.put("username",phone);
       body.put("auth_code",code);
       body.put("sign", SignGenerate.generate(body));
       RetrofitUtil.getService().login(body).enqueue(new Callback<Result<LoginList.DataBean>>() {
       @Override
       public void onResponse(Response<Result<LoginList.DataBean>> response, Retrofit retrofit) {
           Result result = response.body();
           if(result.getRet() == 200){
                LoginList.DataBean bean = (LoginList.DataBean) result.getData();
               showToast("登录成功");
               Intent intent = new Intent(getApplicationContext(), MainActivity.class);
               intent.putExtra("user_id",bean.getUser_id());
               intent.putExtra("token",bean.getToken());
               startActivity(intent);
               finish();
           }else if(result.getRet()==410) {
               showToast(result.getMsg());
           }else {
               showToast("登录失败");
           }
       }

       @Override
       public void onFailure(Throwable t) {

       }
   });

    }
    long firstTime = 0;
    //双击退出
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            long secondTime = System.currentTimeMillis();
            if (secondTime-firstTime>2000){
                Toast.makeText(this,"再按一次退出",Toast.LENGTH_SHORT).show();
                firstTime = System.currentTimeMillis();
                return true;
            }else {
                finish();
            }
        }
        return super.onKeyUp(keyCode, event);
    }
    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(getuiBroadcast, intentFilter);
    }

}
