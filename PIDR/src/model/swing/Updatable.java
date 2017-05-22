package model.swing;

import javax.swing.table.AbstractTableModel;

public interface Updatable {

	TableCustomModel getData();
	
	TestFunction getTestFunction();
	
	TransformX getTransformX();
	
	TransformY getTransformY();
	
	AbstractTableModel getDataModel();
	
}
