package com.telemedApp;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MeasurementRepository extends CrudRepository<Measurement,Long> {


    List<Measurement> findByUser_Id(long id);
}
