package com.bd.satellitetracking.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bd.data.model.Satellite
import com.bd.satellitetracking.databinding.ItemSatelliteListBinding

class SatelliteListAdapter : RecyclerView.Adapter<SatelliteListAdapter.ViewHolder>() {

    private val items = arrayListOf<Satellite>()

    private var onClickListener: ((id: Satellite) -> Unit)? = null

    fun setData(list: List<Satellite>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(clickListener: (id: Satellite) -> Unit) {
        onClickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemSatelliteListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding: ItemSatelliteListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Satellite) {
            binding.data = data

            binding.root.setOnClickListener {
                onClickListener?.invoke(data)
            }
        }
    }
}