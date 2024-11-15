package com.example.barchart.presentation.githubreposlist.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubListUIModel (
    val id: Int,
    val repoName: String,
    val avatar: String
) : Parcelable