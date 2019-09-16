package com.example.mvpdemo.Common.Base

import com.example.mvpdemo.Common.Global.ErrorReason
import com.example.mvpdemo.Common.Global.GlobalError
import com.example.mvpdemo.Common.Network.CommonJSONCallBack
import okhttp3.Response
import org.json.JSONObject
import java.lang.Error

/**
 * Created by XiaoTong on 2019-09-12.
 */
abstract class ABSBaseRequestListener<T> {

    var callBack: IResponseCallBack? = null

    constructor(callBack: IResponseCallBack?) {
        if (callBack != null) {
            this.callBack = callBack
        }
    }

    fun commonResponseHandler(isSuccess: Boolean, content: Any) {
        if (isSuccess) {
            onSuccess(content)
        } else {
            onFailure(content)
        }
        if (this.callBack != null) {
            this.callBack?.commonCallBack(isSuccess, content)
        }
    }

    /**
     * 失败的默认实现
     */
    open fun onFailure(response: Any) {

    }

    abstract fun onSuccess(response: Any)
}