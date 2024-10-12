package com.loc.newsapp.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L, // Primary key field with compatible type
    val author: String? = null,
    val content: String? = null,
    val description: String? = null,
    val publishedAt: String? = null,
    val source: Source? = null,
    val title: String? = null,
    val url: String,
    val urlToImage: String? = null
):Parcelable
