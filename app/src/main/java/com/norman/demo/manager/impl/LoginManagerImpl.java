package com.norman.demo.manager.impl;

import com.norman.demo.listener.DataFinishedListener;
import com.norman.demo.manager.LoginManager;

/**
 * 登录接口
 */
public class LoginManagerImpl implements LoginManager {


    @Override
    public void login(String userName, String userPwd, final DataFinishedListener listener) {
//        OkHttpUtils.post("http://192.168.0.118:8080/LFHAPI/clientapi.ashx?action=99999&VType=1&VChannl=fuwuqi")
//                .tag(this)
//                .execute(new BeanCallBack<ApiResponse<Version>>() {
//                    @Override
//                    public void onResponse(ApiResponse<Version> versionInfo) {
//                        if(versionInfo.getEvents().equals("0"));
//                       //     listener.onSuccess(versionInfo.getObjs());
//                    }
//
//                    @Override
//                    public void onError(Request request, @Nullable Response response, @Nullable Exception e) {
//                        super.onError(request, response, e);
//                        listener.onFailed();
//                    }
//                });
    }
}

