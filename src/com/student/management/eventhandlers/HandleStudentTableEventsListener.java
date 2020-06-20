package com.student.management.eventhandlers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

public class HandleStudentTableEventsListener {

	public void handleTable(JTable table, JButton pauseButton, JButton removeButton, JPanel mainLayoutHolder) {

		table.setFocusable(false);
		
//		table.
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evt) {
//				System.out.println("event fired");

				int row = table.rowAtPoint(evt.getPoint());
//				System.out.println("The row is " + row);
				if (row >= 0) {
//					System.out.println("the row is " + row);
					String value = (String) table.getModel().getValueAt(row, 3);
//					System.out.println("The value " + value);
					if (value == null) {
						pauseButton.setEnabled(false);
						removeButton.setEnabled(false);
					} else if (value.equals("Unpaused")) {
						pauseButton.setEnabled(true);
						removeButton.setEnabled(true);
						pauseButton.setText("Pause");
					} else {
						pauseButton.setEnabled(true);
						removeButton.setEnabled(true);
						pauseButton.setText("Unpause");
					}
				} else {
					table.clearSelection();
					pauseButton.setEnabled(false);
					removeButton.setEnabled(false);
				}
			}
		});
	}
}
