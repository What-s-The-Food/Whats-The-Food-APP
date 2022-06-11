package xyz.heydarrn.whatsthefood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.heydarrn.whatsthefood.databinding.ActivityFoodPredictionResultBinding

class FoodPredictionResultActivity : AppCompatActivity() {
    private lateinit var bindingResultPrediction:ActivityFoodPredictionResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_food_prediction_result)
        setContentView(bindingResultPrediction.root)
    }


}