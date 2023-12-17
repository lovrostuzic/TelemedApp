package com.telemedApp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Long> {

    Doctor findById(long aLong);
    Doctor findByEmailAndPassword(String email, String password);

    List<Doctor> findBySuperadmin(SuperAdmin superadmin);

}


