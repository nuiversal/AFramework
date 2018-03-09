package org.domain.lzy.app.commonly;

import android.app.Application;
import android.content.Context;

/**
 * 作者：zhengyang on 2018/3/9
 * 邮箱：lzy@winwayit.com.cn
 * 内容: 用于代理 {@link android.app.Application} 的生命周期
 * 注意:
 */

public interface AppLifecles {
    void attachBaseContext(Context base);

    void onCreate(Application application);

    void onTerminate(Application application);
}
