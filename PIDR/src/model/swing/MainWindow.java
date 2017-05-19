package model.swing;

import java.awt.Component;
import java.io.File;
import java.util.Observable;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.jzy3d.chart.Chart;
import org.jzy3d.chart.factories.AWTChartComponentFactory;
import org.jzy3d.chart.factories.IChartComponentFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.colors.ColorMapper;
import org.jzy3d.colors.colormaps.ColorMapRainbow;
import org.jzy3d.maths.Range;
import org.jzy3d.plot3d.builder.Builder;
import org.jzy3d.plot3d.builder.Mapper;
import org.jzy3d.plot3d.builder.concrete.OrthonormalGrid;
import org.jzy3d.plot3d.primitives.Shape;
import org.jzy3d.plot3d.rendering.canvas.Quality;

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
	
	private JTabbedPane onglets;
	
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
	private SlopeConstraintPanel slopeConstraint;
	private LineConstraintsChoicePanel chosenPanel;
	private TransformationsLine transformationsLine;

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
	private LineConstraintsChoice lineConstraintsChoice;
	
	public MainWindow() {
		initLinePanel();
		init2DPanel();
		initPlanePanel();
		init3DPanel();
	}
	
	private void init3DPanel() {
		// Datas
		threeDDatas = new Data("N�","Xi","Yi","Zi");
		threeDDatasPane = new DataPanel(threeDDatas);
		//Contraintes
		threeDConstraints = new Constraints(new String[]{"N�","Xw","Yw","Valeur contrainte","Ordre de d�rivation","Ux","Uy"});
		threeDConstraintsPane = new ConstraintsPanel(threeDConstraints);
		//Fonction de Test
		threeDTestFunction = new TestFunction("(x;y)");
		threeDTestFunctionPane = new TestFunctionPanel(threeDTestFunction);
		//Calculette
		threeDMathShortcuts = new MathShortcuts(threeDTestFunction);
		threeDMathShortcutsPane = new MathShortcutsPanel(threeDMathShortcuts);
		//Fonction calcul�e
		threeDCalculatedFunction = new CalculatedFunction("f(x;y) = ");
		threeDCalculatedFunctionPane = new CalculatedFunctionPanel(threeDCalculatedFunction);
		//Partie display
		threeDDisplaySettings = new DisplaySettings();
		threeDDisplaySettingsPane = new DisplaySettingsPanel(threeDDisplaySettings);
	}

	private void init2DPanel() {
		// Datas
		twoDDatas = new Data("N�","Xi","Yi");
		twoDDatasPane = new DataPanel(twoDDatas);
		//Contraintes
		twoDConstraints = new Constraints(new String[]{"N�","Xw","Valeur contrainte","Ordre de d�rivation"});
		twoDConstraintsPane = new ConstraintsPanel(twoDConstraints);
		//Fonction de Test
		twoDTestFunction = new TestFunction("(x)");
		twoDTestFunctionPane = new TestFunctionPanel(twoDTestFunction);
		//Calculette
		twoDMathShortcuts = new MathShortcuts(twoDTestFunction);
		twoDMathShortcutsPane = new MathShortcutsPanel(twoDMathShortcuts);
		//Fonction calcul�e
		twoDCalculatedFunction = new CalculatedFunction("f(x) = ");
		twoDCalculatedFunctionPane = new CalculatedFunctionPanel(twoDCalculatedFunction);
		//Partie display
		twoDDisplaySettings = new DisplaySettings();
		twoDDisplaySettingsPane = new DisplaySettingsPanel(twoDDisplaySettings);
	}

	public void initLinePanel(){
		tools = new Tools(this);
		data = new Data("n�","xi","yi");
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
		transformationsLine = new TransformationsLine();
		transformationsLinePanel = new TransformationsLinePanel(transformationsLine);
		contentPanel = new JPanel();
		lineConstraintsChoice = new LineConstraintsChoice();
		chosenPanel = new LineConstraintsChoicePanel(lineConstraintsChoice);
	}
	
	public void initPlanePanel(){
		testFunctionPlane = new TestFunction("(x;y)");
		mathShortcutsPlane = new MathShortcuts(testFunctionPlane);
		transformationPlanePanel = new TransformationsPlanePanel(new TransformationsPlane());
		mathShortcutsPlanePanel = new MathShortcutsPanel(mathShortcutsPlane);
		
		planeData = new Data("n�", "xi", "yi", "zi");
		transformedPlaneData = new Data("Xi = tx(xi)","Yi = ty(yi)","Zi = tz(zi)");
		dataPlanePanel = new DataPanel(planeData,transformedPlaneData);
		
		planeConstraintsChoicePanel = new PlaneConstraintsChoicePanel(new PlaneConstraintsChoice());
		planeDisplay = new DisplaySettings();
		displayPlanePanel = new DisplaySettingsPanel(planeDisplay);
	}
	
	public Component getVisualisationPanel() {
		// Define a function to plot
        Mapper mapper = new Mapper() {
            @Override
            public double f(double x, double y) {
                //return x * Math.sin(x * y);
            	return 0;
            }
        };

        // Define range and precision for the function to plot
        Range range = new Range(1, 5);
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
		Component canvas = (Component) chart.getCanvas();
		
		//JPanel panel = new JPanel();
		//panel.add(canvas, BorderLayout.CENTER);
		return canvas;
		//return new JPanel(); 
	}

	public void sendNewFile(File file) {
		data.warnView(file);
	}

	public void runMath() {
		if (!data.getPath().equals("")){
			setChanged();
			notifyObservers("exec");
		}
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
	
	public SlopeConstraintPanel getSlopeConstraint(){
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

	/**
	 * @param dataPanel the dataPanel to set
	 */
	public void setDataPanel(DataPanel dataPanel) {
		this.dataPanel = dataPanel;
	}
	
	/**
	 * @return the onglets
	 */
	public JTabbedPane getOnglets() {
		return onglets;
	}
	
	/**
	 * @param onglets the onglets to set
	 */
	public void setOnglets(JTabbedPane onglets) {
		this.onglets = onglets;
	}

	public void updateInfos() {
		setChanged();
		notifyObservers("infos");
	}
	
	
	
	

}
