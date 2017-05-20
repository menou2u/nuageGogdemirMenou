package model.swing;

import view.panels.DataPanel;
import view.panels.DisplaySettingsPanel;
import view.panels.MathShortcutsPanel;
import view.panels.PlaneConstraintsChoicePanel;
import view.panels.TransformationsPlanePanel;

@SuppressWarnings("serial")
public class Plane extends Onglet {
	
	private TransformationsPlanePanel transformationPlanePanel;
	private MathShortcuts mathShortcutsPlane;
	private MathShortcutsPanel mathShortcutsPlanePanel;
	private Data planeData;
	private Data transformedPlaneData;
	private DataPanel dataPlanePanel;
	private PlaneConstraintsChoicePanel planeConstraintsChoicePanel;
	private DisplaySettings planeDisplay;
	private DisplaySettingsPanel displayPlanePanel;
	private TestFunction testFunctionPlane;
	
	public Plane() {
		testFunctionPlane = new TestFunction("(x;y)");
		mathShortcutsPlane = new MathShortcuts(testFunctionPlane);
		transformationPlanePanel = new TransformationsPlanePanel(new TransformationsPlane());
		mathShortcutsPlanePanel = new MathShortcutsPanel(mathShortcutsPlane);
		
		planeData = new Data("n°", "xi", "yi", "zi");
		transformedPlaneData = new Data("Xi = tx(xi)","Yi = ty(yi)","Zi = tz(zi)");
		dataPlanePanel = new DataPanel(planeData,transformedPlaneData);
		
		planeConstraintsChoicePanel = new PlaneConstraintsChoicePanel(new PlaneConstraintsChoice());
		planeDisplay = new DisplaySettings();
		displayPlanePanel = new DisplaySettingsPanel(planeDisplay);
	}

	@Override
	public Data getData() {
		return planeData;
	}

	/**
	 * @return the transformationPlanePanel
	 */
	public TransformationsPlanePanel getTransformationPlanePanel() {
		return transformationPlanePanel;
	}

	/**
	 * @return the mathShortcutsPlane
	 */
	public MathShortcuts getMathShortcutsPlane() {
		return mathShortcutsPlane;
	}

	/**
	 * @return the mathShortcutsPlanePanel
	 */
	public MathShortcutsPanel getMathShortcutsPlanePanel() {
		return mathShortcutsPlanePanel;
	}

	/**
	 * @return the planeData
	 */
	public Data getPlaneData() {
		return planeData;
	}

	/**
	 * @return the transformedPlaneData
	 */
	public Data getTransformedPlaneData() {
		return transformedPlaneData;
	}

	/**
	 * @return the dataPlanePanel
	 */
	public DataPanel getDataPlanePanel() {
		return dataPlanePanel;
	}

	/**
	 * @return the planeConstraintsChoicePanel
	 */
	public PlaneConstraintsChoicePanel getPlaneConstraintsChoicePanel() {
		return planeConstraintsChoicePanel;
	}

	/**
	 * @return the planeDisplay
	 */
	public DisplaySettings getPlaneDisplay() {
		return planeDisplay;
	}

	/**
	 * @return the displayPlanePanel
	 */
	public DisplaySettingsPanel getDisplayPlanePanel() {
		return displayPlanePanel;
	}

	/**
	 * @return the testFunctionPlane
	 */
	public TestFunction getTestFunctionPlane() {
		return testFunctionPlane;
	}
	
	
}
