package xyz.heydarrn.whatsthefood.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import xyz.heydarrn.whatsthefood.api.ApiConfig
import xyz.heydarrn.whatsthefood.api.FoodsResponse
import xyz.heydarrn.whatsthefood.reduceFileImage
import java.io.File

class UploadImageViewModel:ViewModel() {
    private var _predictionResult=MutableLiveData<FoodsResponse>()
    private val predictionResult:MutableLiveData<FoodsResponse> get() = _predictionResult

    private fun uploadCapturedImageForPredicition(pictureToPredict: File){
        if (pictureToPredict!=null){
            val reducedFile= reduceFileImage(pictureToPredict as File)

            val requestImage=pictureToPredict.asRequestBody("image/jpeg".toMediaTypeOrNull())
            val imageMultipart= MultipartBody.Part.createFormData(
                "image",
                reducedFile.name,
                requestImage
            )

            val service= ApiConfig.getApiService().getFoods(imageMultipart)
            service.enqueue(object : Callback<FoodsResponse> {
                override fun onResponse(
                    call: Call<FoodsResponse>,
                    response: Response<FoodsResponse>
                ) {
                    if (response.isSuccessful){
                        _predictionResult.value=response.body()
                    }
                    Log.d("SUCCESS API", "onResponseAPI: ${response.body()} ")
                }

                override fun onFailure(call: Call<FoodsResponse>, t: Throwable) {
                    Log.d("FAIL API", "onFailureAPI: ${t.cause}")
                }

            })
        }
    }
}