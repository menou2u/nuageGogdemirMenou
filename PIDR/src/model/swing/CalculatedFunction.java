package model.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class CalculatedFunction extends Observable {
	
	//Valeur de la fonction calculée
	private String value = "";
	//Nom de la fonction calculée
	private JLabel functionName;
	//Layout
	private GridBagLayout gbl;
	//Contraintes
	private GridBagConstraints gbc;
	//Zone dans laquelle la fonction est calculée
	private JTextArea functionCalculated;
	//Zone dans laquelle est écrit le x pour chercher un point précis
	private JTextArea point;
	//Bouton de calcul
	private JButton calcul;
	//Résultat du calcul
	private JTextArea calculatedPoint;
	//Nom de l'entrée à calculer
	private JLabel pointName;
	//Nom du résultat
	private JLabel calculatedPointName;
	private Dimension oneCell;
	
	public CalculatedFunction(){
		
		functionName = new JLabel();
		functionName.setText("f(x) = ");
		
		functionCalculated = new JTextArea();
		functionCalculated.setEditable(false);
		functionCalculated.setText(value);
		functionCalculated.setBackground(Color.WHITE);
		functionCalculated.setRows(4);
		functionCalculated.setLineWrap(true);
		functionCalculated.setSize(400,400);
		
		point = new JTextArea();
		point.setLineWrap(true);
		point.setText("");
		point.setBackground(Color.WHITE);
		point.setSize(100,100);

		calcul = new JButton();
		calcul.setText("Calcul");
		
		calculatedPoint = new JTextArea();
		calculatedPoint.setEditable(false);
		calculatedPoint.setLineWrap(true);
		calculatedPoint.setText("");
		calculatedPoint.setBackground(Color.WHITE);
		calculatedPoint.setSize(100,100);

		pointName = new JLabel();
		pointName.setText("(x0) = ");
		
		calculatedPointName = new JLabel();
		calculatedPointName.setText("f(x0) = ");
	}

	public String getValue() {
		return value;
	}

	public JLabel getFunctionName() {
		return functionName;
	}

	public GridBagLayout getGbl() {
		return gbl;
	}

	public GridBagConstraints getGbc() {
		return gbc;
	}

	public JTextArea getFunctionCalculated() {
		return functionCalculated;
	}

	public JTextArea getPoint() {
		return point;
	}

	public JButton getCalcul() {
		return calcul;
	}

	public JTextArea getCalculatedPoint() {
		return calculatedPoint;
	}

	public JLabel getPointName() {
		return pointName;
	}

	public JLabel getCalculatedPointName() {
		return calculatedPointName;
	}

	public Dimension getOneCell() {
		return oneCell;
	}
	
	//Un setter de la valeur à mettre dans la partie textuelle quand on clique sur les raccourcis.
	public void setValue(String newValue) {
		value = newValue;
	}

	
	
}
