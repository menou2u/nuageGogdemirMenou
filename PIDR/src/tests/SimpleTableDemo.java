package tests;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SimpleTableDemo extends JPanel {
    private boolean DEBUG = false;

    public SimpleTableDemo() {
        super(new GridLayout(1,0));

        String[] columnNames = {"xi","yi"};

        Object[][] data = {
	    {"Kathy", "Smith",
	     "Snowboarding", new Integer(5)},
	    {"John", "Doe"},
	    {"Sue", "Black"},
	    {"Jane", "White"},
	    {"Joe", "Brown"}
        };

        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SimpleTableDemo newContentPane = new SimpleTableDemo();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
}
