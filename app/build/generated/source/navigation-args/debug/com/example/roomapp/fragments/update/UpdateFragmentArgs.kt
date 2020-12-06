package com.example.roomapp.fragments.update

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.example.roomapp.db.User
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

data class UpdateFragmentArgs(
  val currentUser: User
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  fun toBundle(): Bundle {
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

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): UpdateFragmentArgs {
      bundle.setClassLoader(UpdateFragmentArgs::class.java.classLoader)
      val __currentUser : User?
      if (bundle.containsKey("currentUser")) {
        if (Parcelable::class.java.isAssignableFrom(User::class.java) ||
            Serializable::class.java.isAssignableFrom(User::class.java)) {
          __currentUser = bundle.get("currentUser") as User?
        } else {
          throw UnsupportedOperationException(User::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__currentUser == null) {
          throw IllegalArgumentException("Argument \"currentUser\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"currentUser\" is missing and does not have an android:defaultValue")
      }
      return UpdateFragmentArgs(__currentUser)
    }
  }
}
