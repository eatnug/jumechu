package com.example.jumechu.menu

import com.example.jumechu.user.User
import jakarta.persistence.*

@Entity
@Table
data class Menu(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    @Enumerated(EnumType.STRING)
    var nationality: FoodNationality,
)

enum class FoodNationality {
    Korean,
    French,
    Japanese
}