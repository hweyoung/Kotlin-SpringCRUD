package com.study.kotlin.user

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    var userService: UserService
) {
    @PostMapping("/user/login")
    fun loginUser(@RequestBody userDto: UserDto){
        userService.loginUser(userDto)
    }
}