package com.delrisu.pcsscovid.repository;


import com.delrisu.pcsscovid.model.UserDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends CrudRepository<UserDao, Integer> {
    UserDao findByUsername(String username);

    @Transactional
    Integer deleteByUsername(String username);

    @Modifying
    @Transactional
    @Query("update UserDao user set user.password = :password where user.username = :username")
    Integer updatePassword(@Param(value = "username") String username, @Param(value = "password") String password);
}
