package model.swing;

import java.awt.Component;
import java.io.File;
import java.util.Observable;

import javax.swing.JPanel;

import org.jzy3d.chart.Chart;

import model.math.DroiteMoindreCarres;
import view.panels.CalculatedFunctionPanel;
import view.panels.ConstraintsPanel;
import view.panels.DataPanel;
import view.panels.DisplaySettingsPanel;
import view.panels.LineConstraintsChoicePanel;
import view.panels.MathShortcutsPanel;
import view.panels.PlaneConstraintsChoicePanel;
import view.panels.PointConstraint;
import view.panels.SlopeConstraint;
import view.panels.TestFunctionPanel;
import view.panels.ToolsPanel;
import view.panels.TransformationsLinePanel;
import view.panels.TransformationsPlanePanel;

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
	private Chart chart;
	private TransformationsLinePanel transformationsLinePanel;
	private Data transformedData;
	private DataPanel transformedDataPanel;
	private JPanel noConstraint;
	private PointConstraint pointConstraint;
	private SlopeConstraint slopeConstraint;
	private LineConstraintsChoicePanel chosenPanel;

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
	
	
	
	public MainWindow() {
		
		initLinePanel();
		initPlanePanel();

	}
	
	public void initLinePanel(){
		menu = new Menu();
		tools = new Tools(this);
		data = new Data("n°","xi","yi");
		transformedData = new Data("Xi = tx(xi)","Yi = ty(yi)");
		constraints = new Constraints();
		testFunction = new TestFunction();
		calculatedFunction = new CalculatedFunction();
		mathShortcuts = new MathShortcuts(testFunction);
		display = new DisplaySettings();
		toolsPanel = new ToolsPanel(tools);
		dataPanel = new DataPanel(data,transformedData);
		//transformedDataPanel = new DataPanel(transformedData);
		testFunctionPanel = new TestFunctionPanel(testFunction);
		mathShortcutsPanel = new MathShortcutsPanel(mathShortcuts);
		calculatedFunctionPanel = new CalculatedFunctionPanel(calculatedFunction);
		displayPanel = new DisplaySettingsPanel(display);
		transformationsLinePanel = new TransformationsLinePanel();
		contentPanel = new JPanel();
		chosenPanel = new LineConstraintsChoicePanel(constraints);
	}
	
	public void initPlanePanel(){
		testFunctionPlane = new TestFunction();
		mathShortcutsPlane = new MathShortcuts(testFunctionPlane);
		transformationPlanePanel = new TransformationsPlanePanel();
		mathShortcutsPlanePanel = new MathShortcutsPanel(mathShortcuts);
		planeData = new Data("n°", "xi", "yi", "zi");
		transformedPlaneData = new Data("Xi = tx(xi)","Yi = ty(yi)","Zi = tz(zi)");
		dataPlanePanel = new DataPanel(planeData,transformedPlaneData);
		planeConstraintsChoicePanel = new PlaneConstraintsChoicePanel();
		planeDisplay = new DisplaySettings();
		displayPlanePanel = new DisplaySettingsPanel(planeDisplay);
	}
	
	public void setCalculatedFunctionPanel(CalculatedFunctionPanel calculatedFunctionPanel) {
		this.calculatedFunctionPanel = calculatedFunctionPanel;
	}
	
	public TestFunction getTestFunctionPlane(){
		return testFunctionPlane;
	}
	
	public MathShortcuts getMathShortcutsPlane(){
		return mathShortcutsPlane;
	}
	
	/**
	 * @return the transformationPlanePanel
	 */
	public TransformationsPlanePanel getTransformationPlanePanel() {
		return transformationPlanePanel;
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
	
	public JPanel getNoConstraintPanel(){
		return noConstraint;
	}
	
	public PointConstraint getPointConstraint(){
		return pointConstraint;
	}
	
	public SlopeConstraint getSlopeConstraint(){
		return slopeConstraint;
	}
	
	public Menu getMenu() {
		return menu;
	}

	public LineConstraintsChoicePanel getChosenPanel() {
		return chosenPanel;
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

	public TransformationsLinePanel getTransformationsPanel() {
		return transformationsLinePanel;
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
		/*// Define a function to plot
        Mapper mapper = new Mapper() {
            @Override
            public double f(double x, double y) {
                return x * Math.sin(x * y);
            }
        };

        // Define range and precision for the function to plot
        Range range = new Range(-3, 3);
        int steps = 80;

        // Create the object to represent the function over the given range.
        final Shape surface = Builder.buildOrthonormal(new OrthonormalGrid(range, steps, range, steps), mapper);
        surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), surface.getBounds().getZmin(), surface.getBounds().getZmax(), new Color(1, 1, 1, .5f)));
        surface.setFaceDisplayed(true);
        surface.setWireframeDisplayed(false);

        // Create a chart
        chart = new Chart();
        chart = AWTChartComponentFactory.chart(Quality.Advanced, IChartComponentFactory.Toolkit.swing);
        chart.getScene().getGraph().add(surface);
        
        chart.addMouseCameraController();
        chart.addMousePickingController(2);
        /*AWTCameraMouseController controller = new AWTCameraMouseController(chart);

		addMouseListener(controller);
		addMouseMotionListener(controller);
		addMouseWheelListener(controller);*/
		/*Component canvas = (Component) chart.getCanvas();
		
		//JPanel panel = new JPanel();
		//panel.add(canvas, BorderLayout.CENTER);
		return canvas;*/
		return new JPanel(); 
	}

	public DataPanel getTransformedDataPanel() {
		return transformedDataPanel;
	}

	public Chart getChart() {
		return chart;
	}

	public void sendNewFile(File file) {
		data.updateTableContent(file.getPath());
		dataPanel = new DataPanel(data);
		setChanged();
		notifyObservers();
	}

	public void runMath() {
		if (!data.getPath().equals("")){
			DroiteMoindreCarres dmc = new DroiteMoindreCarres();
			dmc.run(data.getX(), data.getY(), 0, 0, 0, 0);
			System.out.println(dmc.getRes());
		}
		setChanged();
		notifyObservers();
	}

}
