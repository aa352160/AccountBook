package com.jh352160.myaccoutbook.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jh352160.myaccoutbook.R
import com.jh352160.myaccoutbook.bean.PlanItemB
import kotlinx.android.synthetic.main.item_plan_item_list.view.*

/**
 * Created by jh352160 on 2019/4/12.
 */
class PlanItemListAdapter(val datas: ArrayList<PlanItemB>): RecyclerView.Adapter<PlanItemListAdapter.ViewHolder>() {
    override fun getItemCount() = datas.size
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
        ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_plan_item_list, p0, false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = datas[position]
        with(viewHolder.itemView){
            tv_price.text = item.spendMoney
            tv_remark.text = item.remark
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)
}
