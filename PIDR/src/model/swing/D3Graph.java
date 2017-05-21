package model.swing;

import java.awt.Component;
import java.util.Observable;

import org.jzy3d.chart.AWTChart;
import org.jzy3d.chart.ChartLauncher;
import org.jzy3d.chart.factories.IChartComponentFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.colors.ColorMapper;
import org.jzy3d.colors.colormaps.ColorMapRainbow;
import org.jzy3d.javafx.JavaFXChartFactory;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.maths.Range;
import org.jzy3d.plot3d.builder.Builder;
import org.jzy3d.plot3d.builder.Mapper;
import org.jzy3d.plot3d.primitives.ScatterMultiColor;
import org.jzy3d.plot3d.primitives.Shape;
import org.jzy3d.plot3d.rendering.canvas.Quality;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class D3Graph extends Observable {

	private AWTChart chart;
	private JFXPanel panel;

	public D3Graph() {
		int size = 100000;
		float x;
		float y;
		float z;
		Coord3d[] points = new Coord3d[size];

		@SuppressWarnings("unused")
		Mapper mapper = new Mapper() {
			@Override
			public double f(double x, double y) {
				// return x * Math.sin(x * y);
				return Math.sin(x) + Math.cos(y);
			}
		};

		// Create scatter points
		for (int i = 0; i < size; i++) {
			x = (float) Math.random() - 0.5f;
			y = (float) Math.random() - 0.5f;
			z = (float) Math.random() - 0.5f;
			points[i] = new Coord3d(x, y, z);
		}

		// Create a drawable scatter with a colormap
		ScatterMultiColor scatter = new ScatterMultiColor(points, new ColorMapper(new ColorMapRainbow(), -0.5f, 0.5f));

		// Create a chart and add scatter
		JavaFXChartFactory factory = new JavaFXChartFactory();
		chart = getDemoChart(factory, "offscreen");
		ImageView imageView = factory.bindImageView(chart);

        // JavaFX
		panel = new JFXPanel();
        StackPane pane = new StackPane();
        Scene scene = new Scene(pane);
        panel.setScene(scene);
        Platform.runLater(new Runnable() {
			public void run() {
		        pane.getChildren().add(imageView);				
			}
		});

        //factory.addSceneSizeChangedListener(chart, scene);
        
	}

	public Component getCanvas() {
		return panel;
	}
	private AWTChart getDemoChart(JavaFXChartFactory factory, String toolkit) {
        // -------------------------------
        // Define a function to plot
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
        final Shape surface = Builder.buildOrthonormal(mapper, range, steps);
        surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), surface.getBounds().getZmin(), surface.getBounds().getZmax(), new Color(1, 1, 1, .5f)));
        surface.setFaceDisplayed(true);
        surface.setWireframeDisplayed(false);

        // -------------------------------
        // Create a chart
        Quality quality = Quality.Advanced;
        //quality.setSmoothPolygon(true);
        //quality.setAnimated(true);
        
        // let factory bind mouse and keyboard controllers to JavaFX node
        AWTChart chart = (AWTChart) factory.newChart(quality, toolkit);
        chart.getScene().getGraph().add(surface);
        return chart;
    }
}
