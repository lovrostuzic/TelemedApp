package com.telemedApp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MeasurementRepository extends CrudRepository<Measurement,Long> {


    void deleteById(long aLong);

    List<Measurement> findByUserId(long userId);


}
