package com.sgi.fizzbuzz.dao;

import java.util.List;

import com.sgi.fizzbuzz.model.FizzBuzzDTO;
import com.sgi.fizzbuzz.model.FizzBuzzStatsDTO;

public interface FizzBuzzDao {
	
	public void save(FizzBuzzDTO fizzbuzz);
	public void delete(FizzBuzzDTO fizzbuzz);
	public List<FizzBuzzStatsDTO> statsFizzBuzz();

}
