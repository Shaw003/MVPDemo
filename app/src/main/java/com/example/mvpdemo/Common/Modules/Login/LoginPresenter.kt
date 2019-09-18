package com.example.mvpdemo.Common.Modules.Login

import android.util.Log
import com.example.mvpdemo.Common.Base.ABSBasePresenter
import com.example.mvpdemo.Common.Base.IBaseContract

/**
 * Created by XiaoTong on 2019-09-14.
 */
class LoginPresenter: IBaseContract.IBasePresenter<ILoginContract.ILoginModel, ILoginContract.ILoginView>,
    ILoginContract.ABSLoginPresenter() {

    private var reqID_getVerifyCode: String? = ""

    override fun getVerifyCode(uid: String, pwd: String) {
        if (isAttached()) {
            getView()?.showLoading()
            reqID_getVerifyCode = getModel()?.req_verifyCode(uid, pwd, this)
        }
    }

    override fun login(uid: String) {
        if (isAttached()) {
            getView()?.showLoading()

        }
    }

    /**
     * LoginPresenter中重载的BasePresenter实现的IResponseCallback中定义的成功回调
     */
    override fun onSuccess(requestID: String, response: Any?) {
        super.onSuccess(requestID, response)
        System.out.println("LoginPresenter中重载的BasePresenter实现的IResponseCallback中定义的成功回调")
        when (requestID) {
            reqID_getVerifyCode -> print("getVerifyCode的成功处理")
        }
    }

    /**
     * LoginPresenter中重载的BasePresenter实现的IResponseCallback中定义的失败回调
     */
    override fun onFailure(requestID: String, error: java.lang.Exception) {
        super.onFailure(requestID, error)
        System.out.println("LoginPresenter中重载的BasePresenter实现的IResponseCallback中定义的失败回调")
        when (requestID) {
            reqID_getVerifyCode -> print("getVerifyCode的失败处理")
        }
    }
}