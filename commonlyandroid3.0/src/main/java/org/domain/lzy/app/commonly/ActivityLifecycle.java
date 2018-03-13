package org.domain.lzy.app.commonly;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import java.util.List;

import javax.inject.Inject;
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
    private Cache<String,Object> mExtras;
    private FragmentManager.FragmentLifecycleCallbacks mFragmentLifecles;
    private List<FragmentManager.FragmentLifecycleCallbacks> mFragmentLifecycles;
    @Inject
    public ActivityLifecycle(AppManager appManager,Application application,Cache<String,Object> mExtras){
        this.mAppManager = appManager;
        this.mApplication = application;
        this.mExtras = mExtras;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        //如果 intent 包含了此字段,并且为 true 说明不加入到 list 进行统一管理
        boolean isNotAdd = false;
        Intent activityIntent = activity.getIntent();
        if (activityIntent!=null){
            isNotAdd = activityIntent.getBooleanExtra(AppManager.IS_NOT_ADD_ACTIVITY_LIST,false);
        }
        if (!isNotAdd) mAppManager.addActivity(activity);
        if (activity instanceof IActivity){
            ActivityDelegate activityDelegate = fetchActivityDelegate(activity);
            if (activityDelegate == null) {
                Cache<String, Object> cache = getCacheFromActivity((IActivity) activity);
                activityDelegate = new ActivityDelegateImpl(activity);
                cache.put(ActivityDelegate.ACTIVITY_DELEGATE, activityDelegate);
            }
            activityDelegate.onCreate(savedInstanceState);
        }
        registerFragmentCallbacks(activity);
    }

    /**
     * 给每个 Activity 的所有 Fragment 设置监听其生命周期, Activity 可以通过 {@link IActivity#useFragment()}
     * 设置是否使用监听,如果这个 Activity 返回 false 的话,这个 Activity 下面的所有 Fragment 将不能使用 {@link FragmentDelegate}
     * 意味着 {@link org.domain.lzy.app.commonly.base.BaseFragment} 也不能使用
     *
     * @param activity
     */
    private void registerFragmentCallbacks(Activity activity) {
        if (!(activity instanceof  FragmentActivity))  return;
        if (activity instanceof IActivity ? ((IActivity) activity).useFragment():true){
            if (mFragmentLifecles == null){
                //Fragment 生命周期实现类, 用于框架内部对每个 Fragment 的必要操作, 如给每个 Fragment 配置 FragmentDelegate
                mFragmentLifecles = new FragmentLifecycle();
            }
            ((FragmentActivity)activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(mFragmentLifecles,true);

//            if (mFragmentLifecycles == null && mExtras.containsKey(ConfigM)){

//            }
        }
    }

    private ActivityDelegate fetchActivityDelegate(Activity activity) {
        ActivityDelegate activityDelegate = null;
        Cache<String, Object> cache = getCacheFromActivity((IActivity) activity);
        activityDelegate = (ActivityDelegate) cache.get(ActivityDelegate.ACTIVITY_DELEGATE);
        return activityDelegate;
    }

    private Cache<String,Object> getCacheFromActivity(IActivity activity) {
        Cache<String, Object> cache = activity.provideCache();
//        Preconditions.checkNotNull(cache, "%s cannot be null on Activity", Cache.class.getName());
        return cache;
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
