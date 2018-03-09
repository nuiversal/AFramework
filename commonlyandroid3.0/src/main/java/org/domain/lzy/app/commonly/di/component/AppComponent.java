package org.domain.lzy.app.commonly.di.component;

import android.app.Application;
import android.content.Context;

import org.domain.lzy.app.commonly.AppDelegate;
import org.domain.lzy.app.commonly.AppManager;
import org.domain.lzy.app.commonly.di.module.AppModule;
import org.domain.lzy.app.commonly.utils.ArmsUtils;

import dagger.Component;

/**
 * 作者：zhengyang on 2018/3/8
 * 邮箱：lzy@winwayit.com.cn
 * 内容:
 *      ================================================
 *          可通过 {@link ArmsUtils#obtainAppComponentFromContext(Context)} 拿到此接口的实现类
 *          拥有此接口的实现类即可调用对应的方法拿到 Dagger 提供的对应实例
 * 注意:  , ClientModule.class, GlogalConfigModule.class
 */
@Component(modules = {AppModule.class})
public interface AppComponent  {
    Application application();

    AppManager appManager();



    void inject(AppDelegate delegate);
}
