package com.dicoding.jetpack.jetpackmoviecataloguekotlin.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShowResponse(
    var id: Int,
    var name: String,
    var overview: String,
    var first_air_date: String,
    var poster_path: String,
    var backdrop_path: String,
    var original_language: String,
    var popularity: Double,
    var vote_average: Double,
    var vote_count: Int
): Parcelable
