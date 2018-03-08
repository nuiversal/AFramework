package org.domain.lzy.app.commonly.utils;

import android.content.Context;
import org.domain.lzy.app.commonly.App;
import org.domain.lzy.app.commonly.di.component.AppComponent;

/**
 * 作者：zhengyang on 2018/3/8
 * 邮箱：lzy@winwayit.com.cn
 * 内容:
 * 注意:
 */

public class ArmsUtils {

    public static AppComponent obtainAppComponentFromContext(Context context){
//        Preconditions.checkNotNull(context, "%s cannot be null", Context.class.getName());
//        Preconditions.checkState(context.getApplicationContext() instanceof App, "Application does not implements App");
        return ((App) context.getApplicationContext()).getAppComponent();
    }
}
