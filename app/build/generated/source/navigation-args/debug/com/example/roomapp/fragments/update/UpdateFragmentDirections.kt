package com.example.roomapp.fragments.update

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.roomapp.R

class UpdateFragmentDirections private constructor() {
  companion object {
    fun actionUpdateFragmentToListFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_updateFragment_to_listFragment)
  }
}
