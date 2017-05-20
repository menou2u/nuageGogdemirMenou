package view.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.swing.Line;
import model.swing.UpdatablePanel;

@SuppressWarnings("serial")
public class LinePanel extends JPanel implements Observer, UpdatablePanel {

	private Line line;

	public LinePanel(Line line) {
		this.setLine(line);
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;

		// Fonctions de transformation
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		gbc.weightx = 0;
		gbc.weighty = 0;
		add(line.getTransformationsLinePanel(), gbc);

		// Calculette
		gbc.gridy += gbc.gridheight;
		gbc.gridwidth = 1;
		gbc.gridheight = 3;
		gbc.weightx = 0;
		gbc.weighty = 0;
		add(line.getMathShortcutsPanel(), gbc);

		// Panneau des données brutes
		gbc.gridwidth = 1;
		gbc.weighty = 1;
		gbc.gridy += gbc.gridheight;
		gbc.gridheight = 5;
		add(line.getDataPanel(), gbc);

		// Panneau des contraintes selon choix
		gbc.gridx += gbc.gridwidth;
		gbc.gridy=0;
		gbc.gridheight =3;
		gbc.weightx = 1;
		gbc.weighty=0;
		add(line.getChosenPanel(),gbc);
		 

		// Panel de visualisation du graphe
		gbc.gridx = 1;
		gbc.gridy += gbc.gridheight;
		gbc.gridwidth = 3;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight =7;
		add(line.getVisualisationPanel(), gbc);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	public Line getOnglet() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	
}
