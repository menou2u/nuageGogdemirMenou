package com.nuage.model.math;

import java.util.LinkedList;

import com.nuage.javagiac.prog.ProgLoader;

import javagiac.context;
import javagiac.gen;

public class DroiteMoindreCarres extends XcasProg {

	private int nbDataBrutes;
	private LinkedList<Double> omegaDatas;
	private int commutateur;

	public DroiteMoindreCarres() {
	}

	protected void putArguments(LinkedList<Double> listXi, LinkedList<Double> listYi, int commutateur,
			LinkedList<Double> omegaDatas, double p1) {
		algo = algo.substring(4, algo.length() - 1);
		algo = algo.replace("%1", getListForXcas(listXi));
		algo = algo.replace("%2", getListForXcas(listYi));
		algo = algo.replace("%3", "" + commutateur);
		if (omegaDatas.size() > 0) {
			algo = algo.replace("%4", "" + omegaDatas.get(2));
			algo = algo.replace("%5", "" + omegaDatas.get(3));
		} else {
			algo = algo.replace("%4", "");
			algo = algo.replace("%5", "");
		}
		algo = algo.replace("%6", "" + p1);
		context c = new context();
		gen g = new gen(algo, c);
		res = g.eval(1, c).print(c);
		nbDataBrutes = listXi.size();
		System.out.println(res);
	}

	public void run(LinkedList<Double> listXi, LinkedList<Double> listYi, int commutateur,
			LinkedList<Double> omegaDatas, double p1) {
		parsingProg(ProgLoader.getDroiteDesMoindresCarresProg());
		this.omegaDatas = omegaDatas;
		this.commutateur = commutateur;
		putArguments(listXi, listYi, commutateur, omegaDatas, p1);
	}

	public StringBuilder getInfosC0orC1() {
		infos = new StringBuilder();
		String[] elements = (res.split(",")[1]).split(";");
		infos.append("Donn�es math�matiques\n");
		infos.append("X = tx(x)\n");
		infos.append("Y = ty(y)\n");
		infos.append("\n");
		infos.append("Nombre de donn�es de donn�es brutes : " + nbDataBrutes + "\n");
		if (commutateur != 0) {
			infos.append("xw brut = " + omegaDatas.get(0) + "\n");
			infos.append("yw brut = " + omegaDatas.get(1) + "\n");
			infos.append("xw trait� = " + omegaDatas.get(2) + "\n");
			infos.append("yw trait� = " + omegaDatas.get(3) + "\n");
			infos.append("\n");
		}
		infos.append("x mini = " + elements[16] + "\n");
		infos.append("x maxi = " + elements[17] + "\n");
		infos.append("x moyen = " + elements[18] + "\n");
		infos.append("y moyen = " + elements[19] + "\n");
		infos.append("\n");
		infos.append("Repr�sentation graphique\n");
		infos.append("x mini = " + elements[21] + "\n");
		infos.append("x maxi = " + elements[22] + "\n");
		infos.append("y mini = " + elements[23] + "\n");
		infos.append("y maxi = " + elements[24] + "\n");
		infos.append("\n");
		infos.append("Projection verticale\n");
		infos.append("Droite (Delta V). Y=v1*x+v2\n");
		infos.append("Pente v1 = " + elements[0] + "\n");
		infos.append("Ordonn�e � l'origine v2 = " + elements[1] + "\n");
		infos.append("\n");
		infos.append("Projection horizontale\n");
		infos.append("Droite (Delta H). Y=h1*x+h2\n");
		infos.append("Pente h1 = " + elements[2] + "\n");
		infos.append("Ordonn�e � l'origine h2 = " + elements[3] + "\n");
		infos.append("\n");
		infos.append("Projection orthogonale\n");
		infos.append("Droite (Delta ortho). Y=o1*x+o2\n");
		infos.append("Pente o1 = " + elements[5] + "\n");
		infos.append("Ordonn�e � l'origine o2 = " + elements[6] + "\n");
		infos.append("\n");
		infos.append("Coefficient de corr�lation lin�aire = " + elements[4] + "\n");
		infos.append("R�sidu carre moyen orthogonal proj verticale = " + elements[7] + "\n");
		infos.append("R�sidu carre moyen orthogonal proj horizontale = " + elements[8] + "\n");
		infos.append("R�sidu carre moyen orthogonal proj orthogonale = " + elements[9] + "\n");
		infos.append("R�sidu moyen orthogonal proj verticale = " + elements[10] + "\n");
		infos.append("R�sidu moyen orthogonal proj horizontale = " + elements[11] + "\n");
		infos.append("R�sidu moyen orthogonal proj orthogonale = " + elements[12] + "\n");
		infos.append("Longueur droite = " + elements[13] + "\n");
		infos.append("Longueur polygone = " + elements[14] + "\n");
		infos.append("Facteur de qualit� d'ajustement lin�aire = " + elements[15] + "\n");
		infos.append("Conseil : " + elements[20] + "\n");
		return infos;
	}

	public StringBuilder getInfosC2() {
		infos = new StringBuilder();
		String[] elements = (res.split(",")[1]).split(";");
		infos.append("Donn�es math�matiques\n");
		infos.append("X = tx(x)\n");
		infos.append("Y = ty(y)\n");
		infos.append("\n");
		infos.append("Nombre de donn�es de donn�es brutes : " + nbDataBrutes + "\n");
		infos.append("x mini = " + elements[8] + "\n");
		infos.append("x maxi = " + elements[9] + "\n");
		infos.append("x moyen = " + elements[10] + "\n");
		infos.append("y moyen = " + elements[11] + "\n");
		infos.append("Repr�sentation graphique\n");
		infos.append("x mini = " + elements[12] + "\n");
		infos.append("x maxi = " + elements[13] + "\n");
		infos.append("y mini = " + elements[14] + "\n");
		infos.append("y maxi = " + elements[15] + "\n");
		infos.append("\n");
		infos.append("Projection verticale ou horizontale ou orthogonale\n");
		infos.append("p1 = " + elements[0] + "\n");
		infos.append("p2 = " + elements[1] + "\n");
		infos.append("R�sidu orthogonal moyen = " + elements[4] + "\n");
		infos.append("R�sidu vertical moyen = " + elements[3] + "\n");
		infos.append("Longueur droite = " + elements[5] + "\n");
		infos.append("Longueur polygone = " + elements[6] + "\n");
		infos.append("Facteur de qualit� d'ajustement lin�aire = " + elements[7] + "\n");
		return infos;
	}

}
