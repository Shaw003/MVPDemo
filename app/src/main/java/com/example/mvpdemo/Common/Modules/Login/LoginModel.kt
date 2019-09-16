package com.example.mvpdemo.Common.Modules.Login

import com.example.mvpdemo.Common.Base.ABSBaseRequestListener
import com.example.mvpdemo.Common.Base.IResponseCallBack
import com.example.mvpdemo.Common.Global.ErrorReason
import com.example.mvpdemo.Common.Global.GlobalError
import com.example.mvpdemo.Common.Network.CommonJSONCallBack
import com.example.mvpdemo.Common.Network.CommonParams
import com.example.mvpdemo.Common.Network.HttpClient
import okhttp3.Call
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException
import java.net.URL

/**
 * Created by XiaoTong on 2019-09-12.
 */

class LoginModel : ILoginContract.ILoginModel {


    override fun req_verifyCode(uid: String, pwd: String, callBack: IResponseCallBack) {

        val params = CommonParams.create()
        val tmpParams = mapOf("uid" to uid, "pwd" to pwd)
        params.put("data", tmpParams)
        // TODO 网络请求

        HttpClient.get().post("", tmpParams, JSONObject::class.java,
            object : ABSBaseRequestListener<JSONObject>(callBack) {

                override fun onSuccess(response: Any) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                // 不需要额外处理则可以不用实现该函数
                override fun onFailure(response: Any) {
                    super.onFailure(response)
                }

            })


    }

    override fun req_login(uid: String, callBack: IResponseCallBack) {

    }


    override fun req_logout(callBack: IResponseCallBack) {

    }


}