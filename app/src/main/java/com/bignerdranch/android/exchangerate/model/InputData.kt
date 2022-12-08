package com.bignerdranch.android.exchangerate.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InputData(
    val CharCode: String,
    val Nominal: Int,
    val Value: Float
): Parcelable
