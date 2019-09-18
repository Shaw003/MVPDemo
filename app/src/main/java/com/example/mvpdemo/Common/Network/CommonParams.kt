package com.example.mvpdemo.Common.Network

/**
 * Created by XiaoTong on 2019-09-14.
 */
object CommonParams {

    public fun create(): MutableMap<String, Any> {
        val params = mutableMapOf("commonKey1" to "value1")
        return params as MutableMap<String, Any>
    }
}