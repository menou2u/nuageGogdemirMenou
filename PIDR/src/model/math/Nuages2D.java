package model.math;

import java.util.LinkedList;

import javagiac.context;
import javagiac.gen;

public class Nuages2D extends XcasProg {

	public Nuages2D() {
		setPath("C:\\Users\\Bichette\\git\\nuageGogdemirMenou\\Algo\\droite des moindres carres.cas");
	}
	
	public void run(LinkedList<Double> listXi, LinkedList<Double> listYi, LinkedList<String> listPhi, LinkedList<Double> listXomega, LinkedList<Double> listYomega, LinkedList<Double> listContraintes, LinkedList<Double> listOrdreDerivation){
		parsingProg(path);
		putArguments(listXi, listYi, listPhi, listXomega, listYomega, listContraintes, listOrdreDerivation);
	}
	
	protected void putArguments(LinkedList<Double> listXi, LinkedList<Double> listYi, LinkedList<String> listPhi, LinkedList<Double> listXomega, LinkedList<Double> listYomega, LinkedList<Double> listContraintes, LinkedList<Double> listOrdreDerivation) {
		algo = algo.substring(4, algo.length()-1);
		algo = algo.replace("%1", getListForXcas(listXi));
		algo = algo.replace("%2", getListForXcas(listYi));
		algo = algo.replace("%3", getListForXcas(listPhi));
		algo = algo.replace("%4", getListForXcas(listXomega));
		algo = algo.replace("%5", getListForXcas(listYomega));
		algo = algo.replace("%6", getListForXcas(listOrdreDerivation));
		context c = new context();
		gen g = new gen(algo, c);
		res = g.eval(1, c).print(c);
	}

	public StringBuilder getInfos() {
		infos.append("OIN :D");
		return infos;
	}
	
}
