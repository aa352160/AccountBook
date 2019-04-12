package com.jh352160.myaccoutbook.database

import com.jh352160.myaccoutbook.bean.MyObjectBox
import io.objectbox.BoxStore

/**
 * Created by jh352160 on 2019/4/11.
 */
object DataBoxStoreFactory{
    val boxStore: BoxStore by lazy { MyObjectBox.builder().androidContext(this).build() }
}
