package imager;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CaptionTableModel extends AbstractTableModel {

	  //private  String  []wordArray ;
	  private ArrayList<String> wordArray;
	    
	    public CaptionTableModel(  ArrayList<String> captions)
	    {
	    	wordArray = captions;
	    }
	  
	   
	   
	    public int getColumnCount() {
	    	if(wordArray == null)
	    	{
	    		return 0;
	    	}
	    	else
	    	{	
	    		return wordArray.size();
	    	}
	    }

	    public int getRowCount() {
	      return 1;
	    }
	    
	    public String getColumnName(int col) {
	      return "";
	    }

	    public Object getValueAt(int row, int col) {
	      return wordArray.get(col);
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

	    public void setWordArray( ArrayList<String> captions )
	    {
	    	this.wordArray = captions;
	    }
	    public void setValueAt(Object value, int row, int col) {
	      
	    	if(wordArray.size()<= col)
	      {
	    	  wordArray.add((String) value);
	      }
	      else
	      {
	    	  wordArray.set(col,(String)value);  
	      }	
	    	
	    	 
	    		
	     
	    }

}
