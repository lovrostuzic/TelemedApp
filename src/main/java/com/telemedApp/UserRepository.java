package com.telemedApp;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {


    User findById(long aLong);

    List<User> findByDoctor_Id(long id);

    User findByEmailAndPassword(String email, String password);
}
