package com.developersbreach.networkrequestexercise

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val title: String?,
    val poster: String?
) : Parcelable
