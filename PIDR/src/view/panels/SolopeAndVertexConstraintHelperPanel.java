package view.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.swing.SlopeAndVertexConstraintHelper;

@SuppressWarnings("serial")
public class SolopeAndVertexConstraintHelperPanel extends JPanel{
	
	@SuppressWarnings("static-access")
	public SolopeAndVertexConstraintHelperPanel(SlopeAndVertexConstraintHelper slopeAndVertexConstraintHelper)
	{
		super(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = gbc.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		add(slopeAndVertexConstraintHelper.getV1xLab(),gbc);
		gbc.gridx=1;
		add(slopeAndVertexConstraintHelper.getV1x(),gbc);
		
		gbc.gridx=2;
		add(slopeAndVertexConstraintHelper.getV2xLab(),gbc);
		gbc.gridx=3;
		add(slopeAndVertexConstraintHelper.getV2x(),gbc);
		
		gbc.gridy=1;
		gbc.gridx=0;
		add(slopeAndVertexConstraintHelper.getV1yLab(),gbc);
		gbc.gridx=1;
		add(slopeAndVertexConstraintHelper.getV1y(),gbc);
		
		gbc.gridx=2;
		add(slopeAndVertexConstraintHelper.getV2yLab(),gbc);
		gbc.gridx=3;
		add(slopeAndVertexConstraintHelper.getV2y(),gbc);

	}

    public static void main(String[] args) {
        JFrame frame = new JFrame("ConstraintsPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SlopeAndVertexConstraintHelper s = new SlopeAndVertexConstraintHelper("ij", "ij");
        SolopeAndVertexConstraintHelperPanel newContentPane = new SolopeAndVertexConstraintHelperPanel(s);
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
	
}
