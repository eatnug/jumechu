package com.example.jumechu.ldomain.domain.user

import com.example.jumechu.menu.Menu
import jakarta.persistence.*


data class User(
    val id: Long = 0,
    val name: String,
    var likedMenus: List<Menu> = listOf(),
    var dislikedMenus: List<Menu> = listOf()
) {
    fun likeMenu(menu: Menu) {

        val newLikedMenus = likedMenus.toMutableList()
        newLikedMenus.add(menu)
        likedMenus = newLikedMenus.toList()
    }

    fun unlikeMenu(menu: Menu) {
        val newLikedMenus = likedMenus.toMutableList()
        newLikedMenus.remove(menu)
        likedMenus = newLikedMenus.toList()
    }

    fun dislikeMenu(menu: Menu) {
        val newDislikedMenus = dislikedMenus.toMutableList()
        newDislikedMenus.add(menu)
        dislikedMenus = newDislikedMenus.toList()
    }

    fun undislikeMenu(menu: Menu) {
        val newDislikedMenus = dislikedMenus.toMutableList()
        newDislikedMenus.remove(menu)
        dislikedMenus = newDislikedMenus.toList()
    }
}
