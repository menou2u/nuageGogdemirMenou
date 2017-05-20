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

import view.panels.CalculatedFunctionPanel;
import view.panels.ConstraintsPanel;
import view.panels.DataPanel;
import view.panels.DisplaySettingsPanel;
import view.panels.MathShortcutsPanel;
import view.panels.TestFunctionPanel;

public class D2 implements Updatable{

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
	private D2Graph d2Graph;
	
	public D2() {
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
		d2Graph = new D2Graph();
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
		return twoDDatas;
	}

	/**
	 * @return the twoDDatas
	 */
	public Data getTwoDDatas() {
		return twoDDatas;
	}

	/**
	 * @return the twoDDatasPane
	 */
	public DataPanel getTwoDDatasPane() {
		return twoDDatasPane;
	}

	/**
	 * @return the twoDConstraints
	 */
	public Constraints getTwoDConstraints() {
		return twoDConstraints;
	}

	/**
	 * @return the twoDConstraintsPane
	 */
	public ConstraintsPanel getTwoDConstraintsPane() {
		return twoDConstraintsPane;
	}

	/**
	 * @return the twoDTestFunction
	 */
	private TestFunction getTwoDTestFunction() {
		return twoDTestFunction;
	}

	/**
	 * @return the twoDTestFunctionPane
	 */
	public TestFunctionPanel getTwoDTestFunctionPane() {
		return twoDTestFunctionPane;
	}

	/**
	 * @return the twoDMathShortcuts
	 */
	public MathShortcuts getTwoDMathShortcuts() {
		return twoDMathShortcuts;
	}

	/**
	 * @return the twoDMathShortcutsPane
	 */
	public MathShortcutsPanel getTwoDMathShortcutsPane() {
		return twoDMathShortcutsPane;
	}

	/**
	 * @return the twoDCalculatedFunction
	 */
	public CalculatedFunction getTwoDCalculatedFunction() {
		return twoDCalculatedFunction;
	}

	/**
	 * @return the twoDCalculatedFunctionPane
	 */
	public CalculatedFunctionPanel getTwoDCalculatedFunctionPane() {
		return twoDCalculatedFunctionPane;
	}

	/**
	 * @return the twoDDisplaySettings
	 */
	public DisplaySettings getTwoDDisplaySettings() {
		return twoDDisplaySettings;
	}

	/**
	 * @return the twoDDisplaySettingsPane
	 */
	public DisplaySettingsPanel getTwoDDisplaySettingsPane() {
		return twoDDisplaySettingsPane;
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
		return getTwoDTestFunction();
	}

	public D2Graph getD2Graph() {
		return d2Graph;
	}
	
	
	
}
