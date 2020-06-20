package com.student.management.windowproperty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class AdjustViewPort extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel display;
	JFrame frame;
	private JTextField width;
	private JTextField height;
	private JTabbedPane tabbedPanel;


	public AdjustViewPort(JFrame frame, JTextField width, JTextField height, JTabbedPane tabbedPanel) {
		
		this.frame = frame;
        frame.addComponentListener(new FrameListen());
        this.width = width;
        this.height = height;
        this.tabbedPanel = tabbedPanel;
	}

	private class FrameListen implements ComponentListener {

		@Override
		public void componentHidden(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void componentMoved(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void componentResized(ComponentEvent arg0) {
			frame.setResizable(true);
			width.setText(Integer.toString(frame.getWidth()));
			height.setText(Integer.toString(frame.getHeight()));
			int width = (frame.getWidth() * 90)/100;
			int height = (frame.getHeight() * 90)/100;
			tabbedPanel.setPreferredSize(new Dimension(width, height));
			
		}

		@Override
		public void componentShown(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
}