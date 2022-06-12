package xyz.heydarrn.whatsthefood

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import xyz.heydarrn.whatsthefood.databinding.ActivityPreviewBinding
import java.io.File

class PreviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPreviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //pemanggilan hasil foto
        val myFile = intent.getSerializableExtra("picture") as File
        val isBackCamera = intent.getBooleanExtra("isBackCamera", true) as Boolean

        val result = rotateBitmap(
            BitmapFactory.decodeFile(myFile.path),
            isBackCamera
        )
        binding.imgPreview.setImageBitmap(result)

        binding.btnSearch.setOnClickListener {
            Intent(this,FoodPredictionResultActivity::class.java)
                .putExtra("photo", myFile)
        }
    }

//    private fun uploadCapturedImageForPredicition(pictureToPredict:File){
//        if (pictureToPredict!=null){
//            val reducedFile= reduceFileImage(pictureToPredict as File)
//
//            val requestImage=pictureToPredict.asRequestBody("image/jpeg".toMediaTypeOrNull())
//            val imageMultipart= MultipartBody.Part.createFormData(
//                "image",
//                reducedFile.name,
//                requestImage
//            )
//
//            val service=ApiConfig.getApiService().getFoods(imageMultipart)
//            service.enqueue(object : Callback<FoodsResponse> {
//                override fun onResponse(
//                    call: Call<FoodsResponse>,
//                    response: Response<FoodsResponse>
//                ) {
//                    TODO("Not yet implemented")
//                }
//
//                override fun onFailure(call: Call<FoodsResponse>, t: Throwable) {
//                    TODO("Not yet implemented")
//                }
//
//            })
//        }
//    }
    companion object {
        const val CAMERA_X_RESULT = 200
    }
}