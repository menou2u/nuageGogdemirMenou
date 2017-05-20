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
	
	//Valeur de la fonction calcul�e
	private String value = "";
	//Nom de la fonction calcul�e
	private JLabel functionName;
	//Layout
	private GridBagLayout gbl;
	//Contraintes
	private GridBagConstraints gbc;
	//Zone dans laquelle la fonction est calcul�e
	private JTextArea functionCalculated;
	//Zone dans laquelle est �crit le x pour chercher un point pr�cis
	private JTextArea point;
	//Bouton de calcul
	private JButton calcul;
	//R�sultat du calcul
	private JTextArea calculatedPoint;
	//Nom de l'entr�e � calculer
	private JLabel pointName;
	//Nom du r�sultat
	private JLabel calculatedPointName;
	private Dimension oneCell;
	
	public CalculatedFunction(String s, String parameters){
		
		functionName = new JLabel();
		functionName.setText(s);
		
		functionCalculated = new JTextArea();
		functionCalculated.setEditable(false);
		functionCalculated.setText(value);
		functionCalculated.setBackground(Color.WHITE);
		functionCalculated.setRows(2);
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
		pointName.setText(parameters +" = ");
		
		calculatedPointName = new JLabel();
		calculatedPointName.setText("f"+ parameters +" = ");
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
	
	//Un setter de la valeur � mettre dans la partie textuelle quand on clique sur les raccourcis.
	public void setValue(String newValue) {
		value = newValue;
	}
	
	public void setFunctionCalculated(String res){
		functionCalculated.setText(res);
		System.out.println("res : "+functionCalculated.getText());
		setChanged();
		notifyObservers();
	}

	
	
}
