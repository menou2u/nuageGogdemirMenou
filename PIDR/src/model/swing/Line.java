package model.swing;

import javax.swing.JPanel;

import view.panels.CalculatedFunctionPanel;
import view.panels.ConstraintsPanel;
import view.panels.DataPanel;
import view.panels.DisplaySettingsPanel;
import view.panels.LineConstraintsChoicePanel;
import view.panels.MathShortcutsPanel;
import view.panels.TestFunctionPanel;
import view.panels.ToolsPanel;
import view.panels.TransformationsLinePanel;

public class Line implements Updatable {

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
	private TransformationsLinePanel transformationsLinePanel;
	private Data transformedData;
	private DataPanel transformedDataPanel;
	private JPanel noConstraint;
	private PointConstraint pointConstraint;
	private SlopeConstraintPanel slopeConstraint;
	private LineConstraintsChoicePanel chosenPanel;
	private TransformationsLine transformationsLine;
	private LineConstraintsChoice lineConstraintsChoice;
	private LineGraph lineGraph;

	public Line() {
		data = new Data("n°","xi","yi");
		transformedData = new Data("n°","Xi = tx(xi)","Yi = ty(yi)");
		testFunction = new TestFunction("(x)");
		calculatedFunction = new CalculatedFunction("f(x) = ", "");
		mathShortcuts = new MathShortcuts(testFunction);
		display = new DisplaySettings();
		
		dataPanel = new DataPanel(data,transformedData);
		//transformedDataPanel = new DataPanel(transformedData);
		
		lineGraph = new LineGraph("line");
		testFunctionPanel = new TestFunctionPanel(testFunction);
		mathShortcutsPanel = new MathShortcutsPanel(mathShortcuts);
		calculatedFunctionPanel = new CalculatedFunctionPanel(calculatedFunction);
		displayPanel = new DisplaySettingsPanel(display);
		transformationsLine = new TransformationsLine();
		transformationsLinePanel = new TransformationsLinePanel(transformationsLine);
		contentPanel = new JPanel();
		lineConstraintsChoice = new LineConstraintsChoice();
		chosenPanel = new LineConstraintsChoicePanel(lineConstraintsChoice);
	}

	/**
	 * @return the displayPanel
	 */
	public DisplaySettingsPanel getDisplayPanel() {
		return displayPanel;
	}

	@Override
	public Data getData() {
		return data;
	}

	/**
	 * @return the constraints
	 */
	public Constraints getConstraints() {
		return constraints;
	}

	/**
	 * @return the testFunction
	 */
	public TestFunction getTestFunction() {
		return testFunction;
	}

	/**
	 * @return the mathShortcuts
	 */
	public MathShortcuts getMathShortcuts() {
		return mathShortcuts;
	}

	/**
	 * @return the calculatedFunction
	 */
	public CalculatedFunction getCalculatedFunction() {
		return calculatedFunction;
	}

	/**
	 * @return the display
	 */
	public DisplaySettings getDisplay() {
		return display;
	}

	/**
	 * @return the toolsPanel
	 */
	public ToolsPanel getToolsPanel() {
		return toolsPanel;
	}

	/**
	 * @return the dataPanel
	 */
	public DataPanel getDataPanel() {
		return dataPanel;
	}

	/**
	 * @return the constraintsPanel
	 */
	public ConstraintsPanel getConstraintsPanel() {
		return constraintsPanel;
	}

	/**
	 * @return the testFunctionPanel
	 */
	public TestFunctionPanel getTestFunctionPanel() {
		return testFunctionPanel;
	}

	/**
	 * @return the mathShortcutsPanel
	 */
	public MathShortcutsPanel getMathShortcutsPanel() {
		return mathShortcutsPanel;
	}

	/**
	 * @return the calculatedFunctionPanel
	 */
	public CalculatedFunctionPanel getCalculatedFunctionPanel() {
		return calculatedFunctionPanel;
	}

	/**
	 * @return the displayPanel
	 */
	public DisplaySettingsPanel getDisplaySettingsPanel() {
		return displayPanel;
	}

	/**
	 * @return the contentPanel
	 */
	public JPanel getContentPanel() {
		return contentPanel;
	}

	/**
	 * @return the transformationsLinePanel
	 */
	public TransformationsLinePanel getTransformationsLinePanel() {
		return transformationsLinePanel;
	}

	/**
	 * @return the transformedData
	 */
	public Data getTransformedData() {
		return transformedData;
	}

	/**
	 * @return the transformedDataPanel
	 */
	public DataPanel getTransformedDataPanel() {
		return transformedDataPanel;
	}

	/**
	 * @return the noConstraint
	 */
	public JPanel getNoConstraint() {
		return noConstraint;
	}

	/**
	 * @return the pointConstraint
	 */
	public PointConstraint getPointConstraint() {
		return pointConstraint;
	}

	/**
	 * @return the slopeConstraint
	 */
	public SlopeConstraintPanel getSlopeConstraint() {
		return slopeConstraint;
	}

	/**
	 * @return the chosenPanel
	 */
	public LineConstraintsChoicePanel getChosenPanel() {
		return chosenPanel;
	}

	/**
	 * @return the transformationsLine
	 */
	public TransformationsLine getTransformationsLine() {
		return transformationsLine;
	}

	/**
	 * @return the lineConstraintsChoice
	 */
	public LineConstraintsChoice getLineConstraintsChoice() {
		return lineConstraintsChoice;
	}

	@Override
	public TransformX getTransformX() {
		return getTransformationsLine().getTransformX();
	}

	@Override
	public TransformY getTransformY() {
		return getTransformationsLine().getTransformY();
	}

	public LineGraph getLineGraph() {
		return lineGraph;
	}

}
