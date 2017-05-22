package model.swing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import com.sun.org.apache.bcel.internal.generic.LLOAD;

import controller.Datas3DFactory;

@SuppressWarnings("serial")
public class TableCustom3DModel extends AbstractTableModel {
	private final ArrayList<Point3D> points = new ArrayList<Point3D>();
	private final String[] entetes;
	private TableCustom3DModel transformedData;

	public TableCustom3DModel(String fileName,String[] entetes) {
		super();
		this.entetes = entetes;
		fillPoints(fileName);
		//"C:\\Users\\Romain\\git\\nuageGogdemirMenou\\Excel tests\\test droite.xlsx"
	}
	
	public TableCustom3DModel(String[] entetes){
		super();
		this.entetes = entetes;
		LinkedList<Double> point = new LinkedList<Double>();
		point.add(1.0);
		point.add(0.0);
		point.add(0.0);
		point.add(0.0);
		points.add(new Point3D(point));
	}

	public void fillPoints(String fileName){
		LinkedList<Double> point=new LinkedList<Double>();
		Datas3DFactory fact = null;
		try {
			fact = new Datas3DFactory(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LinkedList<Double> x = fact.getX();
		LinkedList<Double> y = fact.getY();
		LinkedList<Double> z = fact.getZ();
		for (int i=0;i<x.size();i++){
			point.add(i+1.0);
			point.add((Double)x.get(i));
			point.add((Double)y.get(i));
			point.add((Double)z.get(i));
			points.add(new Point3D(point));
			point = new LinkedList<Double>();
		}
	}
	
	public int getRowCount() {
		return points.size();
	}

	public int getColumnCount() {
		return entetes.length;
	}
	
	public ArrayList<Point3D> getPoints()
	{
		return points;
	}

	public String[] getEntetes(){
		return entetes;
	}
	
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return rowIndex+1;
		case 1:
			return points.get(rowIndex).getX();
		case 2:
			return points.get(rowIndex).getY();
		case 3:
			return points.get(rowIndex).getZ();
		default:
			return null; // Ne devrait jamais arriver
		}
	}

	public void addPoint(Point3D point) {
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
    		Point3D point = points.get(rowIndex);
    		switch (columnIndex) {
    		case 1:
    			point.setX((Double)val);
    			break;
    		case 2:
    			point.setY((Double)val);
    		case 3:
    			point.setZ((Double)val);
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
