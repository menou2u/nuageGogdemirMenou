package tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import javagiac.context;
import javagiac.gen;

public class Test {

	public static void main(String[] args) {
		System.loadLibrary("javagiac");
		String algo = null;
		File f = new File("C:\\Users\\Bichette\\git\\nuageGogdemirMenou\\Algo\\dmc.cas"); //d'après la doc le fichier doit s'appeller fichier.cas
		try{ //on instancie les utilitaires de lecture d'un fichier en JAVA
			InputStream ips=new FileInputStream(f);             
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				algo+=ligne+"\n";   //à chaque ligne je concatène avec la chaine de caractère algo
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		context c = new context();
		//algo = algo.replaceAll("[\u0000-\u001f]", "");
		//algo = algo.replaceAll("\\p{Cntrl}", "");
		//algo = CharMatcher.JAVA_ISO_CTRL.removeFrom(algo);
		algo = algo.substring(4, algo.length()-1);
		gen g = new gen(algo, c);
		//System.out.println(g.print(c)); //mettons que j'ai envie de l'afficher
		System.out.println(g.eval(1, c).print(c));
		//System.out.println(giac._eval(g,c).print(c));
	}
	
}
