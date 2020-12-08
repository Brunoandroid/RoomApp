package com.example.roomapp.fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.roomapp.R

class TesteDirections private constructor() {
  companion object {
    fun actionTesteFragmentToAddFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_testeFragment_to_addFragment)
  }
}
