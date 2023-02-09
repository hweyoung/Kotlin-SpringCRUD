package com.study.kotlin.user

import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service

@Service
class UserService(
    var userRepository: UserRepository,
    var modelMapper: ModelMapper
) {
    fun loginUser(userDto: UserDto){
        //login
        if(userRepository.countUserById(userDto.id)>0){
            print("login")
            var user: User = userRepository.findUserById(userDto.id)
            print(user.id)
        }
        //join
        print("join")
        userRepository.save(modelMapper.map(userDto, User::class.java)).userIdx
    }

    fun getUser(id: String): User{
        return userRepository.findUserById(id)
    }

}