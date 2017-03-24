package view.panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Tools;

@SuppressWarnings("serial")
public class ToolsPanel extends JPanel{
	
	@SuppressWarnings("static-access")
	public ToolsPanel(Tools tools){
		
		GridBagLayout globalgbl;
		GridBagConstraints globalgbc;
		
		GridBagLayout filegbl;
		GridBagConstraints filegbc;
		
		GridBagLayout infosgbl;
		GridBagConstraints infosgbc;
		
		GridBagLayout datasgbl;
		GridBagConstraints datasgbc;
		
		GridBagLayout printinggbl;
		GridBagConstraints printinggbc;
		
		GridBagLayout executinggbl;
		GridBagConstraints executinggbc;
		
		globalgbl = new GridBagLayout();
		globalgbc = new GridBagConstraints();
		globalgbc.insets = new Insets(1,1,1,1);

		filegbl = new GridBagLayout();
		filegbc = new GridBagConstraints();
		filegbc.insets = new Insets(1,1,1,1);
		tools.setFile(new JPanel(filegbl));
		tools.getFile().setName("Fichier");
		
		filegbc.gridx = 0;
		filegbc.gridy = 0;
		tools.getFile().add(tools.getClose(),filegbc);
		
		filegbc.gridx = 1;
		tools.getFile().add(tools.getNeww(),filegbc);
		
		for (int i=0;i<5;i++)
		{
			String lastOpened = tools.getLastOpened()[i+1];
			lastOpened = new String("Fichiertroplong n°"+(i+1));
			tools.getOpen().addItem(lastOpened);
		}
		filegbc.gridx = 2;
		tools.getFile().add(tools.getOpen(),filegbc);
		
		filegbc.gridx = 3;
		tools.getFile().add(tools.getRegister(),filegbc);
		
		filegbc.gridx = 4;
		tools.getFile().add(tools.getRegisterAs(),filegbc);
		
		filegbc.gridx = 2;
		filegbc.gridwidth = 2;
		filegbc.gridy = 1;
		filegbc.fill = filegbc.CENTER;
		tools.getFile().add(tools.getNameFile(),filegbc);

		globalgbc.gridx = 0;
		globalgbc.gridy = 0;
		add(tools.getFile(), globalgbc);
		
		infosgbl = new GridBagLayout();
		infosgbc = new GridBagConstraints();
		infosgbc.insets = new Insets(1,1,1,1);
		
		tools.getInfos().setLayout(infosgbl);
		
		infosgbc.gridx = 0;
		infosgbc.gridy = 0;
		tools.getInfos().add(tools.getInfo(), infosgbc);
		
		infosgbc.gridx = 0;
		infosgbc.gridy = 1;
		tools.getInfos().add(tools.getNameInfos(),infosgbc);
		
		globalgbc.gridx = 1;
		add(tools.getInfos());
		
		datasgbl = new GridBagLayout();
		datasgbc = new GridBagConstraints();
		datasgbc.insets = new Insets(1,1,1,1);
		
		tools.getDatas().setLayout(datasgbl);
		
		datasgbc.gridx = 0;
		datasgbc.gridy = 0;
		tools.getDatas().add(tools.getExport(), datasgbc);
		
		datasgbc.gridx = 1;
		tools.getDatas().add(tools.getImportt(),datasgbc);
		
		datasgbc.gridx = 0;
		datasgbc.gridy = 1;
		datasgbc.gridwidth = 2;
		datasgbc.anchor = datasgbc.CENTER;
		tools.getDatas().add(tools.getNameDatas(),datasgbc);
		
		globalgbc.gridx = 2; 
		add(tools.getDatas());
		
		printinggbl = new GridBagLayout();
		printinggbc = new GridBagConstraints();
		printinggbc.insets = new Insets(1,1,1,1);
		
		tools.getPrinting().setLayout(printinggbl);
		
		printinggbc.gridx = 0;
		printinggbc.gridy = 0;
		tools.getPrinting().add(tools.getPrint(), printinggbc);
		
		printinggbc.gridx = 1;
		tools.getPrinting().add(tools.getPreview(),printinggbc);
		
		printinggbc.gridx = 0;
		printinggbc.gridy = 1;
		printinggbc.gridwidth = 2;
		printinggbc.anchor = printinggbc.CENTER;
		tools.getPrinting().add(tools.getNamePrinting(),printinggbc);
		
		globalgbc.gridx = 3;
		add(tools.getPrinting(),globalgbc);
		
		executinggbl = new GridBagLayout();
		executinggbc = new GridBagConstraints();
		executinggbc.insets = new Insets(1,1,1,1);
		
		tools.getExecuting().setLayout(executinggbl);
		
		executinggbc.gridx = 0;
		executinggbc.gridy = 0;
		tools.getExecuting().add(tools.getExecute(), executinggbc);
		
		executinggbc.gridx = 0;
		executinggbc.gridy = 1;
		executinggbc.anchor = executinggbc.CENTER;
		tools.getExecuting().add(tools.getNameExecuting(),executinggbc);
		
		globalgbc.gridx = 4;
		add(tools.getExecuting(),globalgbc);
	}
	
	//main pour test
	public static void main(String[] args) {
		JFrame test = new JFrame();
		test.setSize(1300, 1300);
		Tools tools = new Tools();
		ToolsPanel paneltest = new ToolsPanel(tools);
		test.add(paneltest,null);
		test.setVisible(true);
	}
	
}

