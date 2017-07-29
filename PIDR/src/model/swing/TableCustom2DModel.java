package model.swing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

import controller.Datas2DFactory;

@SuppressWarnings("serial")
public class TableCustom2DModel extends TableCustomModel {
	private final ArrayList<Point2D> points = new ArrayList<Point2D>();
	private final String[] entetes;
	private TableCustom2DModel transformedData;
	private LinkedList<Double> x;
	private LinkedList<Double> y;
	private MainWindow mainWin;

	public TableCustom2DModel(MainWindow mainWindow,String fileName,String[] entetes) {
		super();
		mainWin = mainWindow;
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

	public void setTable(TableCustom2DModel table){
		x = table.getX();
		y = table.getY();
		points.clear();
		for (int i=0;i<x.size();i++)
		{
			points.add(new Point2D(i+0.0,x.get(i),y.get(i)));
		}
	}
	
	@Override
	public void warnView(MainWindow mainWindow,File file)
	{
		setTable(mainWindow,file.getPath());
	}
	
	public void setTable(MainWindow mainWindow,String fileName){
		setTable(new TableCustom2DModel(mainWindow,fileName,entetes));
		fireTableChanged(new TableModelEvent(this));
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
		x = fact.getX();
		y = fact.getY();
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

	public LinkedList<Double> getX(){
		 return x;
	}
	
	public LinkedList<Double> getY(){
		 return y;
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
	
	//REMOVE MUCH POINTS IN ONE BLOW
	public void removePoint(int begin, int end, int ratio)
	{
		int nbPointsToRemove = (end-begin)/ratio;
		int firstToRemove = begin + ratio*nbPointsToRemove;
		for (int i = 0; i<=nbPointsToRemove; i++)
		{
			removePoint(firstToRemove-(i*ratio));
		}
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
    	fireTableCellUpdated(rowIndex,columnIndex);
    }
	
	@Override
	public Class getColumnClass(int columnIndex){
		return Double.class;
	}
	
	public void applyTransfo(){
		//TODO : Quand on clique le bouton Validation du transformationsPanel, Ca devra appeler cette m�thode pour changer la partie des TransformedDatas
	}

	public ArrayList<Point2D> getPoints() {
		// TODO Auto-generated method stub
		return points;
	}

	public String[] getEntetes() {
		// TODO Auto-generated method stub
		return entetes;
	}
	
	public Data toData() {
		Data d = new Data("n�","x","y");
		for (Point2D p : points)
		{
			d.getX().add(p.getX());
			d.getY().add(p.getY());
		}
		return d;
	}
	
	@Override
	public boolean isEmpty(){
		if (x == null || y == null){
			x = new LinkedList<Double>();
			y = new LinkedList<Double>();
			for (int i =0;i<points.size();i++)
			{
				x.add(points.get(i).getX());
				y.add(points.get(i).getY());
			}
		}
		return x.isEmpty()&&y.isEmpty();
	}

	@Override
	public LinkedList<Double> getZ() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
