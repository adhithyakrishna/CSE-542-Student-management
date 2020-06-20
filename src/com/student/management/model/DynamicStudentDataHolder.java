package com.student.management.model;

import java.util.HashMap;
import java.util.Map;

public class DynamicStudentDataHolder 
{
	static Map<String, String[]> studentDataMap = new HashMap<String, String[]>();
	
	public Map<String, String[]> getStudentDataMap() {
		return studentDataMap;
	}

	public void setStudentDataMap(Map<String, String[]> studentDataMap) {
		DynamicStudentDataHolder.studentDataMap = studentDataMap;
	}
}