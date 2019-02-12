package com.jh352160.myaccoutbook.util

import android.content.Context
import com.jh352160.myaccoutbook.BuildConfig

/**
 * Created by jh352160 on 2019/2/12.
 */

fun Context.saveStringToSP(key: String, value: String?){
    getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE).edit().putString(key, value).apply()
}

fun Context.getStringToSP(key: String, defValue: String? = "") =
    getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE).getString(key,defValue)