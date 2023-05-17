package com.example.jumechu.menu

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

// 데이터 이니셜라이징 할려고 했었음
class MenuConfig {
    fun databaseInitializer(menuRepository: MenuRepository) = CommandLineRunner {
        menuRepository.saveAll(
            listOf(
                Menu(name = "딸불백", nationality = FoodNationality.Korean),
                Menu(name = "뉴김찌", nationality = FoodNationality.Korean),
                Menu(name = "쿠쿠아림", nationality = FoodNationality.French),
            )
        )
    }
}