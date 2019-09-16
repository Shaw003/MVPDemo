package com.example.mvpdemo.Common.Base

import okhttp3.Callback

/**
 * Created by XiaoTong on 2019-09-12.
 */
interface IResponseCallBack {

    /**
     * 单独处理成功回调
     * @param response
     */
    fun onSuccess(response: Any?)

    /**
     * 单独处理失败回调
     * @param error 错误
     */
    fun onFailure(error: Error)

    /**
     * 统一处理回调
     * @param isSuccess 是否成功
     * @param content 内容
     */
    fun commonCallBack(isSuccess: Boolean, content: Any?)

}