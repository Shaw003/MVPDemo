package com.example.mvpdemo.Common.Network

/**
 * Created by XiaoTong on 2019-09-14.
 */
object CommonParams {

    public fun create(): MutableMap<String, Any> {
        val params = mutableMapOf("key" to "value")
        return params as MutableMap<String, Any>
    }
}