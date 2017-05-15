package view.panels;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.swing.Constraints;

@SuppressWarnings("serial")
public class SlopeAndVertexConstraintPanelHelper extends JPanel{
	
	private JTextField v1x;
	private JTextField v1y;
	private JTextField v2x;
	private JTextField v2y;
	
	private JLabel v1xLab;
	private JLabel v1yLab;
	private JLabel v2xLab;
	private JLabel v2yLab;
	
	public SlopeAndVertexConstraintPanelHelper(String axev1,String axev2)
	{
		super(new GridLayout(2,4));
		
		initField(axev1,axev2);
		fillWithFields();
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1)));

	}

	private void fillWithFields() {
		add(v1xLab);
		add(v1x);
		add(v2xLab);
		add(v2x);
		add(v1yLab);
		add(v1y);
		add(v2yLab);
		add(v2y);
	}

	private void initField(String axev1,String axev2) {
		v1x = new JTextField();
		v2x = new JTextField();
		v1y = new JTextField();
		v2y = new JTextField();
		
		v1xLab = new JLabel("V1x"+axev1+" = ");
		v1yLab = new JLabel("V1y"+axev1+" = ");
		v2xLab = new JLabel("V2x"+axev2+" = ");
		v2yLab = new JLabel("V2y"+axev2+" = ");
	}

    public static void main(String[] args) {
        JFrame frame = new JFrame("ConstraintsPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Constraints c = new Constraints();
        SlopeAndVertexConstraintPanelHelper newContentPane = new SlopeAndVertexConstraintPanelHelper("ij","ij");
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
	
}
