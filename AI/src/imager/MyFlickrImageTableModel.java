package imager;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MyFlickrImageTableModel extends AbstractTableModel {

	public ArrayList<Image> imgList ;
    int width = 4 ;
    
    public MyFlickrImageTableModel()
    {
    	imgList = new ArrayList<Image>() ;
    	
    }
    
   public void removeValueAt(int col)
   {
	   imgList.remove(col);
	  
   }
   
    public int getColumnCount() {
    	if(imgList == null)
    	{
    		return 0;
    	}
    	else
    	{	
    		
    		return width;
    		
    	}
    }

    public int getRowCount() {
      return (int)Math.ceil((double)imgList.size()/width) ;
    }
    
    public String getColumnName(int col) {
      
      return "";
    }

    public Object getValueAt(int row, int col) {
      return imgList.get(row*width + col);
    }

    /*
     * JTable uses this method to determine the default renderer/ editor for
     * each cell. If we didn't implement this method, then the last column
     * would contain text ("true"/"false"), rather than a check box.
     */
    public Class getColumnClass(int c) {
      return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's editable.
     */
    public boolean isCellEditable(int row, int col) {
      //Note that the data/cell address is constant,
      //no matter where the cell appears onscreen.
      return false;
      
    }

    /*
     * Don't need to implement this method unless your table's data can
     * change.
     */
    public void setValueAt(Object value, int row, int col) {
      //imageList.set(col,(ImageData) value);
    	
    	if(imgList.size()<=(row*4 +col))
    	{
    		imgList.add((Image) value);
    	}
    	else 
    	{
    		imgList.set((row*4 +col),(Image) value);
    			    		
    	}	
     
    }
}
