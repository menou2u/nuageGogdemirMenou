package model.math;

import java.util.LinkedList;

public class Tests {

	public static void main(String[] args) {
		//dmcC0();
		//dmcC1();
		//dmcC2();
		//plan0Contrainte();
		//plan1Contrainte();
		//test3D();
		test2D();
	}
	
	private static void test2D() {
		
	}

	public static void plan0Contrainte(){
		Plan0Contrainte plan = new Plan0Contrainte();
		LinkedList<Double> listXi = new LinkedList<Double>();
		listXi.add(-1.0);
		listXi.add(1.0);
		listXi.add(2.0);
		listXi.add(3.0);
		LinkedList<Double> listYi = new LinkedList<Double>();
		listYi.add(1.0);
		listYi.add(2.0);
		listYi.add(3.0);
		listYi.add(4.0);
		LinkedList<Double> listZi = new LinkedList<Double>();
		listZi.add(-1.0);
		listZi.add(6.0);
		listZi.add(11.0);
		listZi.add(16.0);
		plan.run(listXi, listYi, listZi);
		System.out.println(plan.getInfos());
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
		LinkedList<Double> listXomegaBT = new LinkedList<Double>();
		listXomegaBT.add(3.0);
		listXomegaBT.add(3.0);
		LinkedList<Double> listYomegaBT = new LinkedList<Double>();
		listYomegaBT.add(4.0);
		listYomegaBT.add(4.0);
		LinkedList<Double> listZomegaBT = new LinkedList<Double>();
		listZomegaBT.add(2.0);
		listZomegaBT.add(2.0);
		plan.run(listXi, listYi, listZi, listXomegaBT, listYomegaBT, listZomegaBT);
		System.out.println(plan.getRes());
		//System.out.println(plan.getInfos());
	}
	
	public static void test3D(){
		Nuages3D troisD = new Nuages3D();
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
		listZi.add(-11.0);
		LinkedList<String> listPhi = new LinkedList<>();
		listPhi.add("x");
		listPhi.add("y");
		listPhi.add("1");
		LinkedList<Double> listXomega = new LinkedList<Double>();
		//listXomega.add(3.0);
		LinkedList<Double> listYomega = new LinkedList<Double>();
		//listYomega.add(4.0);
		LinkedList<Double> listZomega = new LinkedList<Double>();
		//listZomega.add(2.0);
		LinkedList<Integer> listOrdreDerivation = new LinkedList<Integer>();
		//listOrdreDerivation.add(0);
		LinkedList<Double> listUx = new LinkedList<Double>();
		LinkedList<Double> listUy = new LinkedList<Double>();
		troisD.run(listXi, listYi, listZi, listPhi, listXomega, listYomega, listZomega, listOrdreDerivation, listUx, listUy);
		System.out.println(troisD.getInfos());	
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
