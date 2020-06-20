package com.student.management.model;

import java.util.Map;

public class ManageStudentInformation 
{
	public Object[][] renderStudentMapAsObjects(Map<String, String[]> StudentDataMap) {
		
		Object[][] displayDataObj = new Object[StudentDataMap.size()][4];
		if(StudentDataMap.isEmpty())
		{
			displayDataObj = new Object[1][1];
			displayDataObj[0][0] = "The Queue is empty!";
		}
		else
		{
			int iterator = 0;
			int sNo = 1;
			for (String key : StudentDataMap.keySet()) {
				String[] data = StudentDataMap.get(key);
				displayDataObj[iterator][0] = sNo;
				displayDataObj[iterator][1] = data[1];
				displayDataObj[iterator][2] = key;
				displayDataObj[iterator][3] = data[0];
				sNo++;
				iterator++;
			}
		}
		return displayDataObj;
	}
	
	public Map<String, String[]> removeUserFromMap(String value, Map<String, String[]> dataMap) {
		if (value != null) {
			if (dataMap.containsKey(value)) {
				dataMap.remove(value);
			}
		}
		return dataMap;
	}

}
