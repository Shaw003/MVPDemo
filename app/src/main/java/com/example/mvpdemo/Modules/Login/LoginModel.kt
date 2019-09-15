package com.example.mvpdemo.Modules.Login

import com.example.mvpdemo.Base.IResponseCallBack
import com.example.mvpdemo.Global.ErrorReason
import com.example.mvpdemo.Global.GlobalError
import com.example.mvpdemo.Network.CommonParams
import org.json.JSONObject

/**
 * Created by XiaoTong on 2019-09-12.
 */

class LoginModel: ILoginContract.ILoginModel {


    override fun req_verifyCode(uid: String, pwd: String,
                                callBack: IResponseCallBack<JSONObject>) {

        val params = CommonParams.create()
        val tmpParams = mapOf("uid" to uid, "pwd" to pwd)
        params.put("data", tmpParams)
        // TODO 网络请求
        // TODO 回调
        // TODO 处理成功
        callBack.onSuccess(null)


        val error = GlobalError.Error.reason(ErrorReason.notReachable)
        callBack.onFailure(error)

        val error1 = GlobalError.Error.reason(ErrorReason.illegalDevice)
        val error2 = GlobalError.Error.handleErrorResponse(-90000001)

    }

    override fun req_login(uid: String, callBack: IResponseCallBack<LoginEntity>) {

    }




    override fun req_logout(callBack: IResponseCallBack<JSONObject>) {

    }


}