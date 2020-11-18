package com.example.recyclerviewapp.screens.list

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.databinding.FragmentListBinding

class ListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       //Menambahkan Objek Data Binding
        val binding =  DataBindingUtil.inflate<FragmentListBinding>(
                inflater,
                R.layout.fragment_list,
                container,
                false
        )

        //Membuat objek view model
        val viewModel = ViewModelProvider(requireActivity())
            .get(ListViewModel::class.java)

        //Membuat objek menu listener
        val menuListener = MenuListener()
        menuListener.itemCheckListener = {
            val alertDialog = AlertDialog.Builder(context)
            alertDialog.setTitle("Detail")
            alertDialog.setMessage("${it.deskripsi}")
            alertDialog.setPositiveButton("Ok", {
                _, _ ->
            })
            alertDialog.show()
        }

        //Membuat objek adapter
        // Menambahkan parameter dari objek menulister
        val adapter = ListAdapter(menuListener)
        binding.recyclerView.adapter = adapter
        viewModel.menus.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })

        return binding.root
    }

}