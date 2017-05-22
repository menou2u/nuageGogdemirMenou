package model.swing;

import java.io.File;
import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

public abstract class TableCustomModel extends AbstractTableModel{
	public abstract LinkedList<Double>getX();
	public abstract LinkedList<Double>getY();
	public abstract LinkedList<Double>getZ();
	public void warnView(MainWindow mainWindow, File file) {
	}
	public boolean isEmpty() {
		return false;
	}
}
