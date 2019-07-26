package com.jh352160.myaccoutbook.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.jh352160.myaccoutbook.R
import com.jh352160.myaccoutbook.adapter.PlanTypeListAdapter
import com.jh352160.myaccoutbook.bean.PlanTypeB
import com.jh352160.myaccoutbook.database.DataBoxStoreFactory
import com.jh352160.myaccoutbook.util.Const
import com.jh352160.myaccoutbook.util.getStringToSP
import com.jh352160.myaccoutbook.util.saveStringToSP
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_plan_type_list.*

/**
 * Created by jh352160 on 2019/4/8.
 */
class PlanTypeListActivity: AppCompatActivity(){
    private var diffDay = 0 // 距离上次使用间隔天数
    private val planTypeBox by lazy { DataBoxStoreFactory.boxStore.boxFor(PlanTypeB::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan_type_list)

        initData()
        refreshList()

        iv_add_plan_type.setOnClickListener {
            startActivityForResult(Intent(this, AddPlanTypeActivity::class.java), Const.RQUEST_INTENT_TO_ADD_PLAN_TYPE)
        }
    }

    private fun initData() {
        val lastTimeDay = getStringToSP("lastTimeDay")!!

        //需要补上8个小时来匹配北京时间
        val currentDay = (System.currentTimeMillis() + 8 * 1000 * 60 * 60) / 1000 / 60 / 60 / 24
        if (lastTimeDay != "") {
            diffDay = currentDay.toInt() - lastTimeDay.toInt()
        }

        saveStringToSP("lastTimeDay", "$currentDay")
    }

    private fun refreshList(){
        var dataList = planTypeBox.all
        if (dataList.size == 0){ dataList = arrayListOf<PlanTypeB>() }

        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = PlanTypeListAdapter(dataList as ArrayList<PlanTypeB>, diffDay)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Const.RQUEST_INTENT_TO_ADD_PLAN_TYPE && resultCode == Activity.RESULT_OK){
            refreshList()
        }
    }
}
