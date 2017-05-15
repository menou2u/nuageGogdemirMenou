package view.panels;

import java.awt.CardLayout;
import java.awt.Color;
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
	
	public CoordAndVertexConstraintPanel(Constraints c){
		super(new GridLayout(1,2));
		
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
		
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 1)));

        vertexChoice.add(vertexIJ,"Vij");
        vertexChoice.add(vertexKI,"Vki");
        vertexChoice.add(vertexJK,"Vjk");
        
        addCustomListener(vertexIJ);   
        addCustomListener(vertexKI);
        addCustomListener(vertexJK);
        
        this.add(vertexChoice);
        this.add(vertexDatas);
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
		
		xij = new JTextField();
		yij = new JTextField();
		zij = new JTextField();
		xijLab = new JLabel("Xw1 brut = ");
		yijLab = new JLabel("Yw1 brut = ");
		zijLab = new JLabel("Zw1 brut = ");
		
		xki = new JTextField();
		yki = new JTextField();
		zki = new JTextField();
		xkiLab = new JLabel("Xw1 brut = ");
		ykiLab = new JLabel("Yw1 brut = ");
		zkiLab = new JLabel("Zw1 brut = ");
		
		xjk = new JTextField();
		yjk = new JTextField();
		zjk = new JTextField();
		xjkLab = new JLabel("Xw1 brut = ");
		yjkLab = new JLabel("Yw1 brut = ");
		zjkLab = new JLabel("Zw1 brut = ");
		
		vertexVij = new JPanel(new GridLayout(3,4));
		
		vertexVXIJ = new JTextField();
		vertexVYIJ = new JTextField();
		
		vertexVij.add(xijLab);
		vertexVij.add(xij);
		
		vertexVij.add(new JLabel("Vxij = "));
		vertexVij.add(vertexVXIJ);
		
		vertexVij.add(yijLab);
		vertexVij.add(yij);
		
		vertexVij.add(new JLabel("Vyij = "));
		vertexVij.add(vertexVYIJ);
		
		vertexVij.add(zijLab);
		vertexVij.add(zij);
		
		vertexDatas.add(vertexVij,"Vij");
		
		
		vertexVki = new JPanel(new GridLayout(3,4));
		
		vertexVXKI = new JTextField();
		vertexVYKI = new JTextField();
		
		vertexVki.add(xkiLab);
		vertexVki.add(xki);
		
		vertexVki.add(new JLabel("Vxki = "));
		vertexVki.add(vertexVXKI);
		
		vertexVki.add(ykiLab);
		vertexVki.add(yki);
		
		vertexVki.add(new JLabel("Vyki = "));
		vertexVki.add(vertexVYKI);

		vertexVki.add(zkiLab);
		vertexVki.add(zki);
		
		vertexDatas.add(vertexVki,"Vki");
		
		vertexVjk = new JPanel(new GridLayout(3,4));
		
		vertexVXJK = new JTextField();
		vertexVYJK = new JTextField();

		vertexVjk.add(xjkLab);
		vertexVjk.add(xjk);
		
		vertexVjk.add(new JLabel("Vxjk = "));
		vertexVjk.add(vertexVXJK);
		
		vertexVjk.add(yjkLab);
		vertexVjk.add(yjk);
		
		vertexVjk.add(new JLabel("Vyjk = "));
		vertexVjk.add(vertexVYJK);

		vertexVjk.add(zjkLab);
		vertexVjk.add(zjk);
		
		vertexDatas.add(vertexVjk,"Vjk");
	}
	
    public static void main(String[] args) {
        JFrame frame = new JFrame("ConstraintsPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Constraints c = new Constraints();
        CoordAndVertexConstraintPanel newContentPane = new CoordAndVertexConstraintPanel(c);
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
}
