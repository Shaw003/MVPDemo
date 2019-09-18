package com.example.mvpdemo.Common.Network

import com.example.mvpdemo.Common.Base.ABSBaseRequestListener
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * Created by XiaoTong on 2019-09-16.
 */
class HttpClient private constructor() {

    companion object {

        private val mClient: OkHttpClient = OkHttpClient()

        private var instance: HttpClient? = null
            get() {
                if (field == null) {
                    field = HttpClient()
                }
                return field
            }
        fun get(): HttpClient {
            return instance!!
        }


    }

    fun <T>post(url: String, params: Map<String, Any>, clazz: Class<T>?, listener: ABSBaseRequestListener<T>): Call {

        val request = Request.Builder().url(url).build()
        val call = mClient.newCall(request)
        System.out.println("requestUrl = ${request.url}\n params = $params")
        call.enqueue(CommonJSONCallBack(listener, clazz))

        return call

    }

}