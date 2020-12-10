package com.example.roomapp.fragments.list

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomapp.R
import com.example.roomapp.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Armazena no val a View do Fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        //RecyclerView
        val adapter = ListAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // UserViewModel
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer {
            user -> adapter.setData(user)
        })

        // Evento botão para ir o fragment seguinte
        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        // Adiciona Menu
        setHasOptionsMenu(true)

        // Retorna View
        return view
    }

    // Cria Menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    // Captura item selecionado no menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteAllUsers()
        }
        return super.onOptionsItemSelected(item)
    }

    // Deleta todos os Usuarios
    private fun deleteAllUsers() {
        // Declara o Alerta
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Sim"){ _, _ ->
            mUserViewModel.deleteAllUsers()
            Toast.makeText(requireContext(), "Usuarios Removidos com sucesso", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Não"){ _, _ ->
        }
        builder.setTitle("Deletar")
        builder.setMessage("Deseja apagar todos os usuarios?")
        // Inicializa o Alerta
        builder.create().show()
    }
}