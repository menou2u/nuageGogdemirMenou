package model.math;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

import javagiac.context;
import javagiac.gen;
import javagiac.giac;

public abstract class XcasProg {

	protected String res;
	protected String algo;
	protected String path;
	protected StringBuilder infos;
	
	protected void parsingProg(String path){
		System.loadLibrary("javagiac");
		//Récupération du code Xcas
		algo = null;
		File f = new File(path);
		try{
			InputStream ips=new FileInputStream(f);             
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				algo+=ligne+"\n";
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	protected <E> CharSequence getListForXcas(LinkedList<E> list) {
		CharSequence res = "";
		if (list.size() != 0){
			for (int i=0; i<list.size(); i++){
				if (list.get(i) != null){
					res = res + ""+list.get(i);
					if (i<list.size() -1){
						res = res + ",";
					}
				}
			}
		}
		return res;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	public String getRes(){
		return res;
	}
	
	public static double simpleEval(String expression){
		System.loadLibrary("javagiac");
		context c = new context();
		gen g = new gen(expression,c);
		gen h = giac._factor(g, c);
		return h.DOUBLE_val();
	}
	
	
}
