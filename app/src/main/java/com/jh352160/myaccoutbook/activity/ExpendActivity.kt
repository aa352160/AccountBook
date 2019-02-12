package com.jh352160.myaccoutbook.activity

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.jh352160.myaccoutbook.R
import com.jh352160.myaccoutbook.util.getStringToSP
import com.jh352160.myaccoutbook.util.saveStringToSP
import kotlinx.android.synthetic.main.activity_expend.*

/**
 * Created by jh352160 on 2019/2/12.
 */
class ExpendActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expend)

        btn_confirm.setOnClickListener { confirm() }
    }

    private fun confirm() {
        val spendMoneyStr = edt_expend_money.text.toString()
        if (spendMoneyStr == "" || spendMoneyStr.toInt() < 0){
            Toast.makeText(this, "输入的金额不合法", Toast.LENGTH_LONG).show()
            return
        }

        val spendMoney = spendMoneyStr.toInt()
        val currentMoney = getStringToSP("lastTimeMoney", "0")!!.toInt()
        if (spendMoney > currentMoney){
            Toast.makeText(this, "可用金额不足", Toast.LENGTH_LONG).show()
            return
        }

        val diffMoney = currentMoney - spendMoney
        saveStringToSP("lastTimeMoney", "$diffMoney")
        setResult(Activity.RESULT_OK)
        finish()
    }
}
