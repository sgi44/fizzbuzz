package com.sgi.fizzbuzz.model;

import java.io.Serializable;

/**
 * DTO for FizzBuzz
 * 
 * @author sgillet
 *
 */
public class FizzBuzzDTO implements Serializable {

	/**
	 * UUID
	 */
	private static final long serialVersionUID = -4340190828285462864L;
	
	/**
	 * Multiple number 1
	 */
	private int multiple1;
	
	/**
	 * Multiple number 2
	 */
	private int multiple2;
	
	/**
	 * Max value of the list to compute
	 */
	private int limit;
	
	/**
	 * Replacement value multiple 1
	 */
	private String replace1;
	
	/**
	 * Replacement value multiple 2
	 */
	private String replace2;
	
	
	
	/**
	 * Constructor
	 */
	public FizzBuzzDTO() {};
	
	/**
	 * Constructor with parameter
	 * 
	 * @param multiple1
	 * @param multiple2
	 * @param limit
	 * @param replace1
	 * @param replace2
	 */
	public FizzBuzzDTO(int multiple1, int multiple2, int limit, String replace1, String replace2) {
		this.multiple1 = multiple1;
		this.multiple2 = multiple2;
		this.limit = limit;
		this.replace1 = replace1;
		this.replace2 = replace2;
	}
	
	/**
	 * Constructor with parameter
	 * 
	 * @param fizzBuzz
	 */
	public FizzBuzzDTO(FizzBuzzDTO fizzBuzz) {
		this.multiple1 = fizzBuzz.getMultiple1();
		this.multiple2 = fizzBuzz.getMultiple2();
		this.limit = fizzBuzz.getLimit();
		this.replace1 = fizzBuzz.getReplace1();
		this.replace2 = fizzBuzz.getReplace2();
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
