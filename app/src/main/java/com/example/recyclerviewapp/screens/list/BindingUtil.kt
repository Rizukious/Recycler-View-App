package com.example.recyclerviewapp.screens.list

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.NumberFormat
import java.util.*

// class untuk memberi format yang berisi binding adapter untuk format sebagai argument yang terhubung dengan data binding
@BindingAdapter("hargaFormatted")
// FUngsi untuk memberi format mata uang Indonesia
fun TextView.hargaFormatted(
    item : com.example.recyclerviewapp.data.Menu?
) {
    item?.let {
        val locale = Locale("in", "ID")
        val formatCurrency = NumberFormat.getCurrencyInstance(locale)
        text = formatCurrency.format(it.harga)
    }
}