package com.jh352160.myaccoutbook.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.jh352160.myaccoutbook.R
import com.jh352160.myaccoutbook.adapter.PlanTypeListAdapter
import com.jh352160.myaccoutbook.bean.PlanTypeB
import kotlinx.android.synthetic.main.activity_plan_type_list.*

/**
 * Created by jh352160 on 2019/4/8.
 */
class PlanTypeListActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan_type_list)

        val data = arrayListOf("1", "2", "3").map { PlanTypeB().apply { name = it } }
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = PlanTypeListAdapter(data as ArrayList<PlanTypeB>)
    }
}
