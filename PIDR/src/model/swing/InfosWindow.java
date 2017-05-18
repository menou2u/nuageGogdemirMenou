package model.swing;

import javax.swing.JButton;
import javax.swing.JTextArea;

import controller.PreviewButtonListener;
import controller.PrintButtonListener;
import controller.SaveButtonListener;

public class InfosWindow {

	private JTextArea infosDisplay;
	private JButton save;
	private JButton print;
	private JButton preview;
	
	public InfosWindow(StringBuilder infos) {
		infosDisplay = new JTextArea(infos.toString());
		
		save = new JButton("Enregistrer");
		save.addActionListener(new SaveButtonListener(this));
		
		print = new JButton("Imprimer");
		print.addActionListener(new PrintButtonListener(this));
		
		preview = new JButton("Prévisualiser");
		preview.addActionListener(new PreviewButtonListener(this));
	}

	/**
	 * @return the infosDisplay
	 */
	public JTextArea getInfosDisplay() {
		return infosDisplay;
	}

	/**
	 * @return the save
	 */
	public JButton getSave() {
		return save;
	}

	/**
	 * @return the print
	 */
	public JButton getPrint() {
		return print;
	}

	/**
	 * @return the preview
	 */
	public JButton getPreview() {
		return preview;
	}
	
	
	
}
