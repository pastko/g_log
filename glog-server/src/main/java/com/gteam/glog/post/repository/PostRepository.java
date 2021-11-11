package com.gteam.glog.post.repository;

import com.gteam.glog.domain.entity.Board;
import com.gteam.glog.domain.entity.Contents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PostRepository {

    private final EntityManager entityManager;

    @Autowired
    public PostRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public String createPost() {
        Board board = new Board();
        Contents contents = new Contents();



        return "fail";
    }

    public String updatePost() {
        return "fail";
    }

    public String deletePost() {
        return "fail";
    }
}
