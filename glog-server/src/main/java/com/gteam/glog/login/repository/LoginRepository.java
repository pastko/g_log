package com.gteam.glog.login.repository;

import com.gteam.glog.domain.dto.UserInfoDTO;
import com.gteam.glog.domain.entity.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class LoginRepository {
    private final EntityManager entityManager;
    public LoginRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Get User Info by Userid
     *
     * @param id
     * @return UserInfoDTO
     */
    public Optional<UserInfoDTO> getUserInfoByUserId(String id){
        List<UserInfoDTO> userInfoDTO = entityManager
                .createQuery("select usr from UserInfos as usr where usr.usr_idx.userId = ?1", UserInfoDTO.class)
                .setParameter(1,id)
                .getResultList();
        return Optional.of(userInfoDTO.get(0));
    }

    /**
     * Get Users by Userid
     *
     * @param id
     * @return Users
     */
    public Optional<Users> getUsersByUserId(String id){
        System.out.println("id;:::::::"+id);
        List<Users> users = entityManager
                .createQuery("select usr from Users as usr where usr.userId = \""+id+"\"", Users.class)
//                .setParameter(1,id)
                .getResultList();
        users.stream().map(e->{
            System.out.println("repo: "+ e);
            return null;
        });

        return Optional.of(users.get(0));
    }
}
