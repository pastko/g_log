package com.gteam.glog.comment.service;

import com.gteam.glog.comment.repository.CommentRepository;
import com.gteam.glog.domain.dto.comment.CommentContentsDTO;
import com.gteam.glog.domain.dto.comment.CommentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public String createComment(CommentRequestDTO requestDTO, String id) {
        CommentContentsDTO commentContentsDTO = new CommentContentsDTO();
        LocalDate now = LocalDate.now();

        commentContentsDTO.setContent(requestDTO.getContent());
        commentContentsDTO.setNikNm(requestDTO.getNikNm());
        commentContentsDTO.setBord_idx(requestDTO.getBord_idx());
        commentContentsDTO.setCreateDt(now);

        return commentRepository.createComment(commentContentsDTO, id);
    }

    public CommentContentsDTO updateComment(int idx) {
        return commentRepository.updateComment(idx);
    }

    public List<CommentContentsDTO> detailComment(int bord_idx) {
        return commentRepository.detailComment(bord_idx);
    }

    public String deleteComment(int idx) {
        return commentRepository.deleteComment(idx);
    }

}
