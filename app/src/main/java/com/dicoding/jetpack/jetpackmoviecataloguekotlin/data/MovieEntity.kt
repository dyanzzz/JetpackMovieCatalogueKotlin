package com.dicoding.jetpack.jetpackmoviecataloguekotlin.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieEntity(
    var movieId: String,
    var title: String,
    var description: String,
    var date: String,
    var tvShow: String,
    var imagePath: String
): Parcelable
