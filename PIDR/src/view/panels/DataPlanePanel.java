package view.panels;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.swing.Point3D;
import model.swing.TableCustom2DModel;
import model.swing.TableCustom3DModel;


public class DataPlanePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5696106447554694086L;
	private TableCustom3DModel modele;
	private JTable tableauDatas;
	private String tx;
	private String ty;
	private String tz;
	private TableCustom3DModel tc3dmDatas;
	private TableCustom3DModel tc3dmTrans;
	private Data3DPanel d3dpDatas;
	private Data3DPanel d3dpTrans;

	public DataPlanePanel(TableCustom3DModel modele,String tx,String ty,String tz)
	{
		super();
		this.tx = tx;
		this.ty = ty;
		this.tz = tz;
		
		tc3dmDatas = modele;
		tc3dmTrans = applyChanges(modele);
		
		d3dpDatas = new Data3DPanel(modele);
		d3dpTrans = new Data3DPanel(tc3dmTrans);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		add(d3dpDatas = new Data3DPanel(tc3dmDatas));
		gbc.gridx=1;
		add(d3dpTrans = new Data3DPanel(tc3dmTrans));
	}

	private TableCustom3DModel applyChanges(TableCustom3DModel modele2) {
		// TODO Auto-generated method stub
		TableCustom3DModel model = new TableCustom3DModel(modele2.getEntetes());
		model.getPoints().clear();
		for (Point3D p : modele2.getPoints()){
			model.addPoint(p);
		}
		return model;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		TableCustom2DModel mod = new TableCustom2DModel(new String[]{"n�","Xi","Yi"});
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
			modele.addPoint(new Point3D(modele.getRowCount() + 1.0, 0.0, 0.0,0.0));
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