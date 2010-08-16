package imager;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Defines a cell renderer.
 * @author Kumaripaba Athukorala
 *
 */

public class MyTableCellRenderer extends DefaultTableCellRenderer {

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {

		JLabel label = (JLabel) super.getTableCellRendererComponent(table,
				value, isSelected, hasFocus, row, column);

		ImageData imagedata = (ImageData) value;
		String status = imagedata.getPath();

		// Image image = new ImageIcon(imagedata.getPath()).getImage();
		ImageIcon icon = new ImageIcon(imagedata.getThumbImage());
		if (icon == null) {
			label.setText(status);
		} else {
			label.setIcon(icon);
		}

		return label;
	}
}
