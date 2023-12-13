package com.telemedApp;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    @Override
    Optional<User> findById(Long aLong);

    List<User> findByDoctor_Id(long id);
}
