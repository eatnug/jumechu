package com.example.jumechu.domain.application.preference

import com.example.jumechu.menu.MenuRepository
import com.example.jumechu.user.UserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class PreferenceService(private val userRepository: UserRepository, private val menuRepository: MenuRepository) {
    @Transactional
    // 얘가 여기 있어서 메뉴 레포지토리까지 주입받는게 맘에 안든다
    fun likeMenu(userId: Long, menuId: Long) {
        val queriedUser = userRepository.findById(userId)

        if (queriedUser.isEmpty()) {
            throw IllegalStateException("존재하지 않는 사용자입니다.")
        }

        val queriedMenu = menuRepository.findById(menuId)

        if (queriedMenu.isEmpty()) {
            throw IllegalStateException("존재하지 않는 메뉴입니다")
        }

        val user = queriedUser.get();
        val menu = queriedMenu.get();

        if (menu in user.likedMenus) {
            user.unlikeMenu(menu)
        } else {
            user.likeMenu(menu)
        }
    }

    @Transactional
    // 얘가 여기 있어서 메뉴 레포지토리까지 주입받는게 맘에 안든다
    fun dislikeMenu(userId: Long, menuId: Long) {
        val queriedUser = userRepository.findById(userId)

        if (queriedUser.isEmpty()) {
            throw IllegalStateException("존재하지 않는 사용자입니다.")
        }

        val queriedMenu = menuRepository.findById(menuId)

        if (queriedMenu.isEmpty()) {
            throw IllegalStateException("존재하지 않는 메뉴입니다")
        }

        val user = queriedUser.get();
        val menu = queriedMenu.get();

        if (menu in user.dislikedMenus) {
            user.undislikeMenu(menu)
        } else {
            user.dislikeMenu(menu)
        }
    }
}