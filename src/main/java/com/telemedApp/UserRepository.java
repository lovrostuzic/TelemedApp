package com.telemedApp;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {


    User findById(long aLong);


    User findByEmailAndPassword(String email, String password);

    List<User> findByDoctorId(long doctorId);

    List<User> findByDoctor(Doctor doctor);
}
