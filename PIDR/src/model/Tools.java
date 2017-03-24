package model;

import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tools extends Observable {

	private JButton close;
	private JButton neww;
	private JButton openButton;
	private JButton register;
	private JButton registerAs;
	private JButton info;
	private JButton export;
	private JButton importt;
	private JButton print;
	private JButton preview;
	private JButton execute;
	private String lastOpened[];
	private JComboBox<String> open;
	private JPanel file;
	private JPanel infos;
	private JPanel datas;
	private JPanel printing;
	private JPanel executing;
	private JLabel nameFile;
	private JLabel nameInfos;
	private JLabel nameDatas;
	private JLabel namePrinting;
	private JLabel nameExecuting;
	
	public Tools(){
		
		close = new JButton("Fermer");
		
		neww = new JButton("Nouveau");
		
		openButton = new JButton("Ouvrir");
		lastOpened = new String[6];
		//open.addItem(openButton);
		open = new JComboBox<String>();
		open.addItem("Ouvrir");

		register = new JButton("Enregistrer");
		
		registerAs = new JButton("Enregistrer Sous...");
		
		info = new JButton("Infos");
		
		export = new JButton("Exporter");
		
		importt = new JButton("Importer");
		
		print = new JButton("Imprimer");
		
		preview = new JButton("Prévisualiser");
		
		execute = new JButton("Exécuter");
		
		infos = new JPanel();
		
		datas = new JPanel();
		
		printing = new JPanel();
		
		executing = new JPanel();
		
		nameFile = new JLabel("Fichier");
		
		nameInfos = new JLabel("Info."); 
		
		nameDatas = new JLabel("Données");
		
		namePrinting = new JLabel("Impression");
		
		nameExecuting = new JLabel("Exécution");
	}

	public JButton getClose() {
		return close;
	}

	public JButton getNeww() {
		return neww;
	}

	public JButton getOpenButton() {
		return openButton;
	}

	public JButton getRegister() {
		return register;
	}

	public JButton getRegisterAs() {
		return registerAs;
	}

	public JButton getInfo() {
		return info;
	}

	public JButton getExport() {
		return export;
	}

	public JButton getImportt() {
		return importt;
	}

	public JButton getPrint() {
		return print;
	}

	public JButton getPreview() {
		return preview;
	}

	public JButton getExecute() {
		return execute;
	}

	public String[] getLastOpened() {
		return lastOpened;
	}

	public JComboBox<String> getOpen() {
		return open;
	}

	public JPanel getFile() {
		return file;
	}

	public JPanel getInfos() {
		return infos;
	}

	public JPanel getDatas() {
		return datas;
	}

	public JPanel getPrinting() {
		return printing;
	}

	public JPanel getExecuting() {
		return executing;
	}

	public JLabel getNameFile() {
		return nameFile;
	}

	public JLabel getNameInfos() {
		return nameInfos;
	}

	public JLabel getNameDatas() {
		return nameDatas;
	}

	public JLabel getNamePrinting() {
		return namePrinting;
	}

	public JLabel getNameExecuting() {
		return nameExecuting;
	}

	public void setFile(JPanel file) {
		this.file = file;
	}
	
	
}
