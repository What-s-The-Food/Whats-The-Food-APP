package xyz.heydarrn.whatsthefood.model

import android.os.Parcelable

@kotlinx.parcelize.Parcelize
data class DummyFoods(
    val foodName:String,
    val foodPictures:Int,
    val shortDescription:String,
    val protein:String,
    val carbohydrate:String,
    val calories:String,
    val fattyAcid:String
) : Parcelable
