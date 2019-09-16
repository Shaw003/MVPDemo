package com.example.mvpdemo.Common.Base

import android.content.Context
import com.example.mvpdemo.Common.Global.ErrorReason
import com.example.mvpdemo.Common.Global.GlobalError
import com.example.mvpdemo.Common.Global.GlobalEvent

import java.lang.ref.WeakReference


/**
 * Created by XiaoTong on 2019-09-12.
 */


/**
 * MVP架构的Presenter基类，对接Model基类和View基类，并实现统一回调处理
 */
abstract class ABSBasePresenter<M : IBaseContract.IBaseModel, V : IBaseContract.IBaseView> : IResponseCallBack {

    private var mvpView: WeakReference<V>? = null
    private var mvpModel: M? = null

    /**
     * 绑定View
     */
    fun attach(view: V) {
        mvpView = WeakReference(view)
        if (mvpModel == null) {
            mvpModel = createModel()
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
     * 通过该方法创建Module
     */
    protected abstract fun createModel(): M

    /**
     * 初始化方法
     */
    abstract fun start()

    /**
     * 统一回调处理
     */
    override fun commonCallBack(isSuccess: Boolean, content: Any?) {
        if (content is GlobalError) {
            val error = content as GlobalError
            when (error.reason) {
                ErrorReason.illegalDevice -> getView()?.notifyGlobalToDealWith(GlobalEvent.event_exitApp)
                ErrorReason.illegalUser -> getView()?.notifyGlobalToDealWith(GlobalEvent.event_backToLogin)
                ErrorReason.decryptFailed -> getView()?.notifyGlobalToDealWith(GlobalEvent.event_showLoginDialog)
                ErrorReason.userPasswordWrong -> getView()?.notifyGlobalToDealWith(GlobalEvent.event_backToLogin)
            }
        }
    }


}