package org.domain.lzy.app.commonly;

import android.os.Bundle;

/**
 * 作者：zhengyang on 2018/3/9
 * 邮箱：lzy@winwayit.com.cn
 * 内容:
 * 注意:
 */

public interface ActivityDelegate {
    String LAYOUT_LINEARLAYOUT = "LinearLayout";
    String LAYOUT_FRAMELAYOUT = "FrameLayout";
    String LAYOUT_RELATIVELAYOUT = "RelativeLayout";
    String ACTIVITY_DELEGATE = "activity_delegate";

    void onCreate(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onSaveInstanceState(Bundle outState);

    void onDestroy();
}
