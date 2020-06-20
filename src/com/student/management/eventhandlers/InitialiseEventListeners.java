package com.student.management.eventhandlers;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class InitialiseEventListeners {

	public void initialiseListeners(JPanel buttonLayout, JTable intializeTable, JScrollPane scrollPane, JPanel mainLayoutHolder)
	{
		JButton pauseButton = (JButton) buttonLayout.getComponent(0);
		JButton removeButton =  (JButton) buttonLayout.getComponent(1);
		JButton addUserButton =  (JButton) buttonLayout.getComponent(2);
		
		if (pauseButton.getActionListeners().length > 0) {
			for (ActionListener g : pauseButton.getActionListeners()) {
				pauseButton.removeActionListener(g);
			}
		}
		
		if (removeButton.getActionListeners().length > 0) {
			for (ActionListener g : removeButton.getActionListeners()) {
				removeButton.removeActionListener(g);
			}
		}
		
		if (addUserButton.getActionListeners().length > 0) {
			for (ActionListener g : addUserButton.getActionListeners()) {
				addUserButton.removeActionListener(g);
			}
		}
		
		new HandlePauseEventListener().handlePause(pauseButton, intializeTable);
		new HandleRemoveEventListener().handleRemove(removeButton, intializeTable, pauseButton);
		new HandleAddEventListener().handleAdd(buttonLayout, addUserButton, intializeTable, scrollPane, mainLayoutHolder);
		new HandleStudentTableEventsListener().handleTable(intializeTable, pauseButton, removeButton, mainLayoutHolder);
	}
}
