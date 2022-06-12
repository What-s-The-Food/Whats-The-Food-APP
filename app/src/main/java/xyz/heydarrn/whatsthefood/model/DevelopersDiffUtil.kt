package xyz.heydarrn.whatsthefood.model

import androidx.recyclerview.widget.DiffUtil

class DevelopersDiffUtil : DiffUtil.ItemCallback<Developers>() {
    override fun areItemsTheSame(oldItem: Developers, newItem: Developers): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Developers, newItem: Developers): Boolean {
        return oldItem == newItem
    }
}