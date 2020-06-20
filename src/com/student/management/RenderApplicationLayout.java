package com.student.management;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import com.student.management.eventhandlers.InitialiseEventListeners;
import com.student.management.model.DynamicStudentDataHolder;
import com.student.management.model.InitialiseStudentData;
import com.student.management.utility.CalculateWindowsDimensions;
import com.student.management.view.RenderButtons;
import com.student.management.view.RenderDimensionsHolderLayout;
import com.student.management.view.RenderTableView;

public class RenderApplicationLayout {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RenderApplicationLayout window = new RenderApplicationLayout();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RenderApplicationLayout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 0, 871, 678);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainLayoutHolder = new JPanel(); // This panel holds all the sub panels
		JScrollPane jScrollPane = new JScrollPane(mainLayoutHolder); // The main layout is designed to be scrollable

		frame.getContentPane().add(jScrollPane, BorderLayout.CENTER);

		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		JPanel dimensionInformationHolder = new JPanel();
		// This is a hidden layout that holds width and height information of the window
		// to make the application responsive
		dimensionInformationHolder.setVisible(false);

		int[] dimensions = new CalculateWindowsDimensions().calculatedimension();

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		JPanel informationHolderPanel = new JPanel();

		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowWeights = new double[] { 0.2 };
		gbl_panel.columnWeights = new double[] { 1.0 };
		informationHolderPanel.setLayout(gbl_panel);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setResizeWeight(0.9);
		splitPane.setDividerLocation(0.9);

		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 0;

		informationHolderPanel.add(splitPane, gbc_splitPane);

		JPanel rightComponent = new JPanel();
		JPanel leftComponent = new JPanel();
		InitialiseStudentData initialiseData = new InitialiseStudentData();
		Map<String, String[]> studentDataMap = initialiseData.initStudentData();

		DynamicStudentDataHolder studentData = new DynamicStudentDataHolder();
		studentData.setStudentDataMap(studentDataMap);
		
		JScrollPane scrollPane = new JScrollPane();
		leftComponent.add(scrollPane);
		
		JPanel buttonLayout = new RenderButtons().renderButtons(rightComponent);
		
		JTable intializeTable = new RenderTableView().renderTable(studentDataMap);
		scrollPane.setViewportView(intializeTable);
		
		leftComponent.setLayout(new GridLayout(1, 1));
		
		splitPane.setLeftComponent(leftComponent);
		
		new InitialiseEventListeners().initialiseListeners(buttonLayout, intializeTable, scrollPane, mainLayoutHolder);
		
		splitPane.setRightComponent(buttonLayout);
		

		tabbedPane.addTab("Student List", null, informationHolderPanel, "Shows student information for meeting TA");
		tabbedPane.setPreferredSize(new Dimension(dimensions[0], dimensions[1]));

		mainLayoutHolder.add(tabbedPane, BorderLayout.NORTH);
		mainLayoutHolder.add(dimensionInformationHolder, BorderLayout.SOUTH);

		new RenderDimensionsHolderLayout().renderLayout(dimensionInformationHolder, frame, tabbedPane);

	}

}
