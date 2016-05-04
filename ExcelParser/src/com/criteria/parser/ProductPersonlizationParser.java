package com.criteria.parser;

import java.util.ArrayList;
import java.util.List;

import com.a4.product.beans.Personalization;
import com.excel.ApplicationConstants;

public class ProductPersonlizationParser {
	public  List<Personalization> getPersonalization(
			String personalizevalue) {
		List<Personalization> personaliseList = new ArrayList<Personalization>();
		try{
		String PersonalizationArr[] = personalizevalue.split(ApplicationConstants.CONST_STRING_COMMA_SEP);
	

		for (int i = 0; i <= PersonalizationArr.length - 1; i++) {
			Personalization perObj = new Personalization();
			String pers = PersonalizationArr[i];
			String[] temp = null;
			if (pers.contains(ApplicationConstants.CONST_STRING_EQUAL)) {
				temp = pers.split(ApplicationConstants.CONST_STRING_EQUAL);
				perObj.setType(temp[0]);
				perObj.setAlias(temp[1]);
			} else {
				perObj.setType(pers);
				perObj.setAlias(pers);
			}

			personaliseList.add(perObj);
		}
		}
		catch(Exception e)
		{
			return null;
		}
		return personaliseList;

	}
}