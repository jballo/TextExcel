package textExcel;

public  class RealCell implements Cell{
	private String fullRealCell;
	
	public RealCell(String value) {
		this.fullRealCell = value;
	}
	
	
	public  double getDoubleValue() {
		Double dblValue = Double.parseDouble(fullCellText());
		return dblValue;
	}
	
	public String abbreviatedCellText() {
		String abrv = getDoubleValue() + "";
		if(abrv.length() < 10) {
			return fillInTxt(abrv);
		}else {
			return abrv.substring(0,10);
		
		}	
	}
	
	
	public String fullCellText() {
		return fullRealCell;
	}
	
	
	
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


