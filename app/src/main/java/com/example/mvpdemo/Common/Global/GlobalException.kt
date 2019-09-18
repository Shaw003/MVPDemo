package com.example.mvpdemo.Common.Global


/**
 * Created by XiaoTong on 2019-09-14.
 */



/**
 * 异常原因
 */
enum class ExceptionReason(var code: Int, var desc: String) {
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


class GlobalException: Exception() {

    val code: Int
        get() = this.reason.code

    val desc: String
        get() = this.reason.desc

    var reason: ExceptionReason = ExceptionReason.unknown


    companion object Exception {
        fun reason(reason: ExceptionReason): GlobalException {
            val exception = GlobalException()
            exception.reason = reason
            return exception
        }

        /**
         * 根据错误码获取错误原因
         * @param code 响应码
         * @return 错误对象
         */
        fun getExceptionReason(code: Int): GlobalException {
            var reason = ExceptionReason.unknown
            when (code) {
                ExceptionReason.notReachable.code -> reason = ExceptionReason.notReachable
                ExceptionReason.timeout.code -> reason = ExceptionReason.timeout
                ExceptionReason.jsonFormatWrong.code -> reason = ExceptionReason.jsonFormatWrong
                ExceptionReason.userNameNotExist.code -> reason = ExceptionReason.userNameNotExist
                ExceptionReason.userPasswordWrong.code -> reason = ExceptionReason.userPasswordWrong
                ExceptionReason.illegalUser.code -> reason = ExceptionReason.illegalUser
                ExceptionReason.illegalDevice.code -> reason = ExceptionReason.illegalDevice
                ExceptionReason.decryptFailed.code -> reason = ExceptionReason.decryptFailed
            }

            return Exception.reason(reason)
        }
    }



}