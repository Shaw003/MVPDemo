package com.example.mvpdemo.Global

import android.content.Context
import java.lang.Exception
import kotlin.system.exitProcess

/**
 * Created by XiaoTong on 2019-09-12.
 */

enum class GlobalEventType {
    event_exitApp, // 退出应用
    event_backToLogin, // 回到登录页面
    event_showLoginDialog // 展示登录窗口
}

object GlobalEvent {

}