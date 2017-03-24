package view.window;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import model.MainWindow;

@SuppressWarnings("serial")
public class MainWindowFrame extends JFrame implements Observer {
	
	public MainWindowFrame(MainWindow mainWindow){
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		//Panneau des outils
		gbc.gridwidth = 4;
		add(mainWindow.getToolsPanel(),gbc);

		//Panneau des données brutes
		gbc.gridwidth = 1;
		gbc.gridheight = 8;
		gbc.gridy += gbc.gridheight;
		add(mainWindow.getDataPanel(),gbc);
		
		//Panneau des contraintes sur coordonnées
		gbc.gridx += gbc.gridwidth;
		gbc.gridheight = 2;
		add(mainWindow.getConstraintsPanel(),gbc);
		
		//Fonction phi
		gbc.gridx += gbc.gridwidth;
		gbc.gridheight = 1;
		add(mainWindow.getTestFunctionPanel(),gbc);
		
		//Calculette
		gbc.gridy += gbc.gridheight;
		gbc.gridheight = 1;
		add(mainWindow.getMathShortcutsPanel(),gbc);
		
		//Fonction f
		/*gbc.gridx += gbc.gridwidth;
		add(mainWindow.getCalculatedFunctionPanel(),gbc);*/
		
		//Paramètres fenêtre
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension sc = Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(sc);
		setVisible(true);
		pack();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args){
		MainWindowFrame window = new MainWindowFrame(new MainWindow());
	}
	
}
