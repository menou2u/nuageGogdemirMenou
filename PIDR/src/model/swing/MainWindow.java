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
import view.panels.MathShortcutsPanel;
import view.panels.TestFunctionPanel;
import view.panels.ToolsPanel;

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
	
	public MainWindow() {
		menu = new Menu();
		tools = new Tools(this);
		data = new Data();
		constraints = new Constraints();
		testFunction = new TestFunction();
		calculatedFunction = new CalculatedFunction();
		mathShortcuts = new MathShortcuts(testFunction);
		display = new DisplaySettings();
		toolsPanel = new ToolsPanel(tools);
		dataPanel = new DataPanel(data);
		constraintsPanel = new ConstraintsPanel(constraints);
		testFunctionPanel = new TestFunctionPanel(testFunction);
		mathShortcutsPanel = new MathShortcutsPanel(mathShortcuts);
		calculatedFunctionPanel = new CalculatedFunctionPanel(calculatedFunction);
		displayPanel = new DisplaySettingsPanel(display);
		contentPanel = new JPanel();
	}
	
	public void setCalculatedFunctionPanel(CalculatedFunctionPanel calculatedFunctionPanel) {
		this.calculatedFunctionPanel = calculatedFunctionPanel;
	}
	
	public Menu getMenu() {
		return menu;
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
			dmc.init(data.getX(), data.getY(), 0, 0, 0, 1);
			dmc.testConseil();
		}
		setChanged();
		notifyObservers();
	}

}
