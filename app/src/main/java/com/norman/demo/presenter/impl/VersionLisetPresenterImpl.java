package com.norman.demo.presenter.impl;

import com.norman.demo.configuration.CommonPrompt;
import com.norman.demo.entity.Version;
import com.norman.demo.listener.DataFinishedListener;
import com.norman.demo.manager.VersionListManager;
import com.norman.demo.manager.impl.VersionListManagerImpl;
import com.norman.demo.presenter.VersionListPresenter;
import com.norman.demo.viewimpl.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2016/3/23.
 */
public class VersionLisetPresenterImpl implements VersionListPresenter,DataFinishedListener<List<Version>> {

    private BaseView bv;
    private VersionListManager lm;

    public VersionLisetPresenterImpl(BaseView bv){
        this.bv = bv;
        lm = new VersionListManagerImpl();
    }

    @Override
    public void onSuccess(List<Version> versions) {
        bv.onSuccess(versions);
    }

    @Override
    public void onFailed() {
        bv.onFailed(CommonPrompt.ERROR);
    }

    @Override
    public void getData(int page) {
        lm.getData(page,this);
    }
}
