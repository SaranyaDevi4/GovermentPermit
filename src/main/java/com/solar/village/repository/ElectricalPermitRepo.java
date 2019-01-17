package com.solar.village.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myspace.solarvillage.ElectricalPermit;

@Repository
public interface ElectricalPermitRepo extends CrudRepository<ElectricalPermit, Long>{

	List<ElectricalPermit> findByStatus(String status);

}
