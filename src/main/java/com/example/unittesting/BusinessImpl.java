package com.example.unittesting;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class BusinessImpl {
	private DataService dataService;

//	public void setDataService(DataService dataService) {
//		this.dataService=dataService;
//	}

	public int calculateSum(int [] data){
		int sum =0;
		for(int value:data){
			sum += value;
		}
		return sum;
	}
	public int calculateSumUsingDataService(){
		int sum =0;
		int [] data= dataService.retrieveAllData();
		for(int value:data){
			sum += value;
		}
		return sum;
	}
	public int calculateSumUsingEmpty(){
		int sum =0;
		int [] data= dataService.retrieveEmpty();
		for(int value:data){
			sum += value;
		}
		return sum;
	}
	public int calculateSumUsingOneValue(){
		int sum =0;
		int [] data= dataService.retrieveOneValue();
		for(int value:data){
			sum += value;
		}
		return sum;
	}
}
