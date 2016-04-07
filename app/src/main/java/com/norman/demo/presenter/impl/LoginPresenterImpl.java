package com.norman.demo.presenter.impl;

import android.text.TextUtils;
import com.norman.demo.configuration.CommonPrompt;
import com.norman.demo.entity.Version;
import com.norman.demo.listener.DataFinishedListener;
import com.norman.demo.manager.LoginManager;
import com.norman.demo.manager.impl.LoginManagerImpl;
import com.norman.demo.presenter.LoginPresenter;
import com.norman.demo.viewimpl.BaseView;

/**
 * 登录控制器
 */
public class LoginPresenterImpl implements LoginPresenter,DataFinishedListener<Version> {

    private BaseView bv;
    private LoginManager lm;

    public LoginPresenterImpl(BaseView bv){
        this.bv = bv;
        lm = new LoginManagerImpl();
    }

    @Override
    public void login(String userName, String userPwd) {
        if(TextUtils.isEmpty(userName)) bv.hideProgress();

        if(TextUtils.isEmpty(userPwd)) bv.hideProgress();

        bv.showProgress();
        lm.login(userName, userPwd, this);
    }

    @Override
    public void onSuccess(Version o) {
        bv.hideProgress();
        bv.onSuccess(o);
    }

    @Override
    public void onFailed() {
        bv.hideProgress();
        bv.onFailed(CommonPrompt.ERROR);
    }
}
