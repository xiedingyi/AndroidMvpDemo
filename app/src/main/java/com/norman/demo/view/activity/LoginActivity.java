package com.norman.demo.view.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.norman.demo.R;
import com.norman.demo.entity.Version;
import com.norman.demo.presenter.LoginPresenter;
import com.norman.demo.presenter.impl.LoginPresenterImpl;
import com.norman.demo.view.BaseActivity;
import com.norman.demo.viewimpl.BaseView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Administrator on 2016/3/18.
 */
public class LoginActivity extends BaseActivity implements BaseView<Version> {
    @Bind(R.id.DF)
    TextView DF;

    LoginPresenter lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
        lm = new LoginPresenterImpl(this);
        lm.login("", "");

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onFailed(String Str) {

    }

    @OnClick(R.id.DF)
    public void onClick() {
    }

    @Override
    public void onSuccess(Version str) {

    }
}
