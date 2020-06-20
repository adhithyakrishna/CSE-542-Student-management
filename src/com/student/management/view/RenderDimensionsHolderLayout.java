package com.student.management.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.student.management.windowproperty.AdjustViewPort;

public class RenderDimensionsHolderLayout 
{

	public void renderLayout(JPanel dimensionInformationHolder, JFrame frame, JTabbedPane tabbedPane) {
		JTextField width;
		JTextField height;

		width = new JTextField();
		dimensionInformationHolder.add(width);
		width.setColumns(10);

		height = new JTextField();
		dimensionInformationHolder.add(height);
		height.setColumns(10);

		new AdjustViewPort(frame, width, height, tabbedPane);

	}
}