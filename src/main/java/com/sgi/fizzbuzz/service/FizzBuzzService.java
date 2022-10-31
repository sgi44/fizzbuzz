package com.sgi.fizzbuzz.service;

import com.sgi.fizzbuzz.model.FizzBuzzDTO;
import com.sgi.fizzbuzz.model.FizzBuzzResultDTO;
import com.sgi.fizzbuzz.model.FizzBuzzStatsDTO;

/**
 * Service to compute fizzbuzz
 * 
 * @author sgillet
 *
 */
public interface FizzBuzzService {
	
	
	/**
	 * Fizzbuzz compute
	 * 
	 * @param param Multiple number 1
	 * @return Result list of results
	 */
	public FizzBuzzResultDTO compute(FizzBuzzDTO param);
	
	
	/**
	 * Fizzbuzz stats
	 * 
	 * @return stats
	 */
	public FizzBuzzStatsDTO stats();

}
