package view.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.swing.Constraints;

@SuppressWarnings("serial")
public class TransformZPanel extends JPanel{
	
	JTextField transformZ;
	
	public TransformZPanel() {

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		transformZ = new JTextField(8);
		JLabel transformZLabel = new JLabel("Z = tz(z)");
		this.setLayout(gbl);
		this.add(transformZLabel,gbc);
		
		gbc.gridx=1;
		this.add(transformZ);
	}

	public JTextField getTransformZ() {
		return transformZ;
	}

	public void setTransformZ(JTextField transformZ) {
		this.transformZ = transformZ;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("xTransform");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TransformZPanel newContentPane = new TransformZPanel();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.pack();
		frame.setVisible(true);
	}
}
