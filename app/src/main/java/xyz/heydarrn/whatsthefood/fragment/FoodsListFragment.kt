package xyz.heydarrn.whatsthefood.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import xyz.heydarrn.whatsthefood.R
import xyz.heydarrn.whatsthefood.databinding.FragmentFoodsListBinding
import xyz.heydarrn.whatsthefood.model.DummyFoodListAdapter
import xyz.heydarrn.whatsthefood.model.DummyFoods
import xyz.heydarrn.whatsthefood.viewmodel.DummyFoodsViewModel

class FoodsListFragment : Fragment() {
    private var _bindingFood:FragmentFoodsListBinding?=null
    private val bindingFood get() = _bindingFood!!
    private val list=ArrayList<DummyFoods>()
    private val adapterDummy by lazy { DummyFoodListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _bindingFood=FragmentFoodsListBinding.inflate(inflater,container,false)
        return bindingFood.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        true.loadingProgress()
        list.addAll(listFood)
        setRecyclerView()

    }

    private val listFood:ArrayList<DummyFoods> get() {
        this.resources.apply {
            val foodName=getStringArray(R.array.food_list)
            val foodPics=obtainTypedArray(R.array.foods_pictures)
            val foodDesc=getStringArray(R.array.food_desc)
            val foodCalories=getStringArray(R.array.food_calories)
            val foodProtein=getStringArray(R.array.food_proteins)
            val foodCarbs=getStringArray(R.array.food_carbohydrate)
            val foodFats=getStringArray(R.array.food_fatsacid)

            val listPerFood=ArrayList<DummyFoods>()
            for (foodie in foodName.indices){
                val food=DummyFoods(
                    foodName = foodName[foodie],
                    foodPictures = foodPics.getResourceId(foodie,-1),
                    shortDescription = foodDesc[foodie],
                    calories = foodCalories[foodie],
                    protein = foodProtein[foodie],
                    carbohydrate = foodCarbs[foodie],
                    fattyAcid = foodFats[foodie]
                )
                listPerFood.add(food)
            }
            foodPics.recycle()
            return listPerFood
        }

    }

    private fun setRecyclerView (){
        bindingFood.recyclerViewFoodList.layoutManager=LinearLayoutManager(context)
        adapterDummy.submitList(list)
        bindingFood.recyclerViewFoodList.adapter=adapterDummy
        adapterDummy.setThisFoodToDetail(object : DummyFoodListAdapter.ChooseThisFood {
            override fun showThisFood(showSelectedFood: DummyFoods) {
                val sendCompleteFood=DummyFoods(
                    foodName = showSelectedFood.foodName,
                    foodPictures = showSelectedFood.foodPictures,
                    shortDescription = showSelectedFood.shortDescription,
                    protein = showSelectedFood.protein,
                    calories = showSelectedFood.calories,
                    carbohydrate = showSelectedFood.carbohydrate,
                    fattyAcid = showSelectedFood.fattyAcid
                )

                findNavController().navigate(FoodsListFragmentDirections.actionNavigationFoodsToFoodFactsFragment(sendCompleteFood))
            }

        })
        false.loadingProgress()
    }

    private fun Boolean.loadingProgress(){
        when(this){
            true -> bindingFood.progressBarFoodList.visibility=View.VISIBLE
            false -> bindingFood.progressBarFoodList.visibility=View.GONE
        }
    }
}