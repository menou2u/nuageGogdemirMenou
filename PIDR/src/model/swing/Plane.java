package model.swing;

import java.awt.Component;

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

import view.panels.DataPanel;
import view.panels.DisplaySettingsPanel;
import view.panels.MathShortcutsPanel;
import view.panels.PlaneConstraintsChoicePanel;
import view.panels.TransformationsPlanePanel;

public class Plane implements Updatable {
	
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
	private PlaneGraph planeGraph;
	
	public Plane() {
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
		planeGraph = new PlaneGraph();
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
        Chart chart = new Chart();
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

	@Override
	public TransformX getTransformX() {
		return null;
	}

	@Override
	public TransformY getTransformY() {
		return null;
	}

	@Override
	public TestFunction getTestFunction() {
		return null;
	}

	public PlaneGraph getPlaneGraph() {
		return planeGraph;
	}
	
	
}
