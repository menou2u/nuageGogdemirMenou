package model.swing;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Observable;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Datas2DFactory;

public class Data extends Observable {

	private Object[][] data;
	private JTable table;
	private String[] columnNames;
	private JScrollPane scrollPane;
	private LinkedList<Double> x = new LinkedList<Double>();
	private LinkedList<Double> y = new LinkedList<Double>();
	private LinkedList<Double> z = new LinkedList<Double>();
	private String path;
	
	public Data(String col1,String col2,String col3, String col4){
		columnNames = new String[]{col1,col2,col3,col4};
		data = new Object[Math.max(1,Math.max(x.size(),Math.max(y.size(),z.size())))][4];
        initTable();
	}
	
	public Data(String col1,String col2,String col3){
		columnNames = new String[]{col1,col2,col3};
		data = new Object[Math.max(1,Math.max(x.size(),y.size()))][3];
        initTable();
	}
	
	public Data(String col1,String col2){
		columnNames = new String[]{col1,col2};
		data = new Object[Math.max(1,Math.max(x.size(),y.size()))][2];
		initTable();
	}
	
	public void updateTableContent(String path){
		this.path = path;
		initData();
		updateTable();
		setChanged();
		notifyObservers();
	}
	
	public void initTable(){
		table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        
        //Create the scroll pane and add the table to it.
        scrollPane = new JScrollPane(table);
        //A voir ï¿½ quoi ï¿½a sert, sinon crï¿½er un MouseListener particulier
        scrollPane.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
	}
	
	public void initData()
	{
		fillDatas();
		data = new Object[Math.max(x.size(),y.size())][3];
		for (int i=0;i<x.size();i++){
			data[i][0] = i;
			data[i][1] = x.get(i);
		}
		for (int j=0;j<y.size();j++)
		{
			data[j][2] = y.get(j);
		}
	}
	
	public void updateTable(){
		// = new JTable(data, columnNames);
		DefaultTableModel defaultTableModel = new DefaultTableModel(data, columnNames);
		table.setModel(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
	}

	/**
	 * @return the x
	 */
	public LinkedList<Double> getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public LinkedList<Double> getY() {
		return y;
	}
	
	/**
	 * @return the z
	 */
	public LinkedList<Double> getZ() {
		return z;
	}

	public void setData(Object[][] datas)
    {
    	int length2 = datas[0].length;
    	int length1 = datas.length;
    	this.data = new Object[length1][length2];
    	for (int i = 0; i<length1; i++)
    	{
    		for (int j = 0; j<length2; i++)
    		{
    			data[i][j] = datas[i][j];
    		}
    	}
    }
	
	public void fillDatas()
	{
		Datas2DFactory d2DF = null;
		try {
			d2DF = new Datas2DFactory(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		x = d2DF.getX();
		y = d2DF.getY();
	}
    
    public void setData(Object dat, int i, int j)
    {
    	data[i][j] = dat;
    }

	public Object[][] getData() {
		return data;
	}

	public JTable getTable() {
		return table;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	public static void main(String[] args){
		Data test = new Data("n°","xi","yi");
		System.out.println(test.getData().toString());
	}

	public void warnView(File file) {
		updateTableContent(file.getPath());
		setChanged();
		notifyObservers();
	}
	
}

