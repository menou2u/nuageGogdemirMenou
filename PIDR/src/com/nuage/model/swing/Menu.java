package com.nuage.model.swing;

import java.util.LinkedList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Menu {
	
	JMenuBar menuBar;
	LinkedList<JMenu> menuItems;
	
	public Menu() {
		menuItems = new LinkedList<JMenu>();
		
		JMenu fichier = new JMenu("Fichier");
		menuItems.add(fichier);
		
		JMenu edition = new JMenu("Edition");
		menuItems.add(edition);
		
		JMenu aide = new JMenu("Aide");
		menuItems.add(aide);
		
		menuBar = new JMenuBar();
		menuBar.add(fichier);
		menuBar.add(edition);
		menuBar.add(aide);
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}
	
}
