package imager;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Defines the table model of Tag table.
 * @author Kumaripaba Athukorala
 *
 */
public class TagTableModel extends AbstractTableModel {

	// private String []wordArray ;
	private ArrayList<String> tagArray;

	public TagTableModel(ArrayList<String> tags) {
		tagArray = tags;
	}

	public int getColumnCount() {
		if (tagArray == null) {
			return 0;
		} else {
			return tagArray.size();
		}
	}

	public int getRowCount() {
		return 1;
	}

	public String getColumnName(int col) {
		return "";
	}

	public Object getValueAt(int row, int col) {
		return tagArray.get(col);
	}

	/*
	 * JTable uses this method to determine the default renderer/ editor for
	 * each cell. If we didn't implement this method, then the last column would
	 * contain text ("true"/"false"), rather than a check box.
	 */
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	/*
	 * Don't need to implement this method unless your table's editable.
	 */
	public boolean isCellEditable(int row, int col) {
		// Note that the data/cell address is constant,
		// no matter where the cell appears onscreen.
		return true;

	}

	public void setWordArray(ArrayList<String> tags) {
		this.tagArray = tags;
	}

	public void setValueAt(Object value, int row, int col) {

		if (tagArray.size() <= col) {
			tagArray.add((String) value);
		} else {
			tagArray.set(col, (String) value);
		}

	}

}
