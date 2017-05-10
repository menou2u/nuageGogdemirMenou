import javax.swing.UIManager;

import model.swing.MainWindow;
import view.window.MainWindowFrame;

public class Nuage {

	public static void main(String[] args) {
		try {

			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		new MainWindowFrame(new MainWindow());
	}
}
