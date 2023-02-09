package com.study.kotlin.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserRepository : JpaRepository<User, Long>{
    fun findUserById(id: String): User

    @Query("select count(u) from User u where u.id=?1")
    fun countUserById(id: String): Int
}