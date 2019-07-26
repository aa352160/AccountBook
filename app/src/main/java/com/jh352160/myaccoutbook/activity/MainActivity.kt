package com.jh352160.myaccoutbook.activity

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import com.jh352160.myaccoutbook.R
import com.jh352160.myaccoutbook.activity.MainActivity.Companion.REQUEST_EXPEND
import com.jh352160.myaccoutbook.activity.MainActivity.Companion.REQUEST_USER_SETTING
import com.jh352160.myaccoutbook.util.getStringToSP
import com.jh352160.myaccoutbook.util.saveStringToSP
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val REQUEST_USER_SETTING = 1
        val REQUEST_EXPEND = 2
    }

    var drawerToggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
//        initDrawer()
        initClick()
        HashMap<Any, Any>()
    }

//    private fun initDrawer() {
//        setSupportActionBar(tool_bar)
//
//        val drawerArray = arrayOf("预算类别")
//        drawer_list.adapter = ArrayAdapter<String>(this, R.layout.item_drawer_list, drawerArray)
//
//        drawerToggle = object: ActionBarDrawerToggle(this, view_drawer, tool_bar, R.string.main_drawer_open, R.string.main_drawer_close){
//            override fun onDrawerOpened(drawerView: View) {
//                super.onDrawerOpened(drawerView)
//                actionBar?.title = "open"
//            }
//
//            override fun onDrawerClosed(drawerView: View) {
//                super.onDrawerClosed(drawerView)
//                actionBar?.title = "close"
//            }
//        }
//        view_drawer.addDrawerListener(drawerToggle!!)
//
//        actionBar?.setDisplayHomeAsUpEnabled(true)
//        actionBar?.setHomeButtonEnabled(true)
//    }

    /**
     * 数据初始化
     */
    private fun initData() {
        val lastTimeDay = getStringToSP("lastTimeDay")!!
        val lastTimeMoney = getStringToSP("lastTimeMoney", "0")!!
        val dailyMoney = getStringToSP("dailyMoney", "0")!!

        var currentMoney = 0
        //需要补上8个小时来匹配北京时间
        val currentDay = (System.currentTimeMillis() + 8 * 1000 * 60 * 60) / 1000 / 60 / 60 / 24
        if (lastTimeDay != "") {
            val diffDay = currentDay.toInt() - lastTimeDay.toInt()
            currentMoney = lastTimeMoney.toInt() + (diffDay * dailyMoney.toInt())
        }

        tv_available_money.text = "$currentMoney"

        saveStringToSP("lastTimeDay", "$currentDay")
        saveStringToSP("lastTimeMoney", "$currentMoney")
    }

    private fun initClick() {
        btn_change_daily_money.setOnClickListener {
            startActivityForResult(Intent(this, EditUserSettingActivity::class.java), REQUEST_USER_SETTING)
        }

        btn_expend.setOnClickListener {
            startActivityForResult(Intent(this, ExpendActivity::class.java), REQUEST_EXPEND)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if ((requestCode == REQUEST_USER_SETTING || requestCode == REQUEST_EXPEND)
                && resultCode == Activity.RESULT_OK){
            tv_available_money.text = "${getStringToSP("lastTimeMoney", "0")}"
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle?.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        drawerToggle?.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (drawerToggle?.onOptionsItemSelected(item) == true){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
