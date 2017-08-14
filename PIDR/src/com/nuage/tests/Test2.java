package com.nuage.tests;

import javagiac.context;
import javagiac.gen;

public class Test2 {

	public static void main(String[] args) {
		System.loadLibrary("javagiac");
		context c = new context();

		gen g = new gen("read(\"C:/Users/Bichette/git/nuageGogdemirMenou/Algo/test.cas\")", c);
		System.out.println(g.print(c));
	}

}
