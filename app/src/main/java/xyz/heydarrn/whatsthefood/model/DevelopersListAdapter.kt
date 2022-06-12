package xyz.heydarrn.whatsthefood.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import xyz.heydarrn.whatsthefood.databinding.DeveloperCardBinding

class DevelopersListAdapter : ListAdapter<Developers,DevelopersListAdapter.DevelopersViewHolder>(DevelopersDiffUtil()) {
    class DevelopersViewHolder (private val bindingDeveloper:DeveloperCardBinding) :RecyclerView.ViewHolder(bindingDeveloper.root) {
        fun setDeveloperToBind(developer:Developers){
            bindingDeveloper.apply {
                Glide.with(itemView)
                    .load(developer.photoProfile)
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .circleCrop()
                    .into(developerPhoto)

                Glide.with(itemView)
                    .load(developer.learningPathIcon)
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .into(devPathIcon)

                developerName.text=developer.name
                developerPath.text=developer.learningPath
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DevelopersViewHolder {
        val view=DeveloperCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DevelopersViewHolder(view)
    }

    override fun onBindViewHolder(holder: DevelopersViewHolder, position: Int) {
        holder.setDeveloperToBind(getItem(position))
    }
}