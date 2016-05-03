package com.criteria.parser;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.a4.product.beans.ProductionTime;

public class ProductionTimeParser {
	
	private Logger              _LOGGER              = Logger.getLogger(getClass()); 
	
public synchronized List<ProductionTime> getProdTimeCriteria(String prodTimeValue){
		
		List<ProductionTime> prodTimeList =new ArrayList<ProductionTime>();
		try{
			String tempValue = prodTimeValue;
			String regex=null;
			String prodTimetArr[] = tempValue.split(",");
			
			ProductionTime prodTimeObj=null;
			for (String tempProdTime : prodTimetArr) {
	 			prodTimeObj= new ProductionTime();
	 			String value=tempProdTime;
	 			String valueArr[]=value.split(":"); 
	 			
	 			if(valueArr.length==2){
	 				prodTimeObj.setBusinessDays(valueArr[0]);
	 				prodTimeObj.setDetails(valueArr[1]);
	 			}else if(valueArr.length==1){
	 				  regex = "\\d+";
	 				
	 				if(valueArr[0].matches(regex)){
	 					prodTimeObj.setBusinessDays(valueArr[0]);
	 					prodTimeObj.setDetails("");
	 				}else{
	 					prodTimeObj.setBusinessDays("");
	 					prodTimeObj.setDetails(valueArr[1]);
	 				}
	 				
	 			}
	 			tempValue=null;
	 			value=null; 
	 			regex=null;
	 			prodTimeList.add(prodTimeObj);
	 			
			}
			
			
			
		}catch(Exception e){
			_LOGGER.error("Error while processing Production Time :"+e.getMessage());
	        return null;
		   	
		   }
		 
		return prodTimeList;
		}

}
