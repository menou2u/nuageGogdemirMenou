package view.window;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import model.swing.InfosWindow;

@SuppressWarnings("serial")
public class InfosWindowFrame extends JFrame implements Observer{
	
	private static InfosWindowFrame infosWindowFrame;
	private InfosWindow infosWindow;

	@SuppressWarnings("static-access")
	public InfosWindowFrame(InfosWindow infosWindow) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = gbc.BOTH;
		gbc.weighty=0;
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridheight=1;
		gbc.gridwidth=1;
		
		this.infosWindow = infosWindow;
		add(infosWindow.getInfosDisplay(),gbc);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = new Dimension((int) (screenSize.width * 0.9), (int) (screenSize.height * 0.9));
		setTitle("Infos");
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		setVisible(true);
		pack();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	public static InfosWindowFrame getCurrent() {
		if (infosWindowFrame == null) {
			infosWindowFrame = new InfosWindowFrame(new InfosWindow(new StringBuilder("")));
		}
		return infosWindowFrame;
	}
	
	
	public void setInfos(StringBuilder infos){
		infosWindow.setInfos(infos);
	}
}
