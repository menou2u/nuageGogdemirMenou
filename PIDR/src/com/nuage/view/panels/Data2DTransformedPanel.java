package com.nuage.view.panels;

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

import com.nuage.model.swing.datas.tables.Point2D;
import com.nuage.model.swing.datas.tables.TableCustom2DModel;

public class Data2DTransformedPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5696106447554694086L;
	private TableCustom2DModel modele;
	private JTable tableau;

	public Data2DTransformedPanel(TableCustom2DModel modele) {
		super();

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 4;
		gbc.gridheight = 3;
		gbc.gridx = 0;
		gbc.gridy = 0;

		this.modele = modele;
		tableau = new JTable(modele);
		tableau.setAutoCreateRowSorter(true);
		tableau.getColumnModel().getColumn(0).setMaxWidth(50);
		JScrollPane scrollPane = new JScrollPane(tableau);
		scrollPane.setMinimumSize(new Dimension(300, 1000));
		add(scrollPane, gbc);

		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridheight = 1;
		gbc.gridy = 3;
		gbc.gridx = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		add(new JButton(new AddAction()), gbc);

		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 2;
		add(new JButton(new RemoveAction()), gbc);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		TableCustom2DModel mod = new TableCustom2DModel(new String[] { "n�", "Xi", "Yi" });
		frame.setContentPane(new Data2DPanel(mod));
		frame.pack();
		frame.setVisible(true);
	}

	@SuppressWarnings("serial")
	private class AddAction extends AbstractAction {
		private AddAction() {
			super("Ajouter ligne");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			modele.addPoint(new Point2D(modele.getRowCount() + 1.0, 0.0, 0.0));
		}
	}

	@SuppressWarnings("serial")
	private class RemoveAction extends AbstractAction {
		private RemoveAction() {
			super("Supprimer");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int[] selection = tableau.getSelectedRows();
			for (int i = selection.length - 1; i >= 0; i--) {
				modele.removePoint(selection[i]);
			}
			for (int i = 0; i < modele.getRowCount(); i++) {
				modele.setValueAt(i + 1.0, i, 0);
				System.out.println(modele.getValueAt(i, 1));
				System.out.println(i + 1.0);
			}
			System.out.println(modele.getRowCount());
		}
	}
}