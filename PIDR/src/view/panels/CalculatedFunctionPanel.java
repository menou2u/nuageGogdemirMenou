package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 * Contient la fonction calculée.
 * Ce panel devra donc se mettre à jour ou se remplacer de lui-même lorsqu'on cliquera sur le bouton
 * Executer
 * @author Miron
 *
 */
public class CalculatedFunctionPanel extends JPanel { //frederic.neurohr@cpc57.fr

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
	
	
	
	//TODO : Mettre toutes les dimensions en adéquationavec le reste de la fenêtre.
	public CalculatedFunctionPanel()
	{
		oneCell = new Dimension((int)(this.getWidth()/10),(int)(this.getHeight()/10));
		
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		this.setLayout(gbl);
		gbc.insets = new Insets(2,2,2,2);
		
		functionName = new JLabel();
		functionName.setText("f(x) = ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = gbc.NORTHWEST;
		this.add(functionName,gbc);
		
		functionCalculated = new JTextArea();
		functionCalculated.setText(value);
		functionCalculated.setBackground(Color.WHITE);
		functionCalculated.setRows(4);
		functionCalculated.setLineWrap(true);
		functionCalculated.setSize(400,400);
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.gridheight=5;
		gbc.gridwidth=gbc.REMAINDER;
		this.add(functionCalculated,gbc);
		
		pointName = new JLabel();
		pointName.setText("(x0) = ");
		gbc.gridx=2;
		gbc.gridy=5;
		gbc.gridheight=1;
		gbc.gridwidth=1;
		gbc.anchor = gbc.CENTER;
		this.add(pointName,gbc);
		
		point = new JTextArea();
		point.setLineWrap(true);
		gbc.anchor = gbc.WEST;
		point.setText("");
		point.setBackground(Color.WHITE);
		point.setSize(100,100);
		gbc.gridx=3;
		this.add(point,gbc);
		
		calcul = new JButton();
		calcul.setText("Calcul");
		gbc.anchor = gbc.CENTER;
		gbc.gridx=4;
		this.add(calcul,gbc);
		
		calculatedPointName = new JLabel();
		calculatedPointName.setText("f(x0) = ");
		gbc.gridx=5;
		this.add(calculatedPointName,gbc);
		
		calculatedPoint = new JTextArea();
		calculatedPoint.setLineWrap(true);
		gbc.anchor = gbc.WEST;
		calculatedPoint.setText("");
		calculatedPoint.setBackground(Color.WHITE);
		calculatedPoint.setSize(100,100);
		gbc.gridx=6;
		this.add(calculatedPoint,gbc);
	}
	
	//Un setter de la valeur à mettre dans la partie textuelle quand on clique sur les raccourcis.
	public void setValue(String newValue) {
		value = newValue;
	}
	
	
	
	//main pour test
	public static void main(String[] args) {
		JFrame test = new JFrame();
		test.setSize(1500, 1000);
		CalculatedFunctionPanel paneltest = new CalculatedFunctionPanel();
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
