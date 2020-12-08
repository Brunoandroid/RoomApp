package com.example.roomapp.fragments.update

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
import androidx.navigation.fragment.navArgs
import com.example.roomapp.R
import com.example.roomapp.db.User
import com.example.roomapp.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*
import kotlinx.android.synthetic.main.fragment_update.view.updateFirstName_et


class UpdateFragment : Fragment() {

    // Recebe os dados enviados pelo Adapter
    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mUserView: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Armazena no val a View do Fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mUserView = ViewModelProvider(this).get(UserViewModel::class.java)

        // Campos do layout recebem os dados passados pelo findNav do Adapter
        view.updateFirstName_et.setText(args.currentUser.firsName)
        view.updateLastName_et.setText(args.currentUser.lastName)
        view.updateAge.setText(args.currentUser.age.toString())

        // Ação para o botão Update
        view.update_btn.setOnClickListener {
            updateItem()
        }

        return view
    }

    private fun updateItem(){
        val firstName = updateFirstName_et.text.toString()
        val lastNome =  updateLastName_et.text.toString()
        val age = Integer.parseInt(updateAge.text.toString())

        if(inputCheck(firstName, lastNome, updateAge.text)){
            // Criar User Onject
            val updateUser = User(args.currentUser.id, firstName, lastNome, age)
            // Atualiza o Usuario
            mUserView.updateUser(updateUser)
            // Imprime texto
            Toast.makeText(requireContext(),"Atualizado com sucesso", Toast.LENGTH_SHORT).show()
            // Navigate Black
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
            // Se os campos estiverem nulos, imprime mensagem
        } else{
            Toast.makeText(requireContext(),"Não atualizado, por favor verifique os dados", Toast.LENGTH_SHORT).show()
        }
    }

    // Verifica se os campos não são nulos e da um retorno
    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }
}