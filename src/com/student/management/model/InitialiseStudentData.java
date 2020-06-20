package com.student.management.model;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class InitialiseStudentData {

	Map<String, String[]> StudentDataMap = new LinkedHashMap<>();

	public InitialiseStudentData() {
		
		Random random = new Random();
		int randomCount = random.nextInt((4 - 0) + 1) + 0;
//		System.out.println("The random count is " + randomCount);
		//remove this
		Map<String, String[]> StudentDataMapHolder = new LinkedHashMap<>();
		StudentDataMapHolder.put("adhithya@buffalo.edu", new String[] { "Unpaused", "Adhithya" });
		StudentDataMapHolder.put("peiyu@buffalo.edu", new String[] { "Unpaused", "Peiyu" });
		StudentDataMapHolder.put("aishwarya@buffalo.edu", new String[] { "Unpaused", "Aishwarya" });
		StudentDataMapHolder.put("anuj@buffalo.edu", new String[] { "Unpaused", "Anuj" });
		
		Iterator<String> itr = StudentDataMapHolder.keySet().iterator();
		while(randomCount >0 && itr.hasNext())
		{
			String key = itr.next();
			String[] data = StudentDataMapHolder.get(key);
			StudentDataMap.put(key, data);
			randomCount--;
		}
	}

	public Map<String, String[]> initStudentData() {
		return StudentDataMap;
	}	

}
