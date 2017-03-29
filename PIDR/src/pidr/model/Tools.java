package pidr.model;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pidr.mag.sample.api.DefaultMenuModelHandler;
import pidr.mag.sample.api.MenuModelHandler;
import pidr.mag.sample.api.MenuOpenerButton;
import pidr.mag.sample.api.RotativeMenuModel;
import pidr.mag.sample.api.SimpleMenuModelItem;
import pidr.mag.sample.implementation.FileItemRenderer;
import pidr.mag.sample.implementation.FileItemRendererConstraint;
import pidr.mag.sample.implementation.FilePopupMenuOpener;
import pidr.model.historic.HistoricData;
import pidr.model.historic.HistoricHandler;
import pidr.view.window.MainWindowFrame;

public class Tools extends Observable {

	/**
		 *
		 */
	public class ChooseOpenFile implements ActionListener {
		private JFileChooser jfc;
		public ChooseOpenFile() {
			jfc= new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			jfc.setMultiSelectionEnabled(false);
		}
		public void actionPerformed(ActionEvent e) {			
			int state = jfc.showOpenDialog(MainWindowFrame.getCurrent());
			switch (state) {
			case JFileChooser.APPROVE_OPTION:				
				File selectedFile = jfc.getSelectedFile();
				open(selectedFile);
				break;
			default:
				break;
			}
		}

	}

	/**
	 * 
	 */
	private static final String NUAGE_DATA = "NuageData";
	private JButton close;
	private JButton neww;
	private JButton openButton;
	private JButton register;
	private JButton registerAs;
	private JButton info;
	private JButton export;
	private JButton importt;
	private JButton print;
	private JButton preview;
	private JButton execute;
	private JButton open;
	private JPanel file;
	private JPanel infos;
	private JPanel datas;
	private JPanel printing;
	private JPanel executing;
	private JLabel nameFile;
	private JLabel nameInfos;
	private JLabel nameDatas;
	private JLabel namePrinting;
	private JLabel nameExecuting;
	private MenuModelHandler openModel;
	private MenuOpenerButton menuOpener;
	private HistoricData data;
	private File historicfile;

	public Tools() {

		open = new JButton("Ouvrir");
		open.addActionListener(new ChooseOpenFile());
		openModel = new DefaultMenuModelHandler();

		menuOpener = createMenuOpener(openModel);

		info = new JButton("Infos");

		export = new JButton("Exporter");

		importt = new JButton("Importer");

		print = new JButton("Imprimer");

		preview = new JButton("Prévisualiser");

		execute = new JButton("Exécuter");

		infos = createPanelWithBorder();

		datas = createPanelWithBorder();

		printing = createPanelWithBorder();

		executing = createPanelWithBorder();

		file = createPanelWithBorder();

		close = new JButton("Fermer");

		neww = new JButton("Nouveau");

		register = new JButton("Enregistrer");

		registerAs = new JButton("Enregistrer Sous...");

		nameFile = createCenteredlabel("Fichier");

		nameInfos = createCenteredlabel("Info.");

		nameDatas = createCenteredlabel("Donnée");

		namePrinting = createCenteredlabel("Impression");

		nameExecuting = createCenteredlabel("Exécution");
	}

	/**
	 * @return
	 * 
	 */
	private MenuOpenerButton createMenuOpener(MenuModelHandler openModel) {
		openModel.setModel(new RotativeMenuModel<SimpleMenuModelItem>(openModel));
		openModel.setCommonConstraint(new FileItemRendererConstraint(20, 7)); // TODO : Check size
		openModel.setItemRenderer(new FileItemRenderer());
		try {
			generateInitialModel();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new MenuOpenerButton(new FilePopupMenuOpener(openModel), open);
	}

	/**
	 * @param text
	 * @return
	 */
	private JLabel createCenteredlabel(String text) {
		return new JLabel(text, JLabel.CENTER);
	}

	/**
	 * @return
	 */
	private JPanel createPanelWithBorder() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBorder(BorderFactory.createRaisedBevelBorder());
		return panel;
	}

