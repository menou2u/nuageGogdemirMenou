package panels;

import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Contient la fonction calculée.
 * Ce panel devra donc se mettre à jour ou se remplacer de lui-même lorsqu'on cliquera sur le bouton
 * Executer
 * @author Miron
 *
 */
public class CalculatedFunctionPanel extends JPanel { //frederic.neurohr@cpc57.fr

	private String value = "";
	private JLabel function;
	
	public CalculatedFunctionPanel()
	{
		function.setText("φ(x) = ");
	}
	
}
