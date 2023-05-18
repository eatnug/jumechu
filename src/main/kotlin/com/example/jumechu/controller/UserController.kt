package com.example.jumechu.controller

import com.example.jumechu.user.User
import com.example.jumechu.user.UserService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/v1/user")
class UserController(private val userService: UserService) {
    @GetMapping
    fun getUsers(): List<User> {
        return userService.getUsers();
    }

    @PostMapping
    fun registerNewUser(@RequestBody user: User) {
        userService.addUser(user)
        // 몬가몬가 성공 응답 리턴해줘야함
    }
}

