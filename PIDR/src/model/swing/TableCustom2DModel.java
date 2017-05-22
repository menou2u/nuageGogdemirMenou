package model.swing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import controller.Datas2DFactory;

@SuppressWarnings("serial")
public class TableCustom2DModel extends AbstractTableModel {
	private final ArrayList<Point2D> points = new ArrayList<Point2D>();
	private final String[] entetes;
	private TableCustom2DModel transformedData;

	public TableCustom2DModel(String fileName,String[] entetes) {
		super();
		this.entetes = entetes;
		fillPoints(fileName);
		//"C:\\Users\\Romain\\git\\nuageGogdemirMenou\\Excel tests\\test droite.xlsx"
	}
	
	public TableCustom2DModel(String[] entetes){
		super();
		this.entetes = entetes;
		LinkedList<Double> point = new LinkedList<Double>();
		point.add(1.0);
		point.add(0.0);
		point.add(0.0);
		points.add(new Point2D(point));
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
		LinkedList<Double> x = fact.getX();
		LinkedList<Double> y = fact.getY();
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
			return rowIndex+1;
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
	
	public void applyTransfo(){
		//TODO : Quand on clique le bouton Validation du transformationsPanel, Ca devra appeler cette méthode pour changer la partie des TransformedDatas
	}

	public ArrayList<Point2D> getPoints() {
		// TODO Auto-generated method stub
		return points;
	}

	public String[] getEntetes() {
		// TODO Auto-generated method stub
		return entetes;
	}
}
