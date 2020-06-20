package com.student.management.utility;

import java.awt.Toolkit;

public class CalculateWindowsDimensions {

	public int[] calculatedimension()
	{
		int[] returnData = new int[2];
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int xSize = ((int) toolkit.getScreenSize().getWidth());
		int ySize = ((int) toolkit.getScreenSize().getHeight());
		int windowWidth = (int) (Math.round(xSize * 0.90));
		int windowHeight = (int) (Math.round(ySize * 0.75));
		returnData[0] = windowWidth;
		returnData[1] = windowHeight;
		return returnData;
	}
}
