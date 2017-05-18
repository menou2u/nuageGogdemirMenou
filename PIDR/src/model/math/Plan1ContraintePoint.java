package model.math;

import java.util.LinkedList;

import javagiac.context;
import javagiac.gen;

public class Plan1ContraintePoint extends XcasProg {

	public Plan1ContraintePoint() {
		setPath("C:\\Users\\Bichette\\git\\nuageGogdemirMenou\\Algo\\Plans\\plans 1 contraintes sur point.cas");
	}
	
	public void run(LinkedList<Double> listXi, LinkedList<Double> listYi, LinkedList<Double> listZi, LinkedList<Double> listXomega, LinkedList<Double> listYomega, LinkedList<Double> listZomega){
		parsingProg(path);
		putArguments(listXi, listYi, listZi, listXomega, listYomega, listZomega);
	}
	
	protected void putArguments(LinkedList<Double> listXi, LinkedList<Double> listYi, LinkedList<Double> listZi, LinkedList<Double> listXomega, LinkedList<Double> listYomega, LinkedList<Double> listZomega) {
		algo = algo.substring(4, algo.length()-1);
		algo = algo.replace("%1", getListForXcas(listXi));
		algo = algo.replace("%2", getListForXcas(listYi));
		algo = algo.replace("%3", getListForXcas(listZi));
		algo = algo.replace("%4", getListForXcas(listXomega));
		algo = algo.replace("%5", getListForXcas(listYomega));
		algo = algo.replace("%6", getListForXcas(listZomega));
		context c = new context();
		gen g = new gen(algo, c);
		res = g.eval(1, c).print(c);
	}
	
	
}
