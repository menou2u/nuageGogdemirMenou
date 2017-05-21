package model.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class JTableData2D extends JFrame {
	private TableCustom2DModel modele = new TableCustom2DModel();
	private JTable tableau;

	public JTableData2D() {
		super();

		setTitle("JTable avec modèle dynamique");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tableau = new JTable(modele);
		tableau.setAutoCreateRowSorter(true);
		getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

		JPanel boutons = new JPanel();

		boutons.add(new JButton(new AddAction()));
		boutons.add(new JButton(new RemoveAction()));

		getContentPane().add(boutons, BorderLayout.SOUTH);

		pack();
	}

	public static void main(String[] args) {
		new JTableData2D().setVisible(true);
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
			super("Supprimmer");
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