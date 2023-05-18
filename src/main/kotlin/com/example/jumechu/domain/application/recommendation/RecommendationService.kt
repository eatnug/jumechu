package com.example.jumechu.domain.application.recommendation

import com.example.jumechu.menu.Menu
import com.example.jumechu.menu.MenuRepository
import com.example.jumechu.user.UserRepository
import org.springframework.stereotype.Service

@Service
class RecommendationService(private val userRepository: UserRepository, private val menuRepository: MenuRepository) {
    fun recommendMenu(userIds: List<Long>): Menu {
        val users = userRepository.findByIdIn(userIds)
        if (users.size != userIds.size) {
            throw IllegalStateException("유저 정보를 찾을 수 없습니다.")
        }

        // FIXME. N + 1
        val liked = users.flatMap { it.likedMenus }
        val disliked = users.flatMap { it.dislikedMenus }

        val mostLikedMenus = (menuRepository.findAll() - disliked.toSet())
            .groupBy { it.countLiked(liked) }
            .toSortedMap()
            .values
            .last()

        if (mostLikedMenus.isEmpty()) {
            throw IllegalStateException("모두가 싫어하지 않는 메뉴를 찾을 수 없습니다.")
        }

        return mostLikedMenus
            .shuffled()
            .first()
    }
}
