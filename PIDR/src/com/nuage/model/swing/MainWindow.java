package com.nuage.model.swing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Scanner;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import com.nuage.model.math.DroiteMoindreCarres;
import com.nuage.model.math.Nuages2D;
import com.nuage.model.math.Nuages3D;
import com.nuage.model.swing.mode.D2;
import com.nuage.model.swing.mode.D3;
import com.nuage.model.swing.mode.Line;
import com.nuage.model.swing.mode.Plane;
import com.nuage.model.swing.mode.Updatable;
import com.nuage.view.panels.UpdatablePanel;
import com.nuage.view.window.InfosWindowFrame;

public class MainWindow extends Observable {

	private Tools tools;
	private Line line;
	private Plane plane;
	private D2 d2;
	private D3 d3;
	private JTabbedPane onglets;

	private StringBuilder infosLine;
	private StringBuilder currentInfos;

	private File currentFile = null;

	public MainWindow() {
		tools = new Tools(this);
		line = new Line();
		plane = new Plane();
		d2 = new D2();
		d3 = new D3();
		onglets = new JTabbedPane(SwingConstants.TOP);
		currentInfos = new StringBuilder("");
	}

	public void sendNewFile(MainWindow mainWindow, File file) {
		getMode().getData().warnView(mainWindow, file);
	}

