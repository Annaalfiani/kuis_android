package com.annaalfianim.annaalfianim.kuis_atk

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.annaalfianim.annaalfianim.kuis_atk.models.AtkModel
import kotlinx.android.synthetic.main.list_item_atk.view.*

class  AtkAdapter (private val mList:List<AtkModel>,private val context: Context): RecyclerView.Adapter<AtkAdapter.ViewHolder> (){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) = ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.list_item_atk,p0,false))

    override fun getItemCount() = mList.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindData(mList[p1],context)
    }


    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        fun bindData (model: AtkModel,context: Context){
            itemView.list_atk_title.text = model.title
            itemView.list_atk_code.text = model.code
            itemView.list_atk_category.text = model.category
            itemView.setOnClickListener {
                Toast.makeText(context,"anda mengklik ${model.title}",Toast.LENGTH_LONG).show()
            }
        }
    }

}