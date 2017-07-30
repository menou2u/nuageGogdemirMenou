package model.swing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.event.TableModelEvent;

import controller.Datas3DFactory;

@SuppressWarnings("serial")
public class TableCustom3DModel extends TableCustomModel {
	private final ArrayList<Point3D> points = new ArrayList<Point3D>();
	private final String[] entetes;
	private TableCustom3DModel transformedData;
	private LinkedList<Double> x ;
	private LinkedList<Double> y ;
	private LinkedList<Double> z ;
	private MainWindow mainWin;
	
	public TableCustom3DModel(MainWindow mainWindow,String fileName,String[] entetes) {
		super();
		mainWin = mainWindow;
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

	public void setTable(TableCustom3DModel table){
		x = table.getX();
		y = table.getY();
		z = table.getZ();
		points.clear();
		for (int i=0;i<x.size();i++)
		{
			points.add(new Point3D(i+0.0,x.get(i),y.get(i),z.get(i)));
		}
	}
	
	@Override
	public void warnView(MainWindow mainWindow,File file)
	{
		setTable(mainWindow,file.getPath());
		fireTableChanged(new TableModelEvent(this));
	}
	
	public void setTable(MainWindow mainWindow,String fileName){
		setTable(new TableCustom3DModel(mainWindow,fileName,entetes));
		fireTableChanged(new TableModelEvent(this));
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
		x = fact.getX();
		y = fact.getY();
		z = fact.getZ();
		for (int i=0;i<x.size();i++){
			point.add(i+1.0);
			point.add((Double)x.get(i));
			point.add((Double)y.get(i));
			point.add((Double)z.get(i));
			points.add(new Point3D(point));
			point = new LinkedList<Double>();
		}

	}
	
	public void removePoint(int begin, int end, int ratio)
	{
		int nbPointsToRemove = (end-begin)/ratio;
		int firstToRemove = begin + ratio*nbPointsToRemove;
		for (int i = 0; i<=nbPointsToRemove; i++)
		{
			removePoint(firstToRemove-(i*ratio));
		}
	}
	
	public int getRowCount() {
		return points.size();
	}

	public int getColumnCount() {
		return entetes.length;
	}
	
	public LinkedList<Double> getX(){
		 return x;
	}
	
	public LinkedList<Double> getY(){
		 return y;
	}
	
	public LinkedList<Double> getZ(){
		 return z;
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
    	fireTableCellUpdated(rowIndex,columnIndex);
    }
	
	@Override
	public Class getColumnClass(int columnIndex){
		return Double.class;
	}

	public Data toData() {
		Data d = new Data("n°","x","y","z");
		for (Point3D p : points)
		{
			d.getX().add(p.getX());
			d.getY().add(p.getY());
			d.getZ().add(p.getZ());
		}
		return d;
	}
	
	@Override
	public boolean isEmpty(){
		if (x == null || y == null || z==null){
			x = new LinkedList<Double>();
			y = new LinkedList<Double>();
			z = new LinkedList<Double>();
			for (int i =0;i<points.size();i++)
			{
				x.add(points.get(i).getX());
				y.add(points.get(i).getY());
				z.add(points.get(i).getZ());
			}
		}
		return x.isEmpty()&&y.isEmpty()&&z.isEmpty();
	}
	
}
