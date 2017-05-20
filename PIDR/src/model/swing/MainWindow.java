package model.swing;

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
		getMode().getData().warnView(file);
	}

	public void runMath() {
		if (!getMode().getData().getPath().equals("")){
			setChanged();
			notifyObservers("exec");
		}
	}

	public void updateInfos() {
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
