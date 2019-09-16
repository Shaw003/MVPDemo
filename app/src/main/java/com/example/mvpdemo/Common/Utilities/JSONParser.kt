package com.example.mvpdemo.Common.Utilities

import com.google.gson.Gson
import org.json.JSONObject
import java.util.*

/**
 * Created by XiaoTong on 2019-09-16.
 */
object JSONParser {

    fun <T> parse(jsonString: String, type: Class<T>): T {
        val gson = Gson()
        return gson.fromJson(jsonString, type)
    }
}