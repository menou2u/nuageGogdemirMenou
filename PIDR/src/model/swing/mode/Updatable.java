package model.swing.mode;

import javax.swing.table.AbstractTableModel;

import model.swing.datas.TestFunction;
import model.swing.datas.TransformX;
import model.swing.datas.TransformY;
import model.swing.datas.tables.TableCustomModel;

public interface Updatable {

	TableCustomModel getData();
	
	TestFunction getTestFunction();
	
	TransformX getTransformX();
	
	TransformY getTransformY();
	
	AbstractTableModel getDataModel();
	
}
