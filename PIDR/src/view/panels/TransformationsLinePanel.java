package view.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TransformationsLinePanel extends JPanel{

	public TransformationsLinePanel(){
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		TransformXPanel xTrans = new TransformXPanel();
		TransformYPanel yTrans = new TransformYPanel();
		JButton validation = new JButton("Validation des données");
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridheight=1;
		gbc.gridwidth=1;
		this.setLayout(gbl);
		this.add(xTrans,gbc);
		
		gbc.gridy+=gbc.gridheight;
		this.add(yTrans,gbc);
		
		gbc.gridy=0;
		gbc.gridx=1;
		gbc.gridheight=2;
		this.add(validation,gbc);
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Transforms");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TransformationsLinePanel newContentPane = new TransformationsLinePanel();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.pack();
		frame.setVisible(true);
	}
	
}
