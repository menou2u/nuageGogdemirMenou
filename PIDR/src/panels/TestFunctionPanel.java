package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TestFunctionPanel extends JPanel{
	
	private String value = "";
	private JLabel function;
	private JTextArea text;
	private GridBagLayout gbl = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	
	public TestFunctionPanel()	{
		//Mise en place de la dimension minimum dans le cadre d'un test
		//dans une fenêtre seule.
		
		//TODO : Gérer la taille en fonction de la fenêtre.
		this.setSize(new Dimension(1000,500));
		this.setLayout(gbl);
		
		
		//Mise en place de la partie fixe : nom de la fonction pour correspondre à ce qui était
		//mis en place dans l'interface précédente.
		this.function = new JLabel("φ(x) = ");
		//Placement
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.1;
		//On centre le texte
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(function, gbc);
		
		
		//Mise en place de la zone de saisie. Dimension à gérer.
		//TODO : Gérer la taille en fonction de la fenêtre.
		text = new JTextArea(value);
		//Première valeur = largeur, deuxième = hauteur.
		//Hauteur inutile...?
		text.setSize(800,400);
		//3 colonnes de texte disponibles nativement, s'étend au besoin.
		text.setRows(3);
		//Renvoie à la ligne si manque de place
		text.setLineWrap(true);
		//Coloration
		text.setBackground(Color.WHITE);
		//Placement
		gbc.gridx=1;
		gbc.weightx = 1;
		gbc.gridheight = 3;
		gbc.gridwidth = 3;
		//Remplissage de la ligne
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		//add
		this.add(text, gbc);

		//TODO : Ajouter éventuellement des marges sur les pour l'esthétique.
	}
	
	
	//Un setter de la valeur à mettre dans la partie textuelle quand on clique sur les raccourcis.
	public void setValue(String newValue) {
		value = newValue;
	}
	
	
	
	//main pour test
	public static void main(String[] args) {
		JFrame test = new JFrame();
		test.setSize(300, 500);
		TestFunctionPanel paneltest = new TestFunctionPanel();
		test.add(paneltest,null);
		test.setVisible(true);
	}
}
