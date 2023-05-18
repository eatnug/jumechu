package com.example.jumechu.controller

import com.example.jumechu.domain.application.recommendation.RecommendationService
import com.example.jumechu.menu.Menu
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/recommendation")
class RecommendationController(private val recommendationService: RecommendationService) {
    @GetMapping
    fun getRecommendation(@RequestParam("userIds") userIds: List<Long>): Menu {
        return recommendationService.recommendMenu(userIds)
    }
}