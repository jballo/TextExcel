package textExcel;

/*Jonathan Ballona S.
 * 11 May, 2018
 * Period 2
 * Text Cell class to create strings/text for cells
 */

public class TextCell implements Cell{
	private String text;
	
	public TextCell(String cellText) {
		this.text = cellText;
	}
	
	public String abbreviatedCellText() {
		//String abr = text.substring(1, text.length()-1);
		String abr = "";
		if((text.charAt(0) == '"') && (text.charAt(text.length() -1) == '"')) {
			abr = text.substring(1,text.length()-1);
		}else {
			abr = text.substring(0,text.length());
		}
		
		if(abr.length()< 10) {
			for(int spaces = abr.length(); spaces < 10; spaces++) {
				abr+=" ";
			}
		}
															//This will get rid of the close and open parenthesis for the text
		
															//this will check whether the text's length is 10
		if(abr.length() < 10) {
			return abr;
		}else {
				return abr.substring(0,10);
		}
	}
	
	public String fullCellText() {
		return text;
	}
}
