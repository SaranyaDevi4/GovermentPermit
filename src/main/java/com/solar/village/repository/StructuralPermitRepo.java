package com.solar.village.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myspace.solarvillage.StructuralPermit;

@Repository
public interface StructuralPermitRepo extends CrudRepository<StructuralPermit, Long>{

	List<StructuralPermit> findByStatus(String status);

}
