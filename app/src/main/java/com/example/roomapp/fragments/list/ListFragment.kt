package com.example.roomapp.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.roomapp.R
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Armazena no val a View do Fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        // Evento botão para ir o fragment seguinte
        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        // Retorna View
        return view
    }
}