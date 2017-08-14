package com.nuage.view.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.nuage.model.swing.DisplaySettings;

@SuppressWarnings("serial")
public class DisplaySettingsPanel extends JPanel {

	public DisplaySettingsPanel(DisplaySettings displaySettings) {
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.anchor = GridBagConstraints.WEST;
		setLayout(gbl);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		add(displaySettings.getPointCloud(), gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		add(displaySettings.getConstraintPoints(), gbc);

		for (int i = 0; i < displaySettings.getFunction().length; i++) {
			JCheckBox temp = displaySettings.getFunction()[i];
			if (temp != null) {
				gbc.gridy = gbc.gridy + 1;
				add(temp, gbc);
			}
		}

		gbc.gridy = gbc.gridy + 1;
		add(displaySettings.getLimited(), gbc);

		gbc.gridy += 1;
		gbc.gridwidth = 1;
		add(displaySettings.getAbs(), gbc);

		gbc.gridx = 1;
		add(displaySettings.getAbsText(), gbc);

		gbc.gridx = 0;
		gbc.gridy += 1;
		add(displaySettings.getOrd(), gbc);

		gbc.gridx = 1;
		add(displaySettings.getOrdText(), gbc);

		gbc.gridx = 0;
		gbc.gridy += 1;
		add(displaySettings.getHei(), gbc);

		gbc.gridx = 1;
		add(displaySettings.getHeiText(), gbc);

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("ConstraintsPanel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		@SuppressWarnings("unused")
		DisplaySettings ds = new DisplaySettings();
		// DisplaySettingsPanel newContentPane = new DisplaySettingsPanel(ds);
		// newContentPane.setOpaque(true);
		// frame.setContentPane(newContentPane);
		frame.pack();
		frame.setVisible(true);
	}

}
