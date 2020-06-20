package com.student.management.utility;

import java.awt.GridBagConstraints;

public class IntializeButtonConstraints {
	public GridBagConstraints generateConstraints (int xAxis)
	{
		GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = xAxis;
        buttonConstraints.gridy = 0;
        buttonConstraints.weightx=0.25;
        buttonConstraints.weighty=0.1;
        return buttonConstraints;
	}
}
