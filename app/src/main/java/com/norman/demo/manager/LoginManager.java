package com.norman.demo.manager;

import com.norman.demo.listener.DataFinishedListener;

/**
 * 登录接口
 */
public interface LoginManager {
    void login(String userName, String userPwd,final DataFinishedListener listener);
}

