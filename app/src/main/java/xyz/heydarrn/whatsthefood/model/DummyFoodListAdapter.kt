package xyz.heydarrn.whatsthefood.model

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import xyz.heydarrn.whatsthefood.databinding.FoodCardBinding

class DummyFoodListAdapter : ListAdapter<DummyFoods,DummyFoodListAdapter.DummyFoodsViewHolder>(DummyFoodsDiffUtil()) {
    class DummyFoodsViewHolder(private val bindingFoods:FoodCardBinding):RecyclerView.ViewHolder(bindingFoods.root) {
        fun setFoodToBinds(foodsToBind:DummyFoods){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DummyFoodsViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: DummyFoodsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}