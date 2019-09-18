package com.example.mvpdemo.Common.Modules.Login

import com.example.mvpdemo.Common.Base.ABSBasePresenter
import com.example.mvpdemo.Common.Base.IBaseContract
import com.example.mvpdemo.Common.Base.IResponseCallback

/**
 * Created by XiaoTong on 2019-09-12.
 */
interface ILoginContract : IBaseContract {

    interface ILoginModel : IBaseContract.IBaseModel {

        /**
         * 请求验证码
         * @param uid 用户名
         * @param pwd 密码
         * @param callback 结果回调
         */
        fun req_verifyCode(uid: String, pwd: String, callback: IResponseCallback): String

        /**
         * 请求登录
         * @param uid 用户名
         * @param callback 结果回调
         */
        fun req_login(uid: String, callback: IResponseCallback)

        /**
         * 请求登出
         * @param 结果回调
         */
        fun req_logout(callback: IResponseCallback)
    }

    interface ILoginView : IBaseContract.IBaseView {

    }

    abstract class ABSLoginPresenter : ABSBasePresenter<ILoginModel, ILoginView>() {
        abstract fun getVerifyCode(uid: String, pwd: String)

        abstract fun login(uid: String)
    }


}