	public void readFile(File file) {
		FileReader fileReader;
		BufferedReader bufferedReader;
		String line, item;
		Scanner scanner;
		LinkedList<Double> listXi = new LinkedList<Double>();
		LinkedList<Double> listYi = new LinkedList<Double>();
		LinkedList<Double> listZi = new LinkedList<Double>();
		LinkedList<Double> listXiTraité = new LinkedList<Double>();
		LinkedList<Double> listYiTraité = new LinkedList<Double>();
		LinkedList<Double> listZiTraité = new LinkedList<Double>();
		LinkedList<Double> xwList = new LinkedList<Double>();
		LinkedList<Double> ywList = new LinkedList<Double>();
		LinkedList<Double> constraintValueList = new LinkedList<Double>();
		LinkedList<Integer> derivationOrderList = new LinkedList<Integer>();
		LinkedList<Double> uxList = new LinkedList<Double>();
		LinkedList<Double> uyList = new LinkedList<Double>();
		String xTreatment = "", yTreatment = "", zTreatment = "";
		Double xwbrut = null, ywbrut = null, xwtraité = null, ywtraité = null, pente = null;
		String textBoxFx = "";
		String textBoxCompoFx = "";
		String mode, scanResult;
		try {
			fileReader = new FileReader(file.getAbsolutePath());
			bufferedReader = new BufferedReader(fileReader);
			line = bufferedReader.readLine();
			mode = line;
			while (line != null) {
				scanner = new Scanner(line);
				scanner.useDelimiter(";");
				item = scanner.next();
				// System.out.println("ITEM "+ item);
				if (item.equals("DB")) {
					int index;
					index = Integer.parseInt(scanner.next()) - 1;
					if (index > listXi.size() - 1) {
						listXi.add(Double.parseDouble(scanner.next()));
					} else {
						listXi.add(index, Double.parseDouble(scanner.next()));
					}
					if (index > listYi.size() - 1) {
						listYi.add(Double.parseDouble(scanner.next()));
					} else {
						listYi.add(index, Double.parseDouble(scanner.next()));
					}
					if (mode.equals("3DKC") || mode.equals("2PLMC")) {
						if (index > listZi.size() - 1) {
							listZi.add(Double.parseDouble(scanner.next()));
						} else {
							listZi.add(index, Double.parseDouble(scanner.next()));
						}
					}
				}
				if (item.equals("DT")) {
					int index;
					index = Integer.parseInt(scanner.next()) - 1;
					if (index > listXiTraité.size() - 1) {
						listXiTraité.add(Double.parseDouble(scanner.next()));
					} else {
						listXiTraité.add(index, Double.parseDouble(scanner.next()));
					}
					if (index > listYiTraité.size() - 1) {
						listYiTraité.add(Double.parseDouble(scanner.next()));
					} else {
						listYiTraité.add(index, Double.parseDouble(scanner.next()));
					}
					if (mode.equals("3DKC") || mode.equals("2PLMC")) {
						if (index > listZiTraité.size() - 1) {
							listZiTraité.add(Double.parseDouble(scanner.next()));
						} else {
							listZiTraité.add(index, Double.parseDouble(scanner.next()));
						}
					}
				}
				if (item.trim().equals("Contrainte:")) {
					int index;
					index = Integer.parseInt(scanner.next()) - 1;
					if (index > xwList.size() - 1) {
						xwList.add(Double.parseDouble(scanner.next()));
					} else {
						xwList.add(index, Double.parseDouble(scanner.next()));
					}
					if (mode.equals("3DKC")) {
						if (index > ywList.size() - 1) {
							ywList.add(Double.parseDouble(scanner.next()));
						} else {
							ywList.add(Double.parseDouble(scanner.next()));
						}
					}
					if (index > constraintValueList.size() - 1) {
						constraintValueList.add(Double.parseDouble(scanner.next()));
					} else {
						constraintValueList.add(index, Double.parseDouble(scanner.next()));
					}
					if (index > derivationOrderList.size() - 1) {
						derivationOrderList.add(Integer.parseInt(scanner.next()));
					} else {
						derivationOrderList.add(index, Integer.parseInt(scanner.next()));
					}
					if (mode.equals("3DKC")) {
						scanResult = scanner.next();
						if (scanResult.isEmpty()) {
							if (index > uxList.size() - 1) {
								uxList.add(0.0);
							} else {
								uxList.add(index, 0.0);
							}
						} else {
							if (index > uxList.size() - 1) {
								uxList.add(Double.parseDouble(scanResult));
							} else {
								uxList.add(index, Double.parseDouble(scanResult));
							}
						}
						scanResult = scanner.next();
						if (scanResult.isEmpty()) {
							if (index > uyList.size() - 1) {
								uyList.add(0.0);
							} else {
								uyList.add(index, 0.0);
							}
						} else {
							if (index > uyList.size() - 1) {
								uyList.add(Double.parseDouble(scanResult));
							} else {
								uyList.add(index, Double.parseDouble(scanResult));
							}
						}
					}
				}
				if (item.equals("X=tx(x)") && scanner.hasNext()) {
					xTreatment = scanner.next();
				}
				if (item.equals("Y=ty(y)") && scanner.hasNext()) {
					yTreatment = scanner.next();
				}
				if (item.equals("Z=tz(z)") && scanner.hasNext()) {
					zTreatment = scanner.next();
				}
				if (item.equals("xw brut") && scanner.hasNext()) {
					xwbrut = Double.parseDouble(scanner.next());
				}
				if (item.equals("yw brut") && scanner.hasNext()) {
					ywbrut = Double.parseDouble(scanner.next());
				}
				if (item.equals("xw traité") && scanner.hasNext()) {
					xwtraité = Double.parseDouble(scanner.next());
				}
				if (item.equals("yw traité") && scanner.hasNext()) {
					ywtraité = Double.parseDouble(scanner.next());
				}
				if (item.equals("pente") && scanner.hasNext()) {
					pente = Double.parseDouble(scanner.next());
				}
				if (item.equals("TextBoxfx :") && scanner.hasNext()) {
					textBoxFx = scanner.next();
				}
				if (item.equals("TextBoxCompoFx :") && scanner.hasNext()) {
					textBoxCompoFx = scanner.next();
				}
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
		}
		/*
		 * System.out.println("listXi "+listXi); System.out.println("listYi "+listYi);
		 * System.out.println("listZi "+listZi);
		 * System.out.println("listXiTraité "+listXiTraité);
		 * System.out.println("listYiTraité "+listYiTraité);
		 * System.out.println("listZiTraité "+listZiTraité);
		 * System.out.println("xwList "+xwList); System.out.println("yxList "+ywList);
		 * System.out.println("constraintValueList "+constraintValueList);
		 * System.out.println("derivationOrderList "+derivationOrderList);
		 * System.out.println("uxList "+uxList); System.out.println("uyList "+uyList);
		 * System.out.println("xTreatment "+xTreatment);
		 * System.out.println("yTreatment "+yTreatment);
		 * System.out.println("zTreatment "+zTreatment);
		 * System.out.println("xwbrut "+xwbrut); System.out.println("ywbrut "+ywbrut);
		 * System.out.println("xwtraité "+xwtraité);
		 * System.out.println("ywtraité "+ywtraité); System.out.println("pente "+pente);
		 * System.out.println("textBoxFx "+textBoxFx);
		 * System.out.println("textBoxCompoFx "+textBoxCompoFx);
		 */

		switch (getOnglets().getSelectedIndex()) {
		case 0:
			Line lineMode = (Line) getMode();
			// lineMode.getData().
			lineMode.getData().fillPoints(listXi, listYi, null);
			lineMode.getTransformX().setTransformX(xTreatment);
			lineMode.getTransformY().setTransformY(yTreatment);
			lineMode.getDataLinePanel().getTc2dmTrans().fillPoints(listXiTraité, listYiTraité, null);
			if (pente != null) {
				lineMode.getLineConstraintsChoice().getSlopeConstraints().setSlopeText("" + pente);
			}
			if (xwbrut != null) {
				lineMode.getLineConstraintsChoice().getPointConstraint().setxWTrueText("" + xwbrut);
			}
			if (ywbrut != null) {
				lineMode.getLineConstraintsChoice().getPointConstraint().setyWTrueText("" + ywbrut);
			}
			if (xwtraité != null) {
				lineMode.getLineConstraintsChoice().getPointConstraint().setxWTreatedText("" + xwtraité);
			}
			if (ywtraité != null) {
				lineMode.getLineConstraintsChoice().getPointConstraint().setyWTreatedText("" + ywtraité);
			}
			break;
		case 1:
			D2 d2Mode = (D2) getMode();
			d2Mode.getData().fillPoints(listXi, listYi, null);
			d2Mode.getTestFunction().getText().setText(textBoxFx);
			d2Mode.getTwoDCalculatedFunction().getFunctionCalculated().setText(textBoxCompoFx);
			d2Mode.getTwoDConstraints().fillConstraints(xwList, constraintValueList, derivationOrderList);
			break;
		case 2:
			Plane planeMode = (Plane) getMode();
			planeMode.getData().fillPoints(listXi, listYi, null);
			planeMode.getTransformX().setTransformX(xTreatment);
			planeMode.getTransformY().setTransformY(yTreatment);
			planeMode.getTransformZ().setTransformZ(zTreatment);
			planeMode.getDataPlanePanel().getTc3dmTrans().fillPoints(listXiTraité, listYiTraité, listZiTraité);
			break;
		case 3:
			D3 d3Mode = (D3) getMode();
			d3Mode.getData().fillPoints(listXi, listYi, listZi);
			d3Mode.getTestFunction().getText().setText(textBoxFx);
			d3Mode.getThreeDCalculatedFunction().getFunctionCalculated().setText(textBoxCompoFx);
			d3Mode.getThreeDConstraints().fillConstraints(xwList, ywList, constraintValueList, derivationOrderList,
					uxList, uyList);
			break;
		}
	}

	public void runMath() {
		// Droite 0/1/2 + data (via cdv)
		if (getOnglets().getSelectedIndex() == 0) {
			DroiteMoindreCarres dmc = new DroiteMoindreCarres();
			Line mode = (Line) getMode();
			String tX = mode.getTransformX().getTransformX().getText();
			String tY = mode.getTransformY().getTransformY().getText();
			if (!tX.equals("")) {

			}
			if (!tY.equals("")) {

			}
			if (mode.getLineConstraintsChoice().getNoConstraintButton().isSelected()) {
				dmc.run(mode.getData().getX(), mode.getData().getY(), 0, new LinkedList<Double>(), 0);
				infosLine = dmc.getInfosC0orC1();
			}
			if (mode.getLineConstraintsChoice().getPointConstraintButton().isSelected()) {
				dmc.run(mode.getData().getX(), mode.getData().getY(), 1,
						mode.getLineConstraintsChoice().getPointConstraint().getOmegaDatas(), 0);
				infosLine = dmc.getInfosC0orC1();
			}
			if (mode.getLineConstraintsChoice().getSlopeConstraintButton().isSelected()) {
				dmc.run(mode.getData().getX(), mode.getData().getY(), 2,
						mode.getLineConstraintsChoice().getPointConstraint().getOmegaDatas(),
						Double.parseDouble(mode.getLineConstraintsChoice().getSlopeConstraints().getSlope().getText()));
				infosLine = dmc.getInfosC2();
			}
			mode.getLineGraph().fill(mode.getData().getX(), mode.getData().getY());
			currentInfos = infosLine;
		}
		// TODO Plans 0/1/2 +++++
		// 2D : phi + datas
		if (getOnglets().getSelectedIndex() == 1) {
			Nuages2D nuages2D = new Nuages2D();
			D2 mode = (D2) getMode();
			String[] phi = mode.getTestFunction().getText().getText().split(",");
			LinkedList<String> phiList = new LinkedList<>();
			for (int i = 0; i < phi.length; i++) {
				phiList.add(phi[i]);
			}
			LinkedList<Integer> derivationList = new LinkedList<>();
			LinkedList<Double> oldDerivationList = mode.getTwoDConstraints().getDerivationOrder();
			for (int i = 0; i < oldDerivationList.size(); i++) {
				derivationList.add(Integer.parseInt("" + oldDerivationList.get(i).intValue()));
			}
			// Y avait ça a la fin de run : mode.getTwoDConstraints().getColumn(3)
			nuages2D.run(mode.getData().getX(), mode.getData().getY(), phiList, mode.getTwoDConstraints().getXw(),
					mode.getTwoDConstraints().getConstraintValue(), derivationList);
			currentInfos = nuages2D.getInfos();
			mode.getTwoDCalculatedFunction().setFunctionCalculated(nuages2D.getFunction());
		}
		// 3D : phi + datas
		if (getOnglets().getSelectedIndex() == 3) {
			Nuages3D nuages3D = new Nuages3D();
			D3 mode = (D3) getMode();
			String[] phi = mode.getTestFunction().getText().getText().split(",");
			LinkedList<String> phiList = new LinkedList<>();
			for (int i = 0; i < phi.length; i++) {
				phiList.add(phi[i]);
			}
			LinkedList<Integer> derivationList = new LinkedList<>();
			LinkedList<Double> oldDerivationList = mode.getThreeDConstraints().getDerivationOrder();
			for (int i = 0; i < oldDerivationList.size(); i++) {
				derivationList.add(Integer.parseInt("" + oldDerivationList.get(i).intValue()));
			}
			nuages3D.run(mode.getData().getX(), mode.getData().getY(), mode.getData().getZ(), phiList,
					mode.getThreeDConstraints().getXw(), mode.getThreeDConstraints().getYw(),
					mode.getThreeDConstraints().getConstraintValue(), derivationList,
					mode.getThreeDConstraints().getUx(), mode.getThreeDConstraints().getUy());
			currentInfos = nuages3D.getInfos();
			mode.getThreeDCalculatedFunction().setFunctionCalculated(nuages3D.getFunction());
			// TODO mode.getD3Graph().update(nuages3D.getFunction());
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

	public Updatable getMode() {
		UpdatablePanel modePanel = (UpdatablePanel) onglets.getSelectedComponent();
		Updatable onglet = modePanel.getOnglet();
		return onglet;
	}

	public Tools getTools() {
		return tools;
	}

	public void setCurrentFile(File file) {
		currentFile = file;
	}

	public File getCurrentFile() {
		return currentFile;
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

	public void saveInFile(File file) {
		if (getMode() instanceof Line) {

		}
		if (getMode() instanceof Plane) {

		}
		if (getMode() instanceof D2) {

		}
		if (getMode() instanceof D3) {

		}
	}

}
