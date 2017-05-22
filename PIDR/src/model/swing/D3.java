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
import view.panels.Data3DPanel;
import view.panels.DataPanel;
import view.panels.DisplaySettingsPanel;
import view.panels.MathShortcutsPanel;
import view.panels.TestFunctionPanel;

public class D3 implements Updatable {

	private TableCustom3DModel threeDDatas;
	private Data3DPanel threeDDatasPane;
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
	private D3Graph d3Graph;
	
	public D3() {
		// Datas
		threeDDatas = new TableCustom3DModel(new String[]{"N�","Xi","Yi","Zi"});
		threeDDatasPane = new Data3DPanel(threeDDatas);
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
		threeDCalculatedFunction = new CalculatedFunction("f(x;y) = ", "x0;y0");
		threeDCalculatedFunctionPane = new CalculatedFunctionPanel(threeDCalculatedFunction);
		//Partie display
		threeDDisplaySettings = new DisplaySettings();
		threeDDisplaySettingsPane = new DisplaySettingsPanel(threeDDisplaySettings);
		d3Graph = new D3Graph();
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

		addMouseMotionListener(controller);
		addMouseWheelListener(controller);*/
		Component canvas = (Component) chart.getCanvas();
		
		//JPanel panel = new JPanel();
		//panel.add(canvas, BorderLayout.CENTER);
		return canvas;
		//return new JPanel(); 
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
	private TestFunction getThreeDTestFunction() {
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
		return getThreeDTestFunction();
	}

	public D3Graph getD3Graph() {
		return d3Graph;
	}

	/**
	 * @return the threeDDatas
	 */
	public TableCustom3DModel getDataModel() {
		return threeDDatas;
	}

	/**
	 * @return the threeDDatasPane
	 */
	public Data3DPanel getThreeDDatasPane() {
		return threeDDatasPane;
	}

	@Override
	public TableCustom3DModel getData() {
		return getDataModel();
	}
	
	
	
}
