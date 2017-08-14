package com.nuage;

import javax.swing.UIManager;

import com.nuage.model.swing.MainWindow;
import com.nuage.view.window.MainWindowFrame;

public class Nuage {

	private static MainWindowFrame frame;

	public static void main(String[] args) {
		/*
		 * File f = null; try { f = new
		 * File(Nuage.class.getProtectionDomain().getCodeSource().getLocation().
		 * toURI(). getPath()); } catch (URISyntaxException e1) { e1.printStackTrace();
		 * } /*JFrame frame = new JFrame(); JPanel p = new JPanel(); p.add(new
		 * JLabel(f.getParentFile().getPath()));
		 * 
		 * frame.add(p); frame.setVisible(true);
		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.pack();
		 */
		/*
		 * File giac = new File(f.getAbsolutePath(), "\\Resources\\javagiac.dll");
		 * System.out.println(""+f.getAbsolutePath()); System.load(giac.getPath());
		 */

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new MainWindowFrame(new MainWindow());
	}

	public static MainWindowFrame getFrame() {
		return frame;
	}

	public static void setFrame(MainWindowFrame frame) {
		Nuage.frame = frame;
	}
}
