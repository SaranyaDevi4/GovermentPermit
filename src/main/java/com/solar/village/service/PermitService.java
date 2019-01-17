package com.solar.village.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import com.myspace.solarvillage.ElectricalPermit;
import com.myspace.solarvillage.StructuralPermit;
import com.solar.village.repository.ElectricalPermitRepo;
import com.solar.village.repository.StructuralPermitRepo;
import com.myspace.solarvillage.Status;

@Service
@EnableJpaRepositories(basePackageClasses = { ElectricalPermitRepo.class, StructuralPermitRepo.class })
public class PermitService {

	@Autowired
	ElectricalPermitRepo electricalPermitRepo;

	@Autowired
	StructuralPermitRepo structuralPermitRepo;

	public static final Logger logger = LoggerFactory.getLogger(PermitService.class);

	public Long submitElectricalPermitRequest(ElectricalPermit request) {

		request.setStatus(Status.IN_PROGRESS.toString());
		request = electricalPermitRepo.save(request);

		return request.getId();

	}

	public Long submitStructuralPermitRequest(StructuralPermit request) {

		request.setStatus(Status.IN_PROGRESS.toString());
		request = structuralPermitRepo.save(request);

		return request.getId();

	}

	public String getElectricalPermitStatus(Long id) {
		// TODO Auto-generated method stub
		if (id > 0) {
			ElectricalPermit electricalPermit = electricalPermitRepo.findOne(id);
			if (electricalPermit != null)
				return electricalPermit.getStatus();
		}
		return null;
	}

	public String getStructuralPermitStatus(Long id) {
		// TODO Auto-generated method stub
		if (id > 0) {
			StructuralPermit structuralPermit = structuralPermitRepo.findOne(id);
			if (structuralPermit != null)
				return structuralPermit.getStatus();
		}
		return null;
	}
	
	public void approveElectricalPermits()
	{
		List<ElectricalPermit> electricalPermitList = electricalPermitRepo.findByStatus("IN_PROGRESS");
		if(electricalPermitList!=null && !electricalPermitList.isEmpty()){
			for(ElectricalPermit electricalPermit:electricalPermitList){
				electricalPermit.setStatus("APPROVED");
				electricalPermitRepo.save(electricalPermit);
			}
		}
	}
	
	public void approveStructuralPermits()
	{
		List<StructuralPermit> structuralPermitList = structuralPermitRepo.findByStatus("IN_PROGRESS");
		if(structuralPermitList!=null && !structuralPermitList.isEmpty()){
			for(StructuralPermit structuralPermit:structuralPermitList){
				structuralPermit.setStatus("APPROVED");
				structuralPermitRepo.save(structuralPermit);
			}
		}	
	}

	public void rescindElectricalPermit(Long id) {
		// TODO Auto-generated method stub
		if (id > 0) {
			ElectricalPermit electricalPermit = electricalPermitRepo.findOne(id);
			if(electricalPermit!=null)
				electricalPermitRepo.delete(electricalPermit);
	}
		
	}

	public void rescindStructuralPermit(Long id) {
		// TODO Auto-generated method stub
		if (id > 0) {
			StructuralPermit structuralPermit = structuralPermitRepo.findOne(id);
			if(structuralPermit!=null)
				structuralPermitRepo.delete(structuralPermit);
	}
	}

}