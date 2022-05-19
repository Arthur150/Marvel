package com.example.marvel.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MarvelComic(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("thumbnail") val thumbnail: Thumbnail
) : Serializable
