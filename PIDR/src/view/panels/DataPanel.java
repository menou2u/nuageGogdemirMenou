package view.panels;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.swing.Data;

@SuppressWarnings("serial")
public class DataPanel extends JPanel {
    

    public DataPanel(Data d) {
        super(new GridLayout(1,2));

        //Add the scroll pane to this panel.
        add(d.getScrollPane());
        //int colSize = d.getData().length;
        //int rowSize = d.getData()[0].length;
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1)));
    }

    public DataPanel(Data d, Data transformedData)
    {
    	super(new GridLayout(1,2));
    	
    	add(d.getScrollPane());
    	add(transformedData.getScrollPane());
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1)));
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("DataPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Data d = new Data("n°","xi","yi");
        DataPanel newContentPane = new DataPanel(d);
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
}
