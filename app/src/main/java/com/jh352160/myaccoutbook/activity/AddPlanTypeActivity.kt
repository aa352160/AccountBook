package com.jh352160.myaccoutbook.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jh352160.myaccoutbook.R
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
        if (edt_type_name.text.toString().isEmpty()){
            return false
        }

        if (edt_type_name.text.toString().isEmpty()){
            return false
        }
        return true
    }

    private fun submit() {

    }
}
