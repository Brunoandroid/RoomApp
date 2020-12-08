package com.example.roomapp.fragments.add

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.roomapp.R

class AddFragmentDirections private constructor() {
  companion object {
    fun actionAddFragmentToListFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_addFragment_to_listFragment)

    fun actionAddFragmentToTesteFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_addFragment_to_testeFragment)
  }
}
