package pidr.mag.sample.api;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 * 
 * @author Arnault Le Prévost-Corvellec
 *
 */
public class DefaultPopupMenuOpener implements Observer {

	protected MenuModelHandler model;
	protected JPopupMenu popup;

	/**
	 * Construct a {@link DefaultPopupMenuOpener} with a {@link MenuModelHandler}
	 * 
	 * @param model
	 *            the {@link MenuModelHandler} that will be set
	 */
	public DefaultPopupMenuOpener(MenuModelHandler model) {
		super();
		if (model == null)
			model = new DefaultMenuModelHandler();
		this.model = model;
		if (model instanceof DefaultMenuModelHandler)
			((DefaultMenuModelHandler) model).addObserver(this);
	}

	/**
	 * @return the number of Elements that should be almost diplay
	 */
	public int getItemCount() {
		return Math.min(model.getItemCount(), model.getCommonConstraint().getMaxItemCount());
	}

	/**
	 * @return the item Margin most of the time 0
	 */
	private int getItemMargin() {
		return model.getItemMargin();
	}

	/**
	 * @param dimension
	 *            the {@link Dimension} used to update the {@link RendererConstraints}
	 * @return the {@link JPopupMenu} to be display
	 */
	public JPopupMenu getPopupMenu(Dimension dimension) {
		model.refresh();
		model.getCommonConstraint().setPreferedWidth(dimension.width);
		popup = new JPopupMenu();
		for (JMenuItem item : model) {
			popup.add(item);
		}
		return popup;
	}

	/**
	 * Compute the size of the popup menu using ItemCount, PreferedItemHeightand ItemMargin
	 * 
	 * @return the height of the popup menu
	 */
	public int getPreferedHeight() {
		return getItemCount() * (getPreferedItemHeight() + getItemMargin());
	}

	/**
	 * @return the prefered Height available in constraints in model.
	 */
	public int getPreferedItemHeight() {
		return model.getPreferedItemHeight();
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		try {
			switch (Integer.parseInt(arg.toString())) {
			case DefaultMenuModelHandler.ITEM_SELECTED:
				popup.setVisible(false);
				break;

			default:
				break;
			}
		} catch (Exception e) {
		}
	}

}