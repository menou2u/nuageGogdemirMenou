package model.swing;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Observable;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.Datas2DFactory;

public class Data extends Observable {

	private Object[][] data;
	private JTable table;
	private String[] columnNames;
	private JScrollPane scrollPane;
	private LinkedList<Double> x = new LinkedList<Double>();
	private LinkedList<Double> y = new LinkedList<Double>();
	private String path;
	
	public Data(){
		columnNames = new String[]{"xi","yi"};
		data = new Object[Math.max(x.size(),y.size())][2];
        initTable();
	}
	
	public void updateTableContent(String path){
		this.path = path;
		initData();
		initTable();
		setChanged();
		notifyObservers();
	}
	
	public void initTable(){
		table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        
        //Create the scroll pane and add the table to it.
        scrollPane = new JScrollPane(table);
        //A voir � quoi �a sert, sinon cr�er un MouseListener particulier
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
		data = new Object[Math.max(x.size(),y.size())][2];
		for (int i=0;i<x.size();i++){
			data[i][0] = x.get(i);
		}
		for (int j=0;j<y.size();j++)
		{
			data[j][1] = y.get(j);
		}
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
			// TODO Auto-generated catch block
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
	
	public static void main(String[] args){
		Data test = new Data();
		System.out.println(test.getData());
	}
	
}

