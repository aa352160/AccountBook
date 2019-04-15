package com.jh352160.myaccoutbook.activity

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jh352160.myaccoutbook.R
import com.jh352160.myaccoutbook.bean.PlanItemB
import com.jh352160.myaccoutbook.bean.PlanTypeB
import com.jh352160.myaccoutbook.bean.PlanTypeB_.dailyMoney
import com.jh352160.myaccoutbook.bean.PlanTypeB_.name
import com.jh352160.myaccoutbook.database.DataBoxStoreFactory
import com.jh352160.myaccoutbook.util.getTextStr
import com.jh352160.myaccoutbook.util.toast
import kotlinx.android.synthetic.main.activity_add_plan_item.*

/**
 * Created by jh352160 on 2019/4/15.
 */
class AddPlanItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_plan_item)

        btn_save.setOnClickListener { if (checkInput()){ submit() } }
    }

    private fun checkInput(): Boolean {
        if (edt_price.getTextStr().isEmpty()){
            return false
        }

        if (edt_remark.getTextStr().isEmpty()){
            return false
        }
        return true
    }

    private fun submit() {
        val typeBox = DataBoxStoreFactory.boxStore.boxFor(PlanItemB::class.java)
        typeBox.put(PlanItemB().apply {
            typeId = intent.getLongExtra("typeId", 0)
            spendMoney = edt_price.getTextStr()
            remark = edt_remark.getTextStr()
            createTime = System.currentTimeMillis()
        })
        toast("保存成功")
        setResult(Activity.RESULT_OK)
        finish()
    }
}
