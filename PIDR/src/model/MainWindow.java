package model;

import java.awt.Color;
import java.awt.Component;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import view.panels.CalculatedFunctionPanel;
import view.panels.ConstraintsPanel;
import view.panels.DataPanel;
import view.panels.DisplaySettingsPanel;
import view.panels.MathShortcutsPanel;
import view.panels.TestFunctionPanel;
import view.panels.ToolsPanel;

public class MainWindow extends Observable {
	
	private Menu menu;
	private Tools tools;
	private Data data;
	private Constraints constraints;
	private TestFunction testFunction;
	private MathShortcuts mathShortcuts;
	private CalculatedFunction calculatedFunction;
	private DisplaySettings display;
	private ToolsPanel toolsPanel;
	private DataPanel dataPanel;
	private ConstraintsPanel constraintsPanel;
	private TestFunctionPanel testFunctionPanel;
	private MathShortcutsPanel mathShortcutsPanel;
	private CalculatedFunctionPanel calculatedFunctionPanel;
	private DisplaySettingsPanel displayPanel;
	private JPanel contentPanel;
	
	public MainWindow() {
		menu = new Menu();
		tools = new Tools();
		data = new Data();
		constraints = new Constraints();
		testFunction = new TestFunction();
		calculatedFunction = new CalculatedFunction();
		mathShortcuts = new MathShortcuts(testFunction);
		display = new DisplaySettings();
		toolsPanel = new ToolsPanel(tools);
		dataPanel = new DataPanel(data);
		constraintsPanel = new ConstraintsPanel(constraints);
		testFunctionPanel = new TestFunctionPanel(testFunction);
		mathShortcutsPanel = new MathShortcutsPanel(mathShortcuts);
		calculatedFunctionPanel = new CalculatedFunctionPanel(calculatedFunction);
		displayPanel = new DisplaySettingsPanel(display);
		contentPanel = new JPanel();
	}
	
	public void setCalculatedFunctionPanel(CalculatedFunctionPanel calculatedFunctionPanel) {
		this.calculatedFunctionPanel = calculatedFunctionPanel;
	}
	
	public Menu getMenu() {
		return menu;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public Tools getTools() {
		return tools;
	}

	public Data getData() {
		return data;
	}

	public Constraints getConstraints() {
		return constraints;
	}

	public TestFunction getTestFunction() {
		return testFunction;
	}

	public MathShortcuts getMathShortcuts() {
		return mathShortcuts;
	}

	public CalculatedFunction getCalculatedFunction() {
		return calculatedFunction;
	}

	public DisplaySettings getDisplay() {
		return display;
	}

	public ToolsPanel getToolsPanel() {
		return toolsPanel;
	}

	public DataPanel getDataPanel() {
		return dataPanel;
	}

	public ConstraintsPanel getConstraintsPanel() {
		return constraintsPanel;
	}

	public TestFunctionPanel getTestFunctionPanel() {
		return testFunctionPanel;
	}

	public MathShortcutsPanel getMathShortcutsPanel() {
		return mathShortcutsPanel;
	}

	public CalculatedFunctionPanel getCalculatedFunctionPanel() {
		return calculatedFunctionPanel;
	}

	public DisplaySettingsPanel getDisplayPanel() {
		return displayPanel;
	}

	public Component getVisualisationPanel() {
		JPanel p = new JPanel();
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		return p;
	}

}
