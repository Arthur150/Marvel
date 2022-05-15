package com.example.marvel.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MarvelCharacter(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("modified") val modified: String,
    @SerializedName("thumbnail") val thumbnail: Thumbnail,
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("comics") val comics: Sample,
    @SerializedName("series") val series: Sample,
    @SerializedName("stories") val stories: Sample,
    @SerializedName("events") val events: Sample,
) : Serializable {
    companion object : DiffUtil.ItemCallback<MarvelCharacter>() {
        override fun areItemsTheSame(oldItem: MarvelCharacter, newItem: MarvelCharacter): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: MarvelCharacter,
            newItem: MarvelCharacter
        ): Boolean {
            return oldItem == newItem
        }
    }
}