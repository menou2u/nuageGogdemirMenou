package view.panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.swing.Constraints;

public class TransformationsPlanePanel extends JPanel{
	
	public TransformationsPlanePanel(){
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		TransformXPanel xTrans = new TransformXPanel();
		TransformYPanel yTrans = new TransformYPanel();
		TransformZPanel zTrans = new TransformZPanel();
		JButton validation = new JButton("Validation des données");
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridheight=1;
		gbc.gridwidth=1;
		this.setLayout(gbl);
		this.add(xTrans,gbc);
		
		gbc.gridy+=gbc.gridheight;
		this.add(yTrans,gbc);
		
		gbc.gridy+=gbc.gridheight;
		this.add(zTrans,gbc);
		
		gbc.gridy=0;
		gbc.gridx=1;
		gbc.gridheight=3;
		this.add(validation,gbc);
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1)));
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Transforms");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Constraints c = new Constraints();
		TransformationsPlanePanel newContentPane = new TransformationsPlanePanel();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.pack();
		frame.setVisible(true);
	}
}
