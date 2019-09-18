package com.example.mvpdemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mvpdemo.App.AppBaseActivity
import com.example.mvpdemo.Common.Base.IBaseContract
import com.example.mvpdemo.Common.Global.GlobalEvent
import com.example.mvpdemo.Common.Modules.Login.ILoginContract
import com.example.mvpdemo.Common.Modules.Login.LoginModel
import com.example.mvpdemo.Common.Modules.Login.LoginPresenter

class MainActivity : AppBaseActivity(), ILoginContract.ILoginView {
    override fun getView(): IBaseContract.IBaseView {
        return this
    }

    override fun createMode(): IBaseContract.IBaseModel {
        return LoginModel()
    }

    override fun initData() {
        (mPresenter as? LoginPresenter)?.getVerifyCode("123", "abc")
    }

    override fun initPresenter() {
        mPresenter = LoginPresenter()
    }

    override fun initView() {

    }

    override fun initLayout(): Int {
        return R.layout.activity_main
    }

    override fun showLoading() {
        Toast.makeText(this,"showLoading",Toast.LENGTH_SHORT).show()
    }

    override fun dismissLoading() {
        Toast.makeText(this,"dismissLoading",Toast.LENGTH_SHORT).show()
    }

    override fun toast(msg: String) {
        Toast.makeText(this,"toast",Toast.LENGTH_SHORT).show()
    }

    override fun getContext(): Context {
        return this
    }

}
