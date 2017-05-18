package model.math;

import java.util.LinkedList;

import javagiac.context;
import javagiac.gen;

public class Plan1ContrainteVecteurXOY extends XcasProg {

	public Plan1ContrainteVecteurXOY() {
		setPath("C:\\Users\\Bichette\\git\\nuageGogdemirMenou\\Algo\\Plans\\plan 1 contraintes sur vecteur xoy.cas");
	}
	
	public void run(LinkedList<Double> listXi, LinkedList<Double> listYi, LinkedList<Double> listZi, double vecteurDxOYX, double vecteurDxOYY, double penteXOY){
		parsingProg(path);
		putArguments(listXi, listYi, listZi, vecteurDxOYX, vecteurDxOYY, penteXOY);
	}
	
	protected void putArguments(LinkedList<Double> listXi, LinkedList<Double> listYi, LinkedList<Double> listZi, double vecteurDxOYX, double vecteurDxOYY, double penteXOY) {
		algo = algo.substring(4, algo.length()-1);
		algo = algo.replace("%1", getListForXcas(listXi));
		algo = algo.replace("%2", getListForXcas(listYi));
		algo = algo.replace("%3", getListForXcas(listZi));
		algo = algo.replace("%4", ""+vecteurDxOYX);
		algo = algo.replace("%5", ""+vecteurDxOYY);
		algo = algo.replace("%6", ""+penteXOY);
		context c = new context();
		gen g = new gen(algo, c);
		res = g.eval(1, c).print(c);
	}
	
}
