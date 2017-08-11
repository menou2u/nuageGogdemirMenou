package model.filesChoosers;

import java.io.File;

import javax.swing.JFileChooser;

import model.swing.mode.Updatable;

@SuppressWarnings("serial")
public class OpenFileChooser extends JFileChooser {

	private File directory;
	
	public OpenFileChooser(Updatable mode) {
		directory = new File(".");
			
		setCurrentDirectory(directory);
		
		setAcceptAllFileFilterUsed(false);
		setFileFilter(new ModeFileFilter(mode));
		
	}
	
}
