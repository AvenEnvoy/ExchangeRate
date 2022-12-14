package com.bignerdranch.android.exchangerate.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.exchangerate.APP
import com.bignerdranch.android.exchangerate.R
import com.bignerdranch.android.exchangerate.databinding.ItemBinding
import com.bignerdranch.android.exchangerate.model.InputData

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private var listMain = emptyList<InputData>()

    class MainViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = ItemBinding.bind(view)
        @SuppressLint("DiscouragedApi")
        fun bind(value: InputData) {
            binding.apply {
                tvCurrency.text = value.CharCode
                tvValue.text = String.format("%.3f", (value.Value / value.Nominal)).toDouble().toString()
                val id = APP.resources.getIdentifier("r_${value.CharCode.lowercase()}", "drawable", APP.packageName)
                ivCurrency.setImageResource(id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(listMain[position])
    }

    override fun getItemCount(): Int {
        return listMain.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<InputData>) {
        listMain = list
        notifyDataSetChanged()
    }
}