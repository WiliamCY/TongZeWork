package com.example.administrator.tongze.Fragment;


import android.annotation.SuppressLint;
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

import com.example.administrator.tongze.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class FragmentInterviewEvaluation extends Fragment {
    /***
     * 面试评价
     * */
    @BindView(R.id.containerss)
    FrameLayout ly_content;
    @BindView(R.id.ObjectiveQuestion)
    TextView ObjectiveQuestion;
    @BindView(R.id.OtherQuestions)
    TextView OtherQuestions;
    @BindView(R.id.subjectiveItem)
    TextView subjectiveItem;
    @BindView(R.id.FinalJudgment)
    TextView FinalJudgment;
    private FragmentObjectiveQuestion fragmentObjectiveQuestion;
    private FragmentOtherQuestions fragmentOtherQuestions;
    private FragmentsubjectiveItem fragmentsubjectiveItem;
    private FragmentFinalJudgment fragmentFinalJudgment;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Fragment mCurrentFragment;
    Unbinder unbinder;

    public FragmentInterviewEvaluation() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.interviewevaluation, container, false);
        unbinder = ButterKnife.bind(this, view);
        initFragment();
        return view;
    }
    private void initFragment(){
        ObjectiveQuestion.setSelected(true);
        fragmentManager = getChildFragmentManager();
        transaction = fragmentManager.beginTransaction();
        fragmentObjectiveQuestion = new FragmentObjectiveQuestion();
        if(!fragmentObjectiveQuestion.isAdded()){
            transaction.add(R.id.containerss, fragmentObjectiveQuestion);
        }
        transaction.commit();
        mCurrentFragment = fragmentObjectiveQuestion;

    }

    private void selected() {
        ObjectiveQuestion.setSelected(false);
        OtherQuestions.setSelected(false);
        subjectiveItem.setSelected(false);
        FinalJudgment.setSelected(false);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.ObjectiveQuestion, R.id.OtherQuestions, R.id.subjectiveItem, R.id.FinalJudgment})
    public void onViewClicked(View view) {
        Fragment lastFragment = mCurrentFragment;
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.ObjectiveQuestion:
                selected();
                ObjectiveQuestion.setSelected(true);
                if(fragmentObjectiveQuestion == null){
                    fragmentObjectiveQuestion = new FragmentObjectiveQuestion();
                }
                mCurrentFragment = fragmentObjectiveQuestion;
                break;
            case R.id.OtherQuestions:
                selected();
                OtherQuestions.setSelected(true);
                if(fragmentOtherQuestions == null){
                    fragmentOtherQuestions = new FragmentOtherQuestions();
                }
                mCurrentFragment = fragmentOtherQuestions;
                break;
            case R.id.subjectiveItem:
                selected();
                subjectiveItem.setSelected(true);
                if(fragmentsubjectiveItem == null){
                    fragmentsubjectiveItem = new FragmentsubjectiveItem();
                }
                mCurrentFragment = fragmentsubjectiveItem;
                break;
            case R.id.FinalJudgment:
                selected();
                FinalJudgment.setSelected(true);
                if(fragmentFinalJudgment == null){
                    fragmentFinalJudgment = new FragmentFinalJudgment();
                }
                mCurrentFragment = fragmentFinalJudgment;
                break;
        }
        if(lastFragment == null){
            transaction.add(R.id.containerss,mCurrentFragment);
        }else {
            if(lastFragment.isAdded()){
                transaction.hide(lastFragment);
            }
            if(mCurrentFragment.isAdded()){
                transaction.show(mCurrentFragment);
            }else {
                transaction.add(R.id.containerss,mCurrentFragment);
            }
        }
        transaction.commit();
    }
}
