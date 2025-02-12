package com.mb.newsappletzte.domain.model

import android.os.Parcelable
import androidx.room.Entity

import kotlinx.parcelize.Parcelize

//@Parcelize, Kotlin’in sağladığı bir kolaylık ve elle writeToParcel() yazmayı gerektirmez.
@Parcelize
@Entity
data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
) : Parcelable
//parcelable sayesinde bu sayede fragmentler intentler bundlelar arasi veri aktarabilirsin
//serilazible dan daha hizli cünkü bu byte dizinine ceviriyor
//Serializable ise reflection kullanarak veri saklar, bu da performansı düşürür.