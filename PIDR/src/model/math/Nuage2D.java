package model.math;

import java.util.LinkedList;

public class Nuage2D extends MathAlgo {

	private LinkedList<Double> listXi, listYi, listPhi, listXomega, listYomega, listContraintes, listOrdreDerivation, listUux, listUuy, listPhik, listPhik1,
								listCarresResidus;
	private int n, p, k;
	private Matrix matLambdaJ, matPhi, matPhik, matPhi1k;
	
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
		matPhi = list2Mat(listPhi,1);
		listUux = new LinkedList<Double>(); //supposé de taille k
		listUuy = new LinkedList<Double>(); //supposé de taille k
		matPhik = new Matrix(k,1);
		matPhik = subMat(matPhi,p-k,0,p,0);
		matPhi1k = subMat(matPhi,0,0,p-k,0);
		listPhik = mat2List(matPhik);
		listPhik1 = mat2List(matPhi1k);
		listCarresResidus = new LinkedList<Double>();
		
	}
	
	
	
}
