package com.sgi.fizzbuzz.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sgi.fizzbuzz.model.FizzBuzzDTO;

@Entity
@Table(name = "fizzbuzz")
public class FizzBuzzEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
	private Long id;
	
	@Column(name = "Multiple1")
	private int multiple1;
	
	@Column(name = "Multiple2")
	private int multiple2;
	
	@Column(name = "Limit")
	private int limit;
	
	@Column(name = "Replace1")
	private String replace1;
	
	@Column(name = "Replace2")
	private String replace2;
	
	
	/**
	 * Constructor
	 */
	public FizzBuzzEntity() {}
	
	
	/**
	 * Constructor with parameters
	 * 
	 * @param fizzBuzzDTO
	 */
	public FizzBuzzEntity(FizzBuzzDTO fizzBuzzDTO) {
		this.multiple1 = fizzBuzzDTO.getMultiple1();
		this.multiple2 = fizzBuzzDTO.getMultiple2();
		this.limit = fizzBuzzDTO.getLimit();
		this.replace1 = fizzBuzzDTO.getReplace1();
		this.replace2 = fizzBuzzDTO.getReplace2();
	}
	
	
	/**
	 * Constructor with parameters
	 * 
	 * @param multiple1
	 * @param multiple2
	 * @param limit
	 * @param replace1
	 * @param replace2
	 */
	public FizzBuzzEntity(int multiple1, int multiple2, int limit, String replace1, String replace2) {
		this.multiple1 = multiple1;
		this.multiple2 = multiple2;
		this.limit = limit;
		this.replace1 = replace1;
		this.replace2 = replace2;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMultiple1() {
		return multiple1;
	}

	public void setMultiple1(int multiple1) {
		this.multiple1 = multiple1;
	}

	public int getMultiple2() {
		return multiple2;
	}

	public void setMultiple2(int multiple2) {
		this.multiple2 = multiple2;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getReplace1() {
		return replace1;
	}

	public void setReplace1(String replace1) {
		this.replace1 = replace1;
	}

	public String getReplace2() {
		return replace2;
	}

	public void setReplace2(String replace2) {
		this.replace2 = replace2;
	}
	

}
