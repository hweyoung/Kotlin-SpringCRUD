package com.study.kotlin.user

import javax.persistence.*

@Entity
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_idx")
    var userIdx: Long? = null,
    var id: String, //글 제목
    var pwd: String //글 내용
){

}