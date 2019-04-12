package com.jh352160.myaccoutbook.activity

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jh352160.myaccoutbook.R
import com.jh352160.myaccoutbook.bean.PlanTypeB
import com.jh352160.myaccoutbook.database.DataBoxStoreFactory
import com.jh352160.myaccoutbook.util.getTextStr
import com.jh352160.myaccoutbook.util.toast
import kotlinx.android.synthetic.main.activity_add_plan_type.*

/**
 * Created by jh352160 on 2019/4/8.
 */
class AddPlanTypeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_plan_type)

        btn_save.setOnClickListener { if (checkInput()){ submit() } }
    }

    private fun checkInput(): Boolean {
        if (edt_type_name.getTextStr().isEmpty()){
            return false
        }

        if (edt_daily_money.getTextStr().isEmpty()){
            return false
        }
        return true
    }

    private fun submit() {
        val typeBox = DataBoxStoreFactory.boxStore.boxFor(PlanTypeB::class.java)
        typeBox.put(PlanTypeB().apply {
            name = edt_type_name.getTextStr()
            dailyMoney = edt_daily_money.getTextStr()
        })
        toast("保存成功")
        setResult(Activity.RESULT_OK)
        finish()
    }
}
