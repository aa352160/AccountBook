package com.jh352160.myaccoutbook

import android.app.Application
import com.jh352160.myaccoutbook.bean.MyObjectBox
import com.jh352160.myaccoutbook.database.DataBoxStoreFactory
import io.objectbox.android.AndroidObjectBrowser

/**
 * Created by jh352160 on 2019/4/11.
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DataBoxStoreFactory.init(this)
//        if (BuildConfig.DEBUG){
//            AndroidObjectBrowser(DataBoxStoreFactory.boxStore).start(this)
//        }
    }
}
