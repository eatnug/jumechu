package com.example.jumechu.menu

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class MenuService(private val menuRepository: MenuRepository) {
    fun getMenus(): List<Menu> {
        return menuRepository.findAll()
    }

    fun addMenu(menu: Menu) {
        val existingMenu: Menu? = menuRepository.findByName(menu.name)

        if (existingMenu != null) {
            throw IllegalStateException("이미 존재하는 메뉴입니다.")
        }

        menuRepository.save(menu)
    }

    fun deleteMenu(id: Long) {
        val existingMenu = menuRepository.findById(id)

        if (existingMenu.isEmpty()) {
            throw IllegalStateException("존재하지 않는 메뉴 아이디 입니다.")
        }
        menuRepository.deleteById(id)
    }

    @Transactional
    fun updateMenu(id: Long, nationality: FoodNationality) {
        val queryResult = menuRepository.findById(id)

        if (queryResult.isEmpty()) {
            throw IllegalStateException("존재하지 않는 메뉴 아이디 입니다.")
        }

        val existingMenu = queryResult.get()

        if (existingMenu.nationality == nationality) {
            throw IllegalStateException("동일한 국적으로 수정할 수 없습니다.")
        }

        existingMenu.nationality = nationality;
    }
}