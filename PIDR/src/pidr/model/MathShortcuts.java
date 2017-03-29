package pidr.model;

import java.util.Observable;

import javax.swing.JButton;

public class MathShortcuts extends Observable {

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
	
	public MathShortcuts(){
	
		sin = new JButton("sin");
		
		cos = new JButton("cos");
		
		tan = new JButton("tan");
		
		sinh = new JButton("sinh");
		
		cosh = new JButton("cosh");
		
		tanh = new JButton("tanh");
		
		asin = new JButton("asin");
		
		acos = new JButton("acos");
		
		atan = new JButton("atan");
		
		asinh = new JButton("asinh");
		
		acosh = new JButton("acosh");
		
		atanh = new JButton("atanh");
		
		abs = new JButton("abs");
		
		pi = new JButton("pi");
		
		pow = new JButton("^");
		
		log10 = new JButton("log10");
		
		ln = new JButton("ln");
		
		exp = new JButton("exp");
		
		fact = new JButton("!");
		
		inv = new JButton("1/x");
		
		sqrt = new JButton("sqrt");
		
		integ = new JButton("Ent.");
	}

	public JButton getSin() {
		return sin;
	}

	public JButton getCos() {
		return cos;
	}

	public JButton getTan() {
		return tan;
	}

	public JButton getSinh() {
		return sinh;
	}

	public JButton getCosh() {
		return cosh;
	}

	public JButton getTanh() {
		return tanh;
	}

	public JButton getAsin() {
		return asin;
	}

	public JButton getAcos() {
		return acos;
	}

	public JButton getAtan() {
		return atan;
	}

	public JButton getAsinh() {
		return asinh;
	}

	public JButton getAcosh() {
		return acosh;
	}

	public JButton getAtanh() {
		return atanh;
	}

	public JButton getAbs() {
		return abs;
	}

	public JButton getPi() {
		return pi;
	}

	public JButton getPow() {
		return pow;
	}

	public JButton getLog10() {
		return log10;
	}

	public JButton getLn() {
		return ln;
	}

	public JButton getExp() {
		return exp;
	}

	public JButton getFact() {
		return fact;
	}

	public JButton getInv() {
		return inv;
	}

	public JButton getSqrt() {
		return sqrt;
	}

	public JButton getInteg() {
		return integ;
	}
	
	
	
}
