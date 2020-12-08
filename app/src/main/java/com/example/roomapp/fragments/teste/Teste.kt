package com.example.roomapp.fragments.teste

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.roomapp.R
import kotlinx.android.synthetic.main.fragment_teste.view.*

class Teste : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_teste, container, false)

        view.bt_back.setOnClickListener {
            backTela()
        }

        return view
    }

    private fun backTela() {
        findNavController().navigate(R.id.action_testeFragment_to_addFragment)
    }
}