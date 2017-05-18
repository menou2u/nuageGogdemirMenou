package model.math;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public abstract class XcasProg {

	protected String res;
	protected String algo;
	protected String path;
	
	protected void parsingProg(String path){
		System.loadLibrary("javagiac");
		//R�cup�ration du code Xcas
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
	
	protected <E> CharSequence getListForXcas(LinkedList<E> listXi) {
		CharSequence res = "";
		if (listXi.size() != 0){	
			for (int i=0; i<listXi.size(); i++){
				res = res + ""+listXi.get(i);
				if (i<listXi.size() -1){
					res = res + ",";
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
	
	
	
}