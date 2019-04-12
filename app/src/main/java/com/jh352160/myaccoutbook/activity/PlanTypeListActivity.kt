package com.jh352160.myaccoutbook.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.jh352160.myaccoutbook.R
import com.jh352160.myaccoutbook.adapter.PlanTypeListAdapter
import com.jh352160.myaccoutbook.bean.PlanTypeB
import com.jh352160.myaccoutbook.bean.PlanTypeB_
import com.jh352160.myaccoutbook.database.DataBoxStoreFactory
import com.jh352160.myaccoutbook.util.Const
import kotlinx.android.synthetic.main.activity_plan_type_list.*
import javax.xml.datatype.DatatypeFactory

/**
 * Created by jh352160 on 2019/4/8.
 */
class PlanTypeListActivity: AppCompatActivity(){
    private val planTypeBox by lazy { DataBoxStoreFactory.boxStore.boxFor(PlanTypeB::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan_type_list)

        refreshList()

        iv_add_plan_type.setOnClickListener {
            startActivityForResult(Intent(this, AddPlanTypeActivity::class.java), Const.RQUEST_INTENT_TO_ADD_PLAN_TYPE)
        }
    }

    private fun refreshList(){
        val planTypeList = DataBoxStoreFactory.boxStore.boxFor(PlanTypeB::class.java).all

        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = PlanTypeListAdapter(planTypeList as ArrayList<PlanTypeB>)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Const.RQUEST_INTENT_TO_ADD_PLAN_TYPE && resultCode == Activity.RESULT_OK){
            refreshList()
        }
    }
}
