package com.gteam.glog.post.controller;

import com.gteam.glog.common.utils.ResponseDTOUtils;
import com.gteam.glog.domain.dto.post.PostRequestDTO;
import com.gteam.glog.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class PostController {

    private final PostService postService;
    private final ResponseDTOUtils responseDTOUtils;

    @Autowired
    public PostController(PostService postService, ResponseDTOUtils responseDTOUtils) {
        this.postService = postService;
        this.responseDTOUtils = responseDTOUtils;
    }
    @PostMapping(value = "/write")
    public ResponseEntity<?> createPost(@RequestBody PostRequestDTO requestDTO, @RequestHeader("X-USR-ID") String id, HttpServletResponse response) {
        return responseDTOUtils.doGenerateResponseDTO(postService.createPost(requestDTO, id));
    }
    @GetMapping(value = "/write")
    public ResponseEntity<?> updatePost(@RequestParam("idx") int idx, HttpServletResponse response) {
        return responseDTOUtils.doGenerateResponseDTO(postService.updatePost(idx));
    }
    @GetMapping(value = "/details")
    public ResponseEntity<?> detailsPost(@RequestParam("idx") int idx, HttpServletResponse response) {
        return responseDTOUtils.doGenerateResponseDTO(postService.detailsPost(idx));
    }
    @PostMapping(value = "/deletepost")
    public ResponseEntity<?> deletePost(@RequestBody PostRequestDTO requestDTO, HttpServletResponse response) {
        return responseDTOUtils.doGenerateResponseDTO(postService.deletePost(requestDTO));
    }
}
