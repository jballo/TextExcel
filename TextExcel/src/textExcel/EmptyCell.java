package textExcel;

/*Jonathan Ballona S.
 * 11 May, 2018
 * Period 2
 * Empty Cell class to create empty cells of text
 */

public class EmptyCell implements Cell{
	public String abbreviatedCellText() {
		return "          ";
	}
	
	public String fullCellText(){
		return "";
	}
}
