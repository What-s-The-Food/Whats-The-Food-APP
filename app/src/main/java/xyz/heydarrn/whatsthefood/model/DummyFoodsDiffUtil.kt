package xyz.heydarrn.whatsthefood.model

import androidx.recyclerview.widget.DiffUtil

class DummyFoodsDiffUtil : DiffUtil.ItemCallback<DummyFoods>() {
    override fun areItemsTheSame(oldItem: DummyFoods, newItem: DummyFoods): Boolean {
        return oldItem.foodName == newItem.foodName
    }

    override fun areContentsTheSame(oldItem: DummyFoods, newItem: DummyFoods): Boolean {
        return oldItem == newItem
    }
}