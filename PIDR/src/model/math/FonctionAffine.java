package model.math;

public class FonctionAffine {

	private String functionName, x;
	private double a,b;
	
	public FonctionAffine(String functionName, double a, String x, double b){
		this.functionName = functionName;
		this.a = a;
		this.x = x;
		this.b = b;
	}
	
	public double eval(double x){
		return a*x+b;
	}
	
	public String toString(){
		if (b < 0){
			return a+"*"+x+b;
		}
		return a+"*"+x+"+"+b;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}
	
	
	
}
