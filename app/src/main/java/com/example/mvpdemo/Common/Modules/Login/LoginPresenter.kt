package com.example.mvpdemo.Common.Modules.Login

import com.example.mvpdemo.Common.Base.IBaseContract
import com.example.mvpdemo.Common.Base.IResponseCallBack
import org.json.JSONObject

/**
 * Created by XiaoTong on 2019-09-14.
 */
abstract class LoginPresenter: IBaseContract.IBasePresenter<ILoginContract.ILoginModel, ILoginContract.ILoginView>,
    ILoginContract.ABSLoginPresenter() {


    override fun getVerifyCode(uid: String, pwd: String) {
        if (isAttached()) {
            getView()?.showLoading()
            getModel()?.req_verifyCode(uid, pwd, object: IResponseCallBack {
                override fun commonCallBack(isSuccess: Boolean, content: Any?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })
        }
    }

    override fun login(uid: String) {
        if (isAttached()) {
            getView()?.showLoading()

        }
    }


}