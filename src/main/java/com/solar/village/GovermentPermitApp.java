package com.solar.village;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.myspace.solarvillage.ElectricalPermit;
import com.myspace.solarvillage.StructuralPermit;
import com.solar.village.controller.RestApiController;
import com.solar.village.repository.ElectricalPermitRepo;
import com.solar.village.repository.StructuralPermitRepo;
import com.solar.village.route.TimerRoute;
import com.solar.village.service.PermitService;

@SpringBootApplication
@EntityScan(basePackageClasses={ElectricalPermit.class,StructuralPermit.class})
@ComponentScan(basePackageClasses={RestApiController.class,PermitService.class,TimerRoute.class})
@EnableJpaRepositories(basePackageClasses= {ElectricalPermitRepo.class,StructuralPermitRepo.class})
public class GovermentPermitApp {
	
	public static final Logger logger = LoggerFactory.getLogger(GovermentPermitApp.class);
	
	public static void main(String[] args) {
        SpringApplication.run(GovermentPermitApp.class, args);
    }
}
