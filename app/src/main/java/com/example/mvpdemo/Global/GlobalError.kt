package com.example.mvpdemo.Global

import java.lang.Error

/**
 * Created by XiaoTong on 2019-09-14.
 */



/**
 * 异常原因
 */
enum class ErrorReason(var code: Int, var desc: String) {
    unknown(-99999999, "未知原因"),

    // 网路原因
    notReachable(-90000001, "网络不可用"),
    timeout(-90000002, "网络连接超时"),
    jsonFormatWrong(-90000003, "json解析失败"),

    // 通信机制异常原因
    userNameNotExist(-80000001, "用户名不存在"),
    userPasswordWrong(-80000002, "用户密码错误"),
    illegalUser(-80000003, "用户状态非法"),
    illegalDevice(-80000004, "设备状态非法"),
    decryptFailed(-80000005, "解密失败"),
}


class GlobalError: Error() {

    val code: Int
        get() = this.reason.code

    val desc: String
        get() = this.reason.desc

    var reason: ErrorReason = ErrorReason.unknown


    companion object Error {
        fun reason(reason: ErrorReason): GlobalError {
            val error = GlobalError()
            error.reason = reason
            return error
        }

        /**
         * 处理异常响应
         * @param code 响应码
         * @return 错误对象
         */
        fun handleErrorResponse(code: Int): GlobalError {
            var reason = ErrorReason.unknown
            when (code) {
                ErrorReason.notReachable.code -> reason = ErrorReason.notReachable
                ErrorReason.timeout.code -> reason = ErrorReason.timeout
                ErrorReason.jsonFormatWrong.code -> reason = ErrorReason.jsonFormatWrong
                ErrorReason.userNameNotExist.code -> reason = ErrorReason.userNameNotExist
                ErrorReason.userPasswordWrong.code -> reason = ErrorReason.userPasswordWrong
                ErrorReason.illegalUser.code -> reason = ErrorReason.illegalUser
                ErrorReason.illegalDevice.code -> reason = ErrorReason.illegalDevice
                ErrorReason.decryptFailed.code -> reason = ErrorReason.decryptFailed
            }

            return Error.reason(reason)
        }
    }



}