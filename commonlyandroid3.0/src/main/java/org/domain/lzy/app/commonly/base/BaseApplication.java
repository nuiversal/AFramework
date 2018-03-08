package org.domain.lzy.app.commonly.base;

import android.app.Application;
import android.content.Context;

import org.domain.lzy.app.commonly.App;
import org.domain.lzy.app.commonly.di.component.AppComponent;

/**
 * 作者：zhengyang on 2018/3/1
 * 邮箱：lzy@winwayit.com.cn
 * 内容: 本框架由 MVP + Dagger2 + Retrofit + RxJava + Androideventbus + Butterknife 组成
 * 注意: 在使用本框架时,需要了解上面框架的api及开发思想
 */

public class BaseApplication extends Application implements App {
    @Override
    public void onCreate() {
        super.onCreate();

    }

    /**
     * 这里会在 {@link BaseApplication#onCreate} 之前被调用,可以做一些较早的初始化
     * 常用于 MultiDex 以及插件化框架的初始化
     * @param base 上下文
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }


    /**
     * 在模拟环境中程序终止时会被调用
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public AppComponent getAppComponent() {



        return null;
    }
}
