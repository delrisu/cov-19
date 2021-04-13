package com.delrisu.pcsscovid.repository;


import com.delrisu.pcsscovid.model.UserDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserDao, Integer> {
    UserDao findByUsername(String username);
}
