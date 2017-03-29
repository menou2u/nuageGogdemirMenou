package pidr.model;

import java.awt.Dimension;
import java.util.Observable;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Constraints extends Observable {

	private Object[][] data;
	private String[] columnNames;
	private final JTable table;
	private JScrollPane scrollPane;

	public Constraints(){
		data = new Object[1][3];

		columnNames = new String[]{"N°","xi","yi"};
		
        table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        
        //Create the scroll pane and add the table to it.
        scrollPane = new JScrollPane(table);
	}
	

	public String[] getColumnNames() {
		return columnNames;
	}


	public JTable getTable() {
		return table;
	}


	public JScrollPane getScrollPane() {
		return scrollPane;
	}


	public Object[][] getData() {
		return data;
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
    
    public void setData(Object dat, int i, int j)
    {
    	data[i][j] = dat;
    }
}
