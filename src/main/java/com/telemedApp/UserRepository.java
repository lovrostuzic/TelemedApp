package com.telemedApp;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User,Long> {


    User findById(long aLong);


    User findByEmailAndPassword(String email, String password);


    List<User> findByDoctor(Doctor doctor);

    List<User> findByDoctor_Id(long id);

    List<User> findByDoctorAndNameAndLastNameOrderByNameAsc(Doctor doctor, String name, String lastName);

    List<User> findByDoctorAndNameOrLastNameOrderByNameAsc(Doctor doctor, String name, String lastName);

    @Transactional
    @Modifying
    @Query("update App_User a set a.doctor = ?1 where a.doctor = ?2")
    void updateDoctorByDoctor(@Nullable Doctor doctor, Doctor doctor1);

}