	private void generateInitialModel() throws IOException {
		if (File.pathSeparator == "/") {// on est sur un linux
			historicfile = new File(System.getProperty("user.home") + File.separator + NUAGE_DATA);
		} else { // on est sur windob
			historicfile = new File(System.getenv("APPDATA") + File.separator + NUAGE_DATA);
		}
		if (historicfile.exists()) {
			if (!historicfile.isDirectory()) {
				throw new IOException("oups the file " + historicfile.getAbsolutePath() + " is not a directory save will historic will be disable");
			} // sinon on est tout bon
			historicfile = new File(historicfile, "historic.tmp");
			if (historicfile.exists()) {
				if (historicfile.isDirectory())
					throw new IOException("oups the file " + historicfile.getAbsolutePath() + " is not a directory save will historic will be disable");
			} else {
				historicfile.createNewFile();
				HistoricHandler.store(new HistoricData(), historicfile); // s'assure que meme le fichier soit parsable par la lib sinon il va dire : eu non c'est pas du xml va te faire voir bisou le pc
			}
		} else {
			historicfile.mkdirs();
			historicfile = new File(historicfile, "historic.tmp");
			historicfile.createNewFile();
			HistoricHandler.store(new HistoricData(), historicfile); // s'assure que meme le fichier soit parsable par la lib sinon il va dire : eu non c'est pas du xml va te faire voir bisou le pc
		}
		data = HistoricHandler.load(historicfile);
		for (String ligne : data) {
			openModel.add(ligne, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					open(new File(ligne));
				}
			});
		}
	}

	/**
	 * @param file2
	 */
	protected void open(File file2) {
		openModel.add(file2.getAbsolutePath(), new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open(file2);
			}
		});
		data.put(file2);
		System.out.println("openning "+file2.getAbsolutePath() );
	}

	/**
	 * 
	 */
	public void saveHistoric() {
		HistoricHandler.store(data, historicfile);
	}
	public JButton getClose() {
		return close;
	}

	public JPanel getDatas() {
		return datas;
	}

	public JButton getExecute() {
		return execute;
	}

	public JPanel getExecuting() {
		return executing;
	}

	public JButton getExport() {
		return export;
	}

	public JPanel getFile() {
		return file;
	}

	public JButton getImportt() {
		return importt;
	}

	public JButton getInfo() {
		return info;
	}

	public JPanel getInfos() {
		return infos;
	}

	/**
	 * @return the menuOpener
	 */
	public MenuOpenerButton getMenuOpener() {
		return menuOpener;
	}

	public JLabel getNameDatas() {
		return nameDatas;
	}

	public JLabel getNameExecuting() {
		return nameExecuting;
	}

	public JLabel getNameFile() {
		return nameFile;
	}

	public JLabel getNameInfos() {
		return nameInfos;
	}

	public JLabel getNamePrinting() {
		return namePrinting;
	}

	public JButton getNeww() {
		return neww;
	}

	public JButton getOpen() {
		return open;
	}

	public JButton getOpenButton() {
		return openButton;
	}

	/**
	 * @return the openModel
	 */
	public MenuModelHandler getOpenModel() {
		return openModel;
	}

	public JButton getPreview() {
		return preview;
	}

	public JButton getPrint() {
		return print;
	}

	public JPanel getPrinting() {
		return printing;
	}

	public JButton getRegister() {
		return register;
	}

	public JButton getRegisterAs() {
		return registerAs;
	}

	/**
	 * @param menuOpener
	 *            the menuOpener to set
	 */
	public void setMenuOpener(MenuOpenerButton menuOpener) {
		this.menuOpener = menuOpener;
	}

	/**
	 * @param openModel
	 *            the openModel to set
	 */
	public void setOpenModel(DefaultMenuModelHandler openModel) {
		this.openModel = openModel;
	}

}
