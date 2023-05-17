package com.example.jumechu.user

import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun getUsers(): List<User> {
        return userRepository.findAll()
    }

    fun addUser(user: User) {
        val existingUser: User? = userRepository.findByName(user.name)

        if (existingUser != null) {
            throw IllegalStateException("이미 존재하는 사용자입니다.")
        }

        userRepository.save(user)
    }
}