package com.example.jumechu.user

import com.example.jumechu.menu.Menu
import jakarta.persistence.*


@Entity
@Table(name = "\"user\"")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,

    @ManyToMany
    @JoinTable(
        name = "menu_like",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "menu_id")]
    )
    var likedMenus: List<Menu> = listOf(),
    @ManyToMany
    @JoinTable(
        name = "menu_dislike",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "menu_id")]
    )
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
