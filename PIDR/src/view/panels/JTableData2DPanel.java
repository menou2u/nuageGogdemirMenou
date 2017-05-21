package view.panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.swing.Point2D;
import model.swing.TableCustom2DModel;

public class JTableData2DPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5696106447554694086L;
	private TableCustom2DModel modele = new TableCustom2DModel();
	private JTable tableau;

	public JTableData2DPanel() {
		super();

		tableau = new JTable(modele);
		tableau.setAutoCreateRowSorter(true);
		tableau.getColumnModel().getColumn(0).setMaxWidth(50);
		add(new JScrollPane(tableau), BorderLayout.CENTER);

		JPanel boutons = new JPanel();

		boutons.add(new JButton(new AddAction()));
		boutons.add(new JButton(new RemoveAction()));

		add(boutons, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setContentPane(new JTableData2DPanel());
		frame.pack();
		frame.setVisible(true);
	}

	private class AddAction extends AbstractAction {
		private AddAction() {
			super("Ajouter ligne");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			modele.addPoint(new Point2D(modele.getRowCount() + 1, 0.0, 0.0));
		}
	}

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
				System.out.println(modele.getValueAt(i,1));
				System.out.println(i+1.0);
			}
			System.out.println(modele.getRowCount());
		}
	}
}