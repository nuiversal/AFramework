package org.domain.lzy.app.commonly.base;

import android.arch.lifecycle.LifecycleObserver;

import org.domain.lzy.app.commonly.AppManager;
import org.domain.lzy.app.commonly.IModel;
import org.domain.lzy.app.commonly.IPresenter;
import org.domain.lzy.app.commonly.IView;

import javax.inject.Inject;

/**
 * 作者：zhengyang on 2018/3/8
 * 邮箱：lzy@winwayit.com.cn
 * 内容:
 * 注意:
 */

public class BasePresenter <M extends IModel,V extends IView> implements IPresenter,LifecycleObserver {

    @Inject
    AppManager appManager;






}
