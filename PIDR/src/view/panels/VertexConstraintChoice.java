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
public class VertexConstraintChoice extends JPanel{
	
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
	private JTextField vertexIJSlope;
	
	private JTextField vertexVXKI;
	private JTextField vertexVYKI;
	private JTextField vertexKISlope;

	private JTextField vertexVXJK;
	private JTextField vertexVYJK;
	private JTextField vertexJKSlope;
	
	private CardLayout cl;
	
	public VertexConstraintChoice(Constraints c){
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
	
	public void initPanelDatas(){
		vertexVij = new JPanel(new GridLayout(3,2));
		
		vertexVXIJ = new JTextField();
		vertexVYIJ = new JTextField();
		vertexIJSlope = new JTextField();
		
		vertexVij.add(new JLabel("Vxij : "));
		vertexVij.add(vertexVXIJ);
		vertexVij.add(new JLabel("Vyij : "));
		vertexVij.add(vertexVYIJ);
		vertexVij.add(new JLabel("Pente : "));
		vertexVij.add(vertexIJSlope);
		
		vertexDatas.add(vertexVij,"Vij");
		
		vertexVki = new JPanel(new GridLayout(3,2));
		
		vertexVXKI = new JTextField();
		vertexVYKI = new JTextField();
		vertexKISlope = new JTextField();
		
		vertexVki.add(new JLabel("Vxki : "));
		vertexVki.add(vertexVXKI);
		vertexVki.add(new JLabel("Vyki : "));
		vertexVki.add(vertexVYKI);
		vertexVki.add(new JLabel("Pente : "));
		vertexVki.add(vertexKISlope);
		
		vertexDatas.add(vertexVki,"Vki");
		
		vertexVjk = new JPanel(new GridLayout(3,2));
		
		vertexVXJK = new JTextField();
		vertexVYJK = new JTextField();
		vertexJKSlope = new JTextField();
		
		vertexVjk.add(new JLabel("Vxjk : "));
		vertexVjk.add(vertexVXJK);
		vertexVjk.add(new JLabel("Vyjk : "));
		vertexVjk.add(vertexVYJK);
		vertexVjk.add(new JLabel("Pente : "));
		vertexVjk.add(vertexJKSlope);
		
		vertexDatas.add(vertexVjk,"Vjk");
	}
	
	public void addCustomListener(JRadioButton bouton){
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
	
    public static void main(String[] args) {
        JFrame frame = new JFrame("ConstraintsPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Constraints c = new Constraints();
        VertexConstraintChoice newContentPane = new VertexConstraintChoice(c);
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }
}
