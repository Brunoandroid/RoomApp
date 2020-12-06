package com.example.roomapp.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapp.R
import com.example.roomapp.db.User
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    // Declara o userList
    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    // Infla o layout ao ListAdapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    // Retorna o tamanho da Lista
    override fun getItemCount(): Int {
        return userList.size
    }

    // Pega os valores da Entidade(currentItem) e joga nos elementos do layout(holder) para que sejam exibidos
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.firstName_txt.text = currentItem.firsName
        holder.itemView.lastName_txt.text = currentItem.lastName
        holder.itemView.age_txt.text = currentItem.age.toString()

        // Captura o item clicado
        holder.itemView.rowLayout.setOnClickListener{
            // Passa de fragment passando o currentItem(User)
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    //  Pega a Entidade e Adiciona na Lista
    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }


}