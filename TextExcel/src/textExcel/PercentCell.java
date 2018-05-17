package textExcel;
//deals with creating a percent cell
public class PercentCell extends RealCell{
	public PercentCell(String percentValue){
		super(percentValue);
		System.out.println(percentValue);
	}
	//Overrides the original abbreviatedCellText
	public String abbreviatedCellText() {
		String abbr = super.fullCellText().substring(0, super.fullCellText().indexOf('.')) + "%";
		System.out.println(abbr);
		abbr = super.fillInTxt(abbr);
		return abbr;
	}
	//Overrides the original getDoubleValue from the RealCell
	public double getDoubleValue() {
		String percent = super.fullCellText().substring(0, super.fullCellText().length()-1);
		System.out.println("Percent:" + percent);
		return Double.parseDouble(percent);
	}
	//gets the full value of the percentcell that is unabbreviated
	public String fullCellText() {
		System.out.println(getDoubleValue() * 0.01);
		return (getDoubleValue() * 0.01) + "";
	}
	
	
}


