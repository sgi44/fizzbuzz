package com.sgi.fizzbuzz.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgi.fizzbuzz.dao.FizzBuzzDao;
import com.sgi.fizzbuzz.model.FizzBuzzDTO;
import com.sgi.fizzbuzz.model.FizzBuzzResultDTO;
import com.sgi.fizzbuzz.model.FizzBuzzStatsDTO;

/**
 * Implement of Service to compute fizzbuzz
 * 
 * @author sgillet
 *
 */
@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {
	
	private static final Logger logger = LoggerFactory.getLogger(FizzBuzzServiceImpl.class);
	
	
	@Autowired
	FizzBuzzDao fizzBuzzDao;
	
	
	@Override
	public FizzBuzzResultDTO compute(FizzBuzzDTO param) {

		logger.info("FizzBuzz compute : multiple1 = {}, multiple2 = {}, limit= {}, replace1 = {}, replace2 = {}", 
				param.getMultiple1(), param.getMultiple2(), param.getLimit(), param.getReplace1(), param.getReplace2());
		
		if (param.getMultiple1() == 0 || param.getMultiple2() == 0)
			throw new IllegalArgumentException("The integer parameters must be greater than 0");
		
		fizzBuzzDao.save(param);
		
		List<String> result = new ArrayList<>();
		IntStream.rangeClosed(1, param.getLimit()).forEach(number -> {
			
			String item = replaceMultiple(number, param.getMultiple1(), param.getReplace1());
			item += replaceMultiple(number, param.getMultiple2(), param.getReplace2());
			
			if (StringUtils.isBlank(item))
				item = String.valueOf(number);
			
			result.add(item);
			
		});
		
		return new FizzBuzzResultDTO(param, result);
		
	}


	@Override
	public FizzBuzzStatsDTO stats() {
		
		logger.info("FizzBuzz stats");

		return fizzBuzzDao.statsFizzBuzz().stream()
				.max(Comparator.comparing(FizzBuzzStatsDTO::getHits))
				.orElseThrow(NoSuchElementException::new)
		;
		
	}
	
	
	
	/**
	 * Get value if the number  is a multiple
	 * 
	 * @param number Number to process 
	 * @param mulitple Multiple to test
	 * @param replace Value to return
	 * @return Value if the number is a multiple, empty otherwise
	 */
	private String replaceMultiple(int number, int mulitple, String replace) {
		return number % mulitple == 0 ? replace : StringUtils.EMPTY;
	}
	
	
}
