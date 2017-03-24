package view.panels;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Data;

@SuppressWarnings("serial")
public class DataPanel extends JPanel {
    

    public DataPanel(Data d) {
        super(new GridLayout(1,0));

        //Add the scroll pane to this panel.
        add(d.getScrollPane());
        
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1)));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DataPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Data d = new Data();
        DataPanel newContentPane = new DataPanel(d);
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
}
