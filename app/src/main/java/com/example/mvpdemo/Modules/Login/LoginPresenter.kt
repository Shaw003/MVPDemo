package com.example.mvpdemo.Modules.Login

import com.example.mvpdemo.Base.CommonCallBack
import com.example.mvpdemo.Base.IBaseContract
import com.example.mvpdemo.Base.IResponseCallBack
import org.json.JSONObject

/**
 * Created by XiaoTong on 2019-09-14.
 */
abstract class LoginPresenter: IBaseContract.IBasePresenter<ILoginContract.ILoginModel, ILoginContract.ILoginView>,
    ILoginContract.ABSLoginPresenter() {


    override fun getVerifyCode(uid: String, pwd: String) {
        if (isAttached()) {
            getView()?.showLoading()
            getModel()?.req_verifyCode(uid, pwd, object: IResponseCallBack<JSONObject> {
                override fun onSuccess(response: JSONObject?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onFailure(error: Error) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun commonCallBack(isSuccess: Boolean, content: Any) {

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