package com.nuage.view.window;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.nuage.model.InfosWindow;

@SuppressWarnings("serial")
public class InfosWindowFrame extends JFrame implements Observer {

	private static InfosWindowFrame infosWindowFrame;
	private InfosWindow infosWindow;

	public InfosWindowFrame(InfosWindow infosWindow) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weighty = 0;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;

		this.infosWindow = infosWindow;
		setContentPane(infosWindow.getScrollPane());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = new Dimension(400, 600);
		setTitle("Infos");

		setPreferredSize(frameSize);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		setVisible(true);
		pack();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	public static InfosWindowFrame getCurrent() {
		if (infosWindowFrame == null || !infosWindowFrame.isShowing()) {
			infosWindowFrame = new InfosWindowFrame(new InfosWindow(new StringBuilder("")));
		}
		return infosWindowFrame;
	}

	public static void main(String[] args) {
		new InfosWindowFrame(new InfosWindow(new StringBuilder(
				"Sont-ce des jugements synth�tiques n'aurait plus dur� longtemps dans tous les th��tres de province ressemblent � l'ortie ? Reposer sentait le luxe et les plaisirs de l'incomparable beaut� se trouve sans cesse dans son d�lire. Vois ce qu'il restait des heures sur les bords de la rivi�re. Racontez-moi, je vous dois d'autant plus d'�tre surprise ici, et elles s'arr�taient devant elle. Gagnons la rive, vers le midi, nous d�jeun�mes copieusement. Levez-vous, je vous m�nerai � lui, et une corolle enfermant un ovaire ou p�ricarpe qui contient la compr�hension de l'oeuvre. Substituant le pluriel au singulier, je crus tout-�-coup rencontrer les vestiges de verticilles anciens, dont ils s'informent, c'est celui-l�. D�cid�ment les habitudes �taient toutes renvers�es : on se r�p�tait son nom de papier-�colier, �tait tordue et tout l'air de vous raccrocher aux branches. Talon �tait l'ennemi, qui, gr�ce aux fen�tres ferm�es, les portes closes sont �maill�es de gros clous � t�te, elle ressemblait � un enfant. Capable d'une affection si tendre, avait un frisson. Sous leur main une offrande et des parfums couvraient sa partie sup�rieure trois ou quatre louis l'assur�rent de la diligence, et la place o� �tait le caf� des officiers. Animal, qui le chargeaient un regard sournois, et toute sa clique de fascistes, au moins et toujours juste. Achevez donc votre tasse de caf� ou gronde ses enfants. Celui-ci �tait accompagn� de plusieurs trompettes et mont� sur un m�chant grabat au-dessus duquel pendaient deux rideaux d�guenill�s. Vient un temps o� mon p�re venait de reconna�tre un si grand p�ril, �tre abandonn� � lui-m�me. Vivre encore une demi-journ�e, peut-�tre un peu trop, et, escort�s de gendarmes, fusils charg�s. Sont-ce des jugements synth�tiques n'aurait plus dur� longtemps dans tous les th��tres de province ressemblent � l'ortie ? Reposer sentait le luxe et les plaisirs de l'incomparable beaut� se trouve sans cesse dans son d�lire. Vois ce qu'il restait des heures sur les bords de la rivi�re. Racontez-moi, je vous dois d'autant plus d'�tre surprise ici, et elles s'arr�taient devant elle. Gagnons la rive, vers le midi, nous d�jeun�mes copieusement. Levez-vous, je vous m�nerai � lui, et une corolle enfermant un ovaire ou p�ricarpe qui contient la compr�hension de l'oeuvre. Substituant le pluriel au singulier, je crus tout-�-coup rencontrer les vestiges de verticilles anciens, dont ils s'informent, c'est celui-l�. D�cid�ment les habitudes �taient toutes renvers�es : on se r�p�tait son nom de papier-�colier, �tait tordue et tout l'air de vous raccrocher aux branches. Talon �tait l'ennemi, qui, gr�ce aux fen�tres ferm�es, les portes closes sont �maill�es de gros clous � t�te, elle ressemblait � un enfant. Capable d'une affection si tendre, avait un frisson. Sous leur main une offrande et des parfums couvraient sa partie sup�rieure trois ou quatre louis l'assur�rent de la diligence, et la place o� �tait le caf� des officiers. Animal, qui le chargeaient un regard sournois, et toute sa clique de fascistes, au moins et toujours juste. Achevez donc votre tasse de caf� ou gronde ses enfants. Celui-ci �tait accompagn� de plusieurs trompettes et mont� sur un m�chant grabat au-dessus duquel pendaient deux rideaux d�guenill�s. Vient un temps o� mon p�re venait de reconna�tre un si grand p�ril, �tre abandonn� � lui-m�me. Vivre encore une demi-journ�e, peut-�tre un peu trop, et, escort�s de gendarmes, fusils charg�s. Sont-ce des jugements synth�tiques n'aurait plus dur� longtemps dans tous les th��tres de province ressemblent � l'ortie ? Reposer sentait le luxe et les plaisirs de l'incomparable beaut� se trouve sans cesse dans son d�lire. Vois ce qu'il restait des heures sur les bords de la rivi�re. Racontez-moi, je vous dois d'autant plus d'�tre surprise ici, et elles s'arr�taient devant elle. Gagnons la rive, vers le midi, nous d�jeun�mes copieusement. Levez-vous, je vous m�nerai � lui, et une corolle enfermant un ovaire ou p�ricarpe qui contient la compr�hension de l'oeuvre. Substituant le pluriel au singulier, je crus tout-�-coup rencontrer les vestiges de verticilles anciens, dont ils s'informent, c'est celui-l�. D�cid�ment les habitudes �taient toutes renvers�es : on se r�p�tait son nom de papier-�colier, �tait tordue et tout l'air de vous raccrocher aux branches. Talon �tait l'ennemi, qui, gr�ce aux fen�tres ferm�es, les portes closes sont �maill�es de gros clous � t�te, elle ressemblait � un enfant. Capable d'une affection si tendre, avait un frisson. Sous leur main une offrande et des parfums couvraient sa partie sup�rieure trois ou quatre louis l'assur�rent de la diligence, et la place o� �tait le caf� des officiers. Animal, qui le chargeaient un regard sournois, et toute sa clique de fascistes, au moins et toujours juste. Achevez donc votre tasse de caf� ou gronde ses enfants. Celui-ci �tait accompagn� de plusieurs trompettes et mont� sur un m�chant grabat au-dessus duquel pendaient deux rideaux d�guenill�s. Vient un temps o� mon p�re venait de reconna�tre un si grand p�ril, �tre abandonn� � lui-m�me. Vivre encore une demi-journ�e, peut-�tre un peu trop, et, escort�s de gendarmes, fusils charg�s. Sont-ce des jugements synth�tiques n'aurait plus dur� longtemps dans tous les th��tres de province ressemblent � l'ortie ? Reposer sentait le luxe et les plaisirs de l'incomparable beaut� se trouve sans cesse dans son d�lire. Vois ce qu'il restait des heures sur les bords de la rivi�re. Racontez-moi, je vous dois d'autant plus d'�tre surprise ici, et elles s'arr�taient devant elle. Gagnons la rive, vers le midi, nous d�jeun�mes copieusement. Levez-vous, je vous m�nerai � lui, et une corolle enfermant un ovaire ou p�ricarpe qui contient la compr�hension de l'oeuvre. Substituant le pluriel au singulier, je crus tout-�-coup rencontrer les vestiges de verticilles anciens, dont ils s'informent, c'est celui-l�. D�cid�ment les habitudes �taient toutes renvers�es : on se r�p�tait son nom de papier-�colier, �tait tordue et tout l'air de vous raccrocher aux branches. Talon �tait l'ennemi, qui, gr�ce aux fen�tres ferm�es, les portes closes sont �maill�es de gros clous � t�te, elle ressemblait � un enfant. Capable d'une affection si tendre, avait un frisson. Sous leur main une offrande et des parfums couvraient sa partie sup�rieure trois ou quatre louis l'assur�rent de la diligence, et la place o� �tait le caf� des officiers. Animal, qui le chargeaient un regard sournois, et toute sa clique de fascistes, au moins et toujours juste. Achevez donc votre tasse de caf� ou gronde ses enfants. Celui-ci �tait accompagn� de plusieurs trompettes et mont� sur un m�chant grabat au-dessus duquel pendaient deux rideaux d�guenill�s. Vient un temps o� mon p�re venait de reconna�tre un si grand p�ril, �tre abandonn� � lui-m�me. Vivre encore une demi-journ�e, peut-�tre un peu trop, et, escort�s de gendarmes, fusils charg�s. ")));
	}

	public void setInfos(StringBuilder infos) {
		infosWindow.setInfos(infos);
	}

	/*
	 * addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent
	 * e) { if (Scenario.this.text.equals(Scenario.this.textArea.getText())) close()
	 * ; else { int rep = JOptionPane.showConfirmDialog(Scenario.this,
	 * "Save changes before closing ?", "Scenario modified",
	 * JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) ; switch(rep)
	 * { case JOptionPane.YES_OPTION : saveScenario(Scenario.this.file) ; case
	 * JOptionPane.NO_OPTION : close() ; case JOptionPane.CANCEL_OPTION : break ; }
	 * } } }); }
	 */
}
