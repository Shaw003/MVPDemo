package com.example.mvpdemo.App.Modules.Login;

import com.example.mvpdemo.App.AppBaseActivity;
import com.example.mvpdemo.Common.Base.IBaseContract;
import com.example.mvpdemo.Common.Modules.Login.LoginModel;
import com.example.mvpdemo.Common.Modules.Login.LoginPresenter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by XiaoTong on 2019-09-15.
 */
public class LoginActivity extends AppBaseActivity {

    @Override
    protected void initData() {

    }

    @Override
    protected void initPresenter() {
        mPresenter = new LoginPresenter();
        login();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int initLayout() {
        return 0;
    }


    @NotNull
    @Override
    public IBaseContract.IBaseModel createMode() {
        return new LoginModel();
    }

    private void login() {

        ((LoginPresenter)mPresenter).getVerifyCode("123", "abc");
    }

    @NotNull
    @Override
    public IBaseContract.IBaseView getView() {
        return null;
    }
}
