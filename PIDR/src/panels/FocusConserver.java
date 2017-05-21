package panels;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FocusConserver extends FocusAdapter {
	private static JComponent lastFocusRecever;

	public static void appendToLastComponent() {
		if (lastFocusRecever == null)
			return;
		if(lastFocusRecever instanceof JTextArea){
			
		}else if(lastFocusRecever instanceof JTextField){
			
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		lastFocusRecever = (JComponent) e.getSource();
	}

}
