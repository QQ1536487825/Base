package com.example.basicframework.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.example.basicframework.R;
import com.example.basicframework.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.text)
    TextView text;

    @Override
    public int intiLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

}
