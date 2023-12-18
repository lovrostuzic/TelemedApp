package com.telemedApp;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
public interface MeasurementRepository extends CrudRepository<Measurement,Long> {


    void deleteById(long aLong);

    List<Measurement> findByUserId(long userId);

    List<Measurement> findByUser(User user);

    @Transactional
    @Modifying
    @Query("delete from Measurement m where m.user = ?1")
    int deleteByUser(User user);

}
