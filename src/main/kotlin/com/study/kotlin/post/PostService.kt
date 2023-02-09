package com.study.kotlin.post

import com.study.kotlin.user.User
import org.hibernate.boot.model.naming.IllegalIdentifierException
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostService @Autowired constructor(
    var postRepository: PostRepository,
    var modelMapper: ModelMapper
){
    fun save(postDto: PostDto, user: User){
        var post: Post = Post(null, user, postDto.title, postDto.writer)
        postRepository.save(post).postIdx
    }

    fun getPost(postIdx: Long): Post {
        return postRepository.findByPostIdx(postIdx)
    }

    fun getPostList(): List<Post> {
        return postRepository.findAll()
    }

    fun updatePost(postIdx: Long, postDto: PostDto, user: User) {
        val post: Post = postRepository.findByPostIdx(postIdx)
        if (!post.writer.id.equals(user.id)) {
            throw IllegalIdentifierException("잘못된 유저")
        }
        post.updatePost(postDto)
        postRepository.save(post)
    }

    fun deletePost(postIdx: Long, user: User){
        val post: Post = postRepository.findByPostIdx(postIdx)
        if(!post.writer.id.equals(user.id)){
            throw IllegalIdentifierException("잘못된 유저")
        }
        postRepository.delete(post)
    }
}
