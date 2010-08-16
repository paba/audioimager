package imager;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/**
 * Defines the cellrenderer for FlickrImgTable
 * @author Kumaripaba Athukorala
 *
 */

public class FlickrImgTableCellRenderer extends DefaultTableCellRenderer {
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {

		JLabel label = (JLabel) super.getTableCellRendererComponent(table,
				value, isSelected, hasFocus, row, column);

		Image image = (Image) value;

		ImageIcon icon = new ImageIcon(image);

		// ImageIcon icon = new ImageIcon(url,"image");
		if (icon == null) {
			label.setText("No Image");
		} else {
			label.setIcon(icon);
		}

		return label;
	}

}
