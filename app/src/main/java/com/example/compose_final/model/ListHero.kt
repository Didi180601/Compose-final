package com.example.compose_final.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListHero (
    val id: String,
    val name: String,
    val photoUrl: String,
    val description:String,
) : Parcelable