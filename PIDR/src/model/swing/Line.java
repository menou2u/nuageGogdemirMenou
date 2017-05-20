package model.swing;

import java.awt.Component;

import javax.swing.JPanel;

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
	
	public Line(Tools tools) {
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
		transformationsLine = new TransformationsLine();
		transformationsLinePanel = new TransformationsLinePanel(transformationsLine);
		contentPanel = new JPanel();
		lineConstraintsChoice = new LineConstraintsChoice();
		chosenPanel = new LineConstraintsChoicePanel(lineConstraintsChoice);
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
	public DisplaySettingsPanel getDisplayPanel() {
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
	
	
}
