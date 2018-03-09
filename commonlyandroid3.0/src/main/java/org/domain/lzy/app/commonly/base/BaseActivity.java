package org.domain.lzy.app.commonly.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

import org.domain.lzy.app.commonly.AppManager;

import javax.inject.Inject;

/**
 * 作者：zhengyang on 2018/3/1
 * 邮箱：lzy@winwayit.com.cn
 * 内容:
 * 注意:
 */

public class BaseActivity extends AppCompatActivity{
    @Inject
    AppManager appManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("TAG","框架启动:" + new Gson());
        appManager.getMessage();
    }
}
