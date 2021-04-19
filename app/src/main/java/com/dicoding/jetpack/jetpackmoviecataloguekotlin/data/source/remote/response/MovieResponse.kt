package com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    var id: Int,
    var title: String,
    var overview: String,
    var date: String,
    var poster_path: String,
    var backdrop_path: String,
    var original_language: String,
    var popularity: Double,
    var vote_average: Double,
    var vote_count: Int
): Parcelable
