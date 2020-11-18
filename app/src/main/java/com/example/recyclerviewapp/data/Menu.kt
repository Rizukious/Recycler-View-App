package com.example.recyclerviewapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// Memberi Parcelable data class menu
@Parcelize
data class Menu (
    var nama : String,
    var kategori : String,
    var harga : Int
) : Parcelable {
    val deskripsi : String
        get() = "Ini adalah ${nama}"
}