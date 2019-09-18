package com.example.mvpdemo.Common.Modules.Login

import com.example.mvpdemo.Common.Base.ABSBaseRequestListener
import com.example.mvpdemo.Common.Base.IResponseCallback
import com.example.mvpdemo.Common.Network.CommonParams
import com.example.mvpdemo.Common.Network.HttpClient
import org.json.JSONObject
import java.lang.Exception

/**
 * Created by XiaoTong on 2019-09-12.
 */

class LoginModel : ILoginContract.ILoginModel {


    override fun req_verifyCode(uid: String, pwd: String, callback: IResponseCallback): String {

        val params = CommonParams.create()
        val tmpParams = mutableMapOf("uid" to uid, "pwd" to pwd)
        params.put("data", tmpParams)
        val url = "http://www.baidu.com/search"
        HttpClient.get().post(url, params, JSONObject::class.java,
            object : ABSBaseRequestListener<JSONObject>(callback) {


                // 不需要额外处理则可以不用实现该函数
                override fun onSuccess(response: Any) {
                    super.onSuccess(response)
                    System.out.println("loginModel处理成功")
                }

                // 不需要额外处理则可以不用实现该函数
                override fun onFailure(response: Exception) {
                    super.onFailure(response)
                    System.out.println("loginModel处理失败")
                }

            })

        return url
    }

    override fun req_login(uid: String, callback: IResponseCallback) {

    }


    override fun req_logout(callback: IResponseCallback) {

    }


}