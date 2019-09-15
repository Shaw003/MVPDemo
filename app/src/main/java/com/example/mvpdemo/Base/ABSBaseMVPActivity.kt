package com.example.mvpdemo.Base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast



/**
 * Created by XiaoTong on 2019-09-12.
 */

/**
 * MVP架构的Activity基类
 */
public abstract class ABSBaseMVPActivity<P: ABSBasePresenter<IBaseContract.IBaseModel, IBaseContract.IBaseView>>: Activity(), IBaseContract.IBaseView {

    public lateinit var mPresenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initLayout())
//        ActivityUtil.push(this)
        //初始化mPresenter
        initPresenter()

        //绑定view
        if (mPresenter != null) {
            mPresenter.attach(this)
        }
        //初始化
        initView()
        initData()
    }




    protected abstract fun initData()

    /**
     * 初始化mPresenter
     */
    protected abstract fun initPresenter()

    /**
     * 初始化
     */
    protected abstract fun initView()

    /**
     * 获取布局id
     * @return
     */
    protected abstract fun initLayout(): Int

    override fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {

    }

    override fun dismissLoading() {

    }

    override fun getContext(): Context {
        return this
    }

    override fun notifyGlobalToDealWith(content: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}