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

import model.math.DroiteMoindreCarres;
import model.math.Nuages2D;
import model.math.Nuages3D;
import model.swing.D2;
import model.swing.D3;
import model.swing.Line;
import model.swing.MainWindow;
import view.panels.D2Panel;
import view.panels.D3Panel;
import view.panels.LinePanel;
import view.panels.PlanePanel;
import view.panels.ToolsPanel;

public class MainWindowFrame extends JFrame implements Observer {

	private static final long serialVersionUID = 2587382723338443456L;
	private static JFrame current;
	private JPanel contentPanel;
	private LinePanel linePanel;
	private PlanePanel planePanel;
	private D2Panel d2Panel;
	private D3Panel d3Panel;
	private ToolsPanel toolsPanel;
	private MainWindow mainWindow;
	private StringBuilder infosLine;
	private StringBuilder infosPlane;
	private StringBuilder infos2D;
	private StringBuilder infos3D;
	private StringBuilder currentInfos;

	/**
	 * @param mainWindow
	 */
	@SuppressWarnings("static-access")
	public MainWindowFrame(MainWindow mainWindow) {
		this.setMainWindow(mainWindow);
		mainWindow.addObserver(this);

		linePanel = new LinePanel(mainWindow.getLine());
		planePanel = new PlanePanel(mainWindow.getPlane());
		d2Panel = new D2Panel(mainWindow.getD2());
		d3Panel = new D3Panel(mainWindow.getD3());
		toolsPanel = new ToolsPanel(mainWindow.getTools());
		
		currentInfos = new StringBuilder("");
		
		setLayout(new BorderLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill = gbc.BOTH;
		gbc.weighty=0;
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridheight=1;
		gbc.gridwidth=1;
		
		JPanel contentPanel = new JPanel(new GridBagLayout());

		mainWindow.getOnglets().addTab("Droites", linePanel);
		mainWindow.getOnglets().addTab("2D", d2Panel);
		mainWindow.getOnglets().addTab("Plans", planePanel);
		mainWindow.getOnglets().addTab("3D", d3Panel);

		// Param�tres fen�tre
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//@TODO : G�rer ce la sauvegarde � la fermeture
				//mainWindow.getTools().saveHistoric();
			}
		});
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = new Dimension((int) (screenSize.width * 0.9), (int) (screenSize.height * 0.9));

		mainWindow.getOnglets().setPreferredSize(frameSize);
		mainWindow.getOnglets().setOpaque(true);

		// Panneau des outils
		//gbc.gridwidth = 4;
		//gbc.weighty = 0;
		//linePanel.add(mainWindow.getToolsPanel(), gbc);
		
		contentPanel.add(toolsPanel,gbc);
		
		gbc.gridy+=gbc.gridheight;
		gbc.weighty=1;
		gbc.weightx=1;
		contentPanel.add(mainWindow.getOnglets(),gbc);
		
		add(contentPanel);  //TODO add un autre gbc
		setPreferredSize(frameSize);
		setTitle("Nuage de points");
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		setVisible(true);
		pack();
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("oin");
		if (o instanceof MainWindow && arg.equals("exec")){
			System.out.println("OIN");
			//Droite 0/1/2 + data (via cdv)
			if (mainWindow.getOnglets().getSelectedIndex() == 0){
				DroiteMoindreCarres dmc = new DroiteMoindreCarres();
				Line mode = (Line) mainWindow.getMode();
				String tX = mode.getTransformX().getTransformX().getText();
				String tY = mode.getTransformY().getTransformY().getText();
				if (!tX.equals("")){
					
				}
				if (!tY.equals("")){
					
				}
				if (mode.getLineConstraintsChoice().getNoConstraint().isSelected()){
					dmc.run(mode.getData().getX(), mode.getData().getY(), 0, new LinkedList<Double>(), 0);
					infosLine = dmc.getInfosC0orC1();
				}
				if (mode.getLineConstraintsChoice().getPointConstraint().isSelected()){//TODO changer omegas
					dmc.run(mode.getData().getX(), mode.getData().getY(), 1, new LinkedList<Double>(), 0);
					infosLine = dmc.getInfosC0orC1();
				}
				if (mode.getLineConstraintsChoice().getSlopeConstraint().isSelected()){//TODO changer omegas
					dmc.run(mode.getData().getX(), mode.getData().getY(), 2, new LinkedList<Double>(), Double.parseDouble(mode.getLineConstraintsChoice().getSlopeConstraintPanel().getSlope().getText()));
					infosLine = dmc.getInfosC2();
				}
				currentInfos = infosLine;
			}
			//Plans 0/1/2 +++++
			//2D : phi + datas
			if (mainWindow.getOnglets().getSelectedIndex() == 1){
				Nuages2D nuages2D = new Nuages2D();
				D2 mode = (D2) mainWindow.getMode();
				String[] phi = mode.getTestFunction().getValue().split(",");
				LinkedList<String> phiList = new LinkedList<>();
				for (int i=0; i<phi.length; i++){
					phiList.add(phi[i]);
				}
				nuages2D.run(mode.getData().getX(), mode.getData().getY(), phiList, mode.getTwoDConstraints().getColumn(1), mode.getTwoDConstraints().getColumn(1), mode.getTwoDConstraints().getColumn(2), mode.getTwoDConstraints().getColumn(3));
				currentInfos = nuages2D.getInfos();
				mode.getTwoDCalculatedFunction().getFunctionCalculated().setText(nuages2D.getFunction());
			}
			//3D : phi + datas
			if (mainWindow.getOnglets().getSelectedIndex() == 3){
				Nuages3D nuages3D = new Nuages3D();
				D3 mode = (D3) mainWindow.getMode();
				String[] phi = mode.getTestFunction().getText().getText().split(",");
				LinkedList<String> phiList = new LinkedList<>();
				for (int i=0; i<phi.length; i++){
					phiList.add(phi[i]);
				}
				nuages3D.run(mode.getData().getX(), mode.getData().getY(), mode.getData().getZ(), phiList, mode.getThreeDConstraints().getColumn(1), mode.getThreeDConstraints().getColumn(2), mode.getThreeDConstraints().getColumn(3), mode.getThreeDConstraints().getColumn(4), mode.getThreeDConstraints().getColumn(5), mode.getThreeDConstraints().getColumn(6));
				currentInfos = nuages3D.getInfos();
				mode.getThreeDCalculatedFunction().setFunctionCalculated(nuages3D.getFunction());
			}
			InfosWindowFrame.getCurrent().setInfos(currentInfos);
			
		}
		if (o instanceof MainWindow && arg.equals("infos")){
			InfosWindowFrame.getCurrent().setInfos(currentInfos);
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

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

}
