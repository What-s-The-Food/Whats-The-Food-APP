package xyz.heydarrn.whatsthefood.api

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("predict")
    fun getFoods():Call<FoodsResponse>
}