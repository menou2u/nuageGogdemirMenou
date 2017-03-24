package model;

import java.awt.Color;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class TestFunction extends Observable {

	private String value = "";
	private JLabel function;
	private JTextArea text;
	
	public TestFunction(){
		
		function = new JLabel("φ(x) = ");
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
		
	}
	
	//Un setter de la valeur à mettre dans la partie textuelle quand on clique sur les raccourcis.
	public void setValue(String newValue) {
		value = newValue;
	}

	public String getValue() {
		return value;
	}

	public JLabel getFunction() {
		return function;
	}

	public JTextArea getText() {
		return text;
	}

	
}
