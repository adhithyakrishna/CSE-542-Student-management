package com.student.management.view;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import com.student.management.utility.IntializeButtonConstraints;


public class RenderButtons {

	public JPanel renderButtons(JPanel panel) {
		JButton pauseButton;
		JButton removeButton;
		JButton addUserButton;

		panel.setLayout(new GridBagLayout());

		pauseButton = new JButton("Pause");
		removeButton = new JButton("Remove");
		addUserButton = new JButton("Add User");
		
		/*disable buttons*/
		pauseButton.setEnabled(false);
		removeButton.setEnabled(false);
		
		pauseButton.setPreferredSize(new Dimension(100, 45));
		removeButton.setPreferredSize(new Dimension(100, 45));
		addUserButton.setPreferredSize(new Dimension(100, 45));

		panel.add(pauseButton, new IntializeButtonConstraints().generateConstraints(0));
		panel.add(removeButton, new IntializeButtonConstraints().generateConstraints(4));
		panel.add(addUserButton, new IntializeButtonConstraints().generateConstraints(2));
		return panel;
	}

}
