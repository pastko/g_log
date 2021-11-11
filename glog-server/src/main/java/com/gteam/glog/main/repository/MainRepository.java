package com.gteam.glog.main.repository;

import com.gteam.glog.domain.dto.post.PostContentsDTO;
import com.gteam.glog.domain.entity.Board;
import com.gteam.glog.domain.entity.Contents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class MainRepository {
    private final EntityManager entityManager;
    private int pageSize;

    @Autowired
    public MainRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        pageSize = (int) entityManager.createQuery("Select COUNT(b) FROM bord b").getSingleResult();
    }
    /*
    * sortRule: 1. 최신순 2. 과거순
    * */
    public List<PostContentsDTO> CallBoardData(int pageNum, int sortRule) {

        List<Contents> resultList = getPageResult(pageNum, sortRule);
        List<PostContentsDTO> postContentsDTOList = new ArrayList<>();

        for(int i = 0; i < resultList.size(); i++) {
            PostContentsDTO postContentsDTO = new PostContentsDTO();

            postContentsDTO.setIdx(resultList.get(i).getIdx().getIdx());
            postContentsDTO.setNikNm(resultList.get(i).getIdx().getNikNm());
            postContentsDTO.setTitle(resultList.get(i).getTitle());
            postContentsDTO.setContents(resultList.get(i).getContents());
            postContentsDTO.setCreateDt(resultList.get(i).getCreateDt());

            postContentsDTOList.add(postContentsDTO);
        }

        return postContentsDTOList;
    }

    public List<Contents> getPageResult(int pageNum, int sortRule) {
        switch (sortRule) {
            case 1:
                return entityManager.createQuery("select b from bord_cont b").setFirstResult(pageNum * 20).setMaxResults(pageNum * 20 + 20).getResultList();
            case 2:
                return entityManager.createQuery("select b from bord_cont b order by b.cret_dt desc").setFirstResult(pageNum * 20).setMaxResults(pageNum * 20 + 20).getResultList();
            default:
                return null;
        }
    }
}
