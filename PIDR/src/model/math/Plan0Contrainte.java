package model.math;

import java.util.LinkedList;

import javagiac.context;
import javagiac.gen;

public class Plan0Contrainte extends XcasProg {

	public Plan0Contrainte() {
		setPath("C:\\Users\\Bichette\\git\\nuageGogdemirMenou\\Algo\\Plans\\plan 0 contrainte.cas");
	}
	
	public void run(LinkedList<Double> listXi, LinkedList<Double> listYi, LinkedList<Double> listZi){
		parsingProg(path);
		putArguments(listXi, listYi, listZi);
	}
	
	protected void putArguments(LinkedList<Double> listXi, LinkedList<Double> listYi, LinkedList<Double> listZi) {
		algo = algo.substring(4, algo.length()-1);
		algo = algo.replace("%1", getListForXcas(listXi));
		algo = algo.replace("%2", getListForXcas(listYi));
		algo = algo.replace("%3", getListForXcas(listZi));
		context c = new context();
		gen g = new gen(algo, c);
		res = g.eval(1, c).print(c);
	}
		
}
