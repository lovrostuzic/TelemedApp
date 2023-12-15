package com.telemedApp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Long> {

    Doctor findById(long aLong);
    Doctor findByEmailAndPassword(String email, String password);


}


