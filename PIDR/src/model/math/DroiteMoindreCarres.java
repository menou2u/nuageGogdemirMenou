package model.math;

import java.util.LinkedList;

import javagiac.context;
import javagiac.gen;

public class DroiteMoindreCarres {

	private context c;
	private LinkedList<Double> listXi, listYi, listXxi, listYyi, longueurI;
	private int n;
	private double xMoyen, yMoyen, xOmega, yOmega, xmaxgraph, xmingraph, ymaxgraph, ymingraph,
					p1, p2, residuVerticalMoyen, residuOrthogonalMoyen, longueurDroite, longueurPolygone,
					facteurQualite, v1, v2, h1, h2, denominateur, alpha, teta, o1, o2, residuMoyenOrthoProjVertical,
					residuMoyenOrthoProjHorizontal, residuMoyenOrthoProjOrthogonal, residuCarreMoyenOrthoProjVertical,
					residuCarreMoyenOrthoProjHorizontal, residuCarreMoyenOrthoProjOrtho, residuCarreMoyenOrtho, 
					residuMoyenOrtho;
	private FonctionAffine f, fv, fh, fo, f1;
	private String conseil;
	
	//TODO ne pas oublier de l'appeler
	public void init(LinkedList<Double> listXi, LinkedList<Double> listYi, int commutateur, double xOmega, double yOmega, double p1){
		c = new context();
		xMoyen = getMoyenne(listXi);
		yMoyen = getMoyenne(listYi);
		n = listXi.size();
		switch (commutateur) {
		case 0: //pas de contraintes
			xOmega = xMoyen;
			yOmega = yMoyen;
			listXxi = listXi;
			concat(listXxi,xOmega);
			listYyi = listYi;
			concat(listYyi,yOmega);
			xmaxgraph = getMax(listXi);
			xmingraph = getMin(listXi);
			ymaxgraph = getMax(listYi);
			ymingraph = getMin(listYi);
			break;
		case 1: //contrainte sur coordonnées d'un point de la droite
			this.xOmega = xOmega;
			this.yOmega = yOmega;
			listXxi = listXi;
			concat(listXxi,xOmega);
			listYyi = listYi;
			concat(listYyi,yOmega);
			xmaxgraph = getMax(listXxi);
			xmingraph = getMin(listXxi);
			ymaxgraph = getMax(listYyi);
			ymingraph = getMin(listYyi);
			break;
		case 2: //contrainte sur la pente p de la droite
			xmaxgraph = getMax(listXi);
			xmingraph = getMin(listXi);
			ymaxgraph = getMax(listYi);
			ymingraph = getMin(listYi);
			this.p1 = p1;
			p2 = yMoyen-p1*xMoyen;
			f = new FonctionAffine("f", p1, "x", p2);
			residuVerticalMoyen = calculResiduVerticalMoyen();
			residuOrthogonalMoyen = residuVerticalMoyen*Math.cos(Math.atan(p1));
			longueurDroite = calculLongueurDroite();
			calculLongueurI();
			longueurPolygone = getSomme(longueurI);
			facteurQualite = longueurDroite/longueurPolygone;
			break;
		default:
			break;
		}
		
		v1 = calculV1();
		v2 = yOmega-v1*xOmega;
		h1 = calculH1();
		h2 = yOmega-h1*xOmega;
		
		denominateur = calculDenominateur();
				
		if (denominateur == 0) {
			System.out.println("Calculs de projection orthogonale impossibles");
		}
		else {
			alpha = 0.5*Math.atan((-2*(getMoyenne(produitTermeATerme(listXi, listYi)) - xOmega*yMoyen - yOmega*xMoyen + xOmega*yOmega))/denominateur);
			if (calculD1() <= calculD2()){
				teta = alpha;
			}
			else {
				teta = alpha+Math.PI/2;
			}
			o1 = -1/Math.tan(teta);
			o2 = yOmega-o1*xOmega;
		}
		fv = new FonctionAffine("fv", p1, "x", p2);
		fh = new FonctionAffine("fh", h1, "x", h2);
		fo = new FonctionAffine("fo", o1, "x", o2);
		residuMoyenOrthoProjVertical = calculResiduMoyenOrthoProj(fv);
		residuMoyenOrthoProjHorizontal = calculResiduMoyenOrthoProj(fh);
		residuMoyenOrthoProjOrthogonal = calculResiduMoyenOrthoProj(fo);
		residuCarreMoyenOrthoProjVertical = calculResiduCarreMoyenOrthoProj(fv);
		residuCarreMoyenOrthoProjHorizontal = calculResiduCarreMoyenOrthoProj(fh);
		residuCarreMoyenOrthoProjOrtho = calculResiduCarreMoyenOrthoProj(fo);
		residuCarreMoyenOrtho = Math.min(residuCarreMoyenOrthoProjVertical, Math.min(residuCarreMoyenOrthoProjHorizontal, residuCarreMoyenOrthoProjOrtho));
		residuMoyenOrtho = Math.min(residuMoyenOrthoProjVertical, Math.min(residuMoyenOrthoProjHorizontal, residuMoyenOrthoProjOrthogonal));
	}
	
