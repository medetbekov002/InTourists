package com.dev.intourist.ui.screen.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.dev.intourist.R
import com.dev.intourist.databinding.ItemCategoriesBinding

class CategoriesAdapter(
    private val onClick: (category: String) -> Unit,
    private val list: List<String>,
    private val context: Context
) :
    RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    private var selectedPosition = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder(
            ItemCategoriesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(list[position], onClick)
    }


    inner class CategoriesViewHolder(private val binding: ItemCategoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: String,
            onClick: (category: String) -> Unit,
        ) {
            binding.btnCategory.setOnClickListener {
                onClick(item)
                selectedPosition = adapterPosition
                notifyDataSetChanged()
            }
            if (selectedPosition==adapterPosition) {
                binding.btnCategory.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.white
                    )
                )
                binding.btnCategory.backgroundTintList =
                    ContextCompat.getColorStateList(context, R.color.light_green_for_button_filter)
            } else {
                binding.btnCategory.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.black
                    )
                )
                binding.btnCategory.backgroundTintList =
                    ContextCompat.getColorStateList(context, R.color.white)
            }
            binding.btnCategory.text = item
        }
    }
}