package view.panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.swing.Constraints;

@SuppressWarnings("serial")
public class CoordAndVertexConstraintPanel extends JPanel{

	private ButtonGroup bG;
	private ButtonModel bm;
	
	private JRadioButton vertexIJ;
	private JRadioButton vertexKI;
	private JRadioButton vertexJK;
	
	private JPanel vertexChoice;
	private JPanel vertexDatas;
	
	private JPanel vertexVij;
	private JPanel vertexVki;
	private JPanel vertexVjk;
	
	private JTextField vertexVXIJ;
	private JTextField vertexVYIJ;
	
	private JTextField vertexVXKI;
	private JTextField vertexVYKI;

	private JTextField vertexVXJK;
	private JTextField vertexVYJK;
	
	private CardLayout cl;
	private JTextField xij;
	private JTextField yij;
	private JTextField zij;
	private JLabel xijLab;
	private JLabel yijLab;
	private JLabel zijLab;
	private JTextField xki;
	private JTextField yki;
	private JTextField zki;
	private JLabel xkiLab;
	private JLabel ykiLab;
	private JLabel zkiLab;
	private JTextField xjk;
	private JTextField yjk;
	private JTextField zjk;
	private JLabel xjkLab;
	private JLabel yjkLab;
	private JLabel zjkLab;
	
	public CoordAndVertexConstraintPanel(){
		super(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		cl = new CardLayout();
		
		vertexChoice = new JPanel(new GridLayout(3,1));
		vertexDatas = new JPanel(cl);
		
		initPanelDatas();
		
		vertexIJ = new JRadioButton("Vecteur Vij (xoy)");
		vertexKI = new JRadioButton("Vecteur Vki (zox)");
		vertexJK = new JRadioButton("Vecteur Vjk (yoz)");
		
		bG = new ButtonGroup();
		
		bG.add(vertexIJ);
		bG.add(vertexKI);
		bG.add(vertexJK);
		
		vertexIJ.setSelected(true);
		
		bm = bG.getSelection();
		

        vertexChoice.add(vertexIJ,"Vij");
        vertexChoice.add(vertexKI,"Vki");
        vertexChoice.add(vertexJK,"Vjk");
        
        addCustomListener(vertexIJ);   
        addCustomListener(vertexKI);
        addCustomListener(vertexJK);
        
        
        
        this.add(vertexChoice,gbc);
        gbc.gridx=1;
        gbc.weightx=1;
        this.add(vertexDatas,gbc);
	}

	private void addCustomListener(JRadioButton bouton) {
		bouton.addMouseListener(new MouseAdapter(){
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		super.mouseClicked(e);
        		if (!bm.equals(bG.getSelection())){
        			bm = bG.getSelection();
        			if (bm.equals(vertexIJ.getModel()))
        			{
        				cl.show(vertexDatas,"Vij");
        			}
        			if (bm.equals(vertexKI.getModel())){
        				cl.show(vertexDatas, "Vki");
        			}
        			if (bm.equals(vertexJK.getModel())){
        				cl.show(vertexDatas,"Vjk");
        			}
        		}

        	}
        });
	}

	private void initPanelDatas() {
		
		xij = new JTextField(8);
		yij = new JTextField(8);
		zij = new JTextField(8);
		xijLab = new JLabel("Xw1 brut = ");
		yijLab = new JLabel("Yw1 brut = ");
		zijLab = new JLabel("Zw1 brut = ");
		
		xki = new JTextField(8);
		yki = new JTextField(8);
		zki = new JTextField(8);
		xkiLab = new JLabel("Xw1 brut = ");
		ykiLab = new JLabel("Yw1 brut = ");
		zkiLab = new JLabel("Zw1 brut = ");
		
		xjk = new JTextField(8);
		yjk = new JTextField(8);
		zjk = new JTextField(8);
		xjkLab = new JLabel("Xw1 brut = ");
		yjkLab = new JLabel("Yw1 brut = ");
		zjkLab = new JLabel("Zw1 brut = ");
		
		vertexVij = new JPanel(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		vertexVXIJ = new JTextField(8);
		vertexVYIJ = new JTextField(8);
		
		vertexVij.add(xijLab,gbc);
		gbc.gridx=1;
		vertexVij.add(xij,gbc);
		
		gbc.gridx=2;
		vertexVij.add(new JLabel("Vxij = "),gbc);
		gbc.gridx=3;
		vertexVij.add(vertexVXIJ,gbc);
		
		gbc.gridy=1;
		gbc.gridx=0;
		vertexVij.add(yijLab,gbc);
		gbc.gridx=1;
		vertexVij.add(yij,gbc);
		
		gbc.gridx=2;
		vertexVij.add(new JLabel("Vyij = "),gbc);
		gbc.gridx=3;
		vertexVij.add(vertexVYIJ,gbc);
		
		gbc.gridy=2;
		gbc.gridx=0;
		vertexVij.add(zijLab,gbc);
		gbc.gridx=1;
		vertexVij.add(zij,gbc);
		
		vertexDatas.add(vertexVij,"Vij");
		
		
		vertexVki = new JPanel(new GridBagLayout());
		
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		vertexVXKI = new JTextField(8);
		vertexVYKI = new JTextField(8);
		
		vertexVki.add(xkiLab,gbc);
		gbc.gridx=1;
		vertexVki.add(xki,gbc);
		
		gbc.gridx=2;
		vertexVki.add(new JLabel("Vxki = "),gbc);
		gbc.gridx=3;
		vertexVki.add(vertexVXKI,gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		vertexVki.add(ykiLab,gbc);
		gbc.gridx=1;
		vertexVki.add(yki,gbc);
		
		gbc.gridx=2;
		vertexVki.add(new JLabel("Vyki = "),gbc);
		gbc.gridx=3;
		vertexVki.add(vertexVYKI,gbc);

		gbc.gridy=2;
		gbc.gridx=0;
		vertexVki.add(zkiLab,gbc);
		gbc.gridx=1;
		vertexVki.add(zki,gbc);
		
		vertexDatas.add(vertexVki,"Vki");
		
		vertexVjk = new JPanel(new GridBagLayout());
		
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		vertexVXJK = new JTextField(8);
		vertexVYJK = new JTextField(8);

		vertexVjk.add(xjkLab,gbc);
		gbc.gridx=1;
		vertexVjk.add(xjk,gbc);
		
		gbc.gridx=2;
		vertexVjk.add(new JLabel("Vxjk = "),gbc);
		gbc.gridx=3;
		vertexVjk.add(vertexVXJK,gbc);
		
		gbc.gridy=1;
		gbc.gridx=0;
		vertexVjk.add(yjkLab,gbc);
		gbc.gridx=1;
		vertexVjk.add(yjk,gbc);
		
		gbc.gridx=2;
		vertexVjk.add(new JLabel("Vyjk = "),gbc);
		gbc.gridx=3;
		vertexVjk.add(vertexVYJK,gbc);

		gbc.gridy=2;
		gbc.gridx=0;
		vertexVjk.add(zjkLab,gbc);
		gbc.gridx=1;
		vertexVjk.add(zjk,gbc);
		
		vertexDatas.add(vertexVjk,"Vjk");
	}
	
    public static void main(String[] args) {
        JFrame frame = new JFrame("ConstraintsPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        @SuppressWarnings("unused")
		Constraints c = new Constraints();
        CoordAndVertexConstraintPanel newContentPane = new CoordAndVertexConstraintPanel();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
}
