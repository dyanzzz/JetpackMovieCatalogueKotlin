package com.dicoding.jetpack.jetpackmoviecataloguekotlin.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieEntity(
    var movieId: String,
    var title: String,
    var date: String,
    var category: String,
    var description: String,
    var imagePath: String
): Parcelable
