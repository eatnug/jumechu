package com.example.jumechu.controller

import com.example.jumechu.menu.FoodNationality
import com.example.jumechu.menu.Menu
import com.example.jumechu.domain.application.menu.MenuService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/menu")
class MenuController(private val menuService: MenuService) {
    @GetMapping
    fun getMenus(): List<Menu> {
        return menuService.getMenus();
    }

    @PostMapping
    fun registerNewMenu(@RequestBody menu: Menu) {
        menuService.addMenu(menu)
        // 몬가몬가 성공 응답 리턴해줘야함
    }

    @DeleteMapping("/{menuId}")
    fun deleteMenu(@PathVariable("menuId") id: Long) {
        menuService.deleteMenu(id)
        // 몬가몬가 성공 응답 리턴해줘야함
    }

    @PutMapping("/{menuId}")
    fun updateMenu(@PathVariable("menuId") id: Long, @RequestBody updateMenuRequest: UpdateMenuRequest) {
        menuService.updateMenu(id, updateMenuRequest.nationality)
        // 몬가몬가 성공 응답 리턴해줘야함
    }
}

data class UpdateMenuRequest(
    val nationality: FoodNationality
)

