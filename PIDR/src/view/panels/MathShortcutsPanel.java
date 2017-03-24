package panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MathShortcutsPanel extends JPanel{

	private JButton sin;
	private JButton cos;
	private JButton tan;
	private JButton sinh;
	private JButton cosh;
	private JButton tanh;
	private JButton asin;
	private JButton acos;
	private JButton atan;
	private JButton asinh;
	private JButton acosh;
	private JButton atanh;
	private JButton abs;
	private JButton pi;
	private JButton pow;
	private JButton log10;
	private JButton ln;
	private JButton exp;
	private JButton fact;
	private JButton inv;
	private JButton sqrt;
	private JButton integ;
	
	public MathShortcutsPanel(){
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(gbl);
		
		gbc.fill = gbc.BOTH;
		gbc.insets = new Insets(1,1,1,1);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		sin = new JButton("sin");
		this.add(sin,gbc);
		
		gbc.gridx = 1;
		cos = new JButton("cos");
		this.add(cos,gbc);

		gbc.gridx = 2;
		tan = new JButton("tan");
		this.add(tan,gbc);
		
		gbc.gridx = 3;
		sinh = new JButton("sinh");
		this.add(sinh,gbc);
		
		gbc.gridx = 4;
		cosh = new JButton("cosh");
		this.add(cosh,gbc);
		
		gbc.gridx = 5;
		tanh = new JButton("tanh");
		this.add(tanh,gbc);
		
		gbc.gridy = 1;
		gbc.gridx = 0;
		asin = new JButton("asin");
		this.add(asin,gbc);
		
		gbc.gridx = 1;
		acos = new JButton("acos");
		this.add(acos,gbc);
		
		gbc.gridx = 2;
		atan = new JButton("atan");
		this.add(atan,gbc);
		
		gbc.gridx = 3;
		asinh = new JButton("asinh");
		this.add(asinh,gbc);
		
		gbc.gridx = 4;
		acosh = new JButton("acosh");
		this.add(acosh,gbc);
		
		gbc.gridx = 5;
		atanh = new JButton("atanh");
		this.add(atanh,gbc);
		
		gbc.gridy = 2;
		gbc.gridx = 0;
		abs = new JButton("abs");
		this.add(abs,gbc);
		
		gbc.gridx = 1;
		pi = new JButton("pi");
		this.add(pi,gbc);
		
		gbc.gridx = 2;
		pow = new JButton("^");
		this.add(pow,gbc);
		
		gbc.gridx = 3;
		log10 = new JButton("log10");
		this.add(log10,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		ln = new JButton("ln");
		this.add(ln,gbc);
		
		gbc.gridx = 1;
		exp = new JButton("exp");
		this.add(exp,gbc);
		
		gbc.gridx = 2;
		fact = new JButton("!");
		this.add(fact,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		inv = new JButton("1/x");
		this.add(inv,gbc);
		
		gbc.gridx = 1;
		sqrt = new JButton("sqrt");
		this.add(sqrt,gbc);
		
		gbc.gridx = 2;
		integ = new JButton("Ent.");
		this.add(integ,gbc);
	}
	
	//main pour test
	public static void main(String[] args) {
		JFrame test = new JFrame();
		test.setSize(300, 500);
		MathShortcutsPanel paneltest = new MathShortcutsPanel();
		test.add(paneltest,null);
		test.setVisible(true);
	}
}
