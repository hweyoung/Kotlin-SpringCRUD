package com.study.kotlin.post

import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
    fun findByPostIdx(postIdx: Long): Post
}