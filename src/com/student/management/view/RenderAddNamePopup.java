package com.student.management.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.student.management.eventhandlers.HandleRequestFocusListener;
import com.student.management.eventhandlers.InitialiseEventListeners;
import com.student.management.model.DynamicStudentDataHolder;

public class RenderAddNamePopup implements KeyListener {
	JTable table;
    JScrollPane jScrollPane;
    JPanel mainLayoutHolder;
    JPanel buttonLayout;
    
    public RenderAddNamePopup(JPanel buttonLayout, JTable table, JScrollPane scrollPane, JPanel mainLayoutHolder){
        this.table = table;
        this.jScrollPane = scrollPane;
        this.mainLayoutHolder = mainLayoutHolder;
        this.buttonLayout = buttonLayout;
    }
    
	public boolean requireInfo(){
		JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label1 = new JLabel("Name: ");
        JTextField nameField = new JTextField(10);
        nameField.addAncestorListener( new HandleRequestFocusListener() );
        JLabel label2 = new JLabel("Email:");
        JTextField emailField = new JTextField(10);
        JLabel label3 = new JLabel("password:");
        JPasswordField pass = new JPasswordField(10);   
      
        panel.add(label1);
        panel.add(nameField);
        panel.add(label2);
        panel.add(emailField);
        panel.add(label3);
        panel.add(pass);
        
        frame.add(panel);
        frame.pack();
        
        nameField.addKeyListener(this);//Listens for key inputs in the text field
        emailField.addKeyListener(this);
        pass.addKeyListener(this);
        

        UIManager.put("OptionPane.okButtonText", "Add");
        int option = JOptionPane.showConfirmDialog(null, panel, "Please register your information", JOptionPane.DEFAULT_OPTION,
        		JOptionPane.PLAIN_MESSAGE, null);
        
        if (option == 0 && !(nameField.getText().isEmpty()) && !(emailField.getText().isEmpty()) && ((pass.getPassword().length)!=0) )  //press OK button
        {
            DynamicStudentDataHolder dynamicStudentDataMap = new DynamicStudentDataHolder();
            Map<String, String[]> studentDataMap  = dynamicStudentDataMap.getStudentDataMap();
            
            if(studentDataMap.containsKey(emailField.getText()))
            {
            	RenderErrorPopup renderPopup = new RenderErrorPopup();
            	renderPopup.renderErrorMessage("User is already registered", "Duplicate Entry", false);
            }
            else 
            {
	            studentDataMap.put(emailField.getText(), new String[] { "Unpaused" , nameField.getText()});
	            dynamicStudentDataMap.setStudentDataMap(studentDataMap);
	
	         	JTable intializeTable = new RenderTableView().renderTable(studentDataMap);
	    		this.jScrollPane.setViewportView(intializeTable);
	    		
	    		JButton pauseButton = (JButton) buttonLayout.getComponent(0);
	    		JButton removeButton =  (JButton) buttonLayout.getComponent(1);
	    		
	    		pauseButton.setEnabled(false);
				removeButton.setEnabled(false);
	    		
	    		new InitialiseEventListeners().initialiseListeners(buttonLayout, intializeTable, jScrollPane, mainLayoutHolder);
            }
            
            
    		return false;
        }
        else if (option == 0)
        {
        	boolean returnVal = false;
        	RenderErrorPopup renderPopup = new RenderErrorPopup();
        	if(nameField.getText().isEmpty())
        		returnVal = renderPopup.renderErrorMessage("Name was not entered, Please try again.", "Empty fields");
        	else if(emailField.getText().isEmpty())
        		returnVal = renderPopup.renderErrorMessage("Email was not entered, Please try again.", "Empty fields");
        	else
        		returnVal = renderPopup.renderErrorMessage("Password was not entered, Please try again.", "Empty fields");
        	return returnVal;
        }
        return false;
    }

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
//		System.out.println("Key Code:" + e.getKeyCode());
//		KeyOut();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}