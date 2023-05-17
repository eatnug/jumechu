package com.example.jumechu.ldomain.domain.user

import com.example.jumechu.menu.Menu
import jakarta.persistence.*


@Entity
@Table(name = "\"user\"")
class UserEntity(
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
    companion object {
        fun fromUser(user: User): UserEntity = UserEntity(id = user.id, name = user.name)
    }
}
