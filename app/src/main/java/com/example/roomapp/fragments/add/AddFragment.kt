package com.example.roomapp.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomapp.R
import com.example.roomapp.db.User
import com.example.roomapp.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    lateinit var mUserviewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mUserviewModel = ViewModelProvider(this).get(UserViewModel::class.java)
    }

    private fun insertDataToDatabase(){
        val firstName = addFirstName_et.text.toString()
        val lastName = addFirstName_et.text.toString()
        val age = addAge.text

        if(inputCheck(firstName, lastName, age)){
            //Cria User Object
            val user = User(0, firstName, lastName, Integer.parseInt(age.toString()))
            // Add ao Database
            mUserviewModel.addUser(user)
            Toast.makeText(requireContext(), "Adicionado com Sucesso", Toast.LENGTH_LONG).show()
            //Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Não Adicionado, Reveja", Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }
}