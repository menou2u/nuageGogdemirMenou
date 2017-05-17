package view.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TransformYPanel extends JPanel {

	JTextField transformY;
	
	public TransformYPanel() {

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		transformY = new JTextField(8);
		JLabel transformYLabel = new JLabel("Y = ty(y)");
		this.setLayout(gbl);
		this.add(transformYLabel,gbc);
		
		gbc.gridx=1;
		this.add(transformY);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("xTransform");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TransformYPanel newContentPane = new TransformYPanel();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.pack();
		frame.setVisible(true);
	}
	
	public JTextField getTransformY() {
		return transformY;
	}

	public void setTransformY(JTextField transformY) {
		this.transformY = transformY;
	}

}
