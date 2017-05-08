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
	private final JTable table;
	private String[] columnNames;
	private JScrollPane scrollPane;
	String path = "home/miron/Bureau/comparatif telephones.xlsx";
	
	public Data(){
		
		data = new Object[1][2];
        data[0][0] = "xi";
        data[0][1] = "yi";
        
        columnNames = new String[]{"xi","yi"};

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
	
	public void fillDatas(LinkedList list)
	{
		Datas2DFactory d2DF = null;
		try {
			d2DF = new Datas2DFactory(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int n = 0;
		for (Double d : d2DF.getX())
		{
			data[n][0]=d;
		}
		n=0;
		for (Double d : d2DF.getY())
		{
			data[n][1]=d;
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
	
	
	
}
