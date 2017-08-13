package com.nuage.model.filesChoosers;

import java.io.File;

import javax.swing.JFileChooser;

import com.nuage.model.swing.mode.Updatable;

@SuppressWarnings("serial")
public class SaveFileChooser extends JFileChooser {

	private File directory;

	public SaveFileChooser(Updatable mode) {
		directory = new File(".");
		
		setCurrentDirectory(directory);
		
		setAcceptAllFileFilterUsed(false);
		setFileFilter(new ModeFileFilter(mode));
	}
	
}
