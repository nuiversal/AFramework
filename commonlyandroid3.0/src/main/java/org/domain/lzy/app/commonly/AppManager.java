package org.domain.lzy.app.commonly;

import android.app.Activity;
import android.app.Application;
import android.os.Message;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;
import org.simple.eventbus.ThreadMode;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import timber.log.Timber;

/**
 * 作者：zhengyang on 2018/3/8
 * 邮箱：lzy@winwayit.com.cn
 * 内容:
 * 注意:
 */
@Singleton
public final class AppManager {
    protected final String TAG = this.getClass().getSimpleName();
    public static final String APPMANAGER_MESSAGE = "appmanager_message";
    public static final int START_ACTIVITY = 5000;
    public static final int SHOW_SNACKBAR = 5001;
    public static final int KILL_ALL = 5002;
    public static final int APP_EXIT = 5003;
    private Application mApplication;

    /*管理所有存活Activity,容器中的顺序仅仅是Activity的参加顺序,
        并不能保证和Activity任务栈一致.
     */
    public List<Activity> mActivityList;

    //当前在前台的Activity
    private Activity mCurrentActivity;

    private HandlerListener mHandlerListener;

    @Inject
    public AppManager(Application application){
        this.mApplication = application;
        EventBus.getDefault().register(this);
    }

    /**
     * 通过 {@link EventBus#post(Object)} 事件, 远程遥控执行对应方法
     * 可通过 {@link #setHandleListener(HandlerListener)}, 让外部可扩展新的事件
     */
    @Subscriber(tag = APPMANAGER_MESSAGE,mode = ThreadMode.MAIN)
    public void onReceive(Message message){
        switch (message.what){
            case START_ACTIVITY:
                if (message.obj == null) break;
                dispatchStart(message);
                break;
            case SHOW_SNACKBAR:
                if (message.obj == null) break;
                showSnackbar((String) message.obj,message.arg1==0?false:true);
                break;
            case KILL_ALL:
                killAll();
                break;
            case APP_EXIT:
                appExit();
                break;
            default:
                Timber.tag(TAG).w("The message.what not match");
                break;
                
        }
        if (mHandlerListener != null){
            mHandlerListener.handleMessage(this,message);
        }
    }

    private void appExit() {
    }

    private void killAll() {
    }


    private void showSnackbar(String message,boolean isLong){

    }

    private void dispatchStart(Message message) {




    }

    public void setHandleListener(HandlerListener handleListener) {
        this.mHandlerListener = handleListener;
    }

    public interface HandlerListener {
        void handleMessage(AppManager appManager, Message message);
    }
}
