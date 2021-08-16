package com.example.filmesflix.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @SerializedName("id")
    val id: Int,
    @SerializedName("titulo")
    val title: String,
    @SerializedName("imagem")
    val image: String?,
    @SerializedName("descrição")
    val description: String?,
    @SerializedName("data_lancamento")
    val dataLancamento: String?,
) : Parcelable