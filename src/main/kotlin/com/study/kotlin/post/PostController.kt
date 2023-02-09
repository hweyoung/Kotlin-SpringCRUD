package com.study.kotlin.post

import com.study.kotlin.user.User
import com.study.kotlin.user.UserService
import org.apache.ibatis.annotations.Delete
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class PostController (
    val postService: PostService,
    val userService: UserService
){

    @PostMapping("/post/save")
    fun savePost(@RequestBody postDto: PostDto): ResponseEntity<Any>{
        var user: User = userService.getUser(postDto.writer)
        postService.save(postDto, user);
        return ResponseEntity.ok("save success")
    }

    @GetMapping("/post/{postIdx}")
    fun getPost(@PathVariable postIdx: Long):ResponseEntity<Any>{
        var post: Post = postService.getPost(postIdx)
        return ResponseEntity.ok(post)
    }

    @GetMapping("/post/list")
    fun getPostList():ResponseEntity<Any>{
        var postList: List<Post> = postService.getPostList()
        return ResponseEntity.ok(postList)
    }

    @PutMapping("/post/update/{postIdx}")
    fun updatePost(@RequestBody postDto: PostDto, @PathVariable postIdx: Long): ResponseEntity<Any>{
        val user: User = userService.getUser(postDto.writer)
        postService.updatePost(postIdx,postDto, user)
        return ResponseEntity.ok("success update")
    }

    @DeleteMapping("/post/delete/{postIdx}")
    fun deletePost(@PathVariable postIdx: Long, @RequestParam(name = "id") id: String): ResponseEntity<Any>{
        val user: User = userService.getUser(id)
        postService.deletePost(postIdx, user)
        return ResponseEntity.ok("success delete")
    }
}