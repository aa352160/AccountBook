package com.jh352160.myaccoutbook.activity

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jh352160.myaccoutbook.R
import com.jh352160.myaccoutbook.util.getStringToSP
import com.jh352160.myaccoutbook.util.saveStringToSP
import kotlinx.android.synthetic.main.activity_edit_user_setting.*
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by jh352160 on 2019/2/12.
 */
class EditUserSettingActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_user_setting)

        val dailyMoney = getStringToSP("dailyMoney", "0")!!
        val lastTimeMoney = getStringToSP("lastTimeMoney", "0")!!
        edt_daily_money.setText(dailyMoney)
        edt_available_money.setText(lastTimeMoney)

        btn_save.setOnClickListener { saveSetting() }
    }

    private fun saveSetting() {
        var availableMoney = edt_available_money.text.toString()
        if (availableMoney == "") { availableMoney = "0" }
        var dailyMoney = edt_daily_money.text.toString()
        if (dailyMoney == "") { dailyMoney = "0" }

        saveStringToSP("lastTimeMoney", availableMoney)
        saveStringToSP("dailyMoney", dailyMoney)
        setResult(Activity.RESULT_OK)
        finish()
    }
}
