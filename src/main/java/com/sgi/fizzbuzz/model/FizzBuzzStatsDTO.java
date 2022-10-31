package com.sgi.fizzbuzz.model;

/**
 * DTO for FizzBuzz stats
 * 
 * @author sgillet
 *
 */
public class FizzBuzzStatsDTO extends FizzBuzzDTO {

	/**
	 * UUID
	 */
	private static final long serialVersionUID = 2165454771587020244L;
	
	/**
	 * Number of requests
	 */
	private long hits;
	
	
	/**
	 * Constructor
	 */
	public FizzBuzzStatsDTO() {};
	
	
	/**
	 * Constructor with parameter
	 * 
	 * @param param
	 * @param hits
	 */
	public FizzBuzzStatsDTO(FizzBuzzDTO param, long hits) {
		super(param);
		this.hits = hits;
	}
	
	
	public FizzBuzzStatsDTO(int multiple1, int multiple2, int limit, String replace1, String replace2, long hits) {
		super(multiple1, multiple2, limit, replace1, replace2);
		this.hits = hits;
	}
	
	

	public long getHits() {
		return hits;
	}

	public void setHits(long hits) {
		this.hits = hits;
	}

}
