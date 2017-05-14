package model.swing;

import java.awt.Color;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import controller.CursorForFunctionListener;

public class TestFunction extends Observable {

	private String value = "";
	private JLabel function;
	private JTextArea text;
	
	public TestFunction(){
		
		function = new JLabel("<html>&phi;j "+getParamString()+" = </html>", JLabel.CENTER);
		//TODO : Gérer la taille en fonction de la fenêtre.
		text = new JTextArea(value);
		//Première valeur = largeur, deuxième = hauteur.
		//Hauteur inutile...?
//		text.setSize(800,400);
		//3 colonnes de texte disponibles nativement, s'étend au besoin.
		text.setRows(3);
		//Renvoie à la ligne si manque de place
		text.setLineWrap(true);
		//Coloration
		text.setBackground(Color.WHITE);
		text.addCaretListener(new CursorForFunctionListener(this));
		
	}
	
	//TODO si on efface � la main, �a ne change pas value
	//TODO ne pas ins�rer des fonctions au milieu de fonctions, e.g : tan() => cos()tan() ou tan()cos() ou tan(cos()) mais c'est tout.
	//text.getCaretPosition() permet de r�cup�rer la position du curseur
	public void warnMainWindowFrame(String content) {
		if (value.equals("")){
			value = ((String) content) + "()";
			text.setText(value);
			System.out.println("oin");
		}
		else {
			String formula = value;
			formula = formula + (String) content + "()";
			value = formula;
			text.setText(value);
		}
		setChanged();
		notifyObservers();
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
	
	public String getParamString() {
		return "(x)";
	}
}
