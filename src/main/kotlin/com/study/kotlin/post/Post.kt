package com.study.kotlin.post

import com.study.kotlin.user.User
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.NoArgsConstructor
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*


@Entity
@NoArgsConstructor
@AllArgsConstructor
class Post (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_idx")
    var postIdx: Long? = null,

    @ManyToOne
    @JoinColumn(name = "user")
    @OnDelete(action = OnDeleteAction.CASCADE)
    var writer: User,

    var title: String, //글 제목

    var content: String //글 내용
){

    fun updatePost(postDto: PostDto){
        this.title = postDto.title
        this.content = postDto.content
    }
}