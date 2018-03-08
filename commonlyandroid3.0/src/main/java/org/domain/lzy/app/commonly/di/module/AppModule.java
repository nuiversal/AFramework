package org.domain.lzy.app.commonly.di.module;

import android.app.Application;

import dagger.Module;

/**
 * 作者：zhengyang on 2018/3/8
 * 邮箱：lzy@winwayit.com.cn
 * 内容: 提供一些框架必须的实例的 {@link dagger.Module}
 * 注意:
 */

@Module
public class AppModule {
    private Application mApplication;


    public AppModule(Application application){
        this.mApplication = application;
    }

    public Application provideApplication(){
        return this.mApplication;
    }
}
