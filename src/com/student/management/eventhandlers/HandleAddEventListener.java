package com.student.management.eventhandlers;

import com.student.management.view.RenderAddNamePopup;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandleAddEventListener {

    public void handleAdd(JPanel buttonLayout, JButton addButton, JTable table, JScrollPane scrollPane, JPanel mainLayoutHolder)
    {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	boolean isDataEntered = true;
            
            	while(isDataEntered)
            	{
            		RenderAddNamePopup addName = new RenderAddNamePopup(buttonLayout, table, scrollPane, mainLayoutHolder);
                	isDataEntered = addName.requireInfo();	
            	}
            	
            }
        });
    }
}
