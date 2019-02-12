package com.jh352160.myaccoutbook.activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jh352160.myaccoutbook.R
import com.jh352160.myaccoutbook.util.getStringToSP
import com.jh352160.myaccoutbook.util.saveStringToSP
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val REQUEST_USER_SETTING = 1
        val REQUEST_EXPEND = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        initClick()
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
}
