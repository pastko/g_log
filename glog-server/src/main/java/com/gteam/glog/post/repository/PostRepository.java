package com.gteam.glog.post.repository;

import com.gteam.glog.domain.dto.post.PostContentsDTO;
import com.gteam.glog.domain.dto.post.PostRequestDTO;
import com.gteam.glog.domain.entity.Board;
import com.gteam.glog.domain.entity.Contents;
import com.gteam.glog.domain.entity.Mypage;
import com.gteam.glog.domain.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Repository
@Transactional
public class PostRepository {

    private final EntityManager entityManager;

    @Autowired
    public PostRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public String createPost(PostContentsDTO postContentsDTO) {
        Board board = new Board();
        Contents contents = new Contents();
        LocalDate now = LocalDate.now();

        try {
            String query = "select u from usr u where mail=" + postContentsDTO.getId();
            Users users = (Users) entityManager.createQuery(query);
            query = "select m from mypg m where usr_idx=" + users.getIdx();
            Mypage mypage = (Mypage) entityManager.createQuery(query);

            board.setUsr_idx(mypage);
            contents.setBoard(board);
            contents.setTitle(postContentsDTO.getTitle());
            contents.setContents(postContentsDTO.getContents());
            contents.setImg_nm(postContentsDTO.getImgNm());
            contents.setCreateDt(now.toString());
            contents.setUpdateDt(now.toString());

            entityManager.persist(board);
            entityManager.persist(contents);

            entityManager.flush();
            entityManager.close();

            return "ok";
        } catch (Exception e) {
            return null;
        }
    }

    public PostContentsDTO updatePost(int idx) {
        PostContentsDTO result = new PostContentsDTO();
        try {
            String query = "select c from bord_cont c where bord_idx=" + idx;
            Contents contents = (Contents) entityManager.createQuery(query);

            result.setContents(contents.getContents());
            result.setTitle(contents.getTitle());
            result.setImgNm(contents.getImg_nm());
            result.setIdx(contents.getIdx());
            result.setCreateDt(contents.getCreateDt());

            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public PostContentsDTO detailPost(int idx) {
        PostContentsDTO result = new PostContentsDTO();
        try {
            String query = "select c from bord_cont c where bord_idx=" + idx;
            Contents contents = (Contents) entityManager.createQuery(query);

            result.setContents(contents.getContents());
            result.setTitle(contents.getTitle());
            result.setImgNm(contents.getImg_nm());
            result.setIdx(contents.getIdx());
            result.setCreateDt(contents.getCreateDt());

            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public String deletePost(int idx) {
        try {
            String query = "select c from bord_cont c where bord_idx=" + idx;
            Contents contents = (Contents) entityManager.createQuery(query);
            query = "select b from bord b where bord_idx=" + idx;
            Board board = (Board) entityManager.createQuery(query);

            entityManager.remove(contents);
            entityManager.remove(board);

            entityManager.flush();
            entityManager.close();

            return "ok";
        } catch (Exception e) {
            return null;
        }
    }
}