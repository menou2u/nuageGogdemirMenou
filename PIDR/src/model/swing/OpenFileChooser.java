package model.swing;

import java.io.File;

import javax.swing.JFileChooser;

public class OpenFileChooser extends JFileChooser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3389930082272123374L;
	private File directory;
	
	public OpenFileChooser(Updatable mode) {
		directory = new File(".");
			
		setCurrentDirectory(directory);
		
		setAcceptAllFileFilterUsed(false);
		setFileFilter(new ModeFileFilter(mode));
		
	}
	
}
