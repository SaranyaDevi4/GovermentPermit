package com.solar.village.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myspace.solarvillage.ElectricalPermit;
import com.myspace.solarvillage.StructuralPermit;
import com.solar.village.service.PermitService;

@RestController
@RequestMapping("/")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	PermitService permitService;

	@RequestMapping(method = RequestMethod.POST, value = "/electricalpermit/submit")
	@ResponseBody
	public ResponseEntity<?> submitElectricalPermitRequest(@RequestBody ElectricalPermit request) {

		Long permitId = permitService.submitElectricalPermitRequest(request);
		if (permitId != null)
			return new ResponseEntity<Long>(permitId, HttpStatus.CREATED);
		return new ResponseEntity<Long>(permitId, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/structuralpermit/submit")
	@ResponseBody
	public ResponseEntity<?> submitStructuralPermitRequest(@RequestBody StructuralPermit request) {

		Long permitId = permitService.submitStructuralPermitRequest(request);
		if (permitId != null)
			return new ResponseEntity<Long>(permitId, HttpStatus.CREATED);
		return new ResponseEntity<Long>(permitId, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/electricalpermit/{id}")
	@ResponseBody
	public ResponseEntity<?> getElectricalPermitStatus(@PathVariable("id") Long id) {

		String status = permitService.getElectricalPermitStatus(id);
		if (status != null)
			return new ResponseEntity<String>(status, HttpStatus.OK);
		return new ResponseEntity<String>(status, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/structuralpermit/{id}")
	@ResponseBody
	public ResponseEntity<?> getStructuralpermitStatus(@PathVariable("id") Long id) {

		String status = permitService.getStructuralPermitStatus(id);
		if (status != null)
			return new ResponseEntity<String>(status, HttpStatus.OK);
		return new ResponseEntity<String>(status, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/electricalpermit/{id}")
	@ResponseBody
	public <T> ResponseEntity<?> rescindElectricalPermit(@PathVariable("id") Long id) {

		permitService.rescindElectricalPermit(id);
		return new ResponseEntity<T>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/structuralpermit/{id}")
	@ResponseBody
	public <T> ResponseEntity<?> rescindStructuralPermit(@PathVariable("id") Long id) {

		permitService.rescindStructuralPermit(id);
		return new ResponseEntity<T>(HttpStatus.OK);
	}

}
