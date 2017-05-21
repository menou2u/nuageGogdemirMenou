package model.swing;

import java.awt.Component;
import java.awt.Container;
import java.util.LinkedList;

import javax.swing.JFrame;

import org.jzy3d.analysis.AbstractAnalysis;
import org.jzy3d.chart.factories.AWTChartComponentFactory;
import org.jzy3d.chart.factories.IChartComponentFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord2d;
import org.jzy3d.plot3d.primitives.Scatter;
import org.jzy3d.plot3d.rendering.canvas.Quality;

public class LineGraph extends AbstractAnalysis{

	private Component canvas;	
	private LinkedList<Double> listX;
	private LinkedList<Double> listY;
	
	public LineGraph(LinkedList<Double> listX, LinkedList<Double> listY) {
		this.listX = listX;
		this.listY = listY;
	}
	
	public LineGraph() {
		listX = new LinkedList<>();
		listY = new LinkedList<>();
		init();
	}
	
	public static void main(String[] args) {
		LinkedList<Double> x = new LinkedList<>();
		x.add(1.0);
		x.add(3.0);
		x.add(5.0);
		LinkedList<Double> y = new LinkedList<>();
		y.add(5.0);
		y.add(9.0);
		y.add(25.0);
		LineGraph graph = new LineGraph(x, y);
		graph.init();
		
		JFrame frame = new JFrame();
		frame.setContentPane((Container) graph.getCanvas());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
	
	 public void init(){
	        int size = listX.size();
	        float x;
	        float y;
	        float z;
	        float a;
	        
	        Coord2d[] points = new Coord2d[size];
	        Color[]   colors = new Color[size];
	        
	        for(int i=0; i<size; i++){
	            x = (float) ((double) listX.get(i));
	            System.out.println("x "+x);
	            y = (float) ((double) listY.get(i));
	            System.out.println("y "+y);
	            a = 0.25f;
	            points[i] = new Coord2d(x, y);
	            colors[i] = new Color(x, y, a);
	        }
	        
	        Scatter scatter = new Scatter();
	        chart = AWTChartComponentFactory.chart(Quality.Advanced, IChartComponentFactory.Toolkit.swing);
	        chart.getScene().add(scatter);
	        canvas = (Component) chart.getCanvas();
	}

	public Component getCanvas() {
		return canvas;
	}
	
}
