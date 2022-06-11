package xyz.heydarrn.whatsthefood.api

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @Multipart
    @POST("/predict")
    fun getFoods(
        @Part file:MultipartBody.Part
    ):Call<FoodsResponse>
}