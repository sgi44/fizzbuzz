package com.sgi.fizzbuzz.model;

import java.util.List;

/**
 * DTO for FizzBuzz result compute
 * 
 * @author sgillet
 *
 */
public class FizzBuzzResultDTO extends FizzBuzzDTO {
	
	/**
	 * UUID
	 */
	private static final long serialVersionUID = -4998865558223382908L;
	
	/**
	 * List of results computed
	 */
	private List<String> listResults;
	
	
	/**
	 * Constructor
	 */
	public FizzBuzzResultDTO() {};
	
	/**
	 * Constructor with parameter
	 * 
	 * @param param
	 * @param listResults
	 */
	public FizzBuzzResultDTO(FizzBuzzDTO param, List<String> listResults) {
		super(param);
		this.listResults = listResults;
	}
	
	

	public List<String> getListResults() {
		return listResults;
	}

	public void setListResults(List<String> listResults) {
		this.listResults = listResults;
	}

}
