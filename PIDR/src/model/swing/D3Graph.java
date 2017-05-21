package model.swing;

import java.awt.Component;
import java.util.Observable;

import org.jzy3d.chart.Chart;
import org.jzy3d.chart.factories.AWTChartComponentFactory;
import org.jzy3d.chart.factories.IChartComponentFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.colors.ColorMapper;
import org.jzy3d.colors.colormaps.ColorMapRainbow;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.builder.Mapper;
import org.jzy3d.plot3d.primitives.ScatterMultiColor;
import org.jzy3d.plot3d.rendering.canvas.Quality;

public class D3Graph extends Observable {

	private Component canvas;	
	
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
                //return x * Math.sin(x * y);
            	return Math.sin(x) + Math.cos(y);
            }
        };

		// Create scatter points
		for(int i=0; i<size; i++){
		    x = (float)Math.random() - 0.5f;
		    y = (float)Math.random() - 0.5f;
		    z = (float)Math.random() - 0.5f;
		    points[i] = new Coord3d(x, y, z);
		}       

		// Create a drawable scatter with a colormap
		ScatterMultiColor scatter = new ScatterMultiColor( points, new ColorMapper( new ColorMapRainbow(), -0.5f, 0.5f ) );

		// Create a chart and add scatter
		Chart chart = new Chart();
		chart = AWTChartComponentFactory.chart(Quality.Advanced, IChartComponentFactory.Toolkit.swing);
		chart.getAxeLayout().setMainColor(Color.WHITE);
		chart.getView().setBackgroundColor(Color.WHITE);
		chart.getScene().getGraph().add(scatter);
		canvas = (Component) chart.getCanvas();
		
		//JPanel panel = new JPanel();
		//panel.add(canvas, BorderLayout.CENTER);
		//return canvas;
		//return new JPanel();
	}

	public Component getCanvas() {
		return canvas;
	}
	
}
