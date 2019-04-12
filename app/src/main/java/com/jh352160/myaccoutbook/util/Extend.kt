package com.jh352160.myaccoutbook.util

import android.content.Context
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

/**
 * Created by jh352160 on 2019/4/12.
 */

fun TextView.getTextStr() = this.text.toString()

fun Context.toast(str: String){ Toast.makeText(this, str, Toast.LENGTH_LONG).show() }