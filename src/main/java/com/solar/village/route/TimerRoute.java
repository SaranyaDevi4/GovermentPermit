package com.solar.village.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.solar.village.service.PermitService;

@Component
public class TimerRoute extends RouteBuilder {
    public static final String ROUTE_NAME = "TIMER_ROUTE";
    
    @Autowired
	PermitService permitService;
    
    @Override
    public void configure() throws Exception {
        from("timer:initial//start?period=60000")
                .routeId(ROUTE_NAME)
                .bean(permitService,"approveElectricalPermits")
                .bean(permitService,"approveStructuralPermits");
    }
}
