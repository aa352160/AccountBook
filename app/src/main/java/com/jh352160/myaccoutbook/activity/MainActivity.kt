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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lastTimeDay = getStringToSP("lastTimeDay")!!
        val lastTimeMoney = getStringToSP("lastTimeMoney", "0")!!
        val dailyMoney = getStringToSP("dailyMoney", "0")!!

        var currentMoney = 0
        val currentDay = System.currentTimeMillis() / 1000 / 60 / 60 / 24
        if (lastTimeDay != "") {
            val diffDay = currentDay.toInt() - lastTimeDay.toInt()
            currentMoney = lastTimeMoney.toInt() + (diffDay * dailyMoney.toInt())
        }

        tv_available_money.text = "$currentMoney"

        saveStringToSP("lastTimeDay", "$currentDay")
        saveStringToSP("lastTimeMoney", "$currentMoney")

        btn_change_daily_money.setOnClickListener {
            startActivityForResult(Intent(this, EditUserSettingActivity::class.java), 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK){
            tv_available_money.text = "${getStringToSP("lastTimeMoney", "0")}"
        }
    }
}
