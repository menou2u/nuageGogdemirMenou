package model.swing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import controller.Datas2DFactory;

@SuppressWarnings("serial")
public class TableCustom2DModel extends AbstractTableModel {
	private final ArrayList<Point2D> points = new ArrayList<Point2D>();

	private final String[] entetes = { "n°", "Xi", "Yi" };

	public TableCustom2DModel() {
		super();
		fillPoints("C:\\Users\\Romain\\git\\nuageGogdemirMenou\\Excel tests\\test droite.xlsx");
	}

	public void fillPoints(String fileName){
		LinkedList<Double> point=new LinkedList<Double>();
		Datas2DFactory fact = null;
		try {
			fact = new Datas2DFactory(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LinkedList x = fact.getX();
		LinkedList y = fact.getY();
		for (int i=0;i<x.size();i++){
			point.add(i+1.0);
			point.add((Double)x.get(i));
			point.add((Double)y.get(i));
			points.add(new Point2D(point));
			point = new LinkedList<Double>();
		}
	}
	
	public int getRowCount() {
		return points.size();
	}

	public int getColumnCount() {
		return entetes.length;
	}

	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return points.get(rowIndex).getNum();
		case 1:
			return points.get(rowIndex).getX();
		case 2:
			return points.get(rowIndex).getY();
		default:
			return null; // Ne devrait jamais arriver
		}
	}

	public void addPoint(Point2D point) {
		points.add(point);

		fireTableRowsInserted(points.size() - 1, points.size() - 1);
	}

	public void removePoint(int rowIndex) {
		points.remove(rowIndex);

		fireTableRowsDeleted(rowIndex, rowIndex);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return false;
		}
		return true;
	}

	@Override
    public void setValueAt(Object val, int rowIndex, int columnIndex){
    	if (!isCellEditable(rowIndex,columnIndex))
    	{
    		return;
    	}
    	if (val != null){
    		Point2D point = points.get(rowIndex);
    		switch (columnIndex) {
    		case 1:
    			point.setX((Double)val);
    			break;
    		case 2:
    			point.setY((Double)val);
    		default:
    			break;
			}
    	}
    }
	
	@Override
	public Class getColumnClass(int columnIndex){
		return Double.class;
	}
}
