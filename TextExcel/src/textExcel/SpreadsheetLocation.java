package textExcel;
import java.util.*;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private String cellName;
	private int row;
	private char column;
	
	public SpreadsheetLocation(String cellName)
    {   
		this.cellName = cellName;
        this.column = cellName.charAt(0);
        this.row = Integer.parseInt(cellName.substring(1));
    }
	
    @Override
    public int getRow()
    {
    	int row = this.row-1;
        return row;
    }

    @Override
    public int getCol()
    {
    	int numberPlacement = Character.toUpperCase(this.column) - 65 ;
        return numberPlacement;
    }
    

}
