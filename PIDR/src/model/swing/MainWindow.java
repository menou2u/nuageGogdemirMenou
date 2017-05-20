package model.swing;

import java.awt.Component;
import java.io.File;
import java.util.Observable;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class MainWindow extends Observable {
	
	private Tools tools;
	private Line line;
	private Plane plane;
	private D2 d2;
	private D3 d3;
	private JTabbedPane onglets;
	
	
	public MainWindow() {
		tools = new Tools(this);
		line = new Line(tools);
		plane = new Plane();
		d2 = new D2();
		d3 = new D3();
		onglets = new JTabbedPane(SwingConstants.TOP);
	}
	
	public void sendNewFile(File file) {
		UpdatablePanel modePanel = (UpdatablePanel) onglets.getSelectedComponent();
		Onglet onglet = modePanel.getOnglet();
		onglet.getData().warnView(file);
	}

	public void runMath(Updatable u) {
		if (!u.getData().getPath().equals("")){
			setChanged();
			notifyObservers("exec");
		}
	}

	public Tools getTools() {
		return tools;
	}

	public void updateInfos() {
		setChanged();
		notifyObservers("infos");
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
