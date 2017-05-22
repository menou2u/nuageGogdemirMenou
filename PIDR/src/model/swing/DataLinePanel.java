package model.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import view.panels.Data2DPanel;
import view.panels.Data3DPanel;


public class DataLinePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5696106447554694086L;
	private TableCustom2DModel modele;
	private JTable tableauDatas;
	private String tx;
	private String ty;
	private TableCustom2DModel tc2dmDatas;
	private TableCustom2DModel tc2dmTrans;
	private Data2DPanel d2dpDatas;
	private Data2DPanel d2dpTrans;

	public DataLinePanel(TableCustom2DModel modele,String tx,String ty)
	{
		super();
		this.tx = tx;
		this.ty = ty;
		
		tc2dmDatas = modele;
		tc2dmTrans = applyChanges(modele);
		
		d2dpDatas = new Data2DPanel(modele);
		d2dpTrans = new Data2DPanel(tc2dmTrans);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		add(d2dpDatas = new Data2DPanel(tc2dmDatas));
		gbc.gridx=1;
		add(d2dpTrans = new Data2DPanel(tc2dmTrans));
	}

	private TableCustom2DModel applyChanges(TableCustom2DModel modele2) {
		// TODO Auto-generated method stub
		TableCustom2DModel model = new TableCustom2DModel(new String[]{"n°","Xi = tx(xi)","Yi = ty(yi)"});
		model.getPoints().clear();
		for (Point2D p : modele2.getPoints()){
			model.addPoint(p);
		}
		return model;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		TableCustom2DModel mod = new TableCustom2DModel(new String[]{"n°","Xi","Yi"});
		frame.setContentPane(new Data2DPanel(mod));
		frame.pack();
		frame.setVisible(true);
	}

	private class AddAction extends AbstractAction {
		private AddAction() {
			super("Ajouter ligne");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			modele.addPoint(new Point2D(modele.getRowCount() + 1.0,0.0,0.0));
		}
	}

	private class RemoveAction extends AbstractAction {
		private RemoveAction() {
			super("Supprimer");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int[] selection = tableauDatas.getSelectedRows();
			for (int i = selection.length - 1; i >= 0; i--) {
				modele.removePoint(selection[i]);
			}
			for (int i = 0; i < modele.getRowCount(); i++) {
				modele.setValueAt(i + 1.0, i, 0);
				System.out.println(modele.getValueAt(i,1));
				System.out.println(i+1.0);
			}
			System.out.println(modele.getRowCount());
		}
	}
}