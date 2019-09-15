package com.example.mvpdemo.Modules.Login

import com.example.mvpdemo.Base.ABSBasePresenter
import com.example.mvpdemo.Base.IBaseContract
import com.example.mvpdemo.Base.IResponseCallBack
import org.json.JSONObject

/**
 * Created by XiaoTong on 2019-09-12.
 */
interface ILoginContract: IBaseContract {

    interface ILoginModel: IBaseContract.IBaseModel {

        /**
         * 请求验证码
         * @param uid 用户名
         * @param pwd 密码
         * @param callBack 结果回调
         */
        fun req_verifyCode(uid: String, pwd: String, callBack: IResponseCallBack<JSONObject>)

        /**
         * 请求登录
         * @param uid 用户名
         * @param callBack 结果回调
         */
        fun req_login(uid: String, callBack: IResponseCallBack<LoginEntity>)

        /**
         * 请求登出
         * @param 结果回调
         */
        fun req_logout(callBack: IResponseCallBack<JSONObject>)
    }

    interface ILoginView: IBaseContract.IBaseView {
        /**
         * 登录成功
         */
        fun res_loginSuccess()

    }

    abstract class ABSLoginPresenter: ABSBasePresenter<ILoginModel, ILoginView>() {
        abstract fun getVerifyCode(uid: String, pwd: String)

        abstract fun login(uid: String)
    }


}