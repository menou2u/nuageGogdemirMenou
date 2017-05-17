package view.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TransformXPanel extends JPanel{
	
	JTextField transformX;
	
	public TransformXPanel()
	{
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		transformX = new JTextField(8);
		JLabel transformXLabel = new JLabel("X = tx(x)");
		this.setLayout(gbl);
		this.add(transformXLabel,gbc);
		
		gbc.gridx=1;
		this.add(transformX,gbc);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("xTransform");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TransformXPanel newContentPane = new TransformXPanel();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.pack();
		frame.setVisible(true);
	}
	
	public JTextField getTransformX() {
		return transformX;
	}

	public void setTransformX(JTextField transformX) {
		this.transformX = transformX;
	}
	
}
