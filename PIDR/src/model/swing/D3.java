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

@SuppressWarnings("serial")
public class D3 extends Onglet {

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
	
	public D3() {
		// Datas
		threeDDatas = new Data("N°","Xi","Yi","Zi");
		threeDDatasPane = new DataPanel(threeDDatas);
		//Contraintes
		threeDConstraints = new Constraints(new String[]{"N°","Xw","Yw","Valeur contrainte","Ordre de dérivation","Ux","Uy"});
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
		return threeDDatas;
	}

	/**
	 * @return the threeDDatas
	 */
	public Data getThreeDDatas() {
		return threeDDatas;
	}

	/**
	 * @return the threeDDatasPane
	 */
	public DataPanel getThreeDDatasPane() {
		return threeDDatasPane;
	}

	/**
	 * @return the threeDConstraints
	 */
	public Constraints getThreeDConstraints() {
		return threeDConstraints;
	}

	/**
	 * @return the threeDConstraintsPane
	 */
	public ConstraintsPanel getThreeDConstraintsPane() {
		return threeDConstraintsPane;
	}

	/**
	 * @return the threeDTestFunction
	 */
	public TestFunction getThreeDTestFunction() {
		return threeDTestFunction;
	}

	/**
	 * @return the threeDTestFunctionPane
	 */
	public TestFunctionPanel getThreeDTestFunctionPane() {
		return threeDTestFunctionPane;
	}

	/**
	 * @return the threeDMathShortcuts
	 */
	public MathShortcuts getThreeDMathShortcuts() {
		return threeDMathShortcuts;
	}

	/**
	 * @return the threeDMathShortcutsPane
	 */
	public MathShortcutsPanel getThreeDMathShortcutsPane() {
		return threeDMathShortcutsPane;
	}

	/**
	 * @return the threeDCalculatedFunction
	 */
	public CalculatedFunction getThreeDCalculatedFunction() {
		return threeDCalculatedFunction;
	}

	/**
	 * @return the threeDCalculatedFunctionPane
	 */
	public CalculatedFunctionPanel getThreeDCalculatedFunctionPane() {
		return threeDCalculatedFunctionPane;
	}

	/**
	 * @return the threeDDisplaySettings
	 */
	public DisplaySettings getThreeDDisplaySettings() {
		return threeDDisplaySettings;
	}

	/**
	 * @return the threeDDisplaySettingsPane
	 */
	public DisplaySettingsPanel getThreeDDisplaySettingsPane() {
		return threeDDisplaySettingsPane;
	}
	
	
	
}
