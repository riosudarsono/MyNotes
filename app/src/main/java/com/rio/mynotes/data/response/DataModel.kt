package com.rio.mynotes.data.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class DataModel(
    var id: String,
    var name: String) : Parcelable {
}