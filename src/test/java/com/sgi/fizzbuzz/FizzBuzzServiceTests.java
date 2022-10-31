package com.sgi.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sgi.fizzbuzz.dao.FizzBuzzDao;
import com.sgi.fizzbuzz.model.FizzBuzzDTO;
import com.sgi.fizzbuzz.model.FizzBuzzResultDTO;
import com.sgi.fizzbuzz.model.FizzBuzzStatsDTO;
import com.sgi.fizzbuzz.service.FizzBuzzService;

@SpringBootTest
class FizzBuzzServiceTests {
	
	private final static List<FizzBuzzDTO> dataTest = Arrays.asList(
			new FizzBuzzDTO(6, 9, 50, "fizz", "buzz"), 
			new FizzBuzzDTO(3, 9, 50, "fizz", "buzz"),
			new FizzBuzzDTO(3, 5, 50, "fizz", "buzz"),
			new FizzBuzzDTO(6, 9, 100, "fizz", "buzz"),
			new FizzBuzzDTO(6, 9, 50, "fizz", "buzz"),
			new FizzBuzzDTO(6, 9, 50, "six", "neuf"),
			new FizzBuzzDTO(6, 9, 100, "fizz", "buzz"),
			new FizzBuzzDTO(6, 9, 50, "fizz", "buzz"),
			new FizzBuzzDTO(6, 9, 75, "fizz", "buzz")
	);
	
	
	@Autowired
	FizzBuzzService fizzBuzzService;
	
	@Autowired
	FizzBuzzDao fizzBuzzDao;

	
	@Test
	void testComputeBasic() {
		
		List<String> expectedResult = Arrays.asList("1","2","fizz","4","buzz","fizz","7","8","fizz","buzz","11","fizz","13","14","fizzbuzz","16","17","fizz","19","buzz");
		FizzBuzzResultDTO test = fizzBuzzService.compute(new FizzBuzzDTO(3, 5, 20, "fizz", "buzz"));
		Assertions.assertArrayEquals(expectedResult.toArray(), test.getListResults().toArray());

	}
	
	
	@Test
	void testComputeEmpty() {
		
		List<String> expectedResult = new ArrayList<String>();
		FizzBuzzResultDTO test = fizzBuzzService.compute(new FizzBuzzDTO(3, 5, 0, "fizz", "buzz"));
		Assertions.assertArrayEquals(expectedResult.toArray(), test.getListResults().toArray());

	}
	
	@Test
	void testComputeNull() {
		
		List<String> expectedResult = Arrays.asList("1","2","null","4","test","null","7","8","null","test","11","null","13","14","nulltest");
		FizzBuzzResultDTO test = fizzBuzzService.compute(new FizzBuzzDTO(3, 5, 15, null, "test"));
		Assertions.assertArrayEquals(expectedResult.toArray(), test.getListResults().toArray());

	}
	
	@Test
	void testComputeMultiple0() {
		
		FizzBuzzResultDTO test = null;
		try {
			test = fizzBuzzService.compute(new FizzBuzzDTO(3, 0, 100, "fizz", "buzz"));
		} catch (IllegalArgumentException ex) {
			Assertions.assertTrue(true);
		}
		Assertions.assertNull(test);

	}
	
	@Test
	void testComputeLarge() {
		
		FizzBuzzResultDTO test = fizzBuzzService.compute(new FizzBuzzDTO(7, 15, 10000, "sept", "quinze"));
		Assertions.assertEquals(10000, test.getListResults().size());
		Assertions.assertEquals(1333, test.getListResults().stream().filter(elt -> elt.equals("sept")).count());
		Assertions.assertEquals(571, test.getListResults().stream().filter(elt -> elt.equals("quinze")).count());
		Assertions.assertEquals(95, test.getListResults().stream().filter(elt -> elt.equals("septquinze")).count());

	}
	
	
	@Test
	void testStatsBasic() {
		
		dataTest.stream().forEach(elt -> fizzBuzzDao.save(elt));
		
		FizzBuzzStatsDTO expectedResult = new FizzBuzzStatsDTO(6, 9, 50, "fizz", "buzz", 3);
		FizzBuzzStatsDTO test = fizzBuzzService.stats();
		assertThat(test).usingRecursiveComparison().isEqualTo(expectedResult);
		
		dataTest.stream().forEach(elt -> fizzBuzzDao.delete(elt));

	}

}
