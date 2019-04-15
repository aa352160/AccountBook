package com.jh352160.myaccoutbook.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.jh352160.myaccoutbook.R
import com.jh352160.myaccoutbook.adapter.PlanItemListAdapter
import com.jh352160.myaccoutbook.bean.PlanItemB
import com.jh352160.myaccoutbook.bean.PlanItemB_
import com.jh352160.myaccoutbook.database.DataBoxStoreFactory
import com.jh352160.myaccoutbook.util.Const
import kotlinx.android.synthetic.main.activity_plan_type_detail.*

/**
 * Created by jh352160 on 2019/4/12.
 */
class PlanTypeDetailActivity : AppCompatActivity() {
    private val planItemBox by lazy { DataBoxStoreFactory.boxStore.boxFor(PlanItemB::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan_type_detail)

        refreshList()
        iv_add_item.setOnClickListener {
            startActivityForResult(Intent(this, AddPlanItemActivity::class.java).apply {
                putExtra("typeId", intent.getLongExtra("typeId", 0))
            }, Const.RQUEST_INTENT_TO_ADD_PLAN_TYPE)
        }
    }

    private fun refreshList(){
        val typeId = intent.getLongExtra("typeId", 0)
        val planItemList = planItemBox.query().equal(PlanItemB_.id, typeId).build().find()
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = PlanItemListAdapter(planItemList as ArrayList<PlanItemB>)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Const.RQUEST_INTENT_TO_ADD_PLAN_TYPE && resultCode == Activity.RESULT_OK){ refreshList() }
    }
}
