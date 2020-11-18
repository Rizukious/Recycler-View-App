package com.example.recyclerviewapp.screens.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.data.Menu
import com.example.recyclerviewapp.databinding.ItemMenusBinding

// Menambahkan primary constructor
class ListAdapter(val clickListener : MenuListener) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    var data : List<Menu> = listOf()
    // Membuat member class dari ListAdapter
    // itemMenusBinding yaitu class biniding yang terhubun
    class ViewHolder private constructor(val binding : ItemMenusBinding) : RecyclerView.ViewHolder(binding.root) {
        // memberi nilai pada variable di layout xml
        fun bind(
            item : Menu,
            // Penambahan parameter click listener
            clickListener: MenuListener
        ) {
            binding.menu = item
            binding.menuListener = clickListener
            binding.executePendingBindings()
        }

        //menambahkan member class
        companion object {
            fun from(parent: ViewGroup) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemMenusBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount(): Int  = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // penambahan argument clicklistener
        holder.bind(data[position], clickListener)
    }
}

// Fungsi dianggap sebagai variable
class MenuListener() {
    var itemCheckListener : (menu : Menu) -> Unit = {}

    fun onItemClick(menu: Menu) = itemCheckListener(menu)
}