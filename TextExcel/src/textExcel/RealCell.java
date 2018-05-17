package textExcel;

/*Jonathan Ballona S.
 * 11 May, 2018
 * Period 2
 * RealCell class to make real cells
 */

public  class RealCell implements Cell{
	private String fullRealCell;
	
	public RealCell(String value) {
		this.fullRealCell = value;
	}
	
	
	public  double getDoubleValue() {		//Get the value of the fullCellText ( a string )
		Double dblValue = Double.parseDouble(fullCellText());
		return dblValue;
	}
	
	public String abbreviatedCellText() {
		String abrv = getDoubleValue() + "";
		if(abrv.length() < 10) {			// Will fill in the Text Box if the number is lower then 10 spaces
			return fillInTxt(abrv);
		}else {
			return abrv.substring(0,10);    // Will cut off anything that is over 10 spaces
		}	
	}
	
	
	public String fullCellText() {
		return fullRealCell;				//Returns the fullCellText
	}
	
	
	//Method to fill in the textbox if the text is below 10 characters
	//so the spreadsheet is aligned perfectly in the getGridText
	public String fillInTxt(String txt) {
		String abrvRealCell = txt;
		if(txt.length() < 10) {
			for(int i = txt.length(); i < 10; i++) {
				abrvRealCell +=" ";
			}
			return abrvRealCell;
		}else {
			return abrvRealCell;
		}
	}
}


