package com.example.mvpdemo.Base

/**
 * Created by XiaoTong on 2019-09-15.
 */
abstract class CommonCallBack<T>: IResponseCallBack<T> {

    override fun onSuccess(response: T?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailure(error: Error) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun commonCallBack(isSuccess: Boolean, content: Any) {

    }
}