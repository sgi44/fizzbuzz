package com.sgi.fizzbuzz.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sgi.fizzbuzz.model.FizzBuzzDTO;
import com.sgi.fizzbuzz.model.FizzBuzzResultDTO;
import com.sgi.fizzbuzz.model.FizzBuzzStatsDTO;
import com.sgi.fizzbuzz.service.FizzBuzzService;

/**
 * Controller of Application : REST endpoints 
 * 
 * @author sgillet
 *
 */
@Component
@Path("/fizzbuzz")
public class FizzbuzzController {
	
	@Autowired
	FizzBuzzService fizzBuzzService;
	
	@GET
	@Path("/compute/{int1}/{int2}/{limit}/{str1}/{str2}")
    @Produces(MediaType.APPLICATION_JSON)
	public FizzBuzzResultDTO computeFizzBuzz(
			@PathParam("int1") int multiple1, 
			@PathParam("int2") int multiple2, 
			@PathParam("limit") int limit, 
			@PathParam("str1") String replace1, 
			@PathParam("str2") String replace2) {
		
		return fizzBuzzService.compute(new FizzBuzzDTO(multiple1, multiple2, limit, replace1, replace2));
	}
	
	
	@GET
	@Path("/stats")
    @Produces(MediaType.APPLICATION_JSON)
	public FizzBuzzStatsDTO statsFizzBuzz() {
		return fizzBuzzService.stats();
	}

}
