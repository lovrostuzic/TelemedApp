package com.telemedApp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuperAdminRepository extends CrudRepository<SuperAdmin,Long>{

    SuperAdmin findByEmailAndPassword(String email, String password);


}
