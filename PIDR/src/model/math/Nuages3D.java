package model.math;

import java.util.LinkedList;

import javagiac.context;
import javagiac.gen;

public class Nuages3D extends XcasProg {
	
	public Nuages3D() {
		setPath("C:\\Users\\Bichette\\git\\nuageGogdemirMenou\\Algo\\nuages3D.cas");
	}
	
	public void run(LinkedList<Double> listXi, LinkedList<Double> listYi, LinkedList<Double> listZi, LinkedList<Double> listPhi, LinkedList<Double> listXomega, LinkedList<Double> listYomega, LinkedList<Double> listZomega, LinkedList<Double> listContraintes, LinkedList<Double> listOrdreDerivation, LinkedList<Double> listUx, LinkedList<Double> listUy){
		parsingProg(path);
		putArguments(listXi, listYi, listZi, listPhi, listXomega, listYomega, listZomega, listContraintes, listOrdreDerivation, listUx, listUy);
	}
	
	protected void putArguments(LinkedList<Double> listXi, LinkedList<Double> listYi, LinkedList<Double> listZi, LinkedList<Double> listPhi, LinkedList<Double> listXomega, LinkedList<Double> listYomega, LinkedList<Double> listZomega, LinkedList<Double> listContraintes, LinkedList<Double> listOrdreDerivation, LinkedList<Double> listUx, LinkedList<Double> listUy) {
		algo = algo.substring(4, algo.length()-1);
		algo = algo.replace("%1", getListForXcas(listXi));
		algo = algo.replace("%2", getListForXcas(listYi));
		algo = algo.replace("%3", getListForXcas(listZi));
		algo = algo.replace("%4", getListForXcas(listPhi));
		algo = algo.replace("%5", getListForXcas(listXomega));
		algo = algo.replace("%6", getListForXcas(listYomega));
		algo = algo.replace("%7", getListForXcas(listZomega));
		algo = algo.replace("%8", getListForXcas(listOrdreDerivation));
		algo = algo.replace("%9", getListForXcas(listUx));
		algo = algo.replace("%10", getListForXcas(listUy));
		context c = new context();
		gen g = new gen(algo, c);
		res = g.eval(1, c).print(c);
	}

}
