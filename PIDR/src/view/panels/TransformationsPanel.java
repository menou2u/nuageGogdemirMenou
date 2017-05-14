package pidr.view.panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.omg.CORBA.TypeCodeHolder;

import pidr.model.Constraints;

public class TransformationsPanel extends JPanel{

	public TransformationsPanel(Constraints c){
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		TransformXPanel xTrans = new TransformXPanel(new Constraints());
		TransformYPanel yTrans = new TransformYPanel(new Constraints());
		JButton validation = new JButton("Validation des données");
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridheight=1;
		gbc.gridwidth=1;
		this.setLayout(gbl);
		this.add(xTrans,gbc);
		
		gbc.gridy+=gbc.gridheight;
		this.add(yTrans,gbc);
		
		gbc.gridy=0;
		gbc.gridx=1;
		gbc.gridheight=2;
		this.add(validation,gbc);
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1)));
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Transforms");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Constraints c = new Constraints();
		TransformationsPanel newContentPane = new TransformationsPanel(c);
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.pack();
		frame.setVisible(true);
	}
	
}
