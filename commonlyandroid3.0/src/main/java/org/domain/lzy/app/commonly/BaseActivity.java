package org.domain.lzy.app.commonly;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

/**
 * 作者：zhengyang on 2018/3/1
 * 邮箱：lzy@winwayit.com.cn
 * 内容:
 * 注意:
 */

public class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("TAG","框架启动:" + new Gson());
    }
}
