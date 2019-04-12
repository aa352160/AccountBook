package com.jh352160.myaccoutbook.database

import android.content.Context
import com.jh352160.myaccoutbook.bean.MyObjectBox
import io.objectbox.BoxStore

/**
 * Created by jh352160 on 2019/4/11.
 */
object DataBoxStoreFactory{
    lateinit var boxStore: BoxStore

    fun init(context: Context){
        boxStore = MyObjectBox.builder().androidContext(context).build()
    }
}
