package com.example.mvpdemo.Common.Base

import java.lang.Exception


/**
 * Created by XiaoTong on 2019-09-12.
 */
interface IResponseCallback {

    /**
     * 单独处理成功回调
     * @param requestID 请求识别信息
     * @param response 响应
     */
    fun onSuccess(requestID: String, response: Any?)

    /**
     * 单独处理失败回调
     * @param requestID 请求识别信息
     * @param error 错误
     */
    fun onFailure(requestID: String, error: Exception)

    /**
     * 统一处理回调
     * @param requestID 请求识别信息
     * @param isSuccess 是否成功
     * @param content 内容
     */
    fun commonCallBack(requestID: String, isSuccess: Boolean, content: Any?)

}