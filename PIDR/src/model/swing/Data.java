package model.swing;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Observable;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;

import controller.Datas2DFactory;
import controller.Datas3DFactory;

public class Data extends Observable {

	private Object[][] data;
	private JTable table;
	private String[] columnNames;
	private JScrollPane scrollPane;
	private LinkedList<Double> x = new LinkedList<Double>();
	private LinkedList<Double> y = new LinkedList<Double>();
	private LinkedList<Double> z = new LinkedList<Double>();
	private String path;
	private int length1;
	private int length2;
	private int nbDim;
	private String sortedBy;
	
	public Data(String col1,String col2,String col3, String col4){
		columnNames = new String[]{col1,col2,col3,col4};
		data = new Object[Math.max(1,Math.max(x.size(),Math.max(y.size(),z.size())))][4];
		nbDim = 3;
        initTable();
	}
	
	public Data(String col1,String col2,String col3){
		columnNames = new String[]{col1,col2,col3};
		data = new Object[Math.max(1,Math.max(x.size(),y.size()))][3];
		nbDim = 2;
        initTable();
	}
	
	public Data(String col1,String col2){
		columnNames = new String[]{col1,col2};
		data = new Object[Math.max(1,Math.max(x.size(),y.size()))][2];
		nbDim = 2;
		initTable();
	}
	
	public void updateTableContent(String path){
		this.path = path;
		//TODO : Choisir le type d'initialisation suivant le panneau utilisé
		if (nbDim ==2)
		{
			init2DData();
		}
		else
		{
			init3DData();
		}
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
        //A voir a quoi ca sert, sinon creer un MouseListener particulier
        scrollPane.addMouseListener(new MouseAdapter(){

        });
        scrollPane.setColumnHeader(new JViewport());
        scrollPane.getColumnHeader().addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent event)
        	{
        		if (event.getClickCount() == 2) {
        			//getDataObject().sort();
        	  }
        	}
        });
	}
	
	/*public void sort(ColumnHeader cH){
		data.sort();
	}*/
	
	/**
	 * Remplir un objet data[][] avec des données dans des linkedlist x et y
	 */
	public void init2DData()
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
	
	/**
	 * Remplir un objet data[][] avec des données dans des linkedlist x,y et z
	 */
	public void init3DData()
	{
		fillDatas();
		data = new Object[Math.max(z.size(),Math.max(x.size(),y.size()))][4];
		for (int i=0;i<x.size();i++){
			data[i][0] = i;
			data[i][1] = x.get(i);
		}
		for (int j=0;j<y.size();j++)
		{
			data[j][2] = y.get(j);
		}
		for (int k=0;k<z.size();k++)
		{
			data[k][3] = z.get(k);
		}
	}
	
	public void updateTable(){
		DefaultTableModel defaultTableModel = new DefaultTableModel(data, columnNames);
		table.setModel(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
	}

	public void setData(Object[][] datas)
    {
    	length2 = datas[0].length;
    	length1 = datas.length;
    	this.data = new Object[length1][length2];
    	for (int i = 0; i<length1; i++)
    	{
    		for (int j = 0; j<length2; i++)
    		{
    			data[i][j] = datas[i][j];
    		}
    	}
    }
	
	public Data getDataObject(){
		return this;
	}
	
	public void fillDatas()
	{
		Datas2DFactory d2DF = null;
		Datas3DFactory d3DF = null;
		try {
			if(nbDim==2){
				d2DF = new Datas2DFactory(path);
			}
			else{
				d3DF = new Datas3DFactory(path);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(nbDim==2){
			x = d2DF.getX();
			y = d2DF.getY();
		}
		else
		{
			x=d3DF.getX();
			y=d3DF.getY();
			z=d3DF.getZ();
		}
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
	
}

