package com.example.mvpdemo.Common.Base

import java.lang.Exception

/**
 * Created by XiaoTong on 2019-09-12.
 */
abstract class ABSBaseRequestListener<T> {

    var callback: IResponseCallback? = null

    constructor(callback: IResponseCallback?) {
        if (callback != null) {
            this.callback = callback
        }
    }

    fun commonResponseHandler(requestID: String, isSuccess: Boolean, content: Any) {
        if (isSuccess) {
            onSuccess(content)
            callback?.onSuccess(requestID, content)
        } else {
            onFailure(content as Exception)
            callback?.onFailure(requestID, content as Exception)
        }
        if (this.callback != null) {
            this.callback?.commonCallBack(requestID, isSuccess, content)
        }
    }

    /**
     * ABSBaseRequestListener中定义的默认失败实现
     */
    open fun onFailure(response: Exception) {
        System.out.println("ABSBaseRequestListener中定义的默认失败实现")
    }

    /**
     * ABSBaseRequestListener中定义的默认成功实现
     */
    open fun onSuccess(response: Any) {
        System.out.println("ABSBaseRequestListener中定义的默认失败实现")
    }
}