	private void calculLongueurI(){
		longueurI = new LinkedList<Double>();
		for (int j=0; j<=n-2; j++){
			longueurI.set(j, Math.sqrt(Math.pow(listXi.get(j+1)-listXi.get(j), 2)+Math.pow(listYi.get(j+1)-listYi.get(j), 2)));
		}
	}
	
	public static void main(String[] args) throws Exception{
		try {
			System.out.println("Loading giac java interface");
		        //System.load("/usr/local/lib/libgiacjava.so");
		        System.loadLibrary("javagiac");
		    } catch (UnsatisfiedLinkError e) {
		      System.err.println("Native code library failed to load. See the chapter on Dynamic Linking Problems in the SWIG Java documentation for help.\n" + e);
		      System.exit(1);
		    }
	}
	
	private double calculDenominateur(){
		return getMoyenne(pow2ListElements(listYi)) - getMoyenne(pow2ListElements(listXi)) + Math.pow(yOmega, 2) - Math.pow(xOmega, 2) - 2*(yOmega*getMoyenne(listYi) - xOmega*getMoyenne(listXi));
	}

	//TODO ne pas oublier de l'appeler
	public void testConseil() {
		if (residuMoyenOrthoProjVertical == residuMoyenOrtho){
			conseil = "Choisir la droite de projection verticale : y=f(x)=v1*x+v2";
			f = fv;
		}
		if (residuMoyenOrthoProjHorizontal == residuMoyenOrtho){
			conseil = "Choisir la droite de projection horizontale : y=f(x)=h1*x+h2";
			f = fh;
		}
		if (residuMoyenOrthoProjOrthogonal == residuMoyenOrtho){
			conseil = "Choisir la droite de projection orthogonale : y=f(x)=o1*x+o2";
			f = fo;
		}
		f1 = new FonctionAffine("f1", 0.0, "x", new gen("diff("+f+",x,1)", c).DOUBLE_val()); 
		longueurDroite = new gen("approx(int(sqrt(1+("+f1+").^2),x,"+getMin(listXxi)+","+getMax(listXxi)+"))", c).DOUBLE_val(); //TODO quel est le but de conseil ? car ici on modifie une variable
		calculLongueurI();
		longueurPolygone = getSomme(longueurI);
	}
	
	
	private double calculD1(){
		double res = 0.0;
		for (int i=0; i<listXi.size(); i++){
			res = res + Math.pow((listXi.get(i) - xMoyen)*Math.cos(alpha) + (listYi.get(i) - yMoyen)*Math.sin(alpha),2);
		}
		return res;
	}
	
