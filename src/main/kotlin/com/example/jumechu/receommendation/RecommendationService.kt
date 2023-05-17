package com.example.jumechu.receommendation

import com.example.jumechu.menu.Menu
import com.example.jumechu.menu.MenuRepository
import com.example.jumechu.user.UserRepository
import org.springframework.stereotype.Service

@Service
class RecommendationService(private val userRepository: UserRepository, private val menuRepository: MenuRepository) {
    fun recommendMenu(userIds: List<Long>): Menu {
        val queriedUsers = userRepository.findAllById(userIds)
        if (queriedUsers.isEmpty()) {
            throw IllegalStateException("유저 정보를 찾을 수 없습니다.")
        }
        val users = queriedUsers.toList()

        val disliked = users.map { it.dislikedMenus }.flatten()

        val menus = menuRepository.findAll().filter {
            it !in disliked
        }

        if (menus.isEmpty()) {
            throw IllegalStateException("모두가 싫어하지 않는 메뉴를 찾을 수 없습니다.")
        }
        
        return menus[0]
    }
}