package com.example.jumechu.menu

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.stream.Stream

@Repository
interface MenuRepository : JpaRepository<Menu, Long> {
    @Query("select m from Menu m where m.name = ?1")
    fun findByName(name: String): Menu?
}