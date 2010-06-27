package imager;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;


public class ImageTableModel extends AbstractTableModel {
	
		    public ArrayList<ImageData> imageList ;
		
		    
		    public ImageTableModel()
		    {
		    	imageList = new ArrayList<ImageData>() ;
		    	
		    }
		    
		   public void removeValueAt(int col)
		   {
			   imageList.remove(col);
			  
		   }
		   
		    public int getColumnCount() {
		    	if(imageList == null)
		    	{
		    		return 0;
		    	}
		    	else
		    	{	
		    		
		    		return imageList.size();
		    		
		    	}
		    }

		    public int getRowCount() {
		      return 1;
		    }
		    
		    public String getColumnName(int col) {
		      return imageList.get(col).getPath();
		    }

		    public Object getValueAt(int row, int col) {
		      return imageList.get(col);
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
		      return true;
		      
		    }

		    /*
		     * Don't need to implement this method unless your table's data can
		     * change.
		     */
		    public void setValueAt(Object value, int row, int col) {
		      //imageList.set(col,(ImageData) value);
		    	if(imageList.size()<=col)
		    	{
		    		imageList.add((ImageData) value);
		    	}
		    	else 
		    	{
		    		imageList.set(col,(ImageData) value);
		    			    		
		    	}	
		     
		    }

					
		    

}
