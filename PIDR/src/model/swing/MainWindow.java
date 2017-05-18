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
import view.panels.TestFunctionPanel;
import view.panels.ToolsPanel;
import view.panels.TransformationsLinePanel;
import view.panels.TransformationsPlanePanel;

public class MainWindow extends Observable {

	private String functionMode;
	private static final String LINE = "Line";
	private static final String PLANE = "Plane";
	private static final String D2 = "2D";
	private static final String D3 = "3D";
	
	//Partie Ligne
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

	//Partie Plans
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
	
	//Partie 2D
	private Data twoDDatas;
	private DataPanel twoDDatasPane;
	private Constraints twoDConstraints;
	private ConstraintsPanel twoDConstraintsPane;
	private TestFunction twoDTestFunction;
	private TestFunctionPanel twoDTestFunctionPane;
	private MathShortcuts twoDMathShortcuts;
	private MathShortcutsPanel twoDMathShortcutsPane;
	private CalculatedFunction twoDCalculatedFunction;
	private CalculatedFunctionPanel twoDCalculatedFunctionPane;
	private DisplaySettings twoDDisplaySettings;
	private DisplaySettingsPanel twoDDisplaySettingsPane;
	
	//Partie 3D
	private Data threeDDatas;
	private DataPanel threeDDatasPane;
	private Constraints threeDConstraints;
	private ConstraintsPanel threeDConstraintsPane;
	private TestFunction threeDTestFunction;
	private TestFunctionPanel threeDTestFunctionPane;
	private MathShortcuts threeDMathShortcuts;
	private MathShortcutsPanel threeDMathShortcutsPane;
	private CalculatedFunction threeDCalculatedFunction;
	private CalculatedFunctionPanel threeDCalculatedFunctionPane;
	private DisplaySettings threeDDisplaySettings;
	private DisplaySettingsPanel threeDDisplaySettingsPane;
	
	public MainWindow() {
		initLinePanel();
		init2DPanel();
		initPlanePanel();
		init3DPanel();
	}
	
	private void init3DPanel() {
		functionMode = D3;
		// Datas
		threeDDatas = new Data("N°","Xi","Yi","Zi");
		threeDDatasPane = new DataPanel(threeDDatas);
		//Contraintes
		threeDConstraints = new Constraints(new String[]{"N°","Xw","Yw","Valeur contrainte","Ordre de dérivation","Valeur contrainte","Ordre de dérivation","Ux","Uy"});
		threeDConstraintsPane = new ConstraintsPanel(threeDConstraints);
		//Fonction de Test
		threeDTestFunction = new TestFunction("(x;y)");
		threeDTestFunctionPane = new TestFunctionPanel(threeDTestFunction);
		//Calculette
		threeDMathShortcuts = new MathShortcuts(threeDTestFunction);
		threeDMathShortcutsPane = new MathShortcutsPanel(threeDMathShortcuts);
		//Fonction calculée
		threeDCalculatedFunction = new CalculatedFunction("f(x;y) = ");
		threeDCalculatedFunctionPane = new CalculatedFunctionPanel(threeDCalculatedFunction);
		//Partie display
		threeDDisplaySettings = new DisplaySettings();
		threeDDisplaySettingsPane = new DisplaySettingsPanel(threeDDisplaySettings);
	}

	private void init2DPanel() {
		functionMode = D2;
		// Datas
		twoDDatas = new Data("N°","Xi","Yi");
		twoDDatasPane = new DataPanel(twoDDatas);
		//Contraintes
		twoDConstraints = new Constraints(new String[]{"N°","Xw","Valeur contrainte","Ordre de dérivation"});
		twoDConstraintsPane = new ConstraintsPanel(twoDConstraints);
		//Fonction de Test
		twoDTestFunction = new TestFunction("(x)");
		twoDTestFunctionPane = new TestFunctionPanel(twoDTestFunction);
		//Calculette
		twoDMathShortcuts = new MathShortcuts(twoDTestFunction);
		twoDMathShortcutsPane = new MathShortcutsPanel(twoDMathShortcuts);
		//Fonction calculée
		twoDCalculatedFunction = new CalculatedFunction("f(x) = ");
		twoDCalculatedFunctionPane = new CalculatedFunctionPanel(twoDCalculatedFunction);
		//Partie display
		twoDDisplaySettings = new DisplaySettings();
		twoDDisplaySettingsPane = new DisplaySettingsPanel(twoDDisplaySettings);
	}

	public void initLinePanel(){
		functionMode = LINE;
		tools = new Tools(this);
		data = new Data("n°","xi","yi");
		transformedData = new Data("Xi = tx(xi)","Yi = ty(yi)");
		testFunction = new TestFunction("(x)");
		calculatedFunction = new CalculatedFunction("f(x) = ");
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
		chosenPanel = new LineConstraintsChoicePanel();
	}
	
