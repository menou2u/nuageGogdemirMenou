package panels;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


//Ajouter un bouton pour ajouter des contraintes :)
public class ConstraintsPanel extends JPanel {
    private Object[][] data;

    public ConstraintsPanel() {
        super(new GridLayout(1,0));

        String[] columnNames = {"N°","xi","yi"};
        
        data = new Object[1][3];
       
        data[0][0] = 0;
        data[0][1] = "xi";
        data[0][2] = "yi";

        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        
        table.addMouseListener(new MouseListener(){

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

        //Add the scroll pane to this panel.
        add(scrollPane);
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
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("ConstraintsPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ConstraintsPanel newContentPane = new ConstraintsPanel();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
}
