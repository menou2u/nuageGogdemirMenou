package model.swing;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Table2DConstraintCustomModel extends AbstractTableModel{

	private final LinkedList<Constraint2D> constraints = new LinkedList<Constraint2D>();
	private final String[] entetes;
	private LinkedList<Double> xw;
	private LinkedList<Double> constraintValue;
	private LinkedList<Double> derivationOrder;
	private MainWindow mainWin;
	
	public Table2DConstraintCustomModel(MainWindow mainWindow,String fileName, String[] entetes) {
		// TODO Auto-generated constructor stub
		super();
		mainWin=mainWindow;
		this.entetes=entetes;
		fillConstraints(fileName);
	}
	
	public Table2DConstraintCustomModel(String[] entetes){
		super();
		this.entetes = entetes;
		LinkedList<Double> constraint = new LinkedList<Double>();
		constraint.add(1.0);
		constraint.add(0.0);
		constraint.add(0.0);
		constraint.add(0.0);
		constraints.add(new Constraint2D(constraint));
	}
	
	public void setTable(Table2DConstraintCustomModel table){
		xw = table.getXw();
		constraintValue = table.getConstraintValue();
		derivationOrder = table.getDerivationOrder();
		constraints.clear();
		for (int i=0;i<xw.size();i++)
		{
			constraints.add(new Constraint2D(i+0.0,xw.get(i),constraintValue.get(i),derivationOrder.get(i)));
		}
	}
	
	public void warnView(MainWindow mainWindow, File file)
	{
		setTable(mainWindow,file.getPath());
	}
	
	//Weird ça non?
	public void setTable(MainWindow mainWindow,String fileName){
		setTable(new Table2DConstraintCustomModel(mainWindow,fileName,entetes));
		fireTableChanged(new TableModelEvent(this));
	}
	
	public void fillConstraints(String fileName){
		LinkedList<Double> constraint = new LinkedList<Double>();
		Constraints2DFactory fact = null;
		try{
			fact = new Constraints2DFactory(fileName);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		xw = fact.getXw();
		constraintValue = fact.getConstraintValue();
		derivationOrder = fact.getDerivationOrder();
		for (int i=0;i<xw.size();i++){
			constraint.add(i+1.0);
			constraint.add((Double)xw.get(i));
			constraint.add((Double)constraintValue.get(i));
			constraint.add((Double)derivationOrder.get(i));
			constraints.add(new Constraint2D(constraint));
			constraint = new LinkedList<Double>();
		}
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return constraints.size();
	}
	
	public LinkedList<Double> getConstraintValue(){
		return constraintValue;
	}
	
	public LinkedList<Double> getDerivationOrder(){
		return derivationOrder;
	}
	
	public LinkedList<Double> getXw(){
		return xw;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return entetes.length;
	}

	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}
	
	public void addConstraint(Constraint2D constraint){
		constraints.add(constraint);
		fireTableRowsInserted(constraints.size()-1,constraints.size()-1);
	}
	
	public void removeConstraint(int rowIndex){
		constraints.remove(rowIndex);
		fireTableRowsDeleted(rowIndex,rowIndex);
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return false;
		}
		return true;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return rowIndex+1;
		case 1:
			return constraints.get(rowIndex).getXw();
		case 2:
			return constraints.get(rowIndex).getConstraintValue();
		case 3:
			return constraints.get(rowIndex).getDerivationOrder();
		default:
			return null; // Ne devrait jamais arriver
		}
	}
	
	public LinkedList<Double> getColumn(int i){
		switch (i) {
		case 1:
			return xw;
		case 2:
			return constraintValue;
		case 3:
			return derivationOrder;
		default:
			return null;
		}
	}
	
    public void setValueAt(Object val, int rowIndex, int columnIndex){
    	if (!isCellEditable(rowIndex,columnIndex))
    	{
    		return;
    	}
    	if (val != null){
    		Constraint2D constraint = constraints.get(rowIndex);
    		switch (columnIndex) {
    		case 1:
    			constraint.setXw((Double)val);
    		case 2:
    			constraint.setConstraintValue((Double)val);
    		case 3:
    			constraint.setDerivationOrder((Double)val);
    		default:
    			break;
			}
    	}
    }
    
    public Class getColumnClass(int columnIndex){
    	return Double.class;
    }
    
    public LinkedList<Constraint2D> getConstraints(){
    	return constraints;
    }
    
    public String[] getEntetes(){
    	return entetes;
    }
    
    public boolean isEmpty(){
    	return xw.isEmpty()&&constraintValue.isEmpty()&&derivationOrder.isEmpty();
    }
	
}
