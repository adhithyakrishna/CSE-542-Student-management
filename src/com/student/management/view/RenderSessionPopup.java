package com.student.management.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

import com.student.management.eventhandlers.HandleRequestFocusListener;

public class RenderSessionPopup {

	public int displaySessionPopup(int rowNum, String value) 
	{
		UIManager.put("OptionPane.okButtonText", value);
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Enter password:");
		JPasswordField pass = new JPasswordField(10);
		pass.addAncestorListener( new HandleRequestFocusListener() );
		panel.add(label);
		panel.add(pass);
		frame.add(panel);
        frame.pack();
        int option = JOptionPane.showConfirmDialog(null, panel, "Enter your session password", JOptionPane.DEFAULT_OPTION,
        		JOptionPane.PLAIN_MESSAGE, null);
		char[] passwordCharArr = pass.getPassword();
		String password = new String(passwordCharArr);
		if (option == 0 && password.length() > 0) // pressing OK button
		{
//			System.out.println("Your password is: " + password);
		} 
		else if(option == 0 && password.length()<=0) {
			UIManager.put("OptionPane.okButtonText", "Close");
			RenderErrorPopup errorPopup = new RenderErrorPopup();
			errorPopup.renderErrorMessage("Password was not entered", "Empty fields", false);
			rowNum = -1;
		}
		else {	
			rowNum = -1;
		}
		return rowNum;
	}

}
