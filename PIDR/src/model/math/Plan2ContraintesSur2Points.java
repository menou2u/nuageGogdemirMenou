package model.math;

import java.util.LinkedList;

import javagiac.context;
import javagiac.gen;

public class Plan2ContraintesSur2Points extends XcasProg {

	public Plan2ContraintesSur2Points() {
		setPath("C:\\Users\\Bichette\\git\\nuageGogdemirMenou\\Algo\\Plans\\plan 2 contraintes sur 2 points.cas");
	}
	
	public void run(LinkedList<Double> listXi, LinkedList<Double> listYi, LinkedList<Double> listZi, double xw1, double yw1, double zw1, double xw2, double yw2, double zw2){
		parsingProg(path);
		putArguments(listXi, listYi, listZi, xw1, yw1, zw1, xw2, yw2, zw2);
	}
	
	protected void putArguments(LinkedList<Double> listXi, LinkedList<Double> listYi, LinkedList<Double> listZi, double xw1, double yw1, double zw1, double xw2, double yw2, double zw2) {
		algo = algo.substring(4, algo.length()-1);
		algo = algo.replace("%1", getListForXcas(listXi));
		algo = algo.replace("%2", getListForXcas(listYi));
		algo = algo.replace("%3", getListForXcas(listZi));
		algo = algo.replace("%4", ""+xw1);
		algo = algo.replace("%5", ""+yw1);
		algo = algo.replace("%6", ""+zw1);
		algo = algo.replace("%7", ""+xw2);
		algo = algo.replace("%8", ""+yw2);
		algo = algo.replace("%9", ""+zw2);
		context c = new context();
		gen g = new gen(algo, c);
		res = g.eval(1, c).print(c);
	}
	
	public StringBuilder getInfos(){
		StringBuilder infos = new StringBuilder();
		
		return infos;
	}
	
}
