package com.example.mvpdemo.Common.Base

import android.content.Context
import com.example.mvpdemo.Common.Global.ExceptionReason
import com.example.mvpdemo.Common.Global.GlobalException
import com.example.mvpdemo.Common.Global.GlobalEvent
import java.lang.Exception

import java.lang.ref.WeakReference


/**
 * Created by XiaoTong on 2019-09-12.
 */


/**
 * MVP架构的Presenter基类，对接Model基类和View基类，并实现统一回调处理
 */
abstract class ABSBasePresenter<M : IBaseContract.IBaseModel, V : IBaseContract.IBaseView> : IResponseCallback {

    private var mvpView: WeakReference<V>? = null
    private var mvpModel: M? = null

    /**
     * 绑定View
     */
    fun attach(view: V, model: M) {
        mvpView = WeakReference(view)
        if (mvpModel == null) {
            mvpModel = model
        }
    }

    /**
     * 解绑View
     */
    fun detach() {
        if (mvpView != null) {
            mvpView!!.clear()
            mvpView = null
        }
        this.mvpModel = null
    }

    /**
     * 是否与View建立连接
     */
    protected fun isAttached(): Boolean {
        return mvpView != null && mvpView?.get() != null
    }

    protected fun getView(): V? {
        return mvpView?.get()
    }

    protected fun getModel(): M? {
        return mvpModel
    }

    protected fun getContext(): Context? {
        return getView()?.getContext()
    }

    protected fun showLoading() {
        getView()?.showLoading()
    }

    protected fun dismissLoading() {
        getView()?.dismissLoading()
    }

    protected fun toast(msg: String) {
        getView()?.toast(msg)
    }

    /**
     * IResponseCallback在BasePresenter中的默认成功实现
     */
    override fun onSuccess(requestID: String, response: Any?) {
        System.out.println("IResponseCallback在BasePresenter中的默认成功实现")
    }

    /**
     * IResponseCallback在BasePresenter中的默认失败实现
     */
    override fun onFailure(requestID: String, error: Exception) {
        System.out.println("IResponseCallback在BasePresenter中的默认失败实现")
    }
    /**
     * 统一回调处理
     */
    override fun commonCallBack(requestID: String, isSuccess: Boolean, content: Any?) {
        if (isSuccess) {
            this.onSuccess(requestID, content)
            return
        }
        if (content is GlobalException) {
            val error = content
            when (error.reason) {
                ExceptionReason.illegalDevice -> getView()?.notifyGlobalToDealWith(GlobalEvent.event_exitApp)
                ExceptionReason.illegalUser -> getView()?.notifyGlobalToDealWith(GlobalEvent.event_backToLogin)
                ExceptionReason.decryptFailed -> getView()?.notifyGlobalToDealWith(GlobalEvent.event_showLoginDialog)
                ExceptionReason.userPasswordWrong -> getView()?.notifyGlobalToDealWith(GlobalEvent.event_backToLogin)
                else -> {
                    this.onFailure(requestID, content as Exception)
                }
            }
        }
    }


}