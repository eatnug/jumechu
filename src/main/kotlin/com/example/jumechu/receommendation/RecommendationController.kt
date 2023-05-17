package com.example.jumechu.receommendation

import com.example.jumechu.menu.Menu
import jakarta.websocket.server.PathParam
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