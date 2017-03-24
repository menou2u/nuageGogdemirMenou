package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.TestFunction;

@SuppressWarnings("serial")
public class TestFunctionPanel extends JPanel{
		
	public TestFunctionPanel(TestFunction testFunction)	{
		//Mise en place de la dimension minimum dans le cadre d'un test
		//dans une fenêtre seule.
		
		//TODO : Gérer la taille en fonction de la fenêtre.
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setSize(new Dimension(1000,500));
		setLayout(gbl);
		
		//Mise en place de la partie fixe : nom de la fonction pour correspondre à ce qui était
		//mis en place dans l'interface précédente.
		//En 2D, il n'y a que (x). En 3D, il faudrait ajouter y : (x,y).
		//Placement
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.1;
		//On centre le texte
		gbc.anchor = GridBagConstraints.CENTER;
		add(testFunction.getFunction(), gbc);
		
		
		//Mise en place de la zone de saisie. Dimension à gérer.
		//Placement
		gbc.gridx=1;
		gbc.weightx = 1;
		gbc.gridheight = 3;
		gbc.gridwidth = 3;
		//Remplissage de la ligne
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(testFunction.getText(), gbc);

		//TODO : Ajouter éventuellement des marges sur les pour l'esthétique.
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1)));
	}	
	
	//main pour test
	public static void main(String[] args) {
		JFrame test = new JFrame();
		test.setSize(300, 500);
		TestFunction testFunction = new TestFunction();
		TestFunctionPanel paneltest = new TestFunctionPanel(testFunction);
		test.add(paneltest,null);
		test.setVisible(true);
	}
}
