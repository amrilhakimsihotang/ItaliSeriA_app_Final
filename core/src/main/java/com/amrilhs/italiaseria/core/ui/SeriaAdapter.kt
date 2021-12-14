package com.amrilhs.italiaseria.core.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amrilhs.italiaseria.core.R
import com.amrilhs.italiaseria.core.databinding.ListItemsSeriaBinding
import com.amrilhs.italiaseria.core.domain.model.SeriAModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class SeriaAdapter : RecyclerView.Adapter<SeriaAdapter.ListViewHolder>() {

    private var listData = ArrayList<SeriAModel>()
    var onItemClick: ((SeriAModel) -> Unit)? = null


    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ListItemsSeriaBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun bind(data: SeriAModel) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.strTeamBadge)
                    .apply(RequestOptions().override(SCREEN_W, SCREEN_H))
                    .error(R.drawable.ic_baseline_error_24)
                    .into(ivItemImage)
                tvItemTitle.text = data.strTeam
                tvItemSubtitle.text = data.strStadium + ", " + data.strCountry
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[absoluteAdapterPosition])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_items_seria, parent, false)
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newListData: List<SeriAModel>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    companion object {

        const val SCREEN_W: Int = 800
        const val SCREEN_H: Int = 600
    }

}