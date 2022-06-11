package xyz.heydarrn.whatsthefood.api

import com.google.gson.annotations.SerializedName

data class FoodsResponse(

	@field:SerializedName("Fat")
	val fat: String,

	@field:SerializedName("Carbohydrate")
	val carbohydrate: String,

	@field:SerializedName("Calories")
	val calories: String,

	@field:SerializedName("Protein")
	val protein: String,

	@field:SerializedName("Name")
	val name: String
)
