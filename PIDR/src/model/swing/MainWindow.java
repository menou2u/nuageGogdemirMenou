package model.swing;

import java.io.File;
import java.util.LinkedList;
import java.util.Observable;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import model.math.DroiteMoindreCarres;
import model.math.Nuages2D;
import model.math.Nuages3D;
import view.panels.UpdatablePanel;
import view.window.InfosWindowFrame;

public class MainWindow extends Observable {
	
	private Tools tools;
	private Line line;
	private Plane plane;
	private D2 d2;
	private D3 d3;
	private JTabbedPane onglets;

	private StringBuilder infosLine;
	private StringBuilder infosPlane;
	private StringBuilder infos2D;
	private StringBuilder infos3D;
	private StringBuilder currentInfos;
	
	
	public MainWindow() {
		tools = new Tools(this);
		line = new Line();
		plane = new Plane();
		d2 = new D2();
		d3 = new D3();
		onglets = new JTabbedPane(SwingConstants.TOP);
		currentInfos = new StringBuilder("");
	}
	
	public void sendNewFile(MainWindow mainWindow,File file) {
		getMode().getData().warnView(mainWindow,file);
	}

	public void runMath() {
		//Droite 0/1/2 + data (via cdv)
		if (getOnglets().getSelectedIndex() == 0){
			DroiteMoindreCarres dmc = new DroiteMoindreCarres();
			Line mode = (Line) getMode();
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
			if (mode.getLineConstraintsChoice().getPointConstraint().isSelected()){
				dmc.run(mode.getData().getX(), mode.getData().getY(), 1, mode.getPointConstraint().getOmegaDatas(), 0);
				infosLine = dmc.getInfosC0orC1();
			}
			if (mode.getLineConstraintsChoice().getSlopeConstraint().isSelected()){
				dmc.run(mode.getData().getX(), mode.getData().getY(), 2, mode.getPointConstraint().getOmegaDatas(), Double.parseDouble(mode.getLineConstraintsChoice().getSlopeConstraintPanel().getSlope().getText()));
				infosLine = dmc.getInfosC2();
			}
			mode.getLineGraph().fill(mode.getData().getX(), mode.getData().getY());
			currentInfos = infosLine;
		}
		//TODO Plans 0/1/2 +++++
		//2D : phi + datas
		if (getOnglets().getSelectedIndex() == 1){
			Nuages2D nuages2D = new Nuages2D();
			D2 mode = (D2) getMode();
			String[] phi = mode.getTestFunction().getText().getText().split(",");
			LinkedList<String> phiList = new LinkedList<>();
			for (int i=0; i<phi.length; i++){
				phiList.add(phi[i]);
			}
			nuages2D.run(mode.getData().getX(), mode.getData().getY(), phiList, mode.getTwoDConstraints().getColumn(1), mode.getTwoDConstraints().getColumn(2), mode.getTwoDConstraints().getColumn(3));
			currentInfos = nuages2D.getInfos();
			mode.getTwoDCalculatedFunction().setFunctionCalculated(nuages2D.getFunction());
		}
		//3D : phi + datas
		if (getOnglets().getSelectedIndex() == 3){
			Nuages3D nuages3D = new Nuages3D();
			D3 mode = (D3) getMode();
			String[] phi = mode.getTestFunction().getText().getText().split(",");
			LinkedList<String> phiList = new LinkedList<>();
			for (int i=0; i<phi.length; i++){
				phiList.add(phi[i]);
			}
			nuages3D.run(mode.getData().getX(), mode.getData().getY(), mode.getData().getZ(), phiList, mode.getThreeDConstraints().getColumn(1), mode.getThreeDConstraints().getColumn(2), mode.getThreeDConstraints().getColumn(3), mode.getThreeDConstraints().getColumn(4), mode.getThreeDConstraints().getColumn(5), mode.getThreeDConstraints().getColumn(6));
			currentInfos = nuages3D.getInfos();
			mode.getThreeDCalculatedFunction().setFunctionCalculated(nuages3D.getFunction());
			//TODO mode.getD3Graph().update(nuages3D.getFunction());
		}
		InfosWindowFrame.getCurrent().setInfos(currentInfos);
		setChanged();
		notifyObservers();
	}

	public void updateInfos() {
		InfosWindowFrame.getCurrent().setInfos(currentInfos);
		setChanged();
		notifyObservers("infos");
	}
	
	public Updatable getMode(){
		UpdatablePanel modePanel = (UpdatablePanel) onglets.getSelectedComponent();
		Updatable onglet = modePanel.getOnglet();
		return onglet;
	}

	public Tools getTools() {
		return tools;
	}

	/**
	 * @return the line
	 */
	public Line getLine() {
		return line;
	}

	/**
	 * @return the plane
	 */
	public Plane getPlane() {
		return plane;
	}

	/**
	 * @return the d2
	 */
	public D2 getD2() {
		return d2;
	}

	/**
	 * @return the d3
	 */
	public D3 getD3() {
		return d3;
	}

	/**
	 * @return the onglets
	 */
	public JTabbedPane getOnglets() {
		return onglets;
	}
	
	

}
