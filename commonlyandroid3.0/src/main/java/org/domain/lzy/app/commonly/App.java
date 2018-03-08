package org.domain.lzy.app.commonly;

import org.domain.lzy.app.commonly.di.component.AppComponent;

import io.reactivex.annotations.NonNull;

/**
 * 作者：zhengyang on 2018/3/8
 * 邮箱：lzy@winwayit.com.cn
 * 内容:
 * 注意:
 */

public interface App {
    @NonNull
    AppComponent getAppComponent();
}
