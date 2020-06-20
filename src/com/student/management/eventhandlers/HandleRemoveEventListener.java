package com.student.management.eventhandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JTable;

import com.student.management.model.DynamicStudentDataHolder;
import com.student.management.model.ManageStudentInformation;
import com.student.management.view.RenderSessionPopup;
import com.student.management.view.RenderTableView;

public class HandleRemoveEventListener {

	public void handleRemove(JButton removeButton, JTable table, JButton pauseButton) 
	{
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowNum = table.getSelectedRow();
				rowNum = new RenderSessionPopup().displaySessionPopup(rowNum, "Remove");
				if(rowNum>=0) 
				{
					String value = (String) table.getModel().getValueAt(rowNum, 2);
					Map<String, String[]> studentDataMap = new DynamicStudentDataHolder().getStudentDataMap();
					Map<String, String[]> removedUserMap = new ManageStudentInformation().removeUserFromMap(value,
							studentDataMap);
					Object[][] removedStudentInfoObj = new ManageStudentInformation()
							.renderStudentMapAsObjects(removedUserMap);
					new RenderTableView().renderTableStructure(table, removedStudentInfoObj);
					
					pauseButton.setEnabled(false);
					removeButton.setEnabled(false);
				}
			}
		});
	}

}
