package window;

import javax.swing.JFrame;

import panels.CalculatedFunctionPanel;
import panels.ConstraintsPanel;
import panels.DataPanel;
import panels.DisplayPanel;
import panels.MathShortcutsPanel;
import panels.TestFunctionPanel;
import panels.ToolsPanel;

public class MainWindow extends JFrame {

	

	private ToolsPanel tools;
	private DataPanel data;
	private ConstraintsPanel constraints;
	private TestFunctionPanel testFunction;
	private MathShortcutsPanel mathShortcuts;
	private CalculatedFunctionPanel calculatedFunction;
	private DisplayPanel display;
	
	public MainWindow(){
		
		tools = new ToolsPanel();
		data = new DataPanel();
		constraints = new ConstraintsPanel();
		testFunction = new TestFunctionPanel();
		mathShortcuts = new MathShortcutsPanel();
		calculatedFunction = new CalculatedFunctionPanel();
		display = new DisplayPanel();
		
	}
	
	
	
}
