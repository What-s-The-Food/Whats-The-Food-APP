package xyz.heydarrn.whatsthefood

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import xyz.heydarrn.whatsthefood.databinding.ActivityFoodPredictionResultBinding
import xyz.heydarrn.whatsthefood.viewmodel.UploadImageViewModel
import java.io.File

class FoodPredictionResultActivity : AppCompatActivity() {
    private lateinit var bindingResultPrediction:ActivityFoodPredictionResultBinding
    private val viewModelPrediction by viewModels<UploadImageViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingResultPrediction= ActivityFoodPredictionResultBinding.inflate(layoutInflater)
        setContentView(bindingResultPrediction.root)

        val pictureReceived=intent.getSerializableExtra("photo") as File
        val resultPhoto= rotateBitmap(BitmapFactory.decodeFile(pictureReceived.path))

        setPhotoResult(resultPhoto)
        setPredictionResult(pictureReceived)
    }

    private fun setPhotoResult(bitmap: Bitmap){
        bindingResultPrediction.photoTaken.setImageBitmap(bitmap)
    }

    private fun setPredictionResult(fileReceived:File){
        viewModelPrediction.uploadCapturedImageForPrediction(fileReceived)
        viewModelPrediction.setNewPredictionResult().observe(this){
            if (it!=null){
                bindingResultPrediction.apply {
                    foodNamePrediction.text=resources.getString(R.string.food_name_template,it.name)
                    caloriesPrediction.text=resources.getString(R.string.calories_template,it.calories)
                    carbPrediction.text=resources.getString(R.string.carbohydrate_template,it.carbohydrate)
                    proteinPrediction.text=resources.getString(R.string.protein_template,it.protein)
                    fatsPrediction.text=resources.getString(R.string.fatty_acid_template,it.fat)
                }
            }
        }

    }

}