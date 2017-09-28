package com.nuage.model.swing.mode;

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

import com.nuage.model.swing.DisplaySettings;
import com.nuage.model.swing.MathShortcuts;
import com.nuage.model.swing.datas.Data;
import com.nuage.model.swing.datas.TestFunction;
import com.nuage.model.swing.datas.TransformX;
import com.nuage.model.swing.datas.TransformY;
import com.nuage.model.swing.datas.TransformZ;
import com.nuage.model.swing.datas.TransformationsPlane;
import com.nuage.model.swing.datas.constraints.PlaneConstraintsChoice;
import com.nuage.model.swing.datas.tables.TableCustom3DModel;
import com.nuage.view.panels.DataPlanePanel;
import com.nuage.view.panels.DisplaySettingsPanel;
import com.nuage.view.panels.MathShortcutsPanel;
import com.nuage.view.panels.PlaneConstraintsChoicePanel;
import com.nuage.view.panels.TransformationsPlanePanel;

public class Plane implements Updatable {

	private TransformationsPlanePanel transformationPlanePanel;
	private TransformationsPlane transformationPlane;
	private MathShortcuts mathShortcutsPlane;
	private MathShortcutsPanel mathShortcutsPlanePanel;
	private TableCustom3DModel planeData;
	private Data transformedPlaneData;
	private PlaneConstraintsChoicePanel planeConstraintsChoicePanel;
	private DisplaySettings planeDisplay;
	private DisplaySettingsPanel displayPlanePanel;
	private TestFunction testFunctionPlane;
	private PlaneGraph planeGraph;
	private DataPlanePanel dataPlanePanel;
	private PlaneConstraintsChoice planeConstraintsChoice;

	public Plane() {
		testFunctionPlane = new TestFunction("(x;y)");
		mathShortcutsPlane = new MathShortcuts(testFunctionPlane);
		transformationPlane = new TransformationsPlane();
		transformationPlanePanel = new TransformationsPlanePanel(transformationPlane);
		mathShortcutsPlanePanel = new MathShortcutsPanel(mathShortcutsPlane);

		planeData = new TableCustom3DModel(new String[] { "n°", "Xi", "Yi", "Zi" });
		dataPlanePanel = new DataPlanePanel(planeData, "", "", "");

		planeConstraintsChoice = new PlaneConstraintsChoice();
		planeConstraintsChoicePanel = new PlaneConstraintsChoicePanel(planeConstraintsChoice);
		planeDisplay = new DisplaySettings();
		displayPlanePanel = new DisplaySettingsPanel(planeDisplay);
		planeGraph = new PlaneGraph();
	}

	public Component getVisualisationPanel() {
		// Define a function to plot
		Mapper mapper = new Mapper() {
			@Override
			public double f(double x, double y) {
				// return x * Math.sin(x * y);
				return 0;
			}
		};

		// Define range and precision for the function to plot
		Range range = new Range(1, 5);
		int steps = 80;

		// Create the object to represent the function over the given range.
		final Shape surface = Builder.buildOrthonormal(new OrthonormalGrid(range, steps, range, steps), mapper);
		surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), surface.getBounds().getZmin(),
				surface.getBounds().getZmax(), new Color(1, 1, 1, .5f)));
		surface.setFaceDisplayed(true);
		surface.setWireframeDisplayed(false);

		// Create a chart
		Chart chart = new Chart();
		chart = AWTChartComponentFactory.chart(Quality.Advanced, IChartComponentFactory.Toolkit.swing);
		chart.getScene().getGraph().add(surface);

		chart.addMouseCameraController();
		chart.addMousePickingController(2);
		/*
		 * AWTCameraMouseController controller = new
		 * AWTCameraMouseController(chart);
		 * 
		 * addMouseListener(controller); addMouseMotionListener(controller);
		 * addMouseWheelListener(controller);
		 */
		Component canvas = (Component) chart.getCanvas();

		// JPanel panel = new JPanel();
		// panel.add(canvas, BorderLayout.CENTER);
		return canvas;
		// return new JPanel();
	}

	public PlaneConstraintsChoice getPlaneConstraintsChoice() {
		return planeConstraintsChoice;
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
	 * @return the transformedPlaneData
	 */
	public Data getTransformedPlaneData() {
		return transformedPlaneData;
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

	public TransformationsPlane getTransformationsPlane() {
		return transformationPlane;
	}

	@Override
	public TransformX getTransformX() {
		return transformationPlane.getTransformX();
	}

	@Override
	public TransformY getTransformY() {
		return transformationPlane.getTransformY();
	}

	public TransformZ getTransformZ() {
		return transformationPlane.getTransformZ();
	}

	@Override
	public TestFunction getTestFunction() {
		return null;
	}

	public PlaneGraph getPlaneGraph() {
		return planeGraph;
	}

	@Override
	public TableCustom3DModel getData() {
		// TODO Auto-generated method stub
		return getDataModel();
	}

	/**
	 * @return the planeData
	 */
	@Override
	public TableCustom3DModel getDataModel() {
		return planeData;
	}

	/**
	 * @return the dataPlanePanel
	 */
	public DataPlanePanel getDataPlanePanel() {
		return dataPlanePanel;
	}

}
