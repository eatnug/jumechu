package com.example.jumechu.preference

import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/v1/preference")
class PreferenceController(private val preferenceService: PreferenceService) {
    @PutMapping("/like")
    fun likeMenu(@RequestBody request: LikeMenuRequest) {
        preferenceService.likeMenu(userId = request.userId, menuId = request.menuId)
    }

    @PutMapping("/dislike")
    fun dislikeMenu(@RequestBody request: LikeMenuRequest) {
        preferenceService.dislikeMenu(userId = request.userId, menuId = request.menuId)
    }
}

data class LikeMenuRequest(val userId: Long, val menuId: Long)