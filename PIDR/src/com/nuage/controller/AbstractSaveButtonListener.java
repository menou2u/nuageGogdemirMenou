package com.nuage.controller;

import java.awt.event.ActionListener;

import com.nuage.model.InfosWindow;
import com.nuage.model.swing.Tools;
import com.nuage.model.swing.mode.D2;
import com.nuage.model.swing.mode.Line;
import com.nuage.model.swing.mode.Plane;
import com.nuage.model.swing.mode.Updatable;

public abstract class AbstractSaveButtonListener implements ActionListener {

	protected Tools toolsReference;
	protected InfosWindow infosWindow;

	public AbstractSaveButtonListener(Tools toolsReference) {
		this.toolsReference = toolsReference;
	}

	public AbstractSaveButtonListener(InfosWindow infosWindow) {
		this.infosWindow = infosWindow;
	}

	public String getDescription() {
		Updatable mode = toolsReference.getMainWindow().getMode();
		if (mode instanceof Line) {
			return ".gd";
		}
		if (mode instanceof Plane) {
			return ".gpd";
		}
		if (mode instanceof D2) {
			return ".g2d";
		}
		return ".g3d";
	}
}
