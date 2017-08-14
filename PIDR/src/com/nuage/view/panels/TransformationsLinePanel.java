package com.nuage.view.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.nuage.model.swing.datas.TransformationsLine;

@SuppressWarnings("serial")
public class TransformationsLinePanel extends JPanel {

	public TransformationsLinePanel(TransformationsLine transformationsLine) {
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		this.setLayout(gbl);
		this.add(new TransformXPanel(transformationsLine.getTransformX()), gbc);

		gbc.gridy += gbc.gridheight;
		this.add(new TransformYPanel(transformationsLine.getTransformY()), gbc);

		gbc.gridy = 0;
		gbc.gridx = 1;
		gbc.gridheight = 2;
		this.add(transformationsLine.getValidation(), gbc);

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Transforms");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TransformationsLine transformationsLine = new TransformationsLine();
		TransformationsLinePanel newContentPane = new TransformationsLinePanel(transformationsLine);
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.pack();
		frame.setVisible(true);
	}

}
