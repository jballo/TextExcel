package textExcel;
import java.util.*;

/*Jonathan Ballona S.
 * 11 May, 2018
 * Period 2
 * Spreadsheet class to use and create locations for cell
 */
public class SpreadsheetLocation implements Location
{
	private int row;
	private char column;
	//Constructor for spreadsheetLocation that will provide a column and row for the getMethods
	public SpreadsheetLocation(String cellName){   
        this.column = cellName.charAt(0);
        this.row = Integer.parseInt(cellName.substring(1));
    }
	
    //Get method to get the row for the cell location
    public int getRow(){
    	int row = this.row-1;
        return row;
    }

    //Get method to get the column for the cell location
    public int getCol(){
    	int numberPlacement = Character.toUpperCase(this.column) - 65 ;
        return numberPlacement;
    }
    

}
