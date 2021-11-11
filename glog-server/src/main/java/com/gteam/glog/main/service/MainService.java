package com.gteam.glog.main.service;

import com.gteam.glog.domain.dto.post.PostContentsDTO;
import com.gteam.glog.main.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    private final MainRepository mainRepository;

    @Autowired
    public MainService(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    public List<PostContentsDTO> setMainPage(int pageNum, int sortRule) {

        List<PostContentsDTO> resultList = mainRepository.CallBoardData(pageNum, sortRule);

        return resultList;
    }
}
