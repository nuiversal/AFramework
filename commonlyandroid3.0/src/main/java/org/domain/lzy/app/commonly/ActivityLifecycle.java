package org.domain.lzy.app.commonly;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import javax.inject.Singleton;

/**
 * 作者：zhengyang on 2018/3/9
 * 邮箱：lzy@winwayit.com.cn
 * 内容:{@link Application.ActivityLifecycleCallbacks} 默认实现类
 * 通过 {@link /ActivityDelegate} 管理 {@link android.app.Activity}
 * 注意:
 */

@Singleton
public class ActivityLifecycle implements Application.ActivityLifecycleCallbacks{
    private AppManager mAppManager;
    private Application mApplication;




    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
