package org.lzy.app.commonly.application;


import android.os.Bundle;
import android.support.annotation.Nullable;

import org.domain.lzy.app.commonly.base.BaseActivity;

import app.lzy.app.commonly.application.R;




public class MainActivity extends BaseActivity<MainPresenter>{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);







    }
}
