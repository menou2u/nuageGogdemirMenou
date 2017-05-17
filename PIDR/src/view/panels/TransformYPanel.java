package view.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.swing.Constraints;

@SuppressWarnings("serial")
public class TransformYPanel extends JPanel {

	public TransformYPanel() {

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		JTextField transformY = new JTextField();
		transformY.setColumns(20);
		JLabel transformYLabel = new JLabel("Y = ty(y)");
		this.setLayout(gbl);
		this.add(transformYLabel,gbc);
		
		gbc.gridx=1;
		gbc.gridwidth=4;
		this.add(transformY);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("xTransform");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		@SuppressWarnings("unused")
		Constraints c = new Constraints();
		TransformYPanel newContentPane = new TransformYPanel();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.pack();
		frame.setVisible(true);
	}

}
