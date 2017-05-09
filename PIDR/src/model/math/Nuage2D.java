package model.math;

import java.util.LinkedList;

public class Nuage2D extends MathAlgo {

	private LinkedList<Double> listXi, listYi, listPhi, listXomega, listYomega, listContraintes, listOrdreDerivation;
	private int n, p, k;
	private Matrix matLambdaJ, matPhi;
	
	public void init(LinkedList<Double> listXi, LinkedList<Double> listYi, LinkedList<Double> listPhi, LinkedList<Double> listXomega, LinkedList<Double> listYomega, LinkedList<Double> listOrdreDerivation){
		this.listXi = listXi;
		this.listYi = listYi;
		this.listPhi = listPhi;
		this.listXomega = listXomega;
		this.listYomega = listYomega;
		listContraintes = listYomega;
		this.listOrdreDerivation = listOrdreDerivation;
		
		n = listXi.size();
		p = listPhi.size();
		k = listContraintes.size();
		
		matLambdaJ = new Matrix(p, 1);
		//matPhi = new Matrix(oin);
		
		
	}
	
	
	
}
