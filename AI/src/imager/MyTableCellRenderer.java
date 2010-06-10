package imager;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MyTableCellRenderer extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

        JLabel label = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        ImageData imagedata = (ImageData) value;
        String status = imagedata.getPath();
       
       //Image image = new ImageIcon(imagedata.getPath()).getImage();
       ImageIcon icon = new ImageIcon(imagedata.getImage());
       if(icon == null){
                        label.setText(status);
                }else{
                        label.setIcon(icon);
                }
     
        return label;
    }
}
