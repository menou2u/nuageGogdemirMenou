package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DisplayPanel extends JPanel{

	private JCheckBox pointCloud;
	private JCheckBox constraintPoints;
	private JCheckBox function[];
	private JCheckBox limited;
	private JLabel abs;
	private JLabel ord;
	private JLabel hei;
	private JTextArea absText;
	private JTextArea ordText;
	private JTextArea heiText;
	private JPanel displayZone;
	//>>>>>>private zoneDeDisplay<<<<<<
	
	public DisplayPanel(){
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(1,1,1,1);
		gbc.anchor = gbc.WEST;
		this.setLayout(gbl);
		
		pointCloud = new JCheckBox("Nuage de points");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		this.add(pointCloud, gbc);
		
		constraintPoints = new JCheckBox("Point(s) contraint(s)");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		this.add(constraintPoints,gbc);
		
		function = new JCheckBox[5];
		function[0] = new JCheckBox("f(x,y)");
		for (int i=0; i<function.length;i++)
		{
			if (function[i]!=null)
			{
				gbc.gridy = gbc.gridy+1;
				this.add(function[i],gbc);
			}
		}		
		
		limited = new JCheckBox("Limité");
		gbc.gridy = gbc.gridy+1;
		this.add(limited,gbc);
		
		abs = new JLabel("Abscisses : ");
		gbc.gridy+=1;
		gbc.gridwidth =1;
		this.add(abs,gbc);
		
		absText = new JTextArea("x");
		absText.setColumns(8);
		gbc.gridx=1;
		this.add(absText,gbc);
		
		ord = new JLabel("Ordonnées : ");
		gbc.gridx =0;
		gbc.gridy +=1;
		this.add(ord,gbc);
		
		ordText = new JTextArea("y");
		ordText.setColumns(8);
		gbc.gridx=1;
		this.add(ordText,gbc);
		
		hei = new JLabel("Cote : ");
		gbc.gridx=0;
		gbc.gridy+=1;
		this.add(hei,gbc);
		
		heiText = new JTextArea("z");
		heiText.setColumns(8);
		gbc.gridx=1;
		this.add(heiText,gbc);
		
		//Le panel qu'il faut remplir avec la courbe du monsieur.
		displayZone = new JPanel();
		Dimension dim = new Dimension(400,600);
		displayZone.setSize(dim);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridheight = 20;
		gbc.gridwidth = 20;
		gbc.fill = gbc.BOTH;
		this.add(displayZone,gbc);
	}
	
    public static void main(String[] args) {
        JFrame frame = new JFrame("ConstraintsPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DisplayPanel newContentPane = new DisplayPanel();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
	
}
