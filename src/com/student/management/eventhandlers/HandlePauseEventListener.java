package com.student.management.eventhandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JTable;

import com.student.management.model.DynamicStudentDataHolder;
import com.student.management.view.RenderSessionPopup;

public class HandlePauseEventListener {

	public void handlePause(JButton pauseBtn, JTable table) {
		pauseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DynamicStudentDataHolder dynamicStudentDataHolder = new DynamicStudentDataHolder();
				Map<String, String[]> studentDataMap = dynamicStudentDataHolder.getStudentDataMap();

				int rowNum = table.getSelectedRow();

				String value = (String) table.getModel().getValueAt(rowNum, 3);
				String emailKey = (String) table.getModel().getValueAt(rowNum, 2);
				rowNum = new RenderSessionPopup().displaySessionPopup(rowNum,
						value.equals("Unpaused") ? "Pause" : "Unpause");
				String[] data = studentDataMap.get(emailKey);
				if (rowNum >= 0) {
					if (value.equals("Unpaused")) {
						data[0] = "Paused";
						table.setValueAt("Paused", rowNum, 3);
						pauseBtn.setText("Unpaused");
					} else {
						data[0] = "Unpaused";
						table.setValueAt("Unpaused", rowNum, 3);
						pauseBtn.setText("Pause");
					}
					studentDataMap.put(emailKey, data);
					dynamicStudentDataHolder.setStudentDataMap(studentDataMap);
				}
			}
		});
	}
}
