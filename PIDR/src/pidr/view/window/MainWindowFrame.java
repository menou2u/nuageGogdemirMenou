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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import pidr.model.MainWindow;

public  class MainWindowFrame extends JFrame implements Observer {

	private static final long serialVersionUID = 2587382723338443456L;
	private static JFrame current;
	private JPanel twoDPanel;
	private JPanel threeDPanel;
	private JPanel linePanel;
	private JPanel planePanel;
	
	public MainWindowFrame(MainWindow mainWindow) {
		current = this;
		setLayout(new GridBagLayout());
		init2DPanel(mainWindow);
		init3DPanel(mainWindow);
		initLinePanel(mainWindow);
		initPlanePanel(mainWindow);
		
		JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);
		
		JLabel titreOngletLine = new JLabel("Droites");
		linePanel.add(titreOngletLine);
		onglets.addTab("Droites",linePanel);
		
		JLabel titreOnglet2D = new JLabel("2D");
		twoDPanel.add(titreOnglet2D);
		onglets.addTab("2D",twoDPanel);
		
		JLabel titreOngletPlane = new JLabel("Plans");
		planePanel.add(titreOngletPlane);
		onglets.addTab("Plans",planePanel);
		
		JLabel titreOnglet3D = new JLabel("3D");
		threeDPanel.add(titreOnglet3D);
		onglets.addTab("3D",threeDPanel);
		
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
		
		onglets.setPreferredSize(frameSize);
		onglets.setOpaque(true);
		
		add(onglets);	
		setPreferredSize(frameSize);
		setLocation((screenSize.width-frameSize.width)/2, (screenSize.height-frameSize.height)/2);
		setVisible(true);
		pack();
	}

	public void init2DPanel(MainWindow mainWindow){
		twoDPanel = new JPanel();
	}
	
	public void init3DPanel(MainWindow mainWindow){
		threeDPanel = new JPanel();
	}
	
	public void initLinePanel(MainWindow mainWindow){
		linePanel = new JPanel();
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
		linePanel.add(mainWindow.getToolsPanel(), gbc);
		
		// Fonctions de transformation
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridy += gbc.gridheight;
		linePanel.add(mainWindow.getTransformationsPanel(), gbc);
		
		// Calculette
		gbc.gridy += gbc.gridheight;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.weightx = 0;
		gbc.weighty = 0;
		linePanel.add(mainWindow.getMathShortcutsPanel(), gbc);

		// Panneau des données brutes
		gbc.gridwidth = 1;
		gbc.weighty = 1;
		gbc.gridy += gbc.gridheight;
		linePanel.add(mainWindow.getDataPanel(), gbc);

		// Panneau des contraintes sur coordonnées
		gbc.gridx += gbc.gridwidth;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		gbc.weighty = 0;
		linePanel.add(mainWindow.getConstraintsPanel(), gbc);

		// Panel de visualisation du graphe
		gbc.gridx = 1;
		gbc.gridy += gbc.gridheight;
		gbc.gridwidth = 3;
		gbc.weightx = 1;
		gbc.weighty = 1;
		linePanel.add(mainWindow.getVisualisationPanel(), gbc);
	}
	
	public void initPlanePanel(MainWindow mainWindow){
		planePanel = new JPanel();
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
