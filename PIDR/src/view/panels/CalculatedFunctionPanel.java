package view.panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.CalculatedFunction;
/**
 * Contient la fonction calculée.
 * Ce panel devra donc se mettre à jour ou se remplacer de lui-même lorsqu'on cliquera sur le bouton
 * Executer
 * @author Miron
 *
 */
@SuppressWarnings("serial")
public class CalculatedFunctionPanel extends JPanel { //frederic.neurohr@cpc57.fr

	//TODO : Mettre toutes les dimensions en adéquationavec le reste de la fenêtre.
	@SuppressWarnings("static-access")
	public CalculatedFunctionPanel(CalculatedFunction cF) {
		
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gbl);
		gbc.insets = new Insets(2,2,2,2);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = gbc.NORTHWEST;
		add(cF.getFunctionName(),gbc);
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.gridheight=5;
		gbc.gridwidth=gbc.REMAINDER;
		add(cF.getFunctionCalculated(),gbc);
		
		gbc.gridx=2;
		gbc.gridy=5;
		gbc.gridheight=1;
		gbc.gridwidth=1;
		gbc.anchor = gbc.CENTER;
		add(cF.getPointName(),gbc);
		
		gbc.anchor = gbc.WEST;
		gbc.gridx=3;
		add(cF.getPoint(),gbc);
		
		gbc.anchor = gbc.CENTER;
		gbc.gridx=4;
		add(cF.getCalcul(),gbc);
		
		gbc.gridx=5;
		add(cF.getCalculatedPointName(),gbc);

		gbc.anchor = gbc.WEST;
		gbc.gridx=6;
		add(cF.getCalculatedPoint(),gbc);
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1)));
	}
		
	//main pour test
	public static void main(String[] args) {
		JFrame test = new JFrame();
		CalculatedFunction cF = new CalculatedFunction();
		test.setSize(1500, 1000);
		CalculatedFunctionPanel paneltest = new CalculatedFunctionPanel(cF);
		GridBagLayout gbl = new GridBagLayout();
		test.setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		paneltest.setSize(test.getWidth(),test.getHeight());
		test.add(paneltest,gbc);
		test.setVisible(true);
	}
	
}
