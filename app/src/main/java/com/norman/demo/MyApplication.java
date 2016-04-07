package com.norman.demo;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/3/21.
 */
public class MyApplication extends Application {

    private static MyApplication mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
      //  OkHttpUtils.debug(true, "MyOkHttp");    //是否打开调试
        mInstance = this;
    }

    /**
     * 初始化
     * @return
     */
    public static Context getInstance() {
        return mInstance;
    }



}
