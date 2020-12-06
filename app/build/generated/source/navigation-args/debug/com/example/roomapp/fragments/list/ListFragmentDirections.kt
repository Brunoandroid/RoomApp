package com.example.roomapp.fragments.list

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.roomapp.R
import com.example.roomapp.db.User
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

class ListFragmentDirections private constructor() {
  private data class ActionListFragmentToUpdateFragment(
    val currentUser: User
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_listFragment_to_updateFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(User::class.java)) {
        result.putParcelable("currentUser", this.currentUser as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(User::class.java)) {
        result.putSerializable("currentUser", this.currentUser as Serializable)
      } else {
        throw UnsupportedOperationException(User::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  companion object {
    fun actionListFragmentToAddFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_listFragment_to_addFragment)

    fun actionListFragmentToUpdateFragment(currentUser: User): NavDirections =
        ActionListFragmentToUpdateFragment(currentUser)
  }
}
