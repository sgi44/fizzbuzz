package com.sgi.fizzbuzz;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sgi.fizzbuzz.model.FizzBuzzResultDTO;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FizzbuzzApplicationTests {
	
	@Autowired
    private TestRestTemplate restTemplate;
	
	@Test
	void testComputeBasic() {
		
		List<String> expectedResult = Arrays.asList("1","2","trois","4","cinq","trois","7","8","trois","cinq","11","trois","13","14","troiscinq","16","17","trois","19","cinq");
		ResponseEntity<FizzBuzzResultDTO> entity = this.restTemplate.getForEntity("/fizzbuzz/compute/3/5/20/trois/cinq", FizzBuzzResultDTO.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().getListResults()).isEqualTo(expectedResult);
		
	}
	
	@Test
	void testComputeError() {
		
		ResponseEntity<FizzBuzzResultDTO> entity = this.restTemplate.getForEntity("/fizzbuzz/compute/3/0/100/fizz/buzz", FizzBuzzResultDTO.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		
	}
	
}
