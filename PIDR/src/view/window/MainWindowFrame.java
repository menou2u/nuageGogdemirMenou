package view.window;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import model.swing.MainWindow;

@SuppressWarnings("serial")
public class MainWindowFrame extends JFrame implements Observer {
	
	@SuppressWarnings("unused")
	private MainWindow mainWindow;
	
	public MainWindowFrame(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		mainWindow.addObserver(this);
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		this.setJMenuBar(mainWindow.getMenu().getMenuBar());
		
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
		mainWindow.getTools().addObserver(this);

		// Panneau des donn�es brutes
		gbc.gridwidth = 1;
		gbc.weighty = 1;
		gbc.gridheight = 3;
		gbc.gridy += gbc.gridheight;
		add(mainWindow.getDataPanel(), gbc);
		mainWindow.getData().addObserver(this);

		// Panneau des contraintes sur coordonn�es
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
		//mainWindow.getMathShortcuts().addObserver(this);

		// Fonction f
		gbc.gridx += gbc.gridwidth;
		gbc.weightx = 0;
		gbc.weighty = 0;
		add(mainWindow.getCalculatedFunctionPanel(), gbc);
		mainWindow.getCalculatedFunction().addObserver(this);

		// Panel de visualisation du graphe
		gbc.gridx = 1;
		gbc.gridy += gbc.gridheight;
		gbc.gridwidth = 3;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(mainWindow.getVisualisationPanel(), gbc);

		// Param�tres fen�tre
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize= new Dimension((int)(screenSize.width*0.8), (int)(screenSize.height*0.8));
		setPreferredSize(frameSize);
		setLocation((screenSize.width-frameSize.width)/2, (screenSize.height-frameSize.height)/2);
		setVisible(true);
		pack();
	}

	@Override
	public void update(Observable o, Object arg) {
		/*if (o instanceof Tools){
			System.out.println("TOOLS");
			if (arg instanceof File){
				System.out.println("FILE");
				mainWindow.getData().updateTableContent(((File) arg).getPath());
				System.out.println("oin ?");
			}
		}*/
	}

	public static void main(String[] args) {
		new MainWindowFrame(new MainWindow());
	}

}
