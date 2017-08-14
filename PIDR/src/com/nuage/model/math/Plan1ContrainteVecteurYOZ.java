package com.nuage.model.math;

import java.util.LinkedList;

import com.nuage.javagiac.prog.ProgLoader;

import javagiac.context;
import javagiac.gen;

public class Plan1ContrainteVecteurYOZ extends XcasProg {

	public Plan1ContrainteVecteurYOZ() {
		setPath("Algo\\Plans\\plan 1 contraintes sur vecteur yoz.cas");
	}

	public void run(LinkedList<Double> listXi, LinkedList<Double> listYi, LinkedList<Double> listZi,
			double vecteurDyOZY, double vecteurDxOZZ, double penteYOZ) {
		parsingProg(ProgLoader.getPlan1ContraintesYOZProg());
		putArguments(listXi, listYi, listZi, vecteurDyOZY, vecteurDxOZZ, penteYOZ);
	}

	protected void putArguments(LinkedList<Double> listXi, LinkedList<Double> listYi, LinkedList<Double> listZi,
			double vecteurDyOZY, double vecteurDxOZZ, double penteYOZ) {
		algo = algo.substring(4, algo.length() - 1);
		algo = algo.replace("%1", getListForXcas(listXi));
		algo = algo.replace("%2", getListForXcas(listYi));
		algo = algo.replace("%3", getListForXcas(listZi));
		algo = algo.replace("%4", "" + vecteurDyOZY);
		algo = algo.replace("%5", "" + vecteurDxOZZ);
		algo = algo.replace("%6", "" + penteYOZ);
		context c = new context();
		gen g = new gen(algo, c);
		res = g.eval(1, c).print(c);
	}

	// TODO: create getInfos()

}
