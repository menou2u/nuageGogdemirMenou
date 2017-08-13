package com.nuage.model.swing.mode;

import javax.swing.table.AbstractTableModel;

import com.nuage.model.swing.datas.TestFunction;
import com.nuage.model.swing.datas.TransformX;
import com.nuage.model.swing.datas.TransformY;
import com.nuage.model.swing.datas.tables.TableCustomModel;

public interface Updatable {

	TableCustomModel getData();
	
	TestFunction getTestFunction();
	
	TransformX getTransformX();
	
	TransformY getTransformY();
	
	AbstractTableModel getDataModel();
	
}
