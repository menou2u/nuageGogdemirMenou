package model.math;

import java.util.LinkedList;

import javagiac.context;
import javagiac.gen;

public class DroiteMoindreCarres extends XcasProg {
	
	public DroiteMoindreCarres() {
		setPath("C:\\Users\\Bichette\\git\\nuageGogdemirMenou\\Algo\\droite des moindres carres.cas");
	}

	protected void putArguments(LinkedList<Double> listXi, LinkedList<Double> listYi, int commutateur, double xOmega, double yOmega, double p1) {
		algo = algo.substring(4, algo.length()-1);
		algo = algo.replace("%1", getListForXcas(listXi));
		algo = algo.replace("%2", getListForXcas(listYi));
		algo = algo.replace("%3", ""+commutateur);
		algo = algo.replace("%4", ""+xOmega);
		algo = algo.replace("%5", ""+yOmega);
		algo = algo.replace("%6", ""+p1);
		context c = new context();
		gen g = new gen(algo, c);
		res = g.eval(1, c).print(c);
	}
	
	public void run(LinkedList<Double> listXi, LinkedList<Double> listYi, int commutateur, double xOmega, double yOmega, double p1){
		parsingProg(path);
		putArguments(listXi, listYi, commutateur, xOmega, yOmega, p1);
	}
	
}
