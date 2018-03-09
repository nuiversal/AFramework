package org.domain.lzy.app.commonly;

import android.app.Application;
import android.content.Context;

import org.domain.lzy.app.commonly.di.component.AppComponent;

/**
 * 作者：zhengyang on 2018/3/9
 * 邮箱：lzy@winwayit.com.cn
 * 内容:AppDelegate 可以代理 Application 的生命周期,在对应的生命周期,执行对应的逻辑,因为 Java 只能单继承
 *      所以当遇到某些三方库需要继承于它的 Application 的时候,就只有自定义 Application 并继承于三方库的 Application
 *      这时就不用再继承 BaseApplication,只用在自定义Application中对应的生命周期调用AppDelegate对应的方法
 *      (Application一定要实现APP接口),框架就能照常运行
 * 注意:
 */

public class AppDelegate implements App ,AppLifecles{
    private Application mApplication;
    private AppComponent mAppComponent;

    protected ActivityLifecycle mActivityLifecycle;

    public AppDelegate(Context context){

    }

    @Override
    public AppComponent getAppComponent() {
        return null;
    }

    @Override
    public void attachBaseContext(Context base) {

    }

    @Override
    public void onCreate(Application application) {

    }

    @Override
    public void onTerminate(Application application) {

    }
}
