package com.example.jumechu

import com.example.jumechu.menu.Menu
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class JumechuApplication

fun main(args: Array<String>) {
    runApplication<JumechuApplication>(*args)
}

