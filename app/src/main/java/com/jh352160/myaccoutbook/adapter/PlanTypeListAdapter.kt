package com.jh352160.myaccoutbook.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jh352160.myaccoutbook.R
import com.jh352160.myaccoutbook.activity.PlanTypeDetailActivity
import com.jh352160.myaccoutbook.bean.PlanTypeB
import com.jh352160.myaccoutbook.bean.PlanTypeB_.dailyMoney
import kotlinx.android.synthetic.main.item_plan_type_list.view.*

/**
 * Created by jh352160 on 2019/4/8.
 */
class PlanTypeListAdapter(val datas: ArrayList<PlanTypeB>, val diffDay: Int) : RecyclerView.Adapter<PlanTypeListAdapter.ViewHolder>() {
    override fun getItemCount() = datas.size
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
            ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_plan_type_list, p0, false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = datas[position]
        with(viewHolder.itemView){
            tv_type_name.text = item.name
            setOnClickListener { context.startActivity(Intent(context, PlanTypeDetailActivity::class.java).apply {
                putExtra("typeId", item.id)
            }) }
            val currentMoney = item.residualMoney.toInt() + (diffDay * item.dailyMoney.toInt())
            tv_residual_money.text = "剩余金额：${currentMoney}"
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)
}
