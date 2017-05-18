package model.math;

import java.util.LinkedList;

public class Tests {

	public static void main(String[] args) {
		//dmcC0();
		//dmcC1();
		//dmcC2();
		plan1Contrainte();
	}
	
	public static void plan1Contrainte(){
		Plan1ContraintePoint plan = new Plan1ContraintePoint();
		LinkedList<Double> listXi = new LinkedList<Double>();
		listXi.add(-2.0);
		listXi.add(0.0);
		listXi.add(1.0);
		listXi.add(2.0);
		LinkedList<Double> listYi = new LinkedList<Double>();
		listYi.add(1.0);
		listYi.add(0.0);
		listYi.add(2.0);
		listYi.add(-1.0);
		LinkedList<Double> listZi = new LinkedList<Double>();
		listZi.add(3.0);
		listZi.add(-4.0);
		listZi.add(0.0);
		listZi.add(11.0);
		LinkedList<Double> listXomega = new LinkedList<Double>();
		listXomega.add(3.0);
		LinkedList<Double> listYomega = new LinkedList<Double>();
		listXomega.add(4.0);
		LinkedList<Double> listZomega = new LinkedList<Double>();
		listXomega.add(2.0);
		plan.run(listXi, listYi, listZi, listXomega, listYomega, listZomega);
		
	}
	
	public static void dmcC2(){
		DroiteMoindreCarres dmc = new DroiteMoindreCarres();
		LinkedList<Double> listXi = new LinkedList<Double>();
		listXi.add(-1.0);
		listXi.add(2.0);
		listXi.add(5.0);
		LinkedList<Double> listYi = new LinkedList<Double>();
		listYi.add(1.0);
		listYi.add(4.0);
		listYi.add(9.0);
		LinkedList<Double> constraints = new LinkedList<Double>();
		constraints.add(0.0);
		constraints.add(0.0);
		constraints.add(0.0);
		constraints.add(0.0);
		dmc.run(listXi, listYi, 2, constraints, 2);
		System.out.println(dmc.getInfosC2());
	}
	
	public static void dmcC1(){
		DroiteMoindreCarres dmc = new DroiteMoindreCarres();
		LinkedList<Double> listXi = new LinkedList<Double>();
		listXi.add(-1.0);
		listXi.add(2.0);
		listXi.add(5.0);
		LinkedList<Double> listYi = new LinkedList<Double>();
		listYi.add(1.0);
		listYi.add(4.0);
		listYi.add(9.0);
		LinkedList<Double> constraints = new LinkedList<Double>();
		constraints.add(1.0);
		constraints.add(3.0);
		constraints.add(1.0);
		constraints.add(3.0);
		dmc.run(listXi, listYi, 1, constraints, 0);
		System.out.println(dmc.getInfosC0orC1());
	}
	
	public static void dmcC0(){
		DroiteMoindreCarres dmc = new DroiteMoindreCarres();
		LinkedList<Double> listXi = new LinkedList<Double>();
		listXi.add(1.0);
		listXi.add(3.0);
		listXi.add(5.0);
		LinkedList<Double> listYi = new LinkedList<Double>();
		listYi.add(5.0);
		listYi.add(9.0);
		listYi.add(25.0);
		LinkedList<Double> constraints = new LinkedList<Double>();
		constraints.add(0.0);
		constraints.add(0.0);
		constraints.add(0.0);
		constraints.add(0.0);
		dmc.run(listXi, listYi, 0, constraints, 0);
		System.out.println(dmc.getInfosC0orC1());
	}
}
