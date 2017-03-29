package pidr.view.window;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import pidr.model.MainWindow;

public  class MainWindowFrame extends JFrame implements Observer {

	private static final long serialVersionUID = 2587382723338443456L;
	private static JFrame current;

	public MainWindowFrame(MainWindow mainWindow) {
		current = this;

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;

		// Panneau des outils
		gbc.gridwidth = 4;
		gbc.weighty = 0;
		add(mainWindow.getToolsPanel(), gbc);

		// Panneau des données brutes
		gbc.gridwidth = 1;
		gbc.weighty = 1;
		gbc.gridheight = 3;
		gbc.gridy += gbc.gridheight;
		add(mainWindow.getDataPanel(), gbc);

		// Panneau des contraintes sur coordonnées
		gbc.gridx += gbc.gridwidth;
		gbc.gridheight = 2;
		gbc.weighty = 0;
		add(mainWindow.getConstraintsPanel(), gbc);

		// Fonction phi
		gbc.gridx += gbc.gridwidth;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		add(mainWindow.getTestFunctionPanel(), gbc);

		// Calculette
		gbc.gridy += gbc.gridheight;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		add(mainWindow.getMathShortcutsPanel(), gbc);

		// Fonction f
		gbc.gridx += gbc.gridwidth;
		gbc.weightx = 0;
		gbc.weighty = 0;
		add(mainWindow.getCalculatedFunctionPanel(), gbc);

		// Panel de visualisation du graphe
		gbc.gridx = 1;
		gbc.gridy += gbc.gridheight;
		gbc.gridwidth = 3;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(mainWindow.getVisualisationPanel(), gbc);

		// Paramètres fenêtre
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				mainWindow.getTools().saveHistoric();
			}
		});
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize= new Dimension((int)(screenSize.width*0.8), (int)(screenSize.height*0.8));
		setPreferredSize(frameSize);
		setLocation((screenSize.width-frameSize.width)/2, (screenSize.height-frameSize.height)/2);
		setVisible(true);
		pack();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new MainWindowFrame(new MainWindow());
	}
	/**
	 * @return
	 */
	public static JFrame getCurrent() {
		return current;
	}

}
