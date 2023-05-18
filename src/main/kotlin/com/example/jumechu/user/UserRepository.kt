package com.example.jumechu.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findByIdIn(userIds: Collection<Long>): List<User>
    fun findByName(name: String): User?
}