	private double calculD2(){
		double res = 0.0;
		for (int i=0; i<listXi.size(); i++){
			res = res + Math.pow((listXi.get(i) - xMoyen)*Math.cos(alpha+Math.PI/2) + (listYi.get(i) - yMoyen)*Math.sin(alpha+Math.PI/2),2);
		}
		return res;
	}

	private double calculH1(){
		double num = 0.0;
		double denom = 0.0;
		for (int i=0; i<listXi.size(); i++){
			num = num + Math.pow(listYi.get(i) - yOmega, 2);
			denom = denom + (listYi.get(i) - yOmega)*(listXi.get(i) - xOmega);
		}
		if (denom!=0.0){
			return num/denom;
		}
		return 0.0;
	}

	private double calculV1() {
		double num = 0.0;
		double denom = 0.0;
		for (int i=0; i<listXi.size(); i++){
			num = num + (listYi.get(i) - yOmega) * (listXi.get(i) - xOmega);
			denom = denom + Math.pow(listXi.get(i)-xOmega,2);
		}
		if (denom!=0.0){
			return num/denom;
		}
		return 0.0;
	}
	
	private double calculLongueurDroite(){
		return Math.sqrt(Math.pow(xmaxgraph-xmingraph,2)+Math.pow(f.eval(xmaxgraph)-f.eval(xmingraph), 2));
	}
	
	public double calculResiduVerticalMoyen(){
		double res = 0.0;
		for (int i=0; i<listXi.size(); i++){
			res = res + Math.abs(listYi.get(i) - f.eval(listXi.get(i)));
		}
		return res/n;
	}
	
	/**
	 * Même formule pour vertical, horizontal, orthogonal
	 * @return
	 */
	public double calculResiduMoyenOrthoProj(FonctionAffine function){
		double somme = 0.0;
		for (int i=0; i<listXi.size(); i++){
			somme = somme + Math.abs(listYi.get(i)-function.eval(listXi.get(i)))*Math.cos(Math.atan(function.getA()));
		}
		return somme/n;
	}
	
	/**
	 * Même formule pour vertical, horizontal, orthogonal
	 * @return
	 */
	public double calculResiduCarreMoyenOrthoProj(FonctionAffine function){
		double somme = 0.0;
		for (int i=0; i<listXi.size(); i++) {
			somme = somme + (listYi.get(i)-function.eval(listXi.get(i)))*Math.cos(Math.atan(function.getA()))*(listYi.get(i)-function.eval(listXi.get(i)))*Math.cos(Math.atan(function.getA())); 
		}
		return somme/n;
	}

	public void concat(LinkedList<Double> list, double elt){
		list.add(elt);
	}
	
	public double getMoyenne(LinkedList<Double> list){
		double moyenne = 0.0;
		for (int i=0; i<list.size()-1; i++){
			moyenne += list.get(i);
		}
		return moyenne;
	}
	
	public double getMax(LinkedList<Double> list){
		double max = 0.0;
		for (int i=0; i<list.size()-1; i++){
			if (list.get(i) > max){
				max = list.get(i);
			}
		} 
		return max;
	}
	
	public double getMin(LinkedList<Double> list){
		double min = 0.0;
		for (int i=0; i<list.size()-1; i++){
			if (list.get(i) < min){
				min = list.get(i);
			}
		} 
		return min;
	}

	private double getSomme(LinkedList<Double> list) {
		double somme = 0.0;
		for (int i=0; i<list.size(); i++){
			somme = somme + list.get(i);
		}
		return somme;
	}
	
	private LinkedList<Double> produitTermeATerme(LinkedList<Double> x, LinkedList<Double> y){
		LinkedList<Double> produit = new LinkedList<Double>();
		for (int i=0; i<x.size(); i++){
			produit.set(i, x.get(i)*y.get(i));
		}
		return produit;
	}
	
	private LinkedList<Double> pow2ListElements(LinkedList<Double> list){
		LinkedList<Double> res = new LinkedList<Double>();
		for (int i=0; i<list.size(); i++){
			res.set(i, Math.pow(list.get(i),2));
		}
		return res;
	}
	
}
