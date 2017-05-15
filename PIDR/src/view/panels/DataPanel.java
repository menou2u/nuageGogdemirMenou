package view.panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    	super(new GridBagLayout());
    	GridBagConstraints gbc = new GridBagConstraints();
    	add(new JLabel("Données brutes"),gbc);
    	gbc.gridx=1;
    	add(new JLabel("Données transformées"),gbc);
    	gbc.gridx=0;
    	gbc.gridy=1;
    	gbc.weighty=1;
    	add(d.getScrollPane(),gbc);
    	gbc.gridx=1;
    	add(transformedData.getScrollPane(),gbc);
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1)));
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("DataPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Data d = new Data("n°","xi","yi");
        Data dtrans = new Data("xtrans","ytrans");
        DataPanel newContentPane = new DataPanel(d,dtrans);
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
}
