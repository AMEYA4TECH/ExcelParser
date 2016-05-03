package com.criteria.parser;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


public class ProductOriginParser {

	private Logger              _LOGGER              = Logger.getLogger(getClass());
	
	public List<String> getOriginCriteria(String origin){
		List<String> originList =new ArrayList<String>();
		try{ 
		String originValue = origin;
		String originArr[] = originValue.split(",");
		
		for (String tempOrigin : originArr) {
 			originList.add(tempOrigin);
		}
		
		}catch(Exception e){
			_LOGGER.error("Error while processing Product Origin :"+e.getMessage());            
		   	return null;
		   	
		   }
		return originList;
		
	}
}
