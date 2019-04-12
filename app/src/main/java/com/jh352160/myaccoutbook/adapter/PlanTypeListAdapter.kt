package com.jh352160.myaccoutbook.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.SimpleAdapter
import com.jh352160.myaccoutbook.R
import com.jh352160.myaccoutbook.bean.PlanTypeB
import kotlinx.android.synthetic.main.item_plan_type_list.view.*

/**
 * Created by jh352160 on 2019/4/8.
 */
class PlanTypeListAdapter(val datas: ArrayList<PlanTypeB>) : RecyclerView.Adapter<PlanTypeListAdapter.ViewHolder>() {
    override fun getItemCount() = datas.size
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
            ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_plan_type_list, p0, false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = datas[position]
        with(viewHolder.itemView){
            tv_type_name.text = item.name
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)
}