	public void initPlanePanel(){
		functionMode = PLANE;
		testFunctionPlane = new TestFunction("(x;y)");
		mathShortcutsPlane = new MathShortcuts(testFunctionPlane);
		transformationPlanePanel = new TransformationsPlanePanel();
		mathShortcutsPlanePanel = new MathShortcutsPanel(mathShortcutsPlane);
		
		planeData = new Data("n°", "xi", "yi", "zi");
		transformedPlaneData = new Data("Xi = tx(xi)","Yi = ty(yi)","Zi = tz(zi)");
		dataPlanePanel = new DataPanel(planeData,transformedPlaneData);
		
		planeConstraintsChoicePanel = new PlaneConstraintsChoicePanel();
		planeDisplay = new DisplaySettings();
		displayPlanePanel = new DisplaySettingsPanel(planeDisplay);
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

	public void sendNewFile(File file) {
		data.updateTableContent(file.getPath());
		dataPanel = new DataPanel(data);
		setChanged();
		notifyObservers();
	}

	public void runMath() {
		if (!data.getPath().equals("")){
			switch (functionMode) {
			case LINE:
				DroiteMoindreCarres dmc = new DroiteMoindreCarres();
				dmc.run(data.getX(), data.getY(), chosenPanel.getCommutateur(), pointConstraint.getOmegaDatas(), Double.parseDouble(slopeConstraint.getSlope().getText()));
				/*if (pointConstraint.getOmegaDatas().size() > 0)
				notifyObservers(dmc.get);*/
				break;
			case PLANE:
				
				break;
			case D2:
				
				break;
			case D3:
				
				break;
			default:
				break;
			}
		}
		setChanged();
		notifyObservers();
	}
	
	public DataPanel getTransformedDataPanel() {
		return transformedDataPanel;
	}

	public Chart getChart() {
		return chart;
	}
	
	public Data getThreeDDatas() {
		return threeDDatas;
	}

	public DataPanel getThreeDDatasPane() {
		return threeDDatasPane;
	}

	public Constraints getThreeDConstraints() {
		return threeDConstraints;
	}

	public ConstraintsPanel getThreeDConstraintsPane() {
		return threeDConstraintsPane;
	}

	public TestFunction getThreeDTestFunction() {
		return threeDTestFunction;
	}

	public TestFunctionPanel getThreeDTestFunctionPane() {
		return threeDTestFunctionPane;
	}

	public MathShortcuts getThreeDMathShortcuts() {
		return threeDMathShortcuts;
	}

	public MathShortcutsPanel getThreeDMathShortcutsPane() {
		return threeDMathShortcutsPane;
	}

	public CalculatedFunction getThreeDCalculatedFunction() {
		return threeDCalculatedFunction;
	}

	public CalculatedFunctionPanel getThreeDCalculatedFunctionPane() {
		return threeDCalculatedFunctionPane;
	}

	public DisplaySettings getThreeDDisplaySettings() {
		return threeDDisplaySettings;
	}

	public DisplaySettingsPanel getThreeDDisplaySettingsPane() {
		return threeDDisplaySettingsPane;
	}

	public Data getTwoDDatas() {
		return twoDDatas;
	}

	public DataPanel getTwoDDatasPane() {
		return twoDDatasPane;
	}

	public Constraints getTwoDConstraints() {
		return twoDConstraints;
	}

	public ConstraintsPanel getTwoDConstraintsPane() {
		return twoDConstraintsPane;
	}

	public TestFunction getTwoDTestFunction() {
		return twoDTestFunction;
	}

	public TestFunctionPanel getTwoDTestFunctionPane() {
		return twoDTestFunctionPane;
	}

	public MathShortcuts getTwoDMathShortcuts() {
		return twoDMathShortcuts;
	}

	public MathShortcutsPanel getTwoDMathShortcutsPane() {
		return twoDMathShortcutsPane;
	}

	public CalculatedFunction getTwoDCalculatedFunction() {
		return twoDCalculatedFunction;
	}

	public CalculatedFunctionPanel getTwoDCalculatedFunctionPane() {
		return twoDCalculatedFunctionPane;
	}

	public DisplaySettings getTwoDDisplaySettings() {
		return twoDDisplaySettings;
	}

	public DisplaySettingsPanel getTwoDDisplaySettingsPane() {
		return twoDDisplaySettingsPane;
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

	/**
	 * @return the functionMode
	 */
	public String getFunctionMode() {
		return functionMode;
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
	 * @return the noConstraint
	 */
	public JPanel getNoConstraint() {
		return noConstraint;
	}
	
	

}
