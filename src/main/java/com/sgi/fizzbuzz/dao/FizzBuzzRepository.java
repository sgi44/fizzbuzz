package com.sgi.fizzbuzz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sgi.fizzbuzz.model.FizzBuzzDTO;
import com.sgi.fizzbuzz.model.FizzBuzzStatsDTO;

@Repository
public interface FizzBuzzRepository extends CrudRepository<FizzBuzzEntity, Long>, FizzBuzzDao {

	/*
	 * Get syntax method : 
	 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
	 */
	
	@Query(value="SELECT new com.sgi.fizzbuzz.model.FizzBuzzStatsDTO(fb.multiple1,fb.multiple2,fb.limit,fb.replace1,fb.replace2,COUNT(multiple1)) FROM FizzBuzzEntity fb GROUP BY fb.multiple1,fb.multiple2,fb.limit,fb.replace1,fb.replace2")
	public List<FizzBuzzStatsDTO> findFizzBuzzGroupByFizzBuzzWithJPQL();
	
	
	@Override
	public default void save(FizzBuzzDTO fizzbuzz) {
		this.save(new FizzBuzzEntity(fizzbuzz));
	}
	
	@Override
	public default void delete(FizzBuzzDTO fizzbuzz) {
		this.delete(new FizzBuzzEntity(fizzbuzz));
	}
	
	@Override
	public default List<FizzBuzzStatsDTO> statsFizzBuzz() {
		return this.findFizzBuzzGroupByFizzBuzzWithJPQL();
	}
	
}
