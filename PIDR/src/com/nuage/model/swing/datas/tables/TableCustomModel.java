package com.nuage.model.swing.datas.tables;

import java.io.File;
import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import com.nuage.model.swing.MainWindow;

@SuppressWarnings("serial")
public abstract class TableCustomModel extends AbstractTableModel{
	public abstract LinkedList<Double>getX();
	public abstract LinkedList<Double>getY();
	public abstract LinkedList<Double>getZ();
	public void warnView(MainWindow mainWindow, File file) {
	}
	public boolean isEmpty() {
		return false;
	}
	public abstract void fillPoints(LinkedList<Double> x, LinkedList<Double> y, LinkedList<Double> z);
}
