package com.student.management.view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class RenderErrorPopup {

	public boolean renderErrorMessage(String errorMsg, String title)
	{
		UIManager.put("OptionPane.okButtonText", "Try again");
		JPanel Error = new JPanel();
    	JLabel Emsg;
    	Emsg = new JLabel(errorMsg);
    	Error.add(Emsg);
		JOptionPane.showMessageDialog(Error, Emsg, "Duplicate values!", 0, null);
		return true;
	}
	
	public boolean renderErrorMessage(String errorMsg, String title, boolean defaultRetrun)
	{
		JPanel Error = new JPanel();
    	JLabel Emsg;
    	Emsg = new JLabel(errorMsg);
    	Error.add(Emsg);
		JOptionPane.showMessageDialog(Error, Emsg, title, 0, null);
		return defaultRetrun;
	}
}
