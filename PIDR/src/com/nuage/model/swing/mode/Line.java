package com.nuage.model.swing.mode;

import javax.swing.JPanel;

import com.nuage.model.swing.DisplaySettings;
import com.nuage.model.swing.MathShortcuts;
import com.nuage.model.swing.datas.TestFunction;
import com.nuage.model.swing.datas.TransformX;
import com.nuage.model.swing.datas.TransformY;
import com.nuage.model.swing.datas.TransformationsLine;
import com.nuage.model.swing.datas.constraints.Constraints;
import com.nuage.model.swing.datas.constraints.LineConstraintsChoice;
import com.nuage.model.swing.datas.constraints.SlopeConstraintPanel;
import com.nuage.model.swing.datas.tables.DataLinePanel;
import com.nuage.model.swing.datas.tables.TableCustom2DModel;
import com.nuage.view.panels.ConstraintsPanel;
import com.nuage.view.panels.DisplaySettingsPanel;
import com.nuage.view.panels.LineConstraintsChoicePanel;
import com.nuage.view.panels.MathShortcutsPanel;
import com.nuage.view.panels.ToolsPanel;
import com.nuage.view.panels.TransformationsLinePanel;

public class Line implements Updatable {

	private Constraints constraints;
	private TestFunction testFunction;
	private MathShortcuts mathShortcuts;
	private DisplaySettings display;
	private ToolsPanel toolsPanel;
	private ConstraintsPanel constraintsPanel;
	private MathShortcutsPanel mathShortcutsPanel;
	private DisplaySettingsPanel displayPanel;
	private TransformationsLinePanel transformationsLinePanel;
	private JPanel noConstraint;
	private SlopeConstraintPanel slopeConstraint;
	private LineConstraintsChoicePanel chosenPanel;
	private TransformationsLine transformationsLine;
	private LineConstraintsChoice lineConstraintsChoice;
	private LineGraph lineGraph;
	private TableCustom2DModel dataModel;
	private DataLinePanel dataLinePanel;

	public Line() {
		testFunction = new TestFunction("(x)");

		mathShortcuts = new MathShortcuts(testFunction);
		mathShortcutsPanel = new MathShortcutsPanel(mathShortcuts);

		transformationsLine = new TransformationsLine();
		transformationsLinePanel = new TransformationsLinePanel(transformationsLine);

		dataModel = new TableCustom2DModel(new String[] { "n�", "xi", "yi" });
		dataLinePanel = new DataLinePanel(dataModel, "", "");

		lineConstraintsChoice = new LineConstraintsChoice();
		chosenPanel = new LineConstraintsChoicePanel(lineConstraintsChoice);

		display = new DisplaySettings();

		// transformedDataPanel = new DataPanel(transformedData);

		lineGraph = new LineGraph("Repr�sentation graphique");
		displayPanel = new DisplaySettingsPanel(display);
	}

	/**
	 * @return the displayPanel
	 */
	public DisplaySettingsPanel getDisplayPanel() {
		return displayPanel;
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
	@Override
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
	 * @return the constraintsPanel
	 */
	public ConstraintsPanel getConstraintsPanel() {
		return constraintsPanel;
	}

	/**
	 * @return the mathShortcutsPanel
	 */
	public MathShortcutsPanel getMathShortcutsPanel() {
		return mathShortcutsPanel;
	}

	/**
	 * @return the displayPanel
	 */
	public DisplaySettingsPanel getDisplaySettingsPanel() {
		return displayPanel;
	}

	/**
	 * @return the transformationsLinePanel
	 */
	public TransformationsLinePanel getTransformationsLinePanel() {
		return transformationsLinePanel;
	}

	/**
	 * @return the noConstraint
	 */
	public JPanel getNoConstraint() {
		return noConstraint;
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

	@Override
	public TableCustom2DModel getData() {
		return getDataModel();
	}

	/**
	 * @return the dataModel
	 */
	@Override
	public TableCustom2DModel getDataModel() {
		return dataModel;
	}

	/**
	 * @return the dataLinePanel
	 */
	public DataLinePanel getDataLinePanel() {
		return dataLinePanel;
	}

}
