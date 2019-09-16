package com.example.mvpdemo.Common.Network

import com.example.mvpdemo.Common.Base.ABSBaseRequestListener
import com.example.mvpdemo.Common.Base.IResponseCallBack
import com.example.mvpdemo.Common.Global.ErrorReason
import com.example.mvpdemo.Common.Global.GlobalError
import com.example.mvpdemo.Common.Utilities.JSONParser
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Headers
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException
import kotlin.collections.ArrayList

/**
 * Created by XiaoTong on 2019-09-16.
 */
class CommonJSONCallBack<T>: Callback {

    val mListener: ABSBaseRequestListener<T>
    var clazz: Class<T>? = null

    /* -------------------<okhttp的接口方法>------------------- */
    /**
     * 收到响应回调
     */
    override fun onResponse(call: Call, response: Response) {
        val result = response.body?.string()
        val headers = response.headers
        val cookies = parseCookies(headers)
        if (result.isNullOrEmpty()) {
            onFailure(call, IOException())
        } else {
            dealWithResponse(result!!)
        }
    }

    /**
     * 网络连接失败回调
     */
    override fun onFailure(call: Call, e: IOException) {
        // TODO: 网络原因判断
        val error = GlobalError.reason(ErrorReason.notReachable)
        mListener.commonResponseHandler(false, error)
    }

    /* -------------------<自己定义的方法>------------------- */
    constructor(listener: ABSBaseRequestListener<T>, clazz: Class<T>?) {

        this.mListener = listener
        if (clazz != null) {
            this.clazz = clazz
        }
    }

    /**
     * 解析cookies
     */
    private fun parseCookies(headers: Headers): ArrayList<String> {
        var tmpList = ArrayList<String>()
        for (i in 0 until headers.size) {
            if (headers.name(i).equals("Set-Cookies", true)) {
                tmpList.add(headers.value(i))
            }
        }
        return tmpList
    }


    /**
     * 处理响应
     */
    private fun dealWithResponse(response: String) {
        val json = JSONObject(response)

        val code = json.getString("code")
        if (code != "0000") {
            val error = GlobalError.getErrorReason(code.toInt())
            mListener.commonResponseHandler(false, error)
            return
        } else {
            // 如果没定义实体就返回response回去，如果定义了就尝试转换
            if (clazz != null) {
                val entity = JSONParser.parse(response, clazz!!)
                mListener.commonResponseHandler(true, entity as Any)
            } else {
                mListener.commonResponseHandler(true, response)
            }
        }
    }
}


