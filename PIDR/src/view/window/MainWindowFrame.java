package view.window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import model.math.DroiteMoindreCarres;
import model.swing.InfosWindow;
import model.swing.MainWindow;

public class MainWindowFrame extends JFrame implements Observer {

	private static final long serialVersionUID = 2587382723338443456L;
	private static JFrame current;
	private JPanel twoDPanel;
	private JPanel threeDPanel;
	private JPanel linePanel;
	private JPanel planePanel;
	private JPanel contentPanel;
	private JTabbedPane onglets;
	private MainWindow mainWindow;
	private StringBuilder infosLine;
	private StringBuilder infosPlane;
	private StringBuilder infos2D;
	private StringBuilder infos3D;
	private StringBuilder currentInfos;

	/**
	 * @param mainWindow
	 */
	public MainWindowFrame(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		//mainWindow.getTools().addObserver(this);
		mainWindow.addObserver(this);
		mainWindow.getData().addObserver(this);
		currentInfos = new StringBuilder("");
		current = this;
		setLayout(new BorderLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		init2DPanel(mainWindow);
		init3DPanel(mainWindow);
		initLinePanel(mainWindow);
		initPlanePanel(mainWindow);
		
		gbc.fill = gbc.BOTH;
		gbc.weighty=0;
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridheight=1;
		gbc.gridwidth=1;
		
		JPanel contentPanel = new JPanel(new GridBagLayout());
		onglets = new JTabbedPane(SwingConstants.TOP);

		onglets.addTab("Droites", linePanel);
		onglets.addTab("2D", twoDPanel);
		onglets.addTab("Plans", planePanel);
		onglets.addTab("3D", threeDPanel);

		// Paramètres fenêtre
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//@TODO : Gérer ce la sauvegarde à la fermeture
				//mainWindow.getTools().saveHistoric();
			}
		});
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = new Dimension((int) (screenSize.width * 0.9), (int) (screenSize.height * 0.9));

		onglets.setPreferredSize(frameSize);
		onglets.setOpaque(true);

		// Panneau des outils
		//gbc.gridwidth = 4;
		//gbc.weighty = 0;
		//linePanel.add(mainWindow.getToolsPanel(), gbc);
		
		contentPanel.add(mainWindow.getToolsPanel(),gbc);
		
		gbc.gridy+=gbc.gridheight;
		gbc.weighty=1;
		gbc.weightx=1;
		contentPanel.add(onglets,gbc);
		add(contentPanel);  //TODO add un autre gbc
		setPreferredSize(frameSize);
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		setVisible(true);
		pack();
	}

	public void init2DPanel(MainWindow mainWindow) {
		twoDPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		//Fonction de test
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		twoDPanel.add(mainWindow.getTwoDTestFunctionPane(),gbc);
		
		//CalculatedFunction
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		gbc.gridx = 0;
		gbc.gridy = 1;
		twoDPanel.add(mainWindow.getTwoDCalculatedFunctionPane(),gbc);
		
		//Calculette
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 3;
		gbc.gridx = 1;
		gbc.gridy = 0;
		twoDPanel.add(mainWindow.getTwoDMathShortcutsPane(),gbc);
		
		//Contraintes Différentielles
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 3;
		gbc.gridx = 3;
		gbc.gridy = 0;
		twoDPanel.add(mainWindow.getTwoDConstraintsPane(),gbc);

		//Datas
		gbc.weightx = 0;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 4;
		gbc.gridx = 0;
		gbc.gridy = 3;
		twoDPanel.add(mainWindow.getTwoDDatasPane(),gbc);
		
		//Display
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 4;
		gbc.gridheight = 4;
		gbc.gridx = 2;
		gbc.gridy = 3;
		twoDPanel.add(mainWindow.getTwoDDisplaySettingsPane(),gbc);
	}

	public void init3DPanel(MainWindow mainWindow) {
		threeDPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		//Fonction de test
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		threeDPanel.add(mainWindow.getThreeDTestFunctionPane(),gbc);
		
		//CalculatedFunction
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		gbc.gridy += gbc.gridheight;
		gbc.gridheight = 2;
		gbc.gridx = 0;
		threeDPanel.add(mainWindow.getThreeDCalculatedFunctionPane(),gbc);
		
		//Calculette
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 3;
		gbc.gridx = 1;
		gbc.gridy = 0;
		threeDPanel.add(mainWindow.getThreeDMathShortcutsPane(),gbc);
		
		//Contraintes Différentielles
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 3;
		gbc.gridx = 3;
		gbc.gridy = 0;
		threeDPanel.add(mainWindow.getThreeDConstraintsPane(),gbc);

		//Datas
		gbc.weightx = 0;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 4;
		gbc.gridx = 0;
		gbc.gridy = 3;
		threeDPanel.add(mainWindow.getThreeDDatasPane(),gbc);
		
		//Display
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 4;
		gbc.gridheight = 4;
		gbc.gridx = 2;
		gbc.gridy = 3;
		threeDPanel.add(mainWindow.getThreeDDisplaySettingsPane(),gbc);
	}

	public void initLinePanel(MainWindow mainWindow) {
		linePanel = new JPanel(new GridBagLayout());
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
		linePanel.add(mainWindow.getTransformationsPanel(), gbc);

		// Calculette
		gbc.gridy += gbc.gridheight;
		gbc.gridwidth = 1;
		gbc.gridheight = 3;
		gbc.weightx = 0;
		gbc.weighty = 0;
		linePanel.add(mainWindow.getMathShortcutsPanel(), gbc);

		// Panneau des données brutes
		gbc.gridwidth = 1;
		gbc.weighty = 1;
		gbc.gridy += gbc.gridheight;
		gbc.gridheight = 5;
		linePanel.add(mainWindow.getDataPanel(), gbc);

		// Panneau des contraintes selon choix
		gbc.gridx += gbc.gridwidth;
		gbc.gridy=0;
		gbc.gridheight =3;
		gbc.weightx = 1;
		gbc.weighty=0;
		linePanel.add(mainWindow.getChosenPanel(),gbc);
		 

		// Panel de visualisation du graphe
		gbc.gridx = 1;
		gbc.gridy += gbc.gridheight;
		gbc.gridwidth = 3;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight =7;
		linePanel.add(mainWindow.getVisualisationPanel(), gbc);
	}

	public void initPlanePanel(MainWindow mainWindow) {
		planePanel = new JPanel(new GridBagLayout());
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
		planePanel.add(mainWindow.getTransformationPlanePanel(),gbc);
		
		// Calculette
		gbc.gridy += gbc.gridheight;
		gbc.gridwidth = 1;
		gbc.gridheight = 3;
		gbc.weightx = 0;
		gbc.weighty = 0;
		planePanel.add(mainWindow.getMathShortcutsPlanePanel(),gbc);
		
		
		// Panneau des données brutes
		gbc.gridwidth = 1;
		gbc.weighty = 1;
		gbc.weightx=1;
		gbc.gridy += gbc.gridheight;
		gbc.gridheight = 5;
		planePanel.add(mainWindow.getDataPlanePanel(),gbc);
		
		// Panneau des contraintes selon choix
		gbc.gridx += gbc.gridwidth;
		gbc.gridy=0;
		gbc.gridheight=3;
		gbc.gridwidth=3;
		gbc.weighty=0;
		gbc.weightx=0;
		planePanel.add(mainWindow.getPlaneConstraintsChoicePanel());
		
		// Panel de visualisation du graphe
		gbc.gridx = 1;
		gbc.gridy += gbc.gridheight;
		gbc.gridheight=7;
		gbc.weightx = 1;
		gbc.weighty = 1;
		planePanel.add(mainWindow.getDisplayPlanePanel(),gbc);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("oin");
		if (o instanceof MainWindow && arg.equals("exec")){
			System.out.println("OIN");
			//Droite 0/1/2 + data (via cdv)
			if (onglets.getSelectedIndex() == 0){
				DroiteMoindreCarres dmc = new DroiteMoindreCarres();
				String tX = mainWindow.getTransformationsLine().getTransformX().getTransformX().getText();
				String tY = mainWindow.getTransformationsLine().getTransformY().getTransformY().getText();
				if (!tX.equals("")){
					
				}
				if (!tY.equals("")){
					
				}
				if (mainWindow.getLineConstraintsChoice().getNoConstraint().isSelected()){
					dmc.run(mainWindow.getData().getX(), mainWindow.getData().getY(), 0, new LinkedList<Double>(), 0);
					infosLine = dmc.getInfosC0orC1();
				}
				if (mainWindow.getLineConstraintsChoice().getPointConstraint().isSelected()){//TODO changer omegas
					dmc.run(mainWindow.getData().getX(), mainWindow.getData().getY(), 1, new LinkedList<Double>(), 0);
					infosLine = dmc.getInfosC0orC1();
				}
				if (mainWindow.getLineConstraintsChoice().getSlopeConstraint().isSelected()){//TODO changer omegas
					dmc.run(mainWindow.getData().getX(), mainWindow.getData().getY(), 2, new LinkedList<Double>(), Double.parseDouble(mainWindow.getLineConstraintsChoice().getSlopeConstraintPanel().getSlope().getText()));
					infosLine = dmc.getInfosC2();
				}
				currentInfos = infosLine;
			}
			//Plans 0/1/2 +++++
			//2D : phi + datas
			//3D : phi + datas
			
		}
		if (o instanceof MainWindow && arg.equals("infos")){
			new InfosWindowFrame(new InfosWindow(currentInfos));
		}
		if (o instanceof MainWindow && arg.equals("newDatas")){
			switch (onglets.getSelectedIndex()) {
			case 0:
				this.repaint();
				break;
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			default:
				break;
			}
		}

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

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public void setContentPanel(JPanel contentPanel) {
		this.contentPanel = contentPanel;
	}

}
