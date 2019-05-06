package com.example.administrator.tongze.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.administrator.tongze.Fragment.FragmentInterviewEvaluation;
import com.example.administrator.tongze.Fragment.FragmentPersonalInformation;
import com.example.administrator.tongze.GeTui.GeTuiService;
import com.example.administrator.tongze.GeTui.IntentService;
import com.example.administrator.tongze.GeTui.PushService;
import com.example.administrator.tongze.R;
import com.igexin.sdk.PushManager;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserMessageActivity extends BaseTemplateActivity implements RadioGroup.OnCheckedChangeListener {
    private GeTuiService getuiBroadcast;
    private IntentFilter intentFilter;
    @BindView(R.id.BasicInformationButton)
    RadioButton BasicInformationButton;
    @BindView(R.id.PersonalInformationButton)
    RadioButton PersonalInformationButton;
    @BindView(R.id.exitMain)
    ImageView exitMain;
    @BindView(R.id.rd_group)
    RadioGroup rpTab;
    @BindView(R.id.fragment_container)
    FrameLayout fragmentContainer;
    private FragmentInterviewEvaluation fragmentTwo;
    private FragmentPersonalInformation fragmentOne;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private long mExitTime;
    public final static String ACTION_EXIT_SYSTEM = "sys_exit";
    private Intent intent;
    private Bundle bundle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usermessage);
        ButterKnife.bind(this);
        StatusBarUtil.setTransparent(this);
        getuiBroadcast = new GeTuiService();
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.tongze.GETUI");
        PushManager.getInstance().initialize(this,PushService.class);
        PushManager.getInstance().registerPushIntentService(this, IntentService.class);
         intent = getIntent();
         bundle = intent.getBundleExtra("Message");
        BasicInformationButton.setChecked(true);
        rpTab.setOnCheckedChangeListener(this);
        initFragment();
        }
        private void initFragment(){
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
            fragmentOne = new FragmentPersonalInformation(bundle);
            transaction.add(R.id.fragment_container,fragmentOne);
            transaction.commit();
            }


    @OnClick({ R.id.exitMain})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.exitMain:
                finish();
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId){
            case R.id.BasicInformationButton:

                FragmentTransaction ft1 = manager.beginTransaction();
                hideAll(ft1);
                if(fragmentOne != null){
                    ft1.show(fragmentOne);
                }else {
                    fragmentOne = new FragmentPersonalInformation(bundle);
                    ft1.add(R.id.fragment_container,fragmentOne);
                }
                ft1.commit();
                break;
            case R.id.PersonalInformationButton:
                FragmentTransaction ft2 = manager.beginTransaction();
                hideAll(ft2);
                if(fragmentTwo != null){
                    ft2.show(fragmentTwo);
                }else {
                    fragmentTwo = new FragmentInterviewEvaluation();
                    ft2.add(R.id.fragment_container,fragmentTwo);
                }
                ft2.commit();
                break;
        }

    }
    private void hideAll(FragmentTransaction ft){
        if (ft==null){
            return;
        }
        if (fragmentOne!=null){
            ft.hide(fragmentOne);
        }
        if (fragmentTwo!=null){
            ft.hide(fragmentTwo);
        }

    }
    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(getuiBroadcast, intentFilter);
    }


}
