package panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ToolsPanel extends JPanel{
	
	private JButton close;
	private JButton neww;
	private JButton open;
	private JButton register;
	private JButton registerAs;
	private JButton info;
	private JButton export;
	private JButton importt;
	private JButton print;
	private JButton preview;
	private JButton execute;
	private JButton lastOpened;
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
	
	private GridBagLayout globalgbl;
	private GridBagConstraints globalgbc;
	
	private GridBagLayout filegbl;
	private GridBagConstraints filegbc;
	
	private GridBagLayout infosgbl;
	private GridBagConstraints infosgbc;
	
	private GridBagLayout datasgbl;
	private GridBagConstraints datasgbc;
	
	private GridBagLayout printinggbl;
	private GridBagConstraints printinggbc;
	
	private GridBagLayout executinggbl;
	private GridBagConstraints executinggbc;
	
	//TODO : Remplacer lastOpened qui est un "V" par un sélecteur des derniers fichiers ouverts.
	public ToolsPanel(){
		
		globalgbl = new GridBagLayout();
		globalgbc = new GridBagConstraints();
		globalgbc.insets = new Insets(1,1,1,1);

		filegbl = new GridBagLayout();
		filegbc = new GridBagConstraints();
		filegbc.insets = new Insets(1,1,1,1);
		file = new JPanel(filegbl);
		file.setName("Fichier");
		
		close = new JButton("Fermer");
		filegbc.gridx = 0;
		filegbc.gridy = 0;
		file.add(close,filegbc);
		
		neww = new JButton("Nouveau");
		filegbc.gridx = 1;
		file.add(neww,filegbc);
		
		open = new JButton("Ouvrir");
		filegbc.gridx = 2;
		file.add(open,filegbc);
		
		lastOpened = new JButton("V");
		filegbc.gridx = 3;
		file.add(lastOpened,filegbc);

		register = new JButton("Enregistrer");
		filegbc.gridx = 4;
		file.add(register,filegbc);
		
		registerAs = new JButton("Enregistrer Sous...");
		filegbc.gridx = 5;
		file.add(registerAs,filegbc);
		
		nameFile = new JLabel("Fichier");
		filegbc.gridx = 2;
		filegbc.gridwidth = 2;
		filegbc.gridy = 1;
		filegbc.fill = filegbc.CENTER;
		file.add(nameFile,filegbc);

		globalgbc.gridx = 0;
		globalgbc.gridy = 0;
		this.add(file, globalgbc);
		
		infosgbl = new GridBagLayout();
		infosgbc = new GridBagConstraints();
		infosgbc.insets = new Insets(1,1,1,1);
		
		infos = new JPanel();
		infos.setLayout(infosgbl);
		
		info = new JButton("Infos");
		infosgbc.gridx = 0;
		infosgbc.gridy = 0;
		infos.add(info, infosgbc);
		
		nameInfos = new JLabel("Info."); 
		infosgbc.gridx = 0;
		infosgbc.gridy = 1;
		infos.add(nameInfos,infosgbc);
		
		globalgbc.gridx = 1;
		this.add(infos);
		
		datasgbl = new GridBagLayout();
		datasgbc = new GridBagConstraints();
		datasgbc.insets = new Insets(1,1,1,1);
		
		datas = new JPanel();
		datas.setLayout(datasgbl);
		
		export = new JButton("Exporter");
		datasgbc.gridx = 0;
		datasgbc.gridy = 0;
		datas.add(export, datasgbc);
		
		importt = new JButton("Importer");
		datasgbc.gridx = 1;
		datas.add(importt,datasgbc);
		
		nameDatas = new JLabel("Données");
		datasgbc.gridx = 0;
		datasgbc.gridy = 1;
		datasgbc.gridwidth = 2;
		datasgbc.anchor = datasgbc.CENTER;
		datas.add(nameDatas,datasgbc);
		
		globalgbc.gridx = 2; 
		this.add(datas);
		
		printinggbl = new GridBagLayout();
		printinggbc = new GridBagConstraints();
		printinggbc.insets = new Insets(1,1,1,1);
		
		printing = new JPanel();
		printing.setLayout(printinggbl);
		
		print = new JButton("Imprimer");
		printinggbc.gridx = 0;
		printinggbc.gridy = 0;
		printing.add(print, printinggbc);
		
		preview = new JButton("Prévisualiser");
		printinggbc.gridx = 1;
		printing.add(preview,printinggbc);
		
		namePrinting = new JLabel("Impression");
		printinggbc.gridx = 0;
		printinggbc.gridy = 1;
		printinggbc.gridwidth = 2;
		printinggbc.anchor = printinggbc.CENTER;
		printing.add(namePrinting,printinggbc);
		
		globalgbc.gridx = 3;
		this.add(printing,globalgbc);
		
		executinggbl = new GridBagLayout();
		executinggbc = new GridBagConstraints();
		executinggbc.insets = new Insets(1,1,1,1);
		
		executing = new JPanel();
		executing.setLayout(executinggbl);
		
		execute = new JButton("Exécuter");
		executinggbc.gridx = 0;
		executinggbc.gridy = 0;
		executing.add(execute, executinggbc);
		
		nameExecuting = new JLabel("Exécution");
		executinggbc.gridx = 0;
		executinggbc.gridy = 1;
		executinggbc.anchor = executinggbc.CENTER;
		executing.add(nameExecuting,executinggbc);
		
		globalgbc.gridx = 4;
		this.add(executing,globalgbc);
				
	}
	
	//main pour test
	public static void main(String[] args) {
		JFrame test = new JFrame();
		test.setSize(1300, 1300);
		ToolsPanel paneltest = new ToolsPanel();
		test.add(paneltest,null);
		test.setVisible(true);
	}
	
}

