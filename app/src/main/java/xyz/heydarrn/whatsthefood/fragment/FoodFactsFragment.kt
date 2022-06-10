package xyz.heydarrn.whatsthefood.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import xyz.heydarrn.whatsthefood.R
import xyz.heydarrn.whatsthefood.databinding.FragmentFoodFactsBinding

class FoodFactsFragment : Fragment() {
    private var _bindingFacts:FragmentFoodFactsBinding?=null
    private val bindingFacts get() = _bindingFacts!!
    private val argumentsFood:FoodFactsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _bindingFacts=FragmentFoodFactsBinding.inflate(inflater,container,false)
        return bindingFacts.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setCompleteInfoFromSelectedFood(argumentsFood)
    }

    private fun setCompleteInfoFromSelectedFood(arguments:FoodFactsFragmentArgs) {
        bindingFacts.apply {
            Glide.with(this@FoodFactsFragment)
                .load(arguments.dummyFoodsForFacts.foodPictures)
                .into(detailFoodImage)

            detailFoodTitle.text=arguments.dummyFoodsForFacts.foodName
            detailCalories.text=resources.getString(R.string.calories_template,arguments.dummyFoodsForFacts.calories)
            detailCarbohydrate.text=resources.getString(R.string.carbohydrate_template,arguments.dummyFoodsForFacts.carbohydrate)
            detailProtein.text=resources.getString(R.string.protein_template,arguments.dummyFoodsForFacts.protein)
            detailFatAcid.text=resources.getString(R.string.fatty_acid_template,arguments.dummyFoodsForFacts.fattyAcid)
        }
    }
}