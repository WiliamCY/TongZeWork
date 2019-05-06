package com.example.administrator.tongze.Activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.tongze.R;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImageViewActivity extends AppCompatActivity {
    @BindView(R.id.bat_back)
    ImageView batBack;
    @BindView(R.id.bar_name)
    TextView barName;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_activity);
        ButterKnife.bind(this);
        imageView = findViewById(R.id.imageview);
        String path = getIntent().getStringExtra("uri");
        String name = getIntent().getStringExtra("name");
        barName.setText(name);
        Glide.with(this).load(path).into(imageView);
    }

    @OnClick({R.id.bat_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bat_back:
                finish();
                break;

        }
    }
}
