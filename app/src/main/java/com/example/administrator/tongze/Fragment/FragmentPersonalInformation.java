package com.example.administrator.tongze.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.administrator.tongze.Activity.MainActivity;
import com.example.administrator.tongze.R;
import com.example.administrator.tongze.Utils.AlertDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


@SuppressLint("ValidFragment")
public class FragmentPersonalInformation extends Fragment {
    /***
     * 个人信息
     * */
    @BindView(R.id.fragment_containerss)
    FrameLayout ly_content;
    @BindView(R.id.BasicInformation)
    TextView BasicInformation;
    @BindView(R.id.PastExperience)
    TextView PastExperience;
    @BindView(R.id.ResumeAattachments)
    TextView ResumeAattachments;
    @BindView(R.id.pass)
    TextView pass;
    private FragmentBasicInformation fragmentBasicInformation;
    private FragmentPastExperience fragmentPastExperience;
    private FragmentResumeAattachments fragmentResumeAattachments;
    private FragmentManager fragmentManager;
    private  FragmentTransaction transaction;
    private Fragment mCurrentFragment;
    Unbinder unbinder1;
    private Intent intent;
    private Bundle bundle;

    public FragmentPersonalInformation(Bundle bundle) {
       this.bundle = bundle;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personalinformation, container, false);
        unbinder1 = ButterKnife.bind(this, view);
        initFragment();
        return view;
    }
    private void initFragment(){
        BasicInformation.setSelected(true);
        fragmentManager = getChildFragmentManager();
        transaction = fragmentManager.beginTransaction();
        fragmentBasicInformation = new FragmentBasicInformation(bundle);
        if(!fragmentBasicInformation.isAdded()){
            transaction.add(R.id.fragment_containerss, fragmentBasicInformation);
        }
        transaction.commit();
   mCurrentFragment = fragmentBasicInformation;

    }

    private void selected() {
        BasicInformation.setSelected(false);
        PastExperience.setSelected(false);
        ResumeAattachments.setSelected(false);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
    }

    @OnClick({R.id.BasicInformation, R.id.PastExperience, R.id.ResumeAattachments, R.id.pass})
    public void onViewClicked(View view) {
Fragment lastFragment = mCurrentFragment;
FragmentManager fm = getActivity().getSupportFragmentManager();
FragmentTransaction transaction = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.BasicInformation:
                selected();
                BasicInformation.setSelected(true);
              if(fragmentBasicInformation == null){
                  fragmentBasicInformation = new FragmentBasicInformation(bundle);
              }
              mCurrentFragment = fragmentBasicInformation;
                break;
            case R.id.PastExperience:
                selected();
                PastExperience.setSelected(true);
                if(fragmentPastExperience == null){
                    fragmentPastExperience = new FragmentPastExperience();
                }
                mCurrentFragment = fragmentPastExperience;
                break;
            case R.id.ResumeAattachments:
                selected();
                ResumeAattachments.setSelected(true);
           if(fragmentResumeAattachments == null){
               fragmentResumeAattachments = new FragmentResumeAattachments();
           }
           mCurrentFragment = fragmentResumeAattachments;
                break;
            case R.id.pass:
                new AlertDialog(getActivity()).builder().setMsg("确定要淘汰这货吗?").
                        setPositiveButton("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(getActivity(),MainActivity.class);
                                startActivity(intent);
                                getActivity().finish();
                            }
                        }).setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }).show();
                break;
        }
        if(lastFragment == null){
            transaction.add(R.id.fragment_containerss,mCurrentFragment);
        }else {
            if(lastFragment.isAdded()){
                transaction.hide(lastFragment);
            }
            if(mCurrentFragment.isAdded()){
                transaction.show(mCurrentFragment);
            }else {
                transaction.add(R.id.fragment_containerss,mCurrentFragment);
            }
        }
            transaction.commit();
    }
}
