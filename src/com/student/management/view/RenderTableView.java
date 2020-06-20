package com.student.management.view;

import java.awt.Font;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.student.management.model.ManageStudentInformation;

public class RenderTableView {
	
	public JTable renderTableStructure(JTable table, Object[][] dynamicdata) {
		String[] headers = new String[] { "Sequence Number", "Student Name", "Student Email", "Status" };

		if (dynamicdata.length == 1 && dynamicdata[0].length == 1) {
			dynamicdata = new Object[0][0];
			headers = new String[] { "Queue is Empty" };
			DefaultTableModel model = new DefaultTableModel(dynamicdata, headers);

			table.setModel(model);
		} else {
			table.setModel(new DefaultTableModel(dynamicdata, headers));

			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);
			table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

			table.getColumnModel().getColumn(2).setWidth(0);
			table.getColumnModel().getColumn(2).setMinWidth(0);
			table.getColumnModel().getColumn(2).setMaxWidth(0);

			table.getColumnModel().getColumn(0).setWidth(0);
			table.getColumnModel().getColumn(0).setMinWidth(0);
			table.getColumnModel().getColumn(0).setMaxWidth(0);
		}

		TableCellRenderer rendererFromHeader = table.getTableHeader().getDefaultRenderer();
		JLabel headerLabel = (JLabel) rendererFromHeader;
		headerLabel.setHorizontalAlignment(JLabel.CENTER);

		JTableHeader TableheaderFont = table.getTableHeader();
		TableheaderFont.setFont(new Font("Serif", Font.BOLD, 15));

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);

		return table;

	}

	public JTable renderTable(Map<String, String[]> studentDataMap) {
		JTable table = new JTable();
        table.setFillsViewportHeight(true);
        table.setShowGrid(true);
        Object[][] studentInfoObj = new ManageStudentInformation().renderStudentMapAsObjects(studentDataMap);
        JTable structuredTable = renderTableStructure(table , studentInfoObj);
        
		return structuredTable;
	}

}
