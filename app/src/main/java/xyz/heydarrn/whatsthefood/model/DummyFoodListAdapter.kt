package xyz.heydarrn.whatsthefood.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import xyz.heydarrn.whatsthefood.databinding.FoodCardBinding

class DummyFoodListAdapter : ListAdapter<DummyFoods,DummyFoodListAdapter.DummyFoodsViewHolder>(DummyFoodsDiffUtil()) {
    var whenFoodSelected:ChooseThisFood?=null

    fun setThisFoodToDetail(thisSelectedFood:ChooseThisFood){
        this.whenFoodSelected=thisSelectedFood
    }
    inner class DummyFoodsViewHolder(private val bindingFoods:FoodCardBinding):RecyclerView.ViewHolder(bindingFoods.root) {
        fun setFoodToBinds(foodsToBind:DummyFoods){
            bindingFoods.apply {
                Glide.with(itemView)
                    .load(foodsToBind.foodPictures)
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .into(foodPicture)

                foodTitle.text=foodsToBind.foodName
                foodSubtitle.text=foodsToBind.shortDescription
                foodFacts.setOnClickListener {
                    whenFoodSelected?.showThisFood(foodsToBind)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DummyFoodsViewHolder {
        val view=FoodCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DummyFoodsViewHolder(view)
    }

    override fun onBindViewHolder(holder: DummyFoodsViewHolder, position: Int) {
        holder.setFoodToBinds(getItem(position))
    }

    interface ChooseThisFood{
        fun showThisFood(showSelectedFood:DummyFoods)
    }
}