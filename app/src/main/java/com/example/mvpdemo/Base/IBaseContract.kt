package com.example.mvpdemo.Base

import android.content.Context

/**
 * Created by XiaoTong on 2019-09-12.
 */


public interface IBaseContract {

    interface IBaseModel {


    }

    interface IBaseView {


        /**
         * 显示加载框
         */
        fun showLoading()

        /**
         * 隐藏加载框
         */
        fun dismissLoading()

        fun toast(msg: String)
        /**
         * 上下文
         *
         * @return context
         */
        fun getContext(): Context

        /**
         * 收到响应后需要全局处理的事件
         */
        fun notifyGlobalToDealWith(content: Any)
    }

    interface IBasePresenter<M, V> {

    